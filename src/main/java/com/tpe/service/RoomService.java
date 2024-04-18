package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import com.tpe.exceptions.RoomNotFoundException;
import com.tpe.repository.RoomRepository;

import java.util.List;
import java.util.Scanner;

// serviceler servicelerle veya kendi repolariyla iletisime gecer!!!!
public class RoomService {
    private Scanner scanner = new Scanner(System.in);
    private final HotelService hotelService;

    private final RoomRepository roomRepository;

    public RoomService(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }

//room 1-c

    public void saveRoom() {
        Room room = new Room();

        System.out.println("Enter room ID : ");
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter room number : ");
        room.setNumber(scanner.nextLine());

        System.out.println("Enter room capacity : ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter Hotel ID : ");
        Long hotelId = scanner.nextLong();
        scanner.nextLine();

        //girilen id hangi otele ait
        Hotel foundHotel = hotelService.findHotelById(hotelId);

        if (foundHotel != null) {
            room.setHotel(foundHotel);//oda hangi otele ait ise kaydedildi
            //t_room tablosunda hotel_id sutununa bulunan otelin sadece idsini ekler

//        //bu odayi otelin oda listesine ekleyelim  ==>mappedBy eklemezsek bunu yazmak zorundayiz!!!
//        foundHotel.getRooms().add(room);  ==> mappedBy ile bu islemi yapmaya gerek kalmadi, bizim yerimize yapti

            roomRepository.save(room);//tabloya eklendi
            System.out.println("Room is saved successfully. Room ID : " + room.getId());
        }else System.out.println("Room is not saved!!!");
    }

    //room 2-c id'si verilen room'un console da goruntuleme
    public Room findRoomById(Long roomId) {
        Room foundRoom = roomRepository.findById(roomId);

        try {
            if (foundRoom != null) {
                System.out.println("*******************************************");
                System.out.println(foundRoom);
                System.out.println("*******************************************");
                return foundRoom;
            } else {
                throw new RoomNotFoundException("Room not found by ID : " + roomId);
            }
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //room 4
    public void getAllRooms() {
        List<Room> allRooms = roomRepository.findAll();
        if (!allRooms.isEmpty()) {
            System.out.println("---------------------- ALL ROOMS --------------------");
            allRooms.forEach(System.out::println);
        } else {
            System.out.println("Room list is empty");
        }

    }

}
