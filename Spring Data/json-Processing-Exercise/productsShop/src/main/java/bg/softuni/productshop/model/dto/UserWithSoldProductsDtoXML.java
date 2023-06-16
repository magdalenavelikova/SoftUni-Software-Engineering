package bg.softuni.productshop.model.dto;




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldProductsDtoXML {
    @XmlElement(name = "user")
    List<UserWithSoldProductsDto> users;

    public UserWithSoldProductsDtoXML() {
    }

    public List<UserWithSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProductsDto> users) {
        this.users = users;
    }
}
