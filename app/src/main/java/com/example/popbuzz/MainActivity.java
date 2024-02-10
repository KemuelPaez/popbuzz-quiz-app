package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView card_student, card_teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card_student = findViewById(R.id.card_student);
        card_teacher = findViewById(R.id.card_teacher);

        card_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Student Module selected!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, StudentModule.class);
                startActivity(i);
            }
        });

        card_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Teacher Module selected!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, TeacherModule.class);
                startActivity(i);
            }
        });

    }

}