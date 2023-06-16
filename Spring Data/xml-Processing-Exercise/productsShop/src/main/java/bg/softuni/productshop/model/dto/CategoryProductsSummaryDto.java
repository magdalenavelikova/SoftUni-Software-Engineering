package bg.softuni.productshop.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryProductsSummaryDto {
    @XmlAttribute
    @Expose
    @SerializedName(value = "category")
    private String name;
    @XmlElement(name = "products-count")
    @Expose
    private Long productsCount;
    @XmlElement(name = "average-price")
    @Expose
    private Double averagePrice;
    @XmlElement(name = "total-revenue")
    @Expose
    private BigDecimal totalRevenue;

    public CategoryProductsSummaryDto() {
    }

    public CategoryProductsSummaryDto(String name, Long productsCount, Double averagePrice, BigDecimal totalRevenue) {
        this.name = name;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(Long productsCount) {
        this.productsCount = productsCount;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
