package com.universe.controllers;


import com.universe.models.Lord;

import com.universe.models.Planet;

import com.universe.service.LordServiceImpl;

import com.universe.service.PlanetServiceImpl;

import com.universe.utils.StringFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@RestController
public class AjaxController {

    @Autowired
    private PlanetServiceImpl planetService;

    @Autowired
    private LordServiceImpl lordService;

    @PostMapping("/delete")
    public void deletePlanet(HttpServletRequest request) throws IOException {
        planetService.deletePlanet(StringFormatter.formatRequest(request.getReader().readLine()));

    }

    @PostMapping("/update")
    public void updatePlanet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            String convertedRequest = StringFormatter.formatRequest(request.getReader().readLine());

            String[] array = convertedRequest.split("-");

            Planet planet = planetService.findByName(array[0]);

            Lord lord = lordService.findByName(array[1]);

            if (lord != null) {
                planet.setLord(lord);
                planetService.updatePlanet(planet);
                response.getWriter().write("success");

            } else {
                response.getWriter().write("lordNotFound");
            }

        } catch (Exception e) {
            response.getWriter().write("error");
        }

    }

    @PostMapping("/createplanet")
    public void createPlanet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String convertedRequest = StringFormatter.formatRequest(request.getReader().readLine());
            String[] array = convertedRequest.split("-");
            Planet planet = planetService.findByName(array[0]);
            Lord lord = lordService.findByName(array[1]);
            if (planet == null && lord != null) {
                Planet newPlanet = new Planet();
                newPlanet.setName(array[0]);
                newPlanet.setLord(lord);
                planetService.updatePlanet(newPlanet);
                response.getWriter().write("success");

            } else if (planet != null) {
                response.getWriter().write("planetIsExists");

            } else {
                response.getWriter().write("lordNotFound");
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            response.getWriter().write("error");
        }

    }

    @PostMapping("/createlord")
    public void createLord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            String convertedRequest = StringFormatter.formatRequest(request.getReader().readLine());
            String[] array = convertedRequest.split("-");
            Lord lord = lordService.findByName(array[0]);
            if (lord == null) {
                Lord newLord = new Lord();
                newLord.setName(array[0]);
                newLord.setAge(Integer.parseInt(array[1]));
                lordService.createNewLord(newLord);
                response.getWriter().write("success");

            } else {
                response.getWriter().write("lordIsExists");
            }

        } catch (Exception e) {
            response.getWriter().write("error");
        }
    }
}
