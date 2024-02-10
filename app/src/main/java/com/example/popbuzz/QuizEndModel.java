package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizEndModel extends AppCompatActivity {

    TextView total_score, total_wrong;
    Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_end_model);

        Intent i = getIntent();
        String tScore = i.getStringExtra(QuizModule2.EXTRA_TSCORE);
        String tWrong = i.getStringExtra(QuizModule2.EXTRA_TWRONG);

        total_score = findViewById(R.id.totalScore);
        total_wrong = findViewById(R.id.totalWrong);
        btnEnd = findViewById(R.id.btn_end);

        total_score.setText("Total Score: "+tScore+"/10");
        total_wrong.setText("Total Wrong: "+tWrong);
        total_wrong.setTextColor(Color.RED);

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizEndModel.this, "Quiz Ended! Thanks for answering!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuizEndModel.this, StudentModule.class);
                startActivity(intent);
            }
        });
    }
}