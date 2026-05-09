package com.example.EntityCraft.Repo;

import com.example.EntityCraft.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
