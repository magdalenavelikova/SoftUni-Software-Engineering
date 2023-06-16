package bg.softuni.productshop.model.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedDto  {
    @Expose
    @XmlAttribute(name="first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name="last-name")
    private String lastName;
    @Expose
    @XmlAttribute(name = "age")
    private Integer age;

    public UserSeedDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
   @Size(min = 3)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
