package com.daniel_tessi_assogba.gradle_demo_project.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tenant")
public class Tenant {
    @Id
    private Long id;
    private String name;
    private Integer age;
    private String email;


    public Tenant() {
    }

    public Tenant(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(id, tenant.id) && Objects.equals(name, tenant.name) && Objects.equals(age, tenant.age) && Objects.equals(email, tenant.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}

