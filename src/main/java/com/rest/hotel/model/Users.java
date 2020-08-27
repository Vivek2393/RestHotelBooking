package com.rest.hotel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int money;

    public Users(String name, int money)
    {
        super();
        this.name = name;
        this.money = money;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<Rooms> rooms = new ArrayList<>();

    public Users()
    {
        // TODO Auto-generated constructor stub
    }

    public Users(String name, int money, List<Rooms> rooms)
    {
        super();
        this.name = name;
        this.money = money;
        this.rooms = rooms;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public List<Rooms> getRooms()
    {
        return rooms;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setRooms(List<Rooms> rooms)
    {
        this.rooms = rooms;
    }

}
