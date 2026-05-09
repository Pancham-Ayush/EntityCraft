package com.example.EntityCraft.Repo;

import com.example.EntityCraft.Entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Tenant, Long> {

}
