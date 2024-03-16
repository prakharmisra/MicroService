package org.microservice.ratingservice.RatingController;


import org.microservice.ratingservice.Models.Rating;
import org.microservice.ratingservice.RatingService.RatingService;
import org.microservice.ratingservice.RatingService.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingServiceImpl ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRatinng( @RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));

    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/users/{userId}")
    public  ResponseEntity<List<Rating>> getAllRatingByUser(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getAllRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getAllRatingByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getAllHotelRating(hotelId));
    }
}
