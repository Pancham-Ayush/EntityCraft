package com.example.EntityCraft.Repo;

import com.example.EntityCraft.Entity.ObjectField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepo extends JpaRepository<ObjectField, Long> {
}
