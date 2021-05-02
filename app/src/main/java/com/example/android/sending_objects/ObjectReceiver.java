package com.example.android.sending_objects;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.sending_objects.Models.Student;
import com.example.android.sending_objects.databinding.ActivityObjectReceiverBinding;

public class ObjectReceiver extends AppCompatActivity {
    ActivityObjectReceiverBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To inflate the layout
        b = ActivityObjectReceiverBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        //Changing title of the object viewing activity
        setTitle("Viewing Objects");
        //Calling the method to get details
        getInfo();
    }
    //Method To get details of the student from the other activity
    private void getInfo() {
        Student student = (Student) getIntent().getSerializableExtra(Constants.STUDENT_KEY);
            b.displayName.getEditText().setText(student.getName());
            b.gender.getEditText().setText(student.getGender());
            b.displayPhoneNo.getEditText().setText(student.getPhoneNumber());
            b.displayRollNumber.getEditText().setText(student.getRollNo());
    }
}