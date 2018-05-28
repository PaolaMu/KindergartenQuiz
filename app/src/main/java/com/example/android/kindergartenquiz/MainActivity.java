package com.example.android.kindergartenquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //Initialized
    private int totalScore = 0;
    private RadioButton question1;
    private RadioButton question2;
    private CheckBox question3a;
    private CheckBox question3b;
    private CheckBox question3c;
    private CheckBox question4a;
    private CheckBox question4b;
    private CheckBox question4c;
    private RadioButton question5;
    private RadioButton question6;
    private EditText question7;
    private EditText question8;
    private EditText nameInput;
    public Button reset;
    public Button submitAnswers;
    private Editable userName;


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
        question4b = findViewById(R.id.orange_cone_box);
        question4c = findViewById(R.id.ball_box);
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
        if (question3a.isChecked() && question3b.isChecked() && !question3c.isChecked()) {
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
            Resources res = getResources(); String scoreMessage8 = res.getString(R.string.text8, userName, totalScore);
            Toast.makeText(this, scoreMessage8, Toast.LENGTH_LONG).show();
        } else if (totalScore == 7) {
            Resources res = getResources(); String scoreMessage7 = res.getString(R.string.text7, userName, totalScore);
            Toast.makeText(this, scoreMessage7, Toast.LENGTH_LONG).show();
        } else if (totalScore == 6) {
            Resources res = getResources(); String scoreMessage6 = res.getString(R.string.text6, userName, totalScore);
            Toast.makeText(this, scoreMessage6, Toast.LENGTH_LONG).show();
        } else if (totalScore == 5) {
            Resources res = getResources(); String scoreMessage5 = res.getString(R.string.text5, userName, totalScore);
            Toast.makeText(this, scoreMessage5, Toast.LENGTH_LONG).show();
        } else if (totalScore == 4) {
            Resources res = getResources(); String scoreMessage4 = res.getString(R.string.text4, userName, totalScore);
            Toast.makeText(this, scoreMessage4, Toast.LENGTH_LONG).show();
        } else if (totalScore == 3) {
            Resources res = getResources(); String scoreMessage3 = res.getString(R.string.text3, userName, totalScore);
            Toast.makeText(this, scoreMessage3, Toast.LENGTH_LONG).show();
        } else if (totalScore == 2) {
            Resources res = getResources(); String scoreMessage2 = res.getString(R.string.text2, userName, totalScore);
            Toast.makeText(this, scoreMessage2, Toast.LENGTH_LONG).show();
        } else if (totalScore == 1) {
            Resources res = getResources(); String scoreMessage1 = res.getString(R.string.text1, userName, totalScore);
            Toast.makeText(this, scoreMessage1, Toast.LENGTH_LONG).show();
        } else {
            Resources res = getResources(); String scoreMessage0 = res.getString(R.string.text0, userName, totalScore);
            Toast.makeText(this, scoreMessage0, Toast.LENGTH_LONG).show();

        }
    }

//This method is called when the user click the RESET button.

    public void reset(View view) {

        // This code will restart the quiz/activity
        Intent resetActivity = getIntent();
        finish();
        startActivity(resetActivity);
    }
}
