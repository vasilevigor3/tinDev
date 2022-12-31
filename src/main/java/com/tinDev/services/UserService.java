package com.tinDev.services;

import com.tinDev.models.user.User;
import com.tinDev.models.user.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findUser(final String id);
    UserDto getUser(final String id);
    User create(final UserDto userDto);
}
