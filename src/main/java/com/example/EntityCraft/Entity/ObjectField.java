package com.example.EntityCraft.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectField {

    @Id
    private Long id;

    private String fieldName;

    private String field_type;

    private Boolean nullable;

    private Boolean unique_field;

    private String defaultValue;

    @ManyToOne
    @JoinColumn(name = "objectId")
    private ObjectTable objectTable;


}
