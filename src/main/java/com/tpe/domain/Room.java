package com.tpe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_room")
public class Room {
    @Id
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer capacity;

    //todo: many to one
    @ManyToOne//room ile hotel arasinda iliski kurulmasini saglar:room tablosunda FK(hotel_id) ekler
    @JoinColumn(name="hotel_id",nullable = false)//opsiyonel
    private Hotel hotel;

    //todo:one-to-many
    private List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Room(Long id, String number, Integer capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }
//getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    //toString()

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
