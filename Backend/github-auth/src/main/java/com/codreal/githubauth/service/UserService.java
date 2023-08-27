package com.codreal.githubauth.service;

import com.codreal.githubauth.exceptions.UserAlreadyExistException;
import com.codreal.githubauth.model.User;

public interface UserService {
    User addUser(User user) throws UserAlreadyExistException;
}
