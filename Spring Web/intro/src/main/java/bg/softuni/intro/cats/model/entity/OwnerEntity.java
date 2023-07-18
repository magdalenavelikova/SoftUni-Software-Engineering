package bg.softuni.intro.cats.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class OwnerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String ownerName;

  @OneToMany(
      mappedBy = "owner",
      cascade = CascadeType.ALL
  )
  private List<CatEntity> cats = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public OwnerEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public OwnerEntity setOwnerName(String ownerName) {
    this.ownerName = ownerName;
    return this;
  }

  public OwnerEntity addCat(CatEntity cat) {
    cats.add(cat);
    return this;
  }

  public List<CatEntity> getCats() {
    return cats;
  }

  public OwnerEntity setCats(List<CatEntity> cats) {
    this.cats = cats;
    return this;
  }
}
