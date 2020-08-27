package com.rest.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.hotel.model.Rooms;

@Repository
public interface RoomsRepository extends CrudRepository<Rooms, Long>
{

}
