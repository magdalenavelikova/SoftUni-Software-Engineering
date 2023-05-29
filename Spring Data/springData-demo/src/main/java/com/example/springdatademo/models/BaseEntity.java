package com.example.springdatademo.models;

import jakarta.persistence.*;


@MappedSuperclass
public abstract class BaseEntity {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(unique = true, length = 50)
    public void setId(Long id) {
        this.id = id;
    }

}
