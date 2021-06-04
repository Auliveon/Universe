package com.universe.models;


import javax.persistence.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Objects;


@Entity
@Table(name="lords")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "lord_name", nullable = false, length = 100, unique = true)
    private String name;

    @Column(name = "lord_age", nullable = false)
    private Integer age;

    @OneToMany(mappedBy="lord", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Planet> planets = new ArrayList<>();

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lord lord = (Lord) o;
        return pid.equals(lord.pid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid);
    }
}
