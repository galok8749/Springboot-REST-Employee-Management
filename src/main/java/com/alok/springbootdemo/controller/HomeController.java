package com.alok.springbootdemo.controller;

import com.alok.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello There";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("alok");
        user.setEmailId("alok@gmail.com");

        return user;
    }
}
