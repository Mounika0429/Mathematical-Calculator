package calculator_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class mathcal{

    final static String url = "jdbc:mysql://localhost:3306/jdbc";
    final static String username = "root";
    final static String password = "root";

    // Display calculator menu
    public static String calculatorDisplay() {
        return "Welcome to Calculator\n\n" +
               "Choose one operation:\n" +
               "1. Add\n" +
               "2. Subtract\n" +
               "3. Multiplication\n" +
               "4. Division\n" +
               "5. Modulus\n" +
               "6. Square\n" +
               "7. Square Root\n" +
               "8. Power\n" +
               "9. View Calculator Records\n" +
               "10. Exit\n";
    }

    // Method to insert values into database
    public static void insertIntoDB(int choice, String operation, int a, int b, int result) {
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String insert = "INSERT INTO Calculator (userchoice, operation, a_value, b_value, result) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setInt(1, choice);
            ps.setString(2, operation);
            ps.setInt(3, a);
            ps.setInt(4, b);
            ps.setInt(5, result);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Calculation saved to database.");
            } else {
                System.out.println("Failed to save calculation.");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to handle user choice
    public static void calculatorFunction(int userChoice, Scanner scanner, Connection con) {
        int a = 0, b = 0;
		int result = 0;
        String operation = "";

        if (userChoice >= 1 && userChoice <= 5) {
            System.out.print("Enter first number: ");
            a = scanner.nextInt();
            System.out.print("Enter second number: ");
            b = scanner.nextInt();
        }

        switch (userChoice) {
            case 1:
                operation = "Add";
                result = a + b;
                System.out.println("Result: " + result);
                break;
            case 2:
                operation = "Subtract";
                result = a - b;
                System.out.println("Result: " + result);
                break;
            case 3:
                operation = "Multiplication";
                result = a * b;
                System.out.println("Result: " + result);
                break;
            case 4:
            	operation = "Division";
            	if (b == 0) {
                     System.out.println("Error: Division by zero!");
                     return;
                }
            	result = a / b;
            	System.out.println("Result: " + result);
            	break;
            case 5:
            	operation = "Modulus";
            	result = a % b;
            	System.out.println("Result: " + result);
            	break;
            case 6: 
                System.out.print("Enter number: ");
                a = scanner.nextInt();
                operation = "Square";
                result = a * a;
                System.out.println("Result: " + result);
                break;
            case 7: 
                System.out.print("Enter number: ");
                a = scanner.nextInt();
                operation = "Square Root";
                result = (int)Math.sqrt(a);
                System.out.println("Result: " + result);
                break;
            case 8: 
                System.out.print("Enter base: ");
                a = scanner.nextInt();
                System.out.print("Enter exponent: ");
                b = scanner.nextInt();
                operation = "Power";
                result = (int)Math.pow(a, b);
                System.out.println("Result: " + result);
                break;
            case 9:
            	viewCalculator(con, scanner);
				break;
            case 10:
                System.out.println("Exiting the program...");
                return;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                return;
        }

        // Insert values into database if valid operation
        if (userChoice >= 1 && userChoice <= 8) {
            insertIntoDB(userChoice, operation, a, b, result);
        }
    }
    
    public static void viewCalculator(Connection con, Scanner sc) {
	    try {
	        String query = "SELECT * FROM Calculator";
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        
	        System.out.printf("%-15s %-20s %-15s %-15s %-15s\n", "userchoice", "operation", "a_value", "b_value", "result");
	        System.out.println("-----------------------------------------------------------------------------------");
 
	        while (rs.next()) {
	            int userchoice = rs.getInt("userchoice");
	            String operation = rs.getString("operation");
	            int a_value = rs.getInt("a_value");
	            int b_value = rs.getInt("b_value");
	            int result = rs.getInt("result");

	            System.out.printf("%-15s %-20s %-15s %-15s %-15s\n", userchoice, operation, a_value, b_value, result);
	        }
	    } catch (Exception e) {
	        System.out.println("Error fetching calculator records: " + e.getMessage());
	    }
	}

    public static void main(String[] args) throws SQLException {
    	Connection con = DriverManager.getConnection(url, username, password);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while(true) {
        	System.out.println(calculatorDisplay());
            System.out.print("Select the operation: ");
            int userChoice = scanner.nextInt();
            calculatorFunction(userChoice, scanner, con);
            if (userChoice == 10) {
            	break;
            }
        }
    }
}


