package com.tinDev.models.company;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "interview", schema = "public")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vacancyStatusId")
    private int vacancyStatusId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="vacancyStatusId", insertable=false, updatable=false)
    private VacancyStatus vacancyStatus;
}
