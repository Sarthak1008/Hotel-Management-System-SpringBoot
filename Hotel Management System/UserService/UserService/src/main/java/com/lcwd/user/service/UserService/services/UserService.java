package com.lcwd.user.service.UserService.services;

import java.util.List;

import com.lcwd.user.service.UserService.entities.User;

public interface UserService {
 // user Operations
 
 //create
 User saveUser(User user);

 //get all users
 List<User> getAllUser();

 // get single User of given userId

 User getUser(String userId);
}
