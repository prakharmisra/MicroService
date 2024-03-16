package org.microservice.userservice.Exceptions;

public class UserNotFoundExceptions extends RuntimeException{

    public UserNotFoundExceptions(){
        super("User Not Found Exceptions");
    }

    public  UserNotFoundExceptions(String mesage){

        super(mesage);
    }
}
