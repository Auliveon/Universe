package com.universe.service;


import com.universe.models.Planet;

import com.universe.repository.PlanetRepository;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import java.util.List;


@Service
public class PlanetServiceImpl implements PlanetService {

    @PersistenceContext
    private EntityManager em;

    private PlanetRepository planetRepository;

    public  PlanetServiceImpl(PlanetRepository repository) {
        this.planetRepository = repository;
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @Override
    public void updatePlanet(Planet planet) {
        planetRepository.save(planet);
    }

    @Override
    public void deletePlanet(String name) {
        planetRepository.delete(planetRepository.findByName(name));
    }

    @Override
    public Planet findByName(String name) {
        return planetRepository.findByName(name);
    }

}
