package com.example.json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserWithSoldProductsDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;

    @Expose
    private Set<SoldProductsDto> soldProducts;

    public UserWithSoldProductsDto() {
    }

    public UserWithSoldProductsDto(String firstName, String lastName, Integer age, Set<SoldProductsDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = soldProducts;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Set<SoldProductsDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<SoldProductsDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
