package com.transportation;

import com.management.BusManagement;
import com.management.PassengerManagement;
import com.management.RouteManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Bus Management");
            System.out.println("2. Passenger Management");
            System.out.println("3. Route Management");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    busMenu();
                    break;
                case 2:
                    passengerMenu();
                    break;
                case 3:
                    routeMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void busMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add a new bus");
        System.out.println("2. View bus details");
        System.out.println("3. Update bus information");
        System.out.println("4. Delete a bus");
        System.out.println("5. Back to main menu");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                BusManagement.addBus();
                break;
            case 2:
                BusManagement.viewBusDetails();
                break;
            case 3:
                BusManagement.updateBus();
                break;
            case 4:
                BusManagement.deleteBus();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static void passengerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add a new passenger");
        System.out.println("2. View passenger details");
        System.out.println("3. Update passenger information");
        System.out.println("4. Delete a passenger");
        System.out.println("5. Back to main menu");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                PassengerManagement.addPassenger();
                break;
            case 2:
                PassengerManagement.viewPassengerDetails();
                break;
            case 3:
                PassengerManagement.updatePassenger();
                break;
            case 4:
                PassengerManagement.deletePassenger();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static void routeMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add a new route");
        System.out.println("2. View route details");
        System.out.println("3. Update route information");
        System.out.println("4. Delete a route");
        System.out.println("5. Back to main menu");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                RouteManagement.addRoute();
                break;
            case 2:
                RouteManagement.viewRouteDetails();
                break;
            case 3:
                RouteManagement.updateRoute();
                break;
            case 4:
                RouteManagement.deleteRoute();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}