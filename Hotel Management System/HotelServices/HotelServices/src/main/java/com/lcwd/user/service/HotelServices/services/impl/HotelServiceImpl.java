package com.lcwd.user.service.HotelServices.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.HotelServices.Exception.ResourceNotFoundException;
import com.lcwd.user.service.HotelServices.entities.Hotel;
import com.lcwd.user.service.HotelServices.repositories.HotelRepository;
import com.lcwd.user.service.HotelServices.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel With given id is not found"));
    }
    
}
