package com.tinDev.models.user;
import com.tinDev.models.stack.Languages;
import com.tinDev.models.stack.TechStack;
import com.tinDev.models.user.enums.WorkType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name="tinDevUser", schema = "public")
public class User {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int userId;

    @Column(name = "userName")
    private String userName;
    @Column(name = "userLastName")
    private String userLastName;

    @Column(name = "workType")
    private WorkType workType;
    @Column(name = "salaryExpectations")
    private int salaryExpectations;
    @Column(name = "experience")
    private int experience;

    @OneToMany(mappedBy="user")
    @Column(name = "languages")
    private List<Languages> languages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

    @OneToMany(mappedBy="user")
    @Column(name = "techStack")
    private List<TechStack> techStack;
//    @OneToMany
//    @Column(name = "vacancies")
//    private List<Vacancy> vacancies;
//    private List<Vacancy> pendingVacancies;
//    private List<Vacancy> acceptedVacancies;
//    private List<Vacancy> rejectedVacancies;
//    private List<Vacancy> interviewVacancies;
//    private List<Vacancy> testAssignmentVacancies;
}
