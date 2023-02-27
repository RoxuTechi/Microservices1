package com.mcs.userservice.services;

import com.mcs.userservice.entities.User;
import com.mcs.userservice.exceptions.ResourceNotFoundException;
import com.mcs.userservice.repositories.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= (Logger) LoggerFactory.getLogger(UserService.class);


    // creating user
    public User saveUser(User user)
    // getting list of users
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    // get single user

    public User getUser(String userId){
        // get user from database with help of user repository
        User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with the given id is not availabel on srver!!"+userId));

        // fetch rating of the above user from RATING SERVICE
        //http://localhost:8083/ratings/users/be148861-4a23-4ba9-90f5-84ea2e80ffb7

           ArrayList forObject= restTemplate.getForObject("http://localhost:8083/ratings/users/be148861-4a23-4ba9-90f5-84ea2e80ffb7", ArrayList.class);


        return user;
    }
}
