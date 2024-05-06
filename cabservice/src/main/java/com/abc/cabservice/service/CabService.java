package com.abc.cabservice.service;

import java.util.List;


import com.abc.cabservice.entity.Cab;

public interface CabService {

    List<Cab> getAllCabs();

    Cab getCabById(int id);

    Cab addCab(Cab cab);

    Cab updateCab(int id, Cab cab);

    void deleteCab(int id);


}