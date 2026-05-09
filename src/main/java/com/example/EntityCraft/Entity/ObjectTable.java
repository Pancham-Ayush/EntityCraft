package com.example.EntityCraft.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ObjectTable {

    @Id
    private Long id;

    private String objectName;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    private String db;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "objectTable",cascade = CascadeType.ALL)
    private List<ObjectField> objectFieldListList;

}
