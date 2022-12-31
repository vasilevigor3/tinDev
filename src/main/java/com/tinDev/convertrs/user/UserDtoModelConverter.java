package com.tinDev.convertrs.user;

import com.tinDev.models.Vacancy;
import com.tinDev.models.user.User;
import com.tinDev.models.user.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserDtoModelConverter {
    @Autowired
    private ModelMapper modelMapper;

    public User convertToEntity(final UserDto userDto){
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        final User user = modelMapper.map(userDto, User.class);
        user.setVacancies(aggregateAllVacancies(userDto));
        return user;
    }

    private Set<Vacancy> aggregateAllVacancies(final UserDto userDto){
        final Set<Vacancy> acceptedVacancies = userDto.getAcceptedVacancies();
        final Set<Vacancy> pendingVacancies = userDto.getPendingVacancies();
        final Set<Vacancy> rejectedVacancies = userDto.getRejectedVacancies();
        final Set<Vacancy> interviewVacancies = userDto.getInterviewVacancies();
        final Set<Vacancy> testAssignmentVacancies = userDto.getTestAssignmentVacancies();

        return merge(acceptedVacancies,pendingVacancies,rejectedVacancies,interviewVacancies,testAssignmentVacancies);
    }

    private Set<Vacancy> merge(Set<Vacancy>... vacancies) {
        return  Stream.of(vacancies).flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

}
