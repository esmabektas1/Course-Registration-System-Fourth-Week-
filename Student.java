/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseregistrationsystem;


public class Student {
    private String studentID;
    private String name;

    
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    
    public void displayStudent() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
    }
}


