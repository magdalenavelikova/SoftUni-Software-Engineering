package bg.softuni.productshop.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersSeedDto {

    @XmlElement(name = "user")
    private List<UserSeedDto> users;

    public UsersSeedDto() {
    }

    public List<UserSeedDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserSeedDto> users) {
        this.users = users;
    }
}
