package com.lcwd.user.service.HotelServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.HotelServices.entities.Hotel;


public interface HotelRepository extends JpaRepository<Hotel,String> {
    
}
