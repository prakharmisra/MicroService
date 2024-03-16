package org.microservice.userservice.External.services;


import jakarta.ws.rs.PUT;
import org.microservice.userservice.Models.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public Rating createRating(Rating rating);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId , Rating rating);

    @DeleteMapping("/ratings{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);

}
