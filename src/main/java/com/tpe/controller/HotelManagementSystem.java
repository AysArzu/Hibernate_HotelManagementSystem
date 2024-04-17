package com.tpe.controller;

import com.tpe.config.HibernateUtils;
import com.tpe.repository.HotelRepository;
import com.tpe.repository.RoomRepository;
import com.tpe.service.HotelService;
import com.tpe.service.RoomService;

import java.util.Scanner;

public class HotelManagementSystem {

    private static Scanner scanner = new Scanner(System.in);


    //ana menü
    public static void displayHotelManagementSystemMenu() {
        //sadece 1 tane hotelrepo olusturduk, tum uygulamada kullanabiliriz.
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);
        RoomRepository roomRepository = new RoomRepository();
        RoomService roomService = new RoomService(roomRepository);

        boolean exit = false;

        while (!exit) {
            System.out.println("========= Hotel Management System =========");
            System.out.println("1.Hotel Operations");
            System.out.println("2.Room Operations");
            System.out.println("3.Guest Operations");
            System.out.println("4.Reservation Operations");
            System.out.println("0. Exit");
            System.out.println("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayHotelOperationsMenu(hotelService);
                    break;
                case 2:
                    displayRoomOperationsMenu(roomService);
                    break;
                case 3:
                    displayGuestOperationsMenu();
                    break;
                case 4:
                    displayReservationOperationsMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good Bye...");
                    HibernateUtils.shutdown();
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }


        }

    }

    //hotel operations
    private static void displayHotelOperationsMenu(HotelService hotelService) {
        //yeni obje uretmek yerine parametre verdik
        System.out.println("Hotel Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //1-a : save hotel
                    hotelService.saveHotel();
                    break;
                case 2:
                    //2-a hotel bulma
                    System.out.println("Enter hotel ID");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    hotelService.findHotelById(id);
                    break;
                case 3:

                    break;
                case 4:
                    //4-a tum otelleri bulma
                    hotelService.getAllHotels();
                    break;
                case 5:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    //room operations
    private static void displayRoomOperationsMenu(RoomService roomService) {


        System.out.println("Room Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    roomService.saveRoom();
                    break;
                case 2:
                    //2-a room bulma
                    System.out.println("Enter room ID");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    roomService.findRoomById(id);
                    break;
                case 3:

                    break;
                case 4:
                    roomService.getAllRooms();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    //guest operations
    private static void displayGuestOperationsMenu() {
        System.out.println("Guest Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:

                    break;
            }
        }
    }

    //reservation operations
    private static void displayReservationOperationsMenu() {
        System.out.println("Reservation Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Find Reservation By ID");
            System.out.println("3. Find All Reservations");
            System.out.println("4. Delete Reservation By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }


}