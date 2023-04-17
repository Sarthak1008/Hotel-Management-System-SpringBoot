package com.lcwd.user.service.HotelServices.Exception;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String s){
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource Not Found !!");
    }
}
