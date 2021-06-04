package com.universe.models;


import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name="planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(name = "planet_name", nullable = false, length = 100, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name="lord_id", nullable=false)
    private Lord lord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return pid.equals(planet.pid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid);
    }
}
