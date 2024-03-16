package org.microservice.ratingservice.Repositry;

import org.microservice.ratingservice.Models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface RatingRepositry extends MongoRepository<Rating,String> {

      List<Rating> findByUserId(String userId);
      List<Rating> findByHotelId(String hotelId);

}
