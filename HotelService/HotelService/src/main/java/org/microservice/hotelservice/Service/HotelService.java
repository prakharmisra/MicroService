package org.microservice.hotelservice.Service;

import org.microservice.hotelservice.Models.Hotel;

import java.util.*;

public interface HotelService {

    public List<Hotel> getAllHotel();

    public Hotel getHotel(String id);

    public Hotel createHotel(Hotel hotel);


}
