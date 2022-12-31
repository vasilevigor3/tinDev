package com.tinDev.models.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tinDev.models.Vacancy;
import com.tinDev.models.company.enums.VacancyEnumStatus;
import com.tinDev.models.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "vacancyStatuses", schema = "public")
public class VacancyStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vacancyStatusId")
    private int vacancyStatusId;

    @Column(name = "vacancyEnumStatus")
    private VacancyEnumStatus vacancyEnumStatus;

    @OneToMany(mappedBy="vacancyStatus", fetch=FetchType.EAGER)
    @Column(name = "interview")
    private List<Interview> interview;

    @OneToMany(mappedBy="vacancyStatus", fetch=FetchType.EAGER)
    @Column(name = "testAssignment")
    private List<TestAssignment> testAssignment;

    @ManyToMany
    @JoinTable(name = "table_vacancyStatuses_user",
            joinColumns = @JoinColumn(name = "vacancyStatuses_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnoreProperties("vacancyStatuses")
    private List<User> listUser;

    @ManyToMany
    @JoinTable(name = "table_vacancyStatuses_vacancy",
            joinColumns = @JoinColumn(name = "vacancyStatuses_id"),
            inverseJoinColumns = @JoinColumn(name = "vacancy_id"))
    @JsonIgnoreProperties("vacancyStatuses")
    private List<Vacancy> listVacancy;
}
