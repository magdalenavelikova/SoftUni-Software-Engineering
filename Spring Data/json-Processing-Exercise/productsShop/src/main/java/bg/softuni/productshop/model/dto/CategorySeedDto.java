package bg.softuni.productshop.model.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedDto {
    @Expose
    private String name;

    public CategorySeedDto() {
    }
    @Size(min = 3, max=15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
