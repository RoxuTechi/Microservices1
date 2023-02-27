package com.mcs.ratingService.services;

import com.mcs.ratingService.entities.Rating;
import com.mcs.ratingService.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    //create
    public Rating create(Rating rating){
      return this.ratingRepository.save(rating);
    }
    //get all rating of user
    public List<Rating> getRatings(){
        return this.ratingRepository.findAll();
    }

    //get rating by user id
    public List<Rating> getRatingByUserId(String userId){
     return this.ratingRepository.findByUserId(userId);
    }

    // get rating by hotel id
    public List<Rating> getRatingByHotelId(String hotelId){
        return this.ratingRepository.findByHotelId(hotelId);
    }


}
