package com.rest.hotel.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.hotel.model.Rooms;
import com.rest.hotel.model.Users;
import com.rest.hotel.service.RoomService;
import com.rest.hotel.service.UserService;

//creating RestController
@RestController
public class UserController
{

    @Autowired
    UserService userService;

    @Autowired
    RoomService roomsService;

//creating a get mapping that retrieves all the user detail from the database 

    @RequestMapping(method = RequestMethod.GET, path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Users> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/rooms")
    private List<Rooms> getAllRooms()
    {
        return roomsService.getAllRooms();
    }

    @PutMapping("/book/{id}")
    private ResponseEntity<String> bookRoom(@PathVariable("id") long id)
    {
        try
        {
            if (userService.checkSufficientBalance(id))
            {
                Rooms bookedRoom = roomsService.bookARoom();
                userService.allotRoomToUser(id, bookedRoom);
                int numberOfRooms = userService.getUserById(id).getRooms().size();
                String username = userService.getUserById(id).getName();
                return new ResponseEntity<>("User " + username + " Booked Room Number "
                        + userService.getUserById(id).getRooms().get(numberOfRooms - 1).getId()
                        + ". Available Balance with " + username + " is " + userService.getUserById(id).getMoney()
                        + " ", HttpStatus.CREATED);
            } else
                return new ResponseEntity<>("Insufficient Balance with User ->" + userService.getUserById(id).getName()
                        + " Minimum 400 INR is required to book a Room", HttpStatus.NOT_ACCEPTABLE);
        } catch (IndexOutOfBoundsException ex)
        {
            return new ResponseEntity<>("All rooms are booked. No Vacancy", HttpStatus.NOT_ACCEPTABLE);
        } catch (NoSuchElementException ex)
        {
            return new ResponseEntity<>("NO user with given id " + id + " is found", HttpStatus.NOT_FOUND);
        }
    }

//creating a get mapping that retrieves the detail of a specific user
    @GetMapping("/user/{id}")
    private Users getUser(@PathVariable("id") long id)
    {
        return userService.getUserById(id);
    }

//creating a delete mapping that deletes a specific user
    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id)
    {
        userService.delete(id);
    }

//creating post mapping that creates a new user
    @PostMapping("/user")
    private ResponseEntity<String> saveUser(@RequestBody Users user)
    {
        userService.saveOrUpdate(user);
        return new ResponseEntity<>("User " + user.getName() + " Created", HttpStatus.CREATED);
    }
}
