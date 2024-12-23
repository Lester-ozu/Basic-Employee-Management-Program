import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DataRepository {
    
    private static String url, query;
    private static Connection conn;
    private static Statement statement;

    static {

        try {

            url = "jdbc:sqlite:src/EmployeeDB.db";
            conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
        }

        catch (SQLException e) {

            System.out.println("Failed to connect to database: " + e.getMessage());
        }

        catch (Exception e) {

            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url);Statement stmt = conn.createStatement()) {

            query = "create table if not exists Employees (\n"
                    + "Name varchar(30),\n"
                    + "Position varchar(25),\n"
                    + "Age INT, \n"
                    + "ID varchar(6)\n"
                    + ");";

            stmt.execute(query);
        }

        catch (SQLException e) {

            System.out.println("Failed to connect to database: " + e.getMessage());
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void addEmployee(Employee emp) {

        query = "INSERT INTO Employees (Name, Position, Age, ID) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pdst = conn.prepareStatement(query)) {
            
            pdst.setString(1, emp.getName());
            pdst.setString(2, emp.getPosition());
            pdst.setInt(3, (int)emp.getAge());
            pdst.setString(4, emp.getID());
            pdst.executeUpdate();
        }
        
        catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());
        }

        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean delEmployee(Employee emp) {

        query = "DELETE FROM Employees WHERE Name = ? AND Position = ? AND Age = ? AND ID = ?";

        try (PreparedStatement pdst = conn.prepareStatement(query)) {

            pdst.setString(1, emp.getName());
            pdst.setString(2, emp.getPosition());
            pdst.setInt(3, (int)emp.getAge());
            pdst.setString(4, emp.getID());

            int rowsAffected = pdst.executeUpdate();

            if (rowsAffected > 0) return true;
            else return false;
        }

        catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());
        }

        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        return false;
    } 

    public static void clear() {

        query = "DELETE FROM Employees";

        try(Statement stmt = conn.createStatement()) {

            stmt.executeQuery(query);
        }

        catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());
        }

        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ResultSet getTable() {

        query = "SELECT * FROM Employees";
        ResultSet rs = null;

        try {

            rs = statement.executeQuery(query);
        }

        catch (SQLException e) {

            System.out.println("Error: " + e.getMessage());
        }

        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        return rs;
    }

    public static void importArrayList(Employee [] list, int size) {

        clear();

        for (int i = 0 ; i < size ; i++) {
            
            addEmployee(list[i]);
        }
    }

    public static void importArrayList(ArrayList<Employee> list, int size) {

        clear();

        for (int i = 0 ; i < size ; i++) {
            
            addEmployee(list.get(i));
        }
    }

    public static void importStack(Stack<Employee> list) {

        clear();

        for(Employee employee : list) {

            addEmployee(employee);
        }
    }

    public static void importQueue(Queue<Employee> list) {

        clear();

        for(Employee employee : list) {

            addEmployee(employee);
        }
    }

    public static void importLinkedList(Employee head, int size) {

        clear();

        int x = 0;
        Employee nav1 = head;

        while (x != size) {

            addEmployee(nav1);
            nav1 = nav1.getNext();
            x++;
        }
    }

    public static void importLinkedList(LinkedList<Employee> list, int size) {

        clear();

        for (Employee employee : list) {

            addEmployee(employee);
        }
    }
}   
