package org.microservice.userservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rating {

    private String ratingId;
    private String hotelId;
    private  int rating;
    private String userId;

    private Hotel hotel;

}
