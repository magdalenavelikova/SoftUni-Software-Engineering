package bg.softuni.gamestore.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class GameAddDto {
    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailURL;
    private String description;
    private String releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer, String thumbnailURL, String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "[A-Z][A-z]{3,100}", message = "Title – has to begin with an uppercase letter and must have length between 3 and 100 symbols ")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DecimalMin(value = "0", message = "Must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Positive(message = "Must be a positive number")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Size(min = 11, max = 11, message = "Enter valid trailer. Exactly 11 characters")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "(https?\\:\\/\\/.*)", message = "Enter valid path. Must starting with http://, https://")
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @Size(min = 20, message = "Enter valid description. Must be at least 20 symbols")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
