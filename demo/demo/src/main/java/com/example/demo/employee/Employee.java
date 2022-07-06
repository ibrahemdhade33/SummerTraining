package com.example.demo.employee;

import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
@Entity
@Table(name = "Employee_info")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID ;

    private String firstName ;

    private String lastName ;

    private int Salary ;

    private String Email ;

    private String Position ;
    public Employee (String firstName, String lastName, int salary, String email, String position) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.Salary = salary;
        this.Email = email;
        this.Position = position;
    }

    public Employee() {

    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Salary=" + Salary +
                ", Email='" + Email + '\'' +
                ", Position='" + Position + '\'' +
                '}';
    }
}
