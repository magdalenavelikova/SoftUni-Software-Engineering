package bg.softuni.productshop.model.entity;

import jakarta.persistence.*;




@MappedSuperclass
public abstract class BaseEntity {

    Long id;

    protected BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
