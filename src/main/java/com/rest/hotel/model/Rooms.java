package com.rest.hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rooms")
public class Rooms
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean isbooked;

    public Rooms(boolean isbooked)
    {
        super();
        this.isbooked = isbooked;
    }

    public boolean isIsbooked()
    {
        return isbooked;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setIsbooked(boolean isbooked)
    {
        this.isbooked = isbooked;
    }

    public Rooms()
    {
        // TODO Auto-generated constructor stub
    }

}
