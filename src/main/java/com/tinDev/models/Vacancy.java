package com.tinDev.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinDev.models.company.VacancyStatus;
import com.tinDev.models.stack.TechStack;
import com.tinDev.models.user.User;
import jakarta.persistence.*;
import com.tinDev.models.user.enums.Carrier;
import com.tinDev.models.user.enums.Seniority;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "vacancies", schema = "public")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vacancyId")
    private int vacancyId;

    @Column(name = "companyName")
    private String companyName;
    @Column(name = "description")
    private String description;
    @Column(name = "requiredSeniority")
    private Seniority requiredSeniority;
    @Column(name = "jobTitle")
    private Carrier jobTitle;

    @OneToMany(mappedBy = "vacancy")
    @Column(name = "techStack")
    private List<TechStack> techStack;

    @ManyToMany
    @JoinTable(name = "users_vacancies",
            joinColumns = @JoinColumn(name = "us_id"),
            inverseJoinColumns = @JoinColumn(name = "va_id"))
    @JsonIgnoreProperties("vacancies")
    private Set<User> users;

    @ManyToMany(mappedBy = "listVacancy")
    private List<VacancyStatus> listVacancyStatuses;

}
