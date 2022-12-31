package com.tinDev.models.user;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinDev.models.Vacancy;
import com.tinDev.models.company.VacancyStatus;
import com.tinDev.models.stack.Languages;
import com.tinDev.models.stack.TechStack;
import com.tinDev.models.user.enums.WorkType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


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

    @OneToMany
    @JoinColumn(name = "user_id")
    @Column(name = "languages")
    private Set<Languages> languages;

    @OneToMany
    @JoinColumn(name = "positionId")
    private List<Position> position;

    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    @Column(name = "techStack")
    private List<TechStack> techStack;

    @ManyToMany
    @JoinTable(name = "users_vacancies",
            //foreign key for UserEntity in users_vacancies table
            joinColumns = @JoinColumn(name = "va_id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "us_id"))
    @JsonIgnoreProperties("users")
    private Set<Vacancy> vacancies;

    @ManyToMany(mappedBy = "listUser")
    @JsonIgnoreProperties("users")
    private List<VacancyStatus> listVacancyStatuses;
}
