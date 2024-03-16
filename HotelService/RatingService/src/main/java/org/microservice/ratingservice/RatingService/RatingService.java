package org.microservice.ratingservice.RatingService;

import org.microservice.ratingservice.Models.Rating;

import java.util.List;

public interface RatingService {

    //create

    Rating createRating(Rating rating);

    //all ratings

    List<Rating> getAllRating();

    //get all by user rating

    List<Rating> getAllRatingByUserId(String userId);

    //get all hotel rating

    List<Rating> getAllHotelRating(String HotelId);
}
