package org.microservice.userservice.Service;

import lombok.Getter;
import lombok.Setter;
import org.microservice.userservice.Exceptions.UserNotFoundExceptions;
import org.microservice.userservice.External.services.HotelService;
import org.microservice.userservice.Models.Hotel;
import org.microservice.userservice.Models.Rating;
import org.microservice.userservice.Models.User;
import org.microservice.userservice.Repositry.UserRepositry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Getter
@Setter
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepositry userRepositry;

    @Autowired
    HotelService hotelService;

    @Autowired
    RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomeId = UUID.randomUUID().toString();
        user.setUid(randomeId);
        logger.trace("hello");
       return  userRepositry.save(user);
    }

    @Override
    public List<User> getAllUser() {
       return userRepositry.findAll();
    }

    @Override
    public User getUser(String userId) {
       User user =  userRepositry.findById(userId).orElseThrow(() -> new  UserNotFoundExceptions("User Not Found Exceptions" + userId));

        //http://localhost:8083/ratings/users/33504c80-ddd9-436d-b4ec-4efe2778ea1b

        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUid() , Rating[].class);

        for(Rating ob : forObject){
            logger.info("val : {}" ,ob);
        }

        List<Rating> ratings = Arrays.stream(forObject).toList();
        List<Rating> ratingList =   ratings.stream().map(rating -> {
              //api call to hotel service to get the hotel
          //http://localhost:8082/hotels/c9cfa878-db83-4616-b730-abb262a625c5
            //set the hotel to rating
            //return the rating

        //  ResponseEntity<Hotel> ratingResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
           Hotel hotel = hotelService.getHotel(rating.getHotelId());
          //Hotel hotel = ratingResponseEntity.getBody();

          rating.setHotel(hotel);
          return rating;

        }).collect(Collectors.toList());

        user.setRatingList(ratingList);

       return user;
    }
}
