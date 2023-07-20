package bg.softuni.errors.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDTO {

  private final String name;
  private final BigDecimal price;

  public ProductDTO(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductDTO that = (ProductDTO) o;
    return Objects.equals(name, that.name) && Objects.equals(price, that.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }
}
