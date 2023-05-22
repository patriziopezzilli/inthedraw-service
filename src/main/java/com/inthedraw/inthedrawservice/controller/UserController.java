package com.inthedraw.inthedrawservice.controller;

import com.inthedraw.inthedrawservice.model.user.*;
import com.inthedraw.inthedrawservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "in-the-draw/customer/user/{id}", method = RequestMethod.GET)
    public UserDTO retrieveUser(@PathVariable Integer id) {
        logger.info("> retrieve user " + id.toString());
        return userService.retrieveUser(id);
    }

    @RequestMapping(value = "in-the-draw/customer/user/register", method = RequestMethod.POST)
    public LoginResponse registerUser(@RequestBody CreateUserRequest request) throws ParseException {
        logger.info("> register user performing");
        return userService.register(request);
    }

    @RequestMapping(value = "in-the-draw/customer/user/register/mock", method = RequestMethod.POST)
    public void registerMockUsers() throws ParseException {
        logger.info("> register user performing");
        userService.createMockUsers();
    }

    @RequestMapping(value = "in-the-draw/customer/user/{id}", method = RequestMethod.PUT)
    public LoginResponse updateUser(@PathVariable Integer id, @RequestBody UpdateUserRequest request) throws ParseException {
        logger.info("> update user performing");
        return userService.updateUser(id, request);
    }

    @RequestMapping(value = "in-the-draw/customer/user/login", method = RequestMethod.POST)
    public LoginResponse loginUser(@RequestBody LoginRequest request) throws ParseException {
        logger.info("> login request performing");
        return userService.login(request);
    }
}