package softuni.exam.models.dto;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentWrapperDto {
    @XmlElement(name = "apartment")
    private List<ApartmentSeedDto> apartments;

    public List<ApartmentSeedDto> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentSeedDto> apartments) {
        this.apartments = apartments;
    }
}
