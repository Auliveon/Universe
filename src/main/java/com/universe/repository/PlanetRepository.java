package com.universe.repository;


import com.universe.models.Planet;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

    List<Planet> findAll();

    @Query("select p from Planet p where p.name = :name ")
    Planet findByName(@Param("name")String name);







}
