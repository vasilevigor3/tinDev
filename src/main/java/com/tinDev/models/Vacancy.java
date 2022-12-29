package com.tinDev.models;

import com.tinDev.models.company.CompanyStatus;
import com.tinDev.models.company.VacancyStatus;
import com.tinDev.models.stack.TechStack;
import jakarta.persistence.*;
import com.tinDev.models.user.enums.Carrier;
import com.tinDev.models.user.enums.Seniority;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@Table(name = "vacancies", schema = "public")
public class Vacancy {
    @jakarta.persistence.Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private int vacancyId;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "description")
    private String description;
//    @Column(name = "postedOn")
//    @OneToMany
//    private List<JobPlatform> postedOn;
    @Column(name = "requiredSeniority")
    private Seniority requiredSeniority;
    @Column(name = "jobTitle")
    private Carrier jobTitle;
    @Column(name = "companyStatus")
    private CompanyStatus companyStatus;
    @Column(name = "vacancyStatus")
    private VacancyStatus vacancyStatus;
    @Column(name = "techStack")
    private TechStack techStack;




}
