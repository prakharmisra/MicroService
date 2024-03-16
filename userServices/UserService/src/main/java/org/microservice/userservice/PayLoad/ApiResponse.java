package org.microservice.userservice.PayLoad;


import lombok.*;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ApiResponse {

    String message;
    boolean success;
    HttpStatus httpStatus;



}
