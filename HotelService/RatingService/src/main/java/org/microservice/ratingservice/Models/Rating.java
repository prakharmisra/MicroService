package org.microservice.ratingservice.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("user_rating")
public class Rating {

    @Id  //autogenerate
    private String ratingId;

    private String hotelId;
    private  int rating;
    private String userId;





}
