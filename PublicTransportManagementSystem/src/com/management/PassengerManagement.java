package com.management;

import com.transportation.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class PassengerManagement {
    public static void addPassenger() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            String sql = "INSERT INTO Passenger (name, email, phone_number, address) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);
            statement.setString(4, address);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new passenger was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewPassengerDetails() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Passenger";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("passenger_id");
                String name = result.getString("name");
                String email = result.getString("email");
                String phoneNumber = result.getString("phone_number");
                String address = result.getString("address");

                System.out.printf("Passenger ID: %d, Name: %s, Email: %s, Phone Number: %s, Address: %s\n", id, name, email, phoneNumber, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePassenger() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter passenger ID to update: ");
            int passengerId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Enter new address: ");
            String address = scanner.nextLine();

            String sql = "UPDATE Passenger SET name=?, email=?, phone_number=?, address=? WHERE passenger_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);
            statement.setString(4, address);
            statement.setInt(5, passengerId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Passenger information updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePassenger() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter passenger ID to delete: ");
            int passengerId = scanner.nextInt();

            String sql = "DELETE FROM Passenger WHERE passenger_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, passengerId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Passenger deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
