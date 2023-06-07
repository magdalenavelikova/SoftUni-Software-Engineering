package bg.softuni.gamestore.model.dto;

import java.math.BigDecimal;

public class AllGamesDto {
    private String title;
    private BigDecimal price;

    public AllGamesDto() {
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

    @Override
    public String toString() {
        return title + " " + price;
    }
}
