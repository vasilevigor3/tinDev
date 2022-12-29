//package com.tinDev.repository;
//
//import com.tinDev.models.user.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class UserRepositoryImpl {
//
//    private List<User> users;
//
//    public List<User> getAll() {
//        List<User> users = new ArrayList<>();
//        users.add(createUser());
//        return users;
//    }
//
//    private User createUser(){
//        final User user = new User();
//        user.setUserId(1);
//        user.setUserName("Ololo");
//        return user;
//    }
//}