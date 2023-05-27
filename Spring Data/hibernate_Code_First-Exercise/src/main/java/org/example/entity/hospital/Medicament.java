package org.example.entity.hospital;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.entity.BaseEntity;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {

    private String name;

    @Column(nullable = false,length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
