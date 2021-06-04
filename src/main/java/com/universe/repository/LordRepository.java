package com.universe.repository;

import com.universe.models.Lord;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface LordRepository extends JpaRepository<Lord, Long> {

    @Query("select l from Lord l where l.name = :name ")
    Lord findByName(@Param("name")String name);

}
