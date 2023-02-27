package com.mcs.hotelService.services;

import com.mcs.hotelService.entities.Hotel;
import com.mcs.hotelService.exceptions.ResourceNotFoundException;
import com.mcs.hotelService.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
     public Hotel create(Hotel hotel){
         String hotelId =UUID.randomUUID().toString();
         hotel.setId(hotelId);
         return hotelRepository.save(hotel);
     }

     public List<Hotel> getAll(){
         return hotelRepository.findAll();
     }

     public Hotel get(String id){
         return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id is not present!!"));
     }
}
