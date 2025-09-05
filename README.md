# 🧮 Java Calculator with MySQL Integration

This project is a **Java-based Calculator Application** integrated with **MySQL** using **JDBC**. 
It supports both basic operations like addition, subtraction, multiplication, and division, as well as advanced functions such as modulus, square, square root, and power. 
Every calculation performed by the user is automatically stored in a MySQL database, allowing them to view and manage their calculation history directly from the application. 
With proper error handling, database connectivity, and an interactive command-line interface, 
this project demonstrates the practical use of Java and MySQL integration in building real-time applications.

---

## ✨ Features
- Interactive menu-driven calculator
- Supported operations:
  1.	Addition
  2.	Subtraction
  3.	Multiplication
  4.	Division (with zero check)
  5.	Modulus
  6.	Square
  7.	Square root
  8.	Power
  9.	View Calculator Records
  10.	Exit  
- Stores every calculation in MySQL database  
- View past calculation history  
- Error handling for invalid inputs (e.g., division by zero)  
- Interactive command-line interface  

---

##  🚀 Technologies Used
- **Java (Core Java)**  
- **JDBC (Java Database Connectivity)**  
- **MySQL 8.0 (Command Line Client – Unicode)**  
- **MySQL Connector**: `mysql-connector-java-8.0.25`  

---

## 📝 Setup Instructions
1. Install **Java JDK 8 or higher**.  
2. Install **MySQL 8.0** and configure root user/password.  
3. Add the **MySQL Connector JAR (mysql-connector-java-8.0.25.jar)** to your project classpath.  
4. Create a database and table:

   ```sql
   CREATE DATABASE jdbc;
   USE jdbc;

   CREATE TABLE Calculator (
       userchoice INT,
       operation VARCHAR(50),
       a_value INT,
       b_value INT,
       result INT
   );
   
5. Update database credentials in the code if required:
- final static String url = "jdbc:mysql://localhost:3306/jdbc";
- final static String username = "root";
- final static String password = "root";

6. Running the Project
Compile and run the program from your IDE or terminal:

- javac mathcal.java
- java calculator_java.mathcal

- Select an operation from the menu.
- Results are displayed and saved into MySQL automatically.
- Option 9 → View calculation history.
- Option 10 → Exit the program.
  
## 📸 Screenshots

### 1️⃣ Calculator Menu
- After running the project, the calculator menu is displayed.
![Calculator Menu]

<img width="1919" height="1021" alt="Screenshot 2025-09-05 225225" src="https://github.com/user-attachments/assets/ad432b3b-4ce0-41f7-8fac-3e9e2df53b6b" />

### 2️⃣ Performing Addition
- Example showing addition of two numbers.
  
<img width="1916" height="979" alt="Screenshot 2025-09-05 225256" src="https://github.com/user-attachments/assets/8b84e21b-e814-4bca-b7d0-2f56ca8f6eb5" />

### 3️⃣ Performing Subtraction
- Example showing subtraction operation.
  
<img width="1918" height="981" alt="Screenshot 2025-09-05 225324" src="https://github.com/user-attachments/assets/0d30730d-78b8-40bd-8e35-246a78dd5e80" />

### 4️⃣ Performing Multiplication
- Example showing multiplication operation.

<img width="1907" height="993" alt="Screenshot 2025-09-05 225349" src="https://github.com/user-attachments/assets/07d34cc3-e6be-4c6e-abff-c3242285c5ed" />

### 5️⃣ Performing Division
- Example showing division operation and Modulus operation.

<img width="1919" height="1012" alt="Screenshot 2025-09-05 225438" src="https://github.com/user-attachments/assets/0cab0877-1565-4887-a4f3-8e205e99f419" />

<img width="1919" height="1023" alt="Screenshot 2025-09-05 225506" src="https://github.com/user-attachments/assets/c0cf92ea-437a-44cd-bebb-cd16243e7fc1" />

### 6️⃣ Square & Square Root
- Demonstration of square and square root calculations.

<img width="1919" height="1018" alt="Screenshot 2025-09-05 225529" src="https://github.com/user-attachments/assets/d74c1b73-454a-443e-8643-8ab768197284" />

<img width="1919" height="1017" alt="Screenshot 2025-09-05 225558" src="https://github.com/user-attachments/assets/91a670ce-e202-4204-9c6f-644478ef0828" />


### 7️⃣ Power Operation
- Example showing base & exponent calculation.

<img width="1919" height="1019" alt="Screenshot 2025-09-05 225628" src="https://github.com/user-attachments/assets/e8d65ef0-db29-49f7-bd3e-2de84f1ad840" />


### 8️⃣ MySQL Records
- All calculations are saved in the MySQL database and displayed here.

<img width="1919" height="1019" alt="Screenshot 2025-09-05 225656" src="https://github.com/user-attachments/assets/1c87c1dd-7d6f-4176-8c21-45388e41831f" />


### 📂 Project Structure
- mathcal.java → Main program file
- Calculator → Database table
- README.md → Project documentation
