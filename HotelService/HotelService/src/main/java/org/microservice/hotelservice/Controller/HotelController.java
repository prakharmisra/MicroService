package org.microservice.hotelservice.Controller;

import org.microservice.hotelservice.Models.Hotel;
import org.microservice.hotelservice.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {


    @Autowired
    HotelService hotelService;


    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id){

        return ResponseEntity.ok(hotelService.getHotel(id));
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>>  getAllHotel(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }
}
