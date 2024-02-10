package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuizModule2 extends AppCompatActivity {

    private TextView tvQuestion, tvScore, tvQuestionNo;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score = 0;
    int wrong = 0;

    ColorStateList dfRbColor;
    boolean answered;

    private QuestionModel currentQuestion;

    private List<QuestionModel> questionsList;

    public static final String EXTRA_TSCORE = "com.example.apptrivia.EXTRA_TSCORE";
    public static final String EXTRA_TWRONG = "com.example.apptrivia.EXTRA_TWRONG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_module2);

        questionsList = new ArrayList<>();
        tvQuestion = findViewById(R.id.textQuestion);
        tvScore = findViewById(R.id.textScore);
        tvQuestionNo = findViewById(R.id.textQuestionNo);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btnNext = findViewById(R.id.btnNext);

        dfRbColor = rb1.getTextColors();

        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered == false){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                        checkanswer();
                    }else{
                        Toast.makeText(QuizModule2.this, "Please select an option!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNextQuestion();
                }
            }
        });

    }

    private void checkanswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected) + 1;
        if (answerNo == currentQuestion.getCorrectAnsNo()){
            score++;
            tvScore.setText("Score: "+score);

        }else{
            wrong++;
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
        }
        if(qCounter < totalQuestions){
            btnNext.setText("Next");
        }else{
            btnNext.setText("Finish Quiz");

            String total, twrong;

            total = String.valueOf(score);
            twrong = String.valueOf(wrong);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(), QuizEndModel.class);
                    i.putExtra(EXTRA_TSCORE, total);
                    i.putExtra(EXTRA_TWRONG, twrong);
                    startActivity(i);
                }
            });

        }

    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);

        if(qCounter < totalQuestions){
            currentQuestion = questionsList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            qCounter++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Question: "+qCounter+"/"+totalQuestions);
            answered = false;

        }else{
            finish();
        }

    }

    private void addQuestions() {
        questionsList.add(new QuestionModel("This folder will contain various XML files, such as strings, colors, styles.",
                "A: Resource Folder", "B: Layout Folder", "C: Mipmap Folder", 1));
        questionsList.add(new QuestionModel("This folder will contain app/launcher icons that are used to show on the home screen.",
                "A: Manifests Folder", "B: Mipmap Folder", "C: Layout Folder", 2));
        questionsList.add(new QuestionModel("This folder will contain all XML layout files which we used to define the user interface of our application.",
                "A: Values Folder", "B: Resource Folder", "C: Layout Folder", 3));
        questionsList.add(new QuestionModel("It is one of the basic building blocks of creating layouts in ConstraintLayout.",
                "A: Relative Positioning", "B: Constant Positioning", "C: Easy Positioning", 1));
        questionsList.add(new QuestionModel("It is the standard text entry widget in Android apps. If the user enters the text into an app, \n this is the primary way for them to do that.",
                "A: EditText", "B: TextView", "C: OnClickListener", 2));
        questionsList.add(new QuestionModel("A simple message object that is used to communicate between Android components such as activities, content providers etc.",
                "A: Class", "B: Method", "C: Intent", 3));
        questionsList.add(new QuestionModel("This folder will contain all your Gradle Scripts",
                "A: Gradle Scripts", "B: Gradle Library", "C: Gradle Directory", 1));
        questionsList.add(new QuestionModel("It is used for set of radio buttons.",
                "A: Radio Set", "B: Radio Group", "C: Radio Friends", 2));
        questionsList.add(new QuestionModel("It is the user interface which displays the text message on the screen to the user.",
                "A: ViewText", "B: EditText", "C: TextView", 3));
        questionsList.add(new QuestionModel("is an Interface definition for a callback to be invoked when a view (button in your case) is clicked.",
                "A: OnClickListener();", "B: OnClickAndListen();", "C: OnClickLearnAndListen();", 1));

    }
}