/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package courseregistrationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main{

    
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        System.out.println("=== COURSE REGISTRATION SYSTEM SETUP ===");

        
        int numCourses = 0;
        while (numCourses < 3) {
            System.out.print("How many courses to create? (At least 3): ");
            if (scanner.hasNextInt()) {
                numCourses = scanner.nextInt();
                scanner.nextLine(); // newline temizleme
                if (numCourses < 3) {
                    System.out.println("You must create at least 3 courses!");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        
        for (int i = 0; i < numCourses; i++) {
            System.out.println("\n-- Course " + (i + 1) + " --");
            System.out.print("Enter course name: ");
            String name = scanner.nextLine().trim();

            int capacity = 0;
            while (capacity <= 0) {
                System.out.print("Enter classroom capacity (positive integer): ");
                if (scanner.hasNextInt()) {
                    capacity = scanner.nextInt();
                    scanner.nextLine();
                    if (capacity <= 0) {
                        System.out.println("Capacity must be greater than 0.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.nextLine();
                }
            }

            courses.add(new Course(name, capacity));
        }

        
        System.out.println("\nCreated Courses Available for Registration:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName() + " (Capacity: " + c.getCapacity() + ")");
        }

        
        boolean running = true;
        while (running) {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Register Student to a Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");
            System.out.print("Select an option (1-3): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    
                    System.out.print("\nEnter Student ID: ");
                    String sId = scanner.nextLine().trim();

                    System.out.print("Enter Student Name: ");
                    String sName = scanner.nextLine().trim();

                    System.out.print("Enter Course Name to Register: ");
                    String targetCourseName = scanner.nextLine().trim();

                    
                    Course targetCourse = null;
                    for (Course c : courses) {
                        if (c.getCourseName().equalsIgnoreCase(targetCourseName)) {
                            targetCourse = c;
                            break;
                        }
                    }

                    
                    if (targetCourse == null) {
                        System.out.println("No course found with that name.");
                    } else if (targetCourse.isFull()) {
                        System.out.println("This course is full. Registration failed.");
                    } else if (targetCourse.isStudentEnrolled(sId)) {
                        System.out.println("This student is already registered for this course.");
                    } else {
                        Student newStudent = new Student(sId, sName);
                        targetCourse.addStudent(newStudent);
                        System.out.println("Registration successful.");
                    }
                    break;

                case "2":
                    System.out.println("\n=== ALL COURSES OVERVIEW ===");
                    for (Course c : courses) {
                        c.displayCourseInfo();
                    }
                    break;

                case "3":
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
