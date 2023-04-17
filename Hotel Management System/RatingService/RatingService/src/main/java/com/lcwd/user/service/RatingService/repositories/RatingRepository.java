package com.lcwd.user.service.RatingService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.RatingService.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating,String>{
    // custom finder methods

    List<Rating> findByHotelId(String hotelId);
    List<Rating> findByUserId(String userId);
}
