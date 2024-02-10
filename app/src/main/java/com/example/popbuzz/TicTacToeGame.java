package com.example.popbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeGame extends AppCompatActivity implements View.OnClickListener {

    TextView player1_Score, player2_Score, playerStatus;
    Button[] buttons = new Button[9];
    Button reset, replay, exit;

    boolean player1_active;

    int player1_ScoreCount, player2_ScoreCount, rounds;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winningPos = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game);

        player1_Score = findViewById(R.id.score_p1);
        player2_Score = findViewById(R.id.score_p2);
        playerStatus = findViewById(R.id.text_status);
        reset = findViewById(R.id.btn_reset);
        replay = findViewById(R.id.btn_replay);
        exit = findViewById(R.id.btn_exit);

        buttons[0] = findViewById(R.id.btn0);
        buttons[1] = findViewById(R.id.btn1);
        buttons[2] = findViewById(R.id.btn2);
        buttons[3] = findViewById(R.id.btn3);
        buttons[4] = findViewById(R.id.btn4);
        buttons[5] = findViewById(R.id.btn5);
        buttons[6] = findViewById(R.id.btn6);
        buttons[7] = findViewById(R.id.btn7);
        buttons[8] = findViewById(R.id.btn8);


        for (int i = 0; i < buttons.length; i++){
            buttons[i].setOnClickListener(this);
        }

        player1_ScoreCount = 0;
        player2_ScoreCount = 0;
        rounds = 0;
        player1_active = true;

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TicTacToeGame.this, MainActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View view) {

        if(!((Button)view).getText().toString().equals("")){
            return;
        }else if(checkWinner()){
            return;
        }
        String buttonID = view.getResources().getResourceEntryName(view.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1,buttonID.length()));

        if(player1_active){

            ((Button)view).setText("X");
            ((Button)view).setTextColor(Color.parseColor("#F44336"));
            gameState[gameStatePointer] = 0;

        }else{

            ((Button)view).setText("O");
            ((Button)view).setTextColor(Color.parseColor("#FF3700B3"));
            gameState[gameStatePointer] = 1;
        }
        rounds++;

        if(checkWinner()){
            if(player1_active){

                player1_ScoreCount++;
                updatePlayerScore();
                playerStatus.setText("Player-1 has won!");

            }else{

                player2_ScoreCount++;
                updatePlayerScore();
                playerStatus.setText("Player-2 has won!");

            }
        }
        else if(rounds == 9){

            playerStatus.setText("DRAW");

        }else{

            player1_active =! player1_active;
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replay();
                player1_ScoreCount = 0;
                player2_ScoreCount = 0;
                updatePlayerScore();
            }
        });

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replay();
            }
        });

    }

    private boolean checkWinner() {

        boolean winnerResults = false;
        for(int[] winningPos: winningPos){

            if(gameState[winningPos[0]] == gameState[winningPos[1]] &&
                    gameState[winningPos[1]] == gameState[winningPos[2]] &&
                    gameState[winningPos[0]] != 2){

                winnerResults = true;

            }

        }

        return winnerResults;

    }

    private void replay() {

        rounds = 0;
        player1_active = true;
        for(int i = 0; i < buttons.length; i++){

            gameState[i] = 2;
            buttons[i].setText("");

        }

        playerStatus.setText("---");

    }

    private void updatePlayerScore() {

        player1_Score.setText(Integer.toString(player1_ScoreCount));
        player2_Score.setText(Integer.toString(player2_ScoreCount));

    }
}