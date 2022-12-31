package com.tinDev.controllers;

import com.tinDev.models.Vacancy;
import com.tinDev.repository.VacancyRepository;
import com.tinDev.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    VacancyRepository vacancyRepository;


    @GetMapping(path = "/vacancies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vacancy> getAll() {
        return vacancyService.getAll();
    }

    @PostMapping(path = "/registerNewVacancy")
    public void registerNewUser() {

    }

    @PostMapping(path = "/createStubVacancy", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vacancy createOneStubVacancy() {
        final Vacancy vacancy = new Vacancy();
        vacancy.setCompanyName("testVacancy");
        vacancyRepository.save(vacancy);
        return vacancy;
    }

}
