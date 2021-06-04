package com.universe.service;


import com.universe.models.Lord;

import java.util.List;


public interface LordService {

    List<Lord> getAllLords();

    void createNewLord(Lord lord);

    void deleteLord(Lord lord);

    List<Lord> getTopTenJunLords();

    List<Lord> getIdlerLords();

    Lord findByName(String name);

}
