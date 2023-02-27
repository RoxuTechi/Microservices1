package com.mcs.userservice.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rating {
    private String ratingId;
    private String hotelId;
    private String userId;
    private int rating;
    private String feedback;
}
