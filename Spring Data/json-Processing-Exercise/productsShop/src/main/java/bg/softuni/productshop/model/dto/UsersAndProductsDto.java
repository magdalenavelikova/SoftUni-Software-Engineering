package bg.softuni.productshop.model.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersAndProductsDto {
    @Expose
    @XmlAttribute(name = "count")
   private Integer usersCount;
    @XmlElement(name = "user")
    @Expose
   private List<UsersSoldProductsWithAgeDto> users;

    public UsersAndProductsDto() {
    }

    public UsersAndProductsDto( List<UsersSoldProductsWithAgeDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UsersSoldProductsWithAgeDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersSoldProductsWithAgeDto> users) {
        this.users = users;
    }

}
