package org.microservice.hotelservice.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Not Found Exceptions");
    }
}
