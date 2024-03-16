package org.microservice.ratingservice.RatingService;

import org.microservice.ratingservice.Models.Rating;
import org.microservice.ratingservice.Repositry.RatingRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepositry ratingRepositry;
    @Override
    public Rating createRating(Rating rating) {
        return ratingRepositry.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepositry.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepositry.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllHotelRating(String hotelId) {
        return  ratingRepositry.findByHotelId(hotelId);
    }
}
