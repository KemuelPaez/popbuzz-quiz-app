package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeacherModule extends AppCompatActivity {

    CardView card_grade, card_attendance, card_game, card_calc, card_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_module);

        card_grade = findViewById(R.id.card_teachGrade);
        card_attendance = findViewById(R.id.card_attendance);
        card_game = findViewById(R.id.card_game);
        card_calc = findViewById(R.id.card_calc);
        card_home = findViewById(R.id.card_home);

        card_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherModule.this, GradeModule.class);
                startActivity(i);
            }
        });
        card_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherModule.this, AttendanceModule.class);
                startActivity(i);
            }
        });
        card_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherModule.this, TicTacToeModule.class);
                startActivity(i);
            }
        });
        card_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherModule.this, CalculatorModule.class);
                startActivity(i);
            }
        });
        card_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TeacherModule.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}