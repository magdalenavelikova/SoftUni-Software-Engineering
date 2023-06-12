package com.example.json.model.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UsersAndProductsDto {
    @Expose
   private Integer usersCount;
    @Expose
   private List<UsersSoldProductsWithAgeDto> users;

    public UsersAndProductsDto() {
    }

    public UsersAndProductsDto( List<UsersSoldProductsWithAgeDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UsersSoldProductsWithAgeDto> getUsers() {
        return users;
    }

    public void setUsers(List<UsersSoldProductsWithAgeDto> users) {
        this.users = users;
    }

}
