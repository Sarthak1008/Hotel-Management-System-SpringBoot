package com.lcwd.user.service.UserService.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.Exception.ResourceNotFoundException;
import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.external.services.HotelService;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given ID is not found on the server :"+userId));
        // fetch rating of the above user from rating service
        // http://localhost:8084/ratings/users/a9ae3de2-bc9d-4ca5-9485-ee577b0f92db
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGS-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
        

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            System.out.println(rating.getHotelId());
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            //logger.info("response status code: {} ",forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        // Generate unique userID
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }
}
