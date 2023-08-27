package com.codreal.githubauth.controller;

import com.codreal.githubauth.exceptions.UserAlreadyExistException;
import com.codreal.githubauth.model.User;
import com.codreal.githubauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/check")
    public String check() {
        return "Working...!";
    }

    //    To register the new user
    @PostMapping("/registerNewUser")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) throws IOException {
        try {
            return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
        } catch (UserAlreadyExistException e) {

            return new ResponseEntity("User Already Exists", HttpStatus.CONFLICT);
        }
    }
}
