package bg.softuni.gamestore.model.dto;

import java.math.BigDecimal;

public class DetailGameDto {
    private String title;
    private BigDecimal price;
    private String description;
    private String releaseDate;

    public DetailGameDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

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

    @Override
    public String toString() {
        return String.format("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n",
                this.getTitle(),this.getPrice(),this.getDescription(), this.getReleaseDate());

    }
}
