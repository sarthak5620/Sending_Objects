package com.example.android.sending_objects.Models;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    String gender;
    String phoneNumber;
    String rollNo;
    // default constructor for parent class
    public Student(){

    }
    //Parametrised constructor for class student. This is to get reference of the arguments of student class
    public Student(String name,String gender,String phoneNumber,String rollNo) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.rollNo = rollNo;
    }
    //Getter to get name
    public String getName() {
        return name;
    }
    //Getter to get Gender
    public String getGender() {
        return gender;
    }
    //Getter to get PhoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    //Getter to get RollNo
    public String getRollNo() {
        return rollNo;
    }

}
