package com.daniel_tessi_assogba.gradle_demo_project.controller;


public class TenantDto {

    private String name;
    private Integer age;
    private String email;

    public TenantDto() {
    }

    public TenantDto(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

