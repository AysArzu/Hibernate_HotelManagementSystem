package com.tpe.service;

import com.tpe.domain.Room;
import com.tpe.exceptions.RoomNotFoundException;
import com.tpe.repository.RoomRepository;

import java.util.List;
import java.util.Scanner;

public class RoomService {
    private Scanner scanner = new Scanner(System.in);
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
        //room 1-c

    public void saveRoom(){
        Room room= new Room();
        System.out.println("Enter room ID :");
        room.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Enter room number :");
        room.setNumber(scanner.nextLine());
        System.out.println("Enter room capacity :");
        room.setCapacity(scanner.nextInt());
        System.out.println("Enter hotel name :");
       // room.setHotel(scanner.);

        roomRepository.save(room);
        System.out.println("Room is saved successfully. Room ID : " + room.getId());
    }
//room 2-c id'si verilen room'un console da goruntuleme
    public Room findRoomById(Long id) {
        Room foundRoom = roomRepository.findById(id);

        try {
            if (foundRoom != null) {
                System.out.println("*******************************************");
                System.out.println(foundRoom);
                System.out.println("*******************************************");
                return foundRoom;
            } else {
                throw new RoomNotFoundException("Room not found by ID : "+id);
            }
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void getAllRooms(){
        List<Room> allRooms =roomRepository.findAll();
        if(!allRooms.isEmpty()){
            System.out.println("---------------------- ALL ROOMS --------------------");
            allRooms.forEach(System.out::println);
        }else {
            System.out.println("Room list is empty");
        }

    }

}
