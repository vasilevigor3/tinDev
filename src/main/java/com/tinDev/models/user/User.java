package com.tinDev.models.user;
import com.tinDev.models.stack.TechStack;
import com.tinDev.models.user.enums.WorkType;
import jakarta.persistence.*;
import lombok.*;
import com.tinDev.models.Vacancy;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;


@Setter
@Getter
@Entity
@Table(name="tinDevUsers", schema = "public")
public class User {

    @jakarta.persistence.Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
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
    @OneToMany
    @Column(name = "languages")
    private List<String> languages;

    @OneToOne
    @Column(name = "position")
    private Position position;
    @OneToOne
    @Column(name = "stack")
    private TechStack stack;
//    @OneToMany
//    @Column(name = "vacancies")
//    private List<Vacancy> vacancies;
    private List<Vacancy> pendingVacancies;
    private List<Vacancy> acceptedVacancies;
    private List<Vacancy> rejectedVacancies;
    private List<Vacancy> interviewVacancies;
    private List<Vacancy> testAssignmentVacancies;
}
