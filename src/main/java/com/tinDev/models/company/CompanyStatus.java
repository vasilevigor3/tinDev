package com.tinDev.models.company;

import lombok.Data;

@Data
public class CompanyStatus {
    private VacancyStatus vacancyStatus;
    private Interview interview;
    private TestAssignment testAssignment;
}
