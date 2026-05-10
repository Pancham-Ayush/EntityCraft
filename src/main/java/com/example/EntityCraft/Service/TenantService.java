package com.example.EntityCraft.Service;

import com.example.EntityCraft.Entity.Tenant;
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

    public Tenant saveTenant(Tenant user)
    {
        return userRepo.save(user);
    }

    public Tenant findById(Long tenantId)
    {
        return userRepo.findById(tenantId).get();
    }
}
