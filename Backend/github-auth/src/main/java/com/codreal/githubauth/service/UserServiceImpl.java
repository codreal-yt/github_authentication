package com.codreal.githubauth.service;

import com.codreal.githubauth.exceptions.UserAlreadyExistException;
import com.codreal.githubauth.model.User;
import com.codreal.githubauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        Optional<User> user1 = userRepository.findById(user.getUserId());
        if (user1.isPresent()) {
            throw new UserAlreadyExistException();
        } else {
            return userRepository.save(user);
        }
    }
}
