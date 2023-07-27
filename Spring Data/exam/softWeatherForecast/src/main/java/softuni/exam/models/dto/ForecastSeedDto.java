package softuni.exam.models.dto;

import softuni.exam.models.enums.DayOfWeek;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSeedDto {
    @NotNull

    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;
    @Min(value = -20)
    @Max(value = 60)
     @XmlElement(name = "max_temperature")
    private Double maxTemperature;

    @Min(value = -50)
    @Max(value = 40)
    @XmlElement(name = "min_temperature")
    private Double minTemperature;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String sunrise;
    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String sunset;
    @NotNull
    private Long city;

    public ForecastSeedDto() {
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
