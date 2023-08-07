package bg.softuni.modelmapper.entities.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ManagerCollectionDto {

@XmlElement(name = "manager")
        @Expose
    List<ManagerDTO> managers;

    public ManagerCollectionDto() {
    }

    public ManagerCollectionDto(List<ManagerDTO> managers) {
        this.managers = managers;
    }

    public List<ManagerDTO> getManagers() {
        return managers;
    }

    public void setManagers(List<ManagerDTO> managers) {
        this.managers = managers;
    }
}
