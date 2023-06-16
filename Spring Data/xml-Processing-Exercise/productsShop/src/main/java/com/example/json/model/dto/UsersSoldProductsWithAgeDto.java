package com.example.json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Set;

public class UsersSoldProductsWithAgeDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
@Expose
    private Integer count;
    @Expose
    private List<ProductNameAndPriceDto> soldProducts;

    public UsersSoldProductsWithAgeDto() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductNameAndPriceDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductNameAndPriceDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}