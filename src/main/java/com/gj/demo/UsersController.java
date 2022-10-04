package com.gj.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
     @Autowired
     UserService userService;



    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        logger.debug("retrieving user data from Service + database");
        return userService.findUserById(id);
    }

    @GetMapping("/all")
    public Map<Integer, User> users() {
        logger.debug("retrieving all users from Service + database");
        return userService.getAll();
    }

    @GetMapping("/ping")
    public String  ping() {
        System.out.println("retrieving data from cache");
        return "Ping ok";
    }
}
