package com.tpe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_hotel")
public class Hotel {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    //todo: one-to-many
    @OneToMany(mappedBy = "hotel")//hotel ile room arasinda iliski kurulmasini saglar=> iliski tablosu ekler 3. tablo olusur
//mappedBy yazinca ekstra tablo olusmasini engelledik. iliskiyi eslestirdik
    private List<Room> rooms = new ArrayList<>();

    //hibernate data cekerken(fetch yaparken) default constructori kullanir.
    public Hotel() {
    }

    //param constructor
    public Hotel(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
