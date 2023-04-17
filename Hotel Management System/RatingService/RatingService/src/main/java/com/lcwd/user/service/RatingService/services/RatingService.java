package com.lcwd.user.service.RatingService.services;

import java.util.List;

import com.lcwd.user.service.RatingService.entities.Rating;

public interface RatingService {
    // user Operations
 
 //create
 Rating saveRating(Rating rating);

 //get all ratings
 List<Rating> getAll();
 

 // get all by userId
 List<Rating> getRatingsByUserId(String userId);

 List<Rating> getRatingByHotelId(String hotelId);

 
}
