package com.example.android.kindergartenquiz;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //Initialized
    int totalScore = 0;
    RadioButton question1;
    RadioButton question2;
    CheckBox question3a;
    CheckBox question3b;
    CheckBox question3c;
    CheckBox question4a;
    CheckBox question4b;
    CheckBox question4c;
    RadioButton question5;
    RadioButton question6;
    EditText question7;
    EditText question8;
    EditText nameInput;
    Button reset;
    Button submitAnswers;
    Editable userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question1 = findViewById(R.id.three_dimensional);
        question2 = findViewById(R.id.sphere);
        question3a = findViewById(R.id.sphere3_box);
        question3b = findViewById(R.id.sphere6_box);
        question3c = findViewById(R.id.cone9_box);
        question4a = findViewById(R.id.cone11_box);
        question4b = findViewById(R.id.conenaranja_box);
        question4c = findViewById(R.id.pelota_box);
        question5 = findViewById(R.id.cube10_radio);
        question6 = findViewById(R.id.No_id);
        question7 = findViewById(R.id.cylinder);
        question8 = findViewById(R.id.cube_text_input);
        submitAnswers = findViewById(R.id.submit_id);
        reset = findViewById(R.id.reset_id);
        nameInput = findViewById(R.id.name_text_input);
    }

    /**
     * This method is called when the user click the Submit button.
     */
    public void submitAnswers() {
        totalScore = 0;

        /*
         * Checks if answer are correct and gives one point per correct answer
         */

        if (question1.isChecked()) {
            totalScore++;
        }

        if (question2.isChecked()) {
            totalScore++;
        }

        if (question3a.isChecked() && question3b.isChecked() && !question3c.isChecked()){
            totalScore++;

        }

        if (question4a.isChecked() && question4b.isChecked() && !question4c.isChecked()) {
            totalScore++;

        }
        if (question5.isChecked()) {
            totalScore++;
        }
        if (question6.isChecked()) {
            totalScore++;
        }
        if (question7.getText().toString().trim().toLowerCase().equals("cylinder")) {
            totalScore++;
        }
        if (question8.getText().toString().trim().toLowerCase().equals("cube")) {
            totalScore++;
        }
    }
    public void submitOnClick(View view) {
        submitAnswers();
        // get user name
        nameInput = (findViewById(R.id.name_text_input));
        userName = nameInput.getText();

        //This next step calls the score interpretation process seen in "scoreToastMessage"
        scoreToastMessage(totalScore);
    }
    // At this point, the program retrieves the message associated with the score, and presents it on the screen as a toast.
    public void scoreToastMessage(int totalScore) {
        if (totalScore == 8) {
            String scoreMessage8 = userName + " You scored " + totalScore + " out of 8! " + "Amazing job!";
            Toast.makeText(this, scoreMessage8, Toast.LENGTH_LONG).show();
        } else if (totalScore == 7) {
            String scoreMessage7 = userName + " You scored " + totalScore + " out of 8! " + "Great job!";
            Toast.makeText(this, scoreMessage7, Toast.LENGTH_LONG).show();
        } else if (totalScore == 6) {
            String scoreMessage6 = userName + " You scored " + totalScore + " out of 8! " + "Good job!";
            Toast.makeText(this, scoreMessage6, Toast.LENGTH_LONG).show();
        } else if (totalScore == 5) {
            String scoreMessage5 = userName + " You scored " + totalScore + " out of 8! " + "Pretty good!";
            Toast.makeText(this, scoreMessage5, Toast.LENGTH_LONG).show();
        } else if (totalScore == 4) {
            String scoreMessage4 = userName + " You scored " + totalScore + " out of 8! " + "You can do better!";
            Toast.makeText(this, scoreMessage4, Toast.LENGTH_LONG).show();
        } else if (totalScore == 3) {
            String scoreMessage3 = userName + " You scored " + totalScore + " out of 8! " + "Keep studying!";
            Toast.makeText(this, scoreMessage3, Toast.LENGTH_LONG).show();
        } else if (totalScore == 2) {
            String scoreMessage2 = userName + " You scored " + totalScore + " out of 8! " + "Tray again!";
            Toast.makeText(this, scoreMessage2, Toast.LENGTH_LONG).show();
        } else if (totalScore == 1) {
            String scoreMessage1 = userName + " You scored " + totalScore + " out of 8! " + "You need practice!";
            Toast.makeText(this, scoreMessage1, Toast.LENGTH_LONG).show();
        } else {
            String scoreMessage0 = userName + " You scored " + totalScore + " out of 8! " + "Review your Three dimensional shapes theme!";
            Toast.makeText(this, scoreMessage0, Toast.LENGTH_LONG).show();
        }
    }

//This method is called when the user click the RESET button.

    public void reset(View view) {

        // This code will restart the quiz/activity
        Intent resetActivity = getIntent();
        finish();
        startActivity(resetActivity);}


}
