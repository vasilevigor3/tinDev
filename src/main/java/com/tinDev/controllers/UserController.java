package com.tinDev.controllers;

import com.tinDev.convertrs.user.UserDtoModelConverter;
import com.tinDev.models.Vacancy;
import com.tinDev.models.user.User;
import com.tinDev.models.user.dto.UserDto;
import com.tinDev.models.user.enums.WorkType;
import com.tinDev.repository.UserRepository;
import com.tinDev.repository.VacancyRepository;
import com.tinDev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VacancyRepository vacancyRepository;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
                return userService.findAll();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PostMapping(path = "/create")
    public User registerNewUser(@RequestBody UserDto userDto){
        return userService.create(userDto);
    }

    @PostMapping(path = "/createStubUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public User createOneStubUser() {
        final User user = new User();
        user.setUserName("setUserName");
        user.setUserLastName("setUserLastName");
        user.setWorkType(WorkType.REMOTE);
        user.setSalaryExpectations(1000);
        user.setExperience(20);
        userRepository.save(user);

        return user;
    }

    @GetMapping(path = "/join")
    public User join(){
        try {
            User referenceById = userRepository.findById(1).get();
            Vacancy referenceById1 = vacancyRepository.findById(1).get();
            Vacancy referenceById2 = vacancyRepository.findById(2).get();

            Set<Vacancy> vacancies = new java.util.HashSet<>(Collections.emptySet());
            vacancies.add(referenceById1);
            vacancies.add(referenceById2);
            referenceById.setVacancies(vacancies);

            userRepository.save(referenceById);
            return referenceById;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}