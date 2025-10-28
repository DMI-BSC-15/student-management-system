import java.sql.*;
import java.util.*;
import java.text.DecimalFormat;
import java.time.LocalDate;

// Updated Results Management System in Java
// Full Combined System: Results, Finance, Class Management
// Features: Enter results/SUPs, transcripts/GPA, semester registration, fee structure/payments/outstanding, scheduling with conflicts, allocations
// PDF generation removed to avoid iText dependency; use console output instead. Add iText JAR for PDFs.
// Database now MySQL: Requires running MySQL server with 'resultsdb' database.

public class ResultsManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/resultsdb?useSSL=false&serverTimezone=UTC";  // Adjust host/port if needed
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "tonny";  // Change to your MySQL username (e.g., 'rms_user')
    private static final String DB_PASS = "tedd";  // Change to your MySQL password

    private static final String CREATE_STUDENTS =
            "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), student_id VARCHAR(20) UNIQUE, " +
                    "current_semester INT DEFAULT 1, program VARCHAR(50))";

    private static final String CREATE_COURSES =
            "CREATE TABLE IF NOT EXISTS courses (id INT PRIMARY KEY AUTO_INCREMENT, course_name VARCHAR(100))";

    private static final String CREATE_SEMESTERS =
            "CREATE TABLE IF NOT EXISTS semesters (id INT PRIMARY KEY AUTO_INCREMENT, semester_number INT UNIQUE)";

    private static final String CREATE_SUBJECTS =
            "CREATE TABLE IF NOT EXISTS subjects (id INT PRIMARY KEY AUTO_INCREMENT, subject_name VARCHAR(50), course_id INT, " +
                    "FOREIGN KEY (course_id) REFERENCES courses(id))";

    private static final String CREATE_INSTRUCTORS =
            "CREATE TABLE IF NOT EXISTS instructors (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), instructor_id VARCHAR(20) UNIQUE)";

    private static final String CREATE_SUBJECT_INSTRUCTORS =
            "CREATE TABLE IF NOT EXISTS subject_instructors (subject_id INT, instructor_id INT, PRIMARY KEY(subject_id, instructor_id), " +
                    "FOREIGN KEY (subject_id) REFERENCES subjects(id), FOREIGN KEY (instructor_id) REFERENCES instructors(id))";

    private static final String CREATE_CLASSES =
            "CREATE TABLE IF NOT EXISTS classes (id INT PRIMARY KEY AUTO_INCREMENT, day VARCHAR(10), time_slot VARCHAR(20), " +
                    "subject_id INT, instructor_id INT, room VARCHAR(20), semester_number INT, " +
                    "FOREIGN KEY (subject_id) REFERENCES subjects(id), FOREIGN KEY (instructor_id) REFERENCES instructors(id))";

    private static final String CREATE_STUDENT_CLASSES =
            "CREATE TABLE IF NOT EXISTS student_classes (student_id VARCHAR(20), class_id INT, PRIMARY KEY(student_id, class_id), " +
                    "FOREIGN KEY (student_id) REFERENCES students(student_id), FOREIGN KEY (class_id) REFERENCES classes(id))";

    private static final String CREATE_RESULTS =
            "CREATE TABLE IF NOT EXISTS results (id INT PRIMARY KEY AUTO_INCREMENT, student_id VARCHAR(20), " +
                    "semester_id INT, subject_id INT, marks DOUBLE, grade VARCHAR(5), " +
                    "FOREIGN KEY (student_id) REFERENCES students(student_id), " +
                    "FOREIGN KEY (semester_id) REFERENCES semesters(id), " +
                    "FOREIGN KEY (subject_id) REFERENCES subjects(id))";

    private static final String CREATE_SUP_EXAMS =
            "CREATE TABLE IF NOT EXISTS sup_exams (id INT PRIMARY KEY AUTO_INCREMENT, student_id VARCHAR(20), " +
                    "semester_id INT, subject_id INT, status VARCHAR(10), marks DOUBLE, " +
                    "FOREIGN KEY (student_id) REFERENCES students(student_id), " +
                    "FOREIGN KEY (semester_id) REFERENCES semesters(id), " +
                    "FOREIGN KEY (subject_id) REFERENCES subjects(id))";

    private static final String CREATE_FEE_STRUCTURE =
            "CREATE TABLE IF NOT EXISTS fee_structure (id INT PRIMARY KEY AUTO_INCREMENT, program VARCHAR(50), " +
                    "fee_amount DOUBLE, semester INT, due_date DATE, PRIMARY KEY(program, semester))";

    private static final String CREATE_STUDENT_PAYMENTS =
            "CREATE TABLE IF NOT EXISTS student_payments (id INT PRIMARY KEY AUTO_INCREMENT, student_id VARCHAR(20), " +
                    "semester_number INT, amount_paid DOUBLE, payment_date DATE, receipt_no VARCHAR(20), " +
                    "FOREIGN KEY (student_id) REFERENCES students(student_id))";

    private Connection conn;

    public ResultsManagementSystem() {
        initDatabase();
        if (conn == null) {
            throw new RuntimeException("Database initialization failed—ensure MySQL server is running and credentials are correct.");
        }
        try {
            if (conn.isClosed()) {
                throw new RuntimeException("Database connection is closed—ensure MySQL server is running and credentials are correct.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database connection check failed: " + e.getMessage());
        }
    }

    private void initDatabase() {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
            stmt.execute(CREATE_STUDENTS);
            stmt.execute(CREATE_COURSES);
            stmt.execute(CREATE_SEMESTERS);
            stmt.execute(CREATE_SUBJECTS);
            stmt.execute(CREATE_INSTRUCTORS);
            stmt.execute(CREATE_SUBJECT_INSTRUCTORS);
            stmt.execute(CREATE_CLASSES);
            stmt.execute(CREATE_STUDENT_CLASSES);
            stmt.execute(CREATE_RESULTS);
            stmt.execute(CREATE_SUP_EXAMS);
            stmt.execute(C
