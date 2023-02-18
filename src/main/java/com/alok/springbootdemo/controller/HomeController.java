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

    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id, @PathVariable("id2") String name) {
        return "The path variables are: " + id + " " + name;
    }

    @GetMapping("/requestParams")
    public String requestParams(
            @RequestParam String name,
            @RequestParam(name = "email", required = false, defaultValue = "") String emailId
    ) {
        return "your name is: " + name + " and email is " + emailId;
    }
}
