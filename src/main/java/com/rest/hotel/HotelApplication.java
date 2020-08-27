package com.rest.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rest.hotel.model.Rooms;
import com.rest.hotel.model.Users;
import com.rest.hotel.repository.RoomsRepository;
import com.rest.hotel.repository.UserRepository;

@SpringBootApplication
public class HotelApplication
{
    public static void main(String[] args)
    {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(HotelApplication.class,
                args);

        UserRepository userRepo = configurableApplicationContext.getBean(UserRepository.class);
        RoomsRepository roomsRepo = configurableApplicationContext.getBean(RoomsRepository.class);
        // Dummy Data
        Rooms r1 = new Rooms(false);
        Rooms r2 = new Rooms(false);
        Rooms r3 = new Rooms(false);
        Rooms r4 = new Rooms(false);
        Rooms r5 = new Rooms(false);
        Rooms r6 = new Rooms(false);

        roomsRepo.save(r1);
        roomsRepo.save(r2);
        roomsRepo.save(r3);
        roomsRepo.save(r4);
        roomsRepo.save(r5);
        roomsRepo.save(r6);

        Users u1 = new Users("Vivek", 500);
        Users u2 = new Users("Rohit", 900);
        Users u3 = new Users("Rahul", 1000);

        userRepo.save(u1);
        userRepo.save(u2);
        userRepo.save(u3);

        /*
         * Optional<Rooms> rm = roomsRepo.findById((long) 1); ArrayList<Rooms> al = new
         * ArrayList<>(); rm.ifPresent(x -> al.add(x));
         * 
         * Optional<Users> ur = userRepo.findById((long) 4); ur.ifPresent((x) -> {
         * x.setRooms(al); userRepo.save(x); });
         */

    }

}
