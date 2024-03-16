package org.microservice.hotelservice.Service;

import org.microservice.hotelservice.Exception.ResourceNotFoundException;
import org.microservice.hotelservice.Models.Hotel;
import org.microservice.hotelservice.Repositry.HotelRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService{


    @Autowired
    HotelRepositry hotelRepositry;
    @Override
    public List<Hotel> getAllHotel() {
       return  hotelRepositry.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepositry.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id =  UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepositry.save(hotel);
    }
}
