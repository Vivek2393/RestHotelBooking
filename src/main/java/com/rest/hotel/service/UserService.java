package com.rest.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.hotel.model.Rooms;
import com.rest.hotel.model.Users;
import com.rest.hotel.repository.UserRepository;

//defining the business logic
@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

//getting all user records
    public List<Users> getAllUsers()
    {
        List<Users> users = new ArrayList<Users>();
        userRepository.findAll().forEach(student -> users.add(student));
        return users;
    }

//getting a specific record
    public Users getUserById(long id)
    {
        return userRepository.findById(id).get();
    }

    public void allotRoomToUser(long id, Rooms bookedRoom)
    {
        Users user = this.getUserById(id);
        user.setMoney(user.getMoney() - 400);
        user.getRooms().add(bookedRoom);

        this.saveOrUpdate(user);
    }

    public void saveOrUpdate(Users user)
    {
        userRepository.save(user);
    }

//deleting a specific record
    public void delete(long id)
    {
        userRepository.deleteById(id);
    }

    public boolean checkSufficientBalance(long id)
    {
        if (this.getUserById(id).getMoney() > 400)

            return true;
        else
            return false;

    }
}