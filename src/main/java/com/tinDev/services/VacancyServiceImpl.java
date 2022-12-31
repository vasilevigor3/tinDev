package com.tinDev.services;

import com.tinDev.models.Vacancy;
import com.tinDev.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {
    @Autowired
    VacancyRepository vacancyRepository;

    @Override
    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();
    }
}
