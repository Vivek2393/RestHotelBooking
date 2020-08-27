package com.rest.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.hotel.model.Rooms;
import com.rest.hotel.repository.RoomsRepository;

//defining the business logic
@Service
public class RoomService
{
    @Autowired
    RoomsRepository roomsRepository;

//getting all user records
    public List<Rooms> getAllRooms()
    {
        List<Rooms> roomsList = new ArrayList<Rooms>();

        roomsRepository.findAll().forEach(rooms -> roomsList.add(rooms));
        return roomsList;
    }

    public Rooms bookARoom()
    {
        ArrayList<Rooms> rmList = new ArrayList<>();
        Optional<Rooms> unbookedRoom = this.getAllRooms().stream().filter(room -> !room.isIsbooked()).findFirst();
        unbookedRoom.ifPresent(room ->
        {
            room.setIsbooked(true);
            rmList.add(room);
        });
        return rmList.get(0);
    }

//getting a specific record
    public Rooms getRoomById(long id)
    {
        return roomsRepository.findById(id).get();
    }

    public void saveOrUpdate(Rooms user)
    {
        roomsRepository.save(user);
    }

//deleting a specific record
    public void delete(long id)
    {
        roomsRepository.deleteById(id);
    }
}