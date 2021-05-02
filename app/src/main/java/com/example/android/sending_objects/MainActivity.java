package com.example.android.sending_objects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.android.sending_objects.Models.Student;
import com.example.android.sending_objects.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To inflate the layout
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        //call the method to hide error
        setupHideErrorForEditText();
    }
    // Overridden Method called to hide error when the text is changed.We have not used other two methods as they are not needed here
    private void setupHideErrorForEditText() {
        b.Name.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                b.Name.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

            b.PhoneNo.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                b.PhoneNo.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        b.RollNumber.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                b.RollNumber.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //Method to save data of student as an object
    private Student infoOfStudent() {
        String name = b.Name.getEditText().getText().toString().trim();
        //Validate name of student
        if (name.isEmpty()) {
            b.Name.setError("Please enter name");
            return null;
        }

        String gender;
        int type = b.radioGroup.getCheckedRadioButtonId();
        //Validate gender of student
        if (type == b.genderFemale.getId()) gender = "Female";
        else if (type == b.genderMale.getId()) gender = "Male";
        else{
            Toast.makeText(this, "Please select gender!", Toast.LENGTH_SHORT).show();
        return null;
        }

        String phoneNumber = b.PhoneNo.getEditText().getText().toString().trim();
        //Validate phone number of student
        if (phoneNumber.isEmpty()) {
            b.PhoneNo.setError("Please enter mobile number");
            return null;
        } else if (!phoneNumber.matches("^\\d{10}")) {
            b.PhoneNo.setError("Please enter a valid mobile number");
            return null;
        }

        String RollNo = b.RollNumber.getEditText().getText().toString().trim();
        //Validate roll no of student
        if (RollNo.isEmpty()) {
            b.RollNumber.setError("Please enter roll number");
            return null;
        } else if (!RollNo.matches("^\\d{2}[a-zA-Z]*\\d{3}")) {
            b.RollNumber.setError("Please enter valid roll number");
            return null;
        }
        return new Student(name,gender,phoneNumber,RollNo);
    }
    //Method which is invoked by on click
    public void SaveButton(View view) {
        Student student = infoOfStudent();
        if (student == null) {
            return;
        }
        //Intent to request an action from component apps
        Intent intent = new Intent(this, ObjectReceiver.class);
        intent.putExtra(Constants.STUDENT_KEY, student);
        startActivity(intent);
    }
}