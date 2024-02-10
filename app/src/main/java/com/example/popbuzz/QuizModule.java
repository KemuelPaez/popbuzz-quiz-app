package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class QuizModule extends AppCompatActivity {

    CardView card_start, card_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_module);

        card_start = findViewById(R.id.card_start);
        card_return = findViewById(R.id.card_return);

        card_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizModule.this, "Quiz started!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(QuizModule.this, QuizModule2.class);
                startActivity(i);
            }
        });
        card_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QuizModule.this, StudentModule.class);
                startActivity(i);
            }
        });

    }
}