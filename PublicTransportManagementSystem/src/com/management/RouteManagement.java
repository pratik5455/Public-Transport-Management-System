package com.management;

import com.transportation.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class RouteManagement {
    public static void addRoute() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter start location: ");
            String startLocation = scanner.nextLine();
            
            System.out.print("Enter end location: ");
            String endLocation = scanner.nextLine();

            System.out.print("Enter distance: ");
            double distance = scanner.nextDouble();

            System.out.print("Enter duration: ");
            double duration = scanner.nextDouble();

            String sql = "INSERT INTO Route (start_location, end_location, distance, duration) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, startLocation);
            statement.setString(2, endLocation);
            statement.setDouble(3, distance);
            statement.setDouble(4, duration);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new route was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewRouteDetails() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM Route";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("route_id");
                String startLocation = result.getString("start_location");
                String endLocation = result.getString("end_location");
                double distance = result.getDouble("distance");
                double duration = result.getDouble("duration");

                System.out.printf("Route ID: %d, Start Location: %s, End Location: %s, Distance: %.2f, Duration: %.2f\n", id, startLocation, endLocation, distance, duration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRoute() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter route ID to update: ");
            int routeId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter new start location: ");
            String startLocation = scanner.nextLine();
            
            System.out.print("Enter new end location: ");
            String endLocation = scanner.nextLine();

            System.out.print("Enter new distance: ");
            double distance = scanner.nextDouble();

            System.out.print("Enter new duration: ");
            double duration = scanner.nextDouble();

            String sql = "UPDATE Route SET start_location=?, end_location=?, distance=?, duration=? WHERE route_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, startLocation);
            statement.setString(2, endLocation);
            statement.setDouble(3, distance);
            statement.setDouble(4, duration);
            statement.setInt(5, routeId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Route information updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRoute() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter route ID to delete: ");
            int routeId = scanner.nextInt();

            String sql = "DELETE FROM Route WHERE route_id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, routeId);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Route deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
