package bg.softuni.productshop.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesProductsSummaryXMLDto {
    @XmlElement(name = "category")
    private List<CategoryProductsSummaryDto> categories;

    public CategoriesProductsSummaryXMLDto() {
    }

    public List<CategoryProductsSummaryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryProductsSummaryDto> categories) {
        this.categories = categories;
    }
}
