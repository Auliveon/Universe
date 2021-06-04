package com.universe.service;


import com.universe.models.Planet;

import java.util.List;


public interface PlanetService {

    List<Planet> getAllPlanets();

    void updatePlanet(Planet planet);

    void deletePlanet(String name);

    Planet findByName(String name);

}
