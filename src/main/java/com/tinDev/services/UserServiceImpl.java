package com.tinDev.services;

import com.tinDev.convertrs.user.UserDtoModelConverter;
import com.tinDev.models.user.User;
import com.tinDev.models.user.dto.UserDto;
import com.tinDev.populators.user.UserPopulator;
import com.tinDev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserPopulator userPopulator;
    @Autowired
    private UserDtoModelConverter userDtoModelConverter;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUser(final String id) {
        return userRepository.findById(Integer.valueOf(id));
    }

    @Override
    public UserDto getUser(final String id) {
        Optional<User> user = findUser(id);

        return userPopulator.populate(user.get());
    }

    @Override
    public User create(final UserDto userDto) {
        final User user = userDtoModelConverter.convertToEntity(userDto);
        userRepository.save(user);
        return user;
    }
}
