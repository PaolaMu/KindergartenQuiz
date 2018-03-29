package com.example.android.kindergartenquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int totalScore;
    EditText nameInput;
    RadioGroup question1;
    RadioGroup question2;
    CheckBox question3;
    CheckBox question4;
    RadioGroup question5;
    Button question6;
    EditText question7;
    EditText question8;
    Button submitAnswers;
    Button reset;
    Toast resultDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void findView() {
        nameInput = (EditText) (findViewById(R.id.name_text_input));
        question1 = (RadioGroup) (findViewById(R.id.three_dimensional_question));
        question2 = (RadioGroup) (findViewById(R.id.shape_question));
        question3 = (CheckBox) (findViewById(R.id.all_spheres_question));
        question4 = (CheckBox) (findViewById(R.id.shape_cone_question));
        question5 = (RadioGroup) (findViewById(R.id.cube_question));
        question6 = (Button) (findViewById(R.id.circle_question));
        question7 = (EditText) (findViewById(R.id.cylinder_question));
        question8 = (EditText) (findViewById(R.id.cube5_question));
        submitAnswers = (Button) (findViewById(R.id.submit_id));
        reset = (Button) (findViewById(R.id.reset_id));

    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void displayResults(View view) {
        String message = "You got " + totalScore + " out of 8!.";
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    public int totalScore(View view) {

        //get name
        String applicantName = nameInput.getText().toString();

        // If user check answer1 three_dimensional in question1 add a point

        // Is the button now checked?
        boolean answer1 = ((RadioButton) view).isChecked();

        // Check which answer was clicked
        switch (view.getId()) {
            case R.id.three_dimensional:
                if (answer1)
                    score = score + 1;
                // three dimensional
                break;
            case R.id.two_dimensional:
                if (answer1)
                    // two dimensional
                    break;
        }

        // If user check answer2 sphere in question2 add a point
        // Is the button now checked?
        boolean answer2 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.sphere:
                if (answer2)
                    totalScore = score + 1;
                // sphere
                break;
            case R.id.cube:
                if (answer2)
                    // cube
                    break;
        }
        // If user checks sphere3_box and sphere6_box on question3 add a point
        boolean isChecked_1 = ((CheckBox) findViewById(R.id.sphere3_box)).isChecked();
        boolean isChecked_2 = ((CheckBox) findViewById(R.id.sphere6_box)).isChecked();
        boolean isChecked_3 = ((CheckBox) findViewById(R.id.cone9_box)).isChecked();
        if (isChecked_1 && isChecked_2) {
            totalScore = score + 1;
        }

        // If user checks cone11_box and conenaraja_box on question 4 add a point
        boolean isChecked_4 = ((CheckBox) findViewById(R.id.cone11_box)).isChecked();
        boolean isChecked_5 = ((CheckBox) findViewById(R.id.pelota_box)).isChecked();
        boolean isChecked_6 = ((CheckBox) findViewById(R.id.conenaranja_box)).isChecked();
        if (isChecked_4 && isChecked_6) {
            totalScore = score + 1;
        }
        // If use check answer5 cube10_radio on question5 add a point

        // Is the button now checked?
        boolean answer5 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.cube10_radio:
                if (answer5)
                    totalScore = score + 1;
                // cube
                break;
            case R.id.cone10_radio:
                if (answer5)
                // cone
                {
                    break;
                }
            case R.id.sphere10_radio:
                if (answer5)
                    // sphere
                    break;
        }
        // If user check answer6 No_id on question6 add a point

        // Is the button now checked?
        boolean answer6 = ((RadioButton) view).isChecked();

        // Check which radio button was clicked and add point
        switch (view.getId()) {
            case R.id.No_id:
                if (answer6)
                    totalScore = score + 1;
                // No
                break;
            case R.id.Yes_id:
                if (answer6)
                    // Yes
                    break;
        }
        // Figure out if the user fill out question7 with Cylinder and add point
        EditText fillIn = (EditText) findViewById(R.id.cylinder_text_input);
        String text = fillIn.getText().toString();
        Log.d("test", text);
        if (text.equals("Cylinder")) {
            Log.d("test", "right");
            totalScore = score + 1;
        }
        // Figure out if the user fill out question8 with Cube and add point
        EditText fillIn2 = (EditText) findViewById(R.id.cube_text_input);
        String text2 = fillIn.getText().toString();
        Log.d("test", text);
        if (text.equals("Cube")) {
            Log.d("test", "right");
            totalScore = score + 1;
        }

        return totalScore;
    }
}