package com.example.courseregistrationwaitlist_surabhipadmini;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText courseNameEdt, studentNameEdt, userPriorityEdt, studentDescriptionEdt;
    private Button addCourseBtn, readCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        studentNameEdt = findViewById(R.id.idEdtCourseTracks);
        userPriorityEdt = findViewById(R.id.idEdtCourseDuration);
        studentDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        readCourseBtn = findViewById(R.id.idBtnReadCourse);

        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String courseName = courseNameEdt.getText().toString();
                String studentName = studentNameEdt.getText().toString();
                String userPriority = userPriorityEdt.getText().toString();
                String studentDescription = studentDescriptionEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (courseName.isEmpty() || studentName.isEmpty() || userPriority.isEmpty() || studentDescription.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(courseName, userPriority, studentDescription, studentName);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Student has been added.", Toast.LENGTH_SHORT).show();
                courseNameEdt.setText("");
                userPriorityEdt.setText("");
                studentNameEdt.setText("");
                studentDescriptionEdt.setText("");
            }
        });

        readCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewCourses.class);
                startActivity(i);
            }
        });
    }
}