package bg.softuni.security.model.entity;

import bg.softuni.security.model.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name ="user_roles")
public class UserRoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private UserRoleEnum userRole;

  public Long getId() {
    return id;
  }

  public UserRoleEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public UserRoleEnum getUserRole() {
    return userRole;
  }

  public UserRoleEntity setUserRole(UserRoleEnum userRole) {
    this.userRole = userRole;
    return this;
  }

  @Override
  public String toString() {
    return "UserRoleEntity{" +
        "id=" + id +
        ", userRole=" + userRole +
        '}';
  }
}
