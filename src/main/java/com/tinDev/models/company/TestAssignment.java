package com.tinDev.models.company;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "testAssignment", schema = "public")
public class TestAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vacancyStatusId")
    private int vacancyStatusId;
    @Column(name = "date")
    private Date date;
    @Column(name = "linkToAssignment")
    private String linkToAssignment;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="vacancyStatusId", insertable=false, updatable=false)
    private VacancyStatus vacancyStatus;

}
