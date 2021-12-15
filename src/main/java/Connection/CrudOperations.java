package Connection;

import University.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudOperations {

    public static void main(String[] args) {
        selectOperations();
       // insertOperation();
        //deleteOperation();
       // updateOperations();
    }

    public static void selectOperations(){
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

    public static void insertOperation() {
        String sql = "INSERT INTO \"University\".\"Students\" (\"id\", \"name\", \"surname\", \"age\", \"GroupId\", \"Gender\") " +
                " VALUES (?, ?, ?, ?,?,?)";
        //INSERT INTO "University"."Students" ("id", "name", "surname", "age", "GroupId", "Gender")
        // VALUES ('28', 'sdff', 'dfg', '27', '33', 'true');
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/University", "postgres", "root");
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, 28);
            statement.setString(2, "udisha");
            statement.setString(3, "pandey");
            statement.setInt(4, 45);
            statement.setInt(5, 33);
            statement.setBoolean(6, true);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteOperation(){
        //DELETE FROM "University"."Students" WHERE  "id"=28;
        String SQL_SELECT = "DELETE FROM \"University\".\"Students\" WHERE  \"id\"=?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/University", "postgres", "root");

             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setInt(1, 28);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A student was deleted successfully!");
            }
            }
        catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateOperations(){
        String sql = "UPDATE \"University\".\"Students\" SET \"surname\"=?, \"age\"=? WHERE \"id\"=?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/University", "postgres", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,"tiwari");
            preparedStatement.setInt(2,28);
            preparedStatement.setInt(3,27);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("A  student was updated successfully!");
            }
        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
