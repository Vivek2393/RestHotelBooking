package com.rest.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.hotel.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>
{

}
