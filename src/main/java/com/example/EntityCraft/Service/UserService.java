package com.example.EntityCraft.Service;

import com.example.EntityCraft.Entity.User;
import com.example.EntityCraft.Repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }

    public User createUser(User user)
    {
        return userRepo.save(user);
    }
}
