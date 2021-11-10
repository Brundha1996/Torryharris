package com.torryharris.trainultimate.controller;

import com.torryharris.trainultimate.model.Ticket;
import com.torryharris.trainultimate.model.Train;
import com.torryharris.trainultimate.model.User;
import com.torryharris.trainultimate.repository.PassengerRepo;
import com.torryharris.trainultimate.repository.TrainRepo;
import com.torryharris.trainultimate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    TrainRepo trainRepo;
    @Autowired
    PassengerRepo passengerRepo;
    @Autowired
    Ticket ticket;
    @RequestMapping("Login")
    public String user(User user){

        return "LoginPage.jsp";
    }
    @RequestMapping("Register")
    public String addUser(User user){
        userRepo.save(user);
        return "LoginPage.jsp";
    }
    @RequestMapping("trainDetails")
    public ModelAndView traindetails(@RequestParam int trainNo,String date){
        ModelAndView mv=new ModelAndView("Passenger.jsp");
        Train train=trainRepo.findById(trainNo).orElse(new Train());
        mv.addObject(train);
        ticket.setTrain(train);
        ticket.setDateString(date);
        System.out.println(date);
        return mv;
    }
    @RequestMapping("addPassengers")
    public ModelAndView passengerDetails(@RequestParam int trainNo,@RequestParam int noOfPassengers, HttpServletRequest request){
        ModelAndView mv=new ModelAndView("confirm.jsp");
        Train train=trainRepo.findById(trainNo).orElse(new Train());
        mv.addObject(train);
        for(int i=1;i<=noOfPassengers;i++){
            
            String name=request.getParameter("name"+i);
            int age=Integer.parseInt(request.getParameter("age"+i));
            char gender=request.getParameter("gender"+i).charAt(0);
            ticket.addPassengers(name,age,gender);
            
        }
        return mv;
    }
    @RequestMapping("download")
    public String downloadTicket(){
        ticket.writeTicket();
        ticket.setCounter(ticket.getCounter()+1);
        return "confirm.jsp";
    }
}
