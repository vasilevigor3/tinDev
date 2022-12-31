package com.tinDev.models.user.dto;

import com.tinDev.models.Vacancy;
import com.tinDev.models.stack.Languages;
import com.tinDev.models.stack.TechStack;
import com.tinDev.models.user.Position;
import com.tinDev.models.user.enums.WorkType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int userId;

    private String userName;
    private String userLastName;

    private WorkType workType;
    private int salaryExpectations;
    private int experience;

    private Set<Languages> languages;
    private List<Position> position;
    private List<TechStack> techStack;

    private Set<Vacancy> pendingVacancies;
    private Set<Vacancy> acceptedVacancies;
    private Set<Vacancy> rejectedVacancies;
    private Set<Vacancy> interviewVacancies;
    private Set<Vacancy> testAssignmentVacancies;
}
