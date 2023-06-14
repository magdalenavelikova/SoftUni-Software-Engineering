package com.example.json.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

    private String name;
    @Column(name = "is_importer")
    private Boolean isImporter;
    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private Set<Part> parts;

}
