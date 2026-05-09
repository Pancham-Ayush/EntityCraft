package com.example.EntityCraft.Controller;

import com.example.EntityCraft.Service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/db")
public class DB_Controller
{

    @Autowired
    JdbcService jdbcService;
    @PostMapping("/createDb")
    public boolean createDatabase(@RequestParam String tenentName)
    {
        return jdbcService.createDatabase(tenentName);
    }
}
