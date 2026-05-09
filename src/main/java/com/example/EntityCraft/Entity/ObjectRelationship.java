package com.example.EntityCraft.Entity;

import jakarta.persistence.*;

public class ObjectRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "source_object_id",
            nullable = false
    )
    private ObjectTable sourceObject;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "target_object_id",
            nullable = false
    )
    private ObjectTable targetObject;

}
