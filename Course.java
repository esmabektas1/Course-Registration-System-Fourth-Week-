/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseregistrationsystem;

import java.util.ArrayList;
import java.util.List;


public class Course {
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    
    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    
    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

       public boolean isStudentEnrolled(String studentID) {
        for (Student s : enrolledStudents) {
            if (s.getStudentID().equalsIgnoreCase(studentID)) {
                return true;
            }
        }
        return false;
    }

    
    public boolean isFull() {
        return enrolledStudents.size() >= capacity;
    }

    
    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    
    public void displayCourseInfo() {
        System.out.println("----------------------------------------------");
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Enrolled: " + enrolledStudents.size());
        System.out.print("Enrolled Students: ");
        
        if (enrolledStudents.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.println();
            for (Student s : enrolledStudents) {
                System.out.println("  - " + s.getName() + " (ID: " + s.getStudentID() + ")");
            }
        }
    }
}
