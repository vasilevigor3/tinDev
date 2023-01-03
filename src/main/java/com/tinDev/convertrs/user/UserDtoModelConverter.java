package com.tinDev.convertrs.user;

import com.tinDev.models.userVacancyMatch.UserVacancyMatch;
import com.tinDev.models.user.User;
import com.tinDev.models.user.dto.UserDto;
import com.tinDev.services.userVacancyMatch.UserVacancyMatchService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDtoModelConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserVacancyMatchService userVacancyMatchService;

    public UserDto convertToEntity(final User user) {
        UserDto userDto = new UserDto();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        PropertyMap<User, UserDto> userPropertyMap = new PropertyMap<User, UserDto>() {
            protected void configure() {
                Set<UserVacancyMatch> customMatchesForCurrentUser =
                        userVacancyMatchService.findAllMatchesForCurrentUser(String.valueOf(user.getUserId()));
                map().setMatches(customMatchesForCurrentUser);
            }
        };

        modelMapper.addMappings(userPropertyMap);
        return modelMapper.map(user, UserDto.class);
    }

//    private Set<Vacancy> aggregateAllVacancies(final UserDto userDto){
//        final Set<Vacancy> acceptedVacancies = userDto.getAcceptedVacancies();
//        final Set<Vacancy> pendingVacancies = userDto.getPendingVacancies();
//        final Set<Vacancy> rejectedVacancies = userDto.getRejectedVacancies();
//        final Set<Vacancy> interviewVacancies = userDto.getInterviewVacancies();
//        final Set<Vacancy> testAssignmentVacancies = userDto.getTestAssignmentVacancies();
//
//        return merge(acceptedVacancies,pendingVacancies,rejectedVacancies,interviewVacancies,testAssignmentVacancies);
//    }

//    private Set<Vacancy> merge(Set<Vacancy>... vacancies) {
//        return  Stream.of(vacancies).flatMap(Set::stream)
//                .collect(Collectors.toSet());
//    }

}
