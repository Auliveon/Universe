package com.universe.controllers;


import com.universe.service.LordServiceImpl;

import com.universe.service.PlanetServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Autowired
    private PlanetServiceImpl planetService;

    @Autowired
    private LordServiceImpl lordService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/lords";
    }

    @RequestMapping("/lords")
    public String getAllLords(Model model) {
        model.addAttribute("lords", lordService.getAllLords());
        return "lords";
    }

    @RequestMapping("/planets")
    public String getAllPlanets(Model model) {
        model.addAttribute("planets", planetService.getAllPlanets());
        return "planets";
    }

    @RequestMapping("/gettoptenlords")
    public String getTopTenLords(Model model) {
        model.addAttribute("toptenlords", lordService.getTopTenJunLords());
        return "toptenlords";
    }

    @RequestMapping("/idlerlords")
    public String getIdlerLords(Model model) {
        model.addAttribute("idlerlords", lordService.getIdlerLords());
        return "idlerlords";
    }

}
