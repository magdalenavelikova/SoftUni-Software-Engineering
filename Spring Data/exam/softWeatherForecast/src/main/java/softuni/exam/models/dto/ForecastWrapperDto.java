package softuni.exam.models.dto;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastWrapperDto {
    @XmlElement(name = "forecast")
    List<ForecastSeedDto> forecasts;

    public ForecastWrapperDto() {
    }

    public List<ForecastSeedDto> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastSeedDto> forecasts) {
        this.forecasts = forecasts;
    }
}
