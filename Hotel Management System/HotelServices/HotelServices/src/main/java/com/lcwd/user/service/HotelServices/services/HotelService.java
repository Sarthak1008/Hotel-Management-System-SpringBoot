package com.lcwd.user.service.HotelServices.services;

import java.util.List;

import com.lcwd.user.service.HotelServices.entities.Hotel;

public interface HotelService {
    // create 
    Hotel create(Hotel hotel);

    // get all
    List<Hotel> getAll();

    // get single
    Hotel get(String id);
}
