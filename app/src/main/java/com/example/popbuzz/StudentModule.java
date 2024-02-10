package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class StudentModule extends AppCompatActivity {

    CardView card_quiz, card_grade, card_game, card_calc, card_home;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_module);

        card_quiz = findViewById(R.id.card_quiz);
        card_grade = findViewById(R.id.card_grade);
        card_game = findViewById(R.id.card_game);
        card_calc = findViewById(R.id.card_calc);
        card_home = findViewById(R.id.card_home);

        card_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentModule.this, QuizModule.class);
                startActivity(i);
            }
        });
        card_grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentModule.this, GradeModule.class);
                startActivity(i);
            }
        });
        card_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentModule.this, TicTacToeModule.class);
                startActivity(i);
            }
        });
        card_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentModule.this, CalculatorModule.class);
                startActivity(i);
            }
        });
        card_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StudentModule.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}