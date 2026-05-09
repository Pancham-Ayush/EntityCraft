package com.example.EntityCraft.Controller;

import com.example.EntityCraft.Entity.User;
import com.example.EntityCraft.Repo.UserRepo;
import com.example.EntityCraft.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(

            @RequestParam(required = false) String tenantName,
            @RequestParam String email

    ) {

        User user = new User();

        user.setTenentName(tenantName);
        user.setEmail(email);

        return userService.createUser(user);
    }

}
