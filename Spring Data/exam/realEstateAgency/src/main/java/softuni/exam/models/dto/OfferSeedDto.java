package softuni.exam.models.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {

    //    •	price – accepts a positive number.
//•	published on – a date in the "dd/MM/yyyy" format.
//•	Constraint: The offers table has a relation with the apartments table.
//•	Constraint: The offers table has a relation with the agents table.

    @Positive
    private BigDecimal price;
    @NotEmpty
    private String publishedOn;

    @NotNull
    private AgentFirstNameDto agent;
    @NotNull
    private ApartmentIdDto apartment;


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public AgentFirstNameDto getAgent() {
        return agent;
    }

    public void setAgent(AgentFirstNameDto agent) {
        this.agent = agent;
    }

    public ApartmentIdDto getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDto apartment) {
        this.apartment = apartment;
    }
}
