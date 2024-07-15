package com.management;

import com.transportation.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class BusManagement {
    public static void addBus() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number plate: ");
            String numberPlate = scanner.nextLine();
            
            System.out.print("Enter model: ");
            String model = scanner.nextLine();

            System.out.print("Enter capacity: ");
            int capacity = scanner.nextInt();

            System.out.print("Enter availability status (true/false): ");
            boolean availabilityStatus = scanner.nextBoolean();

            String sql = "INSERT INTO Bus (number_plate, model, capacity, availability_status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, numberPlate);
            statement.setString(2, model);
            statement.setInt(3, capacity);
            statement.setBoolean(4, availabilityStatus);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new bus was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBusDetails() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Bus";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("bus_id");
                String numberPlate = result.getString("number_plate");
                String model = result.getString("model");
                int capacity = result.getInt("capacity");
                boolean availabilityStatus = result.getBoolean("availability_status");

                System.out.printf("Bus ID: %d, Number Plate: %s, Model: %s, Capacity: %d, Availability: %b\n", id, numberPlate, model, capacity, availabilityStatus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBus() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter bus ID to update: ");
            int busId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter new number plate: ");
            String numberPlate = scanner.nextLine();
            
            System.out.print("Enter new model: ");
            String model = scanner.nextLine();

            System.out.print("Enter new capacity: ");
            int capacity = scanner.nextInt();

            System.out.print("Enter new availability status (true/false): ");
            boolean availabilityStatus = scanner.nextBoolean();

            String sql = "UPDATE Bus SET number_plate=?, model=?, capacity=?, availability_status=? WHERE bus_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, numberPlate);
            statement.setString(2, model);
            statement.setInt(3, capacity);
            statement.setBoolean(4, availabilityStatus);
            statement.setInt(5, busId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Bus information updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBus() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter bus ID to delete: ");
            int busId = scanner.nextInt();

            String sql = "DELETE FROM Bus WHERE bus_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, busId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Bus deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

