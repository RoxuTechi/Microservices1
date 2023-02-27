package com.mcs.userservice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_user_table")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name="NAME")
    private String userName;

    @Column(name="EMAIL")
    private String userEmail;

    @Column(name="ABOUT")
    private String userAbout;

    //other user properties

    @Transient
    private List<Rating> ratings= new ArrayList<>();

}
