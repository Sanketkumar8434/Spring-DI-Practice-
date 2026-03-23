package com.sanket.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("wmg")
public class WishMessageGenerator {

    @Autowired
    LocalDateTime dateTime; //HAS-A PROPERTY

    //b.method
    public String GenerateWish(String user)
    {
        int hour = dateTime.getHour();
        if(hour<12)
            return "Good Morning "+user;
        else if(hour<16)
            return "Good Afternoon "+user;
        else if(hour<20)
            return "Good Evening "+user;
        else
            return "Good Night "+user;

    }
}
