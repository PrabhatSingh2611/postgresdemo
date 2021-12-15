package Connection;

import University.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllRecords {

    public static void main(String[] args) {

        List<Student> result = new ArrayList<>();

        String SQL_SELECT = "Select * from \"University\".\"Students\"";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/University", "postgres", "root");

             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surName = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                int groupId = resultSet.getInt("groupId");
                boolean gender = resultSet.getBoolean("gender");

                Student obj = new Student(id,name,surName,age,gender,groupId);


                result.add(obj);

            }
            result.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
