package com.example.EntityCraft.Controller;

import com.example.EntityCraft.Entity.Tenant;
import com.example.EntityCraft.Service.UserService;
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
    public Tenant createUser(

            @RequestParam(required = false) String dbName,
            @RequestParam String email

    ) {

        Tenant user = new Tenant();

        user.setDbName(dbName);
        user.setEmail(email);

        return userService.createUser(user);
    }

}
