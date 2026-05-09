package com.example.EntityCraft.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String dbName;

    @Email
    private String email;

    @Column( updatable = false)
    @CreatedDate
    private LocalDate dateOfCreation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenant")
    private List<ObjectTable> objectTableList;
}
