package org.microservice.hotelservice.Repositry;

import org.microservice.hotelservice.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepositry extends JpaRepository<Hotel,String> {

}
