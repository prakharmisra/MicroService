package org.microservice.userservice.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.microservice.userservice.Models.User;
import org.microservice.userservice.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User userResp  = userService.saveUser(user);

       return ResponseEntity.status(HttpStatus.CREATED).body(userResp);

    }
    int retryCount = 1;
    @GetMapping("/{userId}")
   // @CircuitBreaker(name = "ratingHotelCall",fallbackMethod = "callingFallBack")
    //@Retry(name = "RatingHotelService", fallbackMethod = "callingFallBack")
    @RateLimiter(name = "userRateLimiter" ,fallbackMethod = "callingFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){logger.info("retry count:  {} " , retryCount);
        retryCount++;
       User user = userService.getUser(userId);
       return ResponseEntity.ok(user);

    }




    //creating fallBackMehtod for circuit breaker
    public ResponseEntity<User> callingFallBack(String uId , Exception ex){
//logger.info("FallBackExcecuted beacuase service is down" , ex.getMessage());

        User user =  User.builder().Email("dummy.com").name("dummy").about("this is dummy").build();

        return ResponseEntity.ok(user);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        String val = "R";

        List<User> users = userService.getAllUser();

        check( userService.getAllUser(),val );

        return ResponseEntity.ok(userService.getAllUser());
    }


    public void check( List<User> users, String vals){

        List<String> formattedData ;

         formattedData = users.stream()
              .sorted((a, b) -> a.getName().compareTo(b.getName()))
              .map(data -> formatData(data))
              .toList();

         logger.info("detail : {}",formattedData);

    }


    private String formatData(User data) {

        return data.getName() + ", " + data.getAbout() + ", " + data.getEmail();
    }
}
