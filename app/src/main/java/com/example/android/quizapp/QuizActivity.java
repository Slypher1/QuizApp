package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private ImageView imageViewQuestion;

    private TextView textViewQuestion;

    private RadioGroup radioGroupAnswers;
    private RadioButton radioButtonAnswer1;
    private RadioButton radioButtonAnswer2;
    private RadioButton radioButtonAnswer3;

    private CheckBox[] checkBoxAnswer = new CheckBox[TOTAL_CHECKBOX];
    boolean stateCheckBox[] = new boolean[TOTAL_CHECKBOX];

    private int sw = 0;
    private int st = 0;
    private int bob = 0;
    private int pointerQuestion = 0;
    private int checkedRadioButtonId = -1;
    private String name;
    private boolean lastQuestion = false;
    private static final int TOTAL_QUESTION = 7;
    private static final int TOTAL_CHECKBOX = 8;
    public static final String KEY_MESSAGE = "fan";

    private Drawable[] images = new Drawable[TOTAL_QUESTION];
    private String[] questions = new String[TOTAL_QUESTION];
    private String[] answers1 = new String[TOTAL_QUESTION];
    private String[] answers2 = new String[TOTAL_QUESTION];
    private String[] answers3 = new String[TOTAL_QUESTION];

    private static final String KEY_SW_SCORE = "starWarsFanScore";
    private static final String KEY_ST_SCORE = "starTrekFanScore";
    private static final String KEY_BOB_SCORE = "bobScore";
    private static final String KEY_QUESTION = "numberOfQuestion";
    private static final String KEY_RADIOGROUPID = "checkedRadioButtonId";
    private static final String KEY_CHECKBOX = "stateCheckBox";
    private static final String KEY_LASTQUESTION = "isLastQuestion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.KEY_NAME);

        imageViewQuestion = (ImageView) findViewById(R.id.image_question);
        textViewQuestion = (TextView) findViewById(R.id.question);

        radioGroupAnswers = (RadioGroup) findViewById(R.id.rg_answers);
        radioButtonAnswer1 = (RadioButton) findViewById(R.id.rb_answer1);
        radioButtonAnswer2 = (RadioButton) findViewById(R.id.rb_answer2);
        radioButtonAnswer3 = (RadioButton) findViewById(R.id.rb_answer3);

        images[0] = getDrawable(R.drawable.question1);
        images[1] = getDrawable(R.drawable.question2);
        images[2] = getDrawable(R.drawable.question3);
        images[3] = getDrawable(R.drawable.question4);
        images[4] = getDrawable(R.drawable.question5);
        images[5] = getDrawable(R.drawable.question6);
        images[6] = getDrawable(R.drawable.question7);

        questions[0] = getString(R.string.question1);
        questions[1] = getString(R.string.question2);
        questions[2] = getString(R.string.question3);
        questions[3] = getString(R.string.question4);
        questions[4] = getString(R.string.question5);
        questions[5] = getString(R.string.question6);
        questions[6] = getString(R.string.question7);

        answers1[0] = getString(R.string.answer1a);
        answers1[1] = getString(R.string.answer2a);
        answers1[2] = getString(R.string.answer3a);
        answers1[3] = getString(R.string.answer4a);
        answers1[4] = getString(R.string.answer5a);
        answers1[5] = getString(R.string.answer6a);
        answers1[6] = getString(R.string.answer7a);

        answers2[0] = getString(R.string.answer1b);
        answers2[1] = getString(R.string.answer2b);
        answers2[2] = getString(R.string.answer3b);
        answers2[3] = getString(R.string.answer4b);
        answers2[4] = getString(R.string.answer5b);
        answers2[5] = getString(R.string.answer6b);
        answers2[6] = getString(R.string.answer7b);

        answers3[0] = getString(R.string.answer1c);
        answers3[1] = getString(R.string.answer2c);
        answers3[2] = getString(R.string.answer3c);
        answers3[3] = getString(R.string.answer4c);
        answers3[4] = getString(R.string.answer5c);
        answers3[5] = getString(R.string.answer6c);
        answers3[6] = getString(R.string.answer7c);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Passing the saved state value to the variable
        sw = savedInstanceState.getInt(KEY_SW_SCORE);
        st = savedInstanceState.getInt(KEY_ST_SCORE);
        bob = savedInstanceState.getInt(KEY_BOB_SCORE);
        lastQuestion = savedInstanceState.getBoolean(KEY_LASTQUESTION);

        if(lastQuestion)
        {
            stateCheckBox = savedInstanceState.getBooleanArray(KEY_CHECKBOX);

            loadLastQuestion();
        }
        else
        {
            pointerQuestion = savedInstanceState.getInt(KEY_QUESTION);
            checkedRadioButtonId = savedInstanceState.getInt(KEY_RADIOGROUPID);
        }

        changeQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        // Save the current value of the variable.
        savedInstanceState.putInt(KEY_SW_SCORE, sw);
        savedInstanceState.putInt(KEY_ST_SCORE, st);
        savedInstanceState.putInt(KEY_BOB_SCORE, bob);
        savedInstanceState.putBoolean(KEY_LASTQUESTION, lastQuestion);

        if(lastQuestion)
        {
            for (int i=0; i<TOTAL_CHECKBOX; i++)
            {
                stateCheckBox[i] = checkBoxAnswer[i].isChecked();
            }
            savedInstanceState.putBooleanArray(KEY_CHECKBOX, stateCheckBox);
        }
        else
        {
            savedInstanceState.putInt(KEY_QUESTION, pointerQuestion);
            savedInstanceState.putInt(KEY_RADIOGROUPID, radioGroupAnswers.getCheckedRadioButtonId());
        }
        // Always call the super class so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void nextQuestion(View view) {

        int selectedId = radioGroupAnswers.getCheckedRadioButtonId();
        // check that an answer has been given
        if (selectedId == -1) {
            //I will inform the user that he must answer
            Toast.makeText(this, R.string.info, Toast.LENGTH_SHORT).show();
        }
        else{
            //otherwise update counters and go to the next question
            if (selectedId == radioButtonAnswer1.getId()) {
                st++;
            }
            else if (selectedId == radioButtonAnswer2.getId()) {
                sw++;
            }
            else if (selectedId == radioButtonAnswer3.getId()) {
                bob++;
            }

            pointerQuestion++;

            if (pointerQuestion < TOTAL_QUESTION) {
                checkedRadioButtonId = -1;
                changeQuestion();
            }
            else {
                // change layout for the last question
                loadLastQuestion();

                lastQuestion = true;
            }
        }
    }

    private void changeQuestion() {

        if (lastQuestion)
        {
            for (int i=0; i<TOTAL_CHECKBOX; i++)
            {
                checkBoxAnswer[i].setChecked(stateCheckBox[i]);
            }
        }
        else {
            imageViewQuestion.setImageDrawable(images[pointerQuestion]);
            textViewQuestion.setText(questions[pointerQuestion]);

            radioGroupAnswers.check(checkedRadioButtonId);
            radioButtonAnswer1.setText(answers1[pointerQuestion]);
            radioButtonAnswer2.setText(answers2[pointerQuestion]);
            radioButtonAnswer3.setText(answers3[pointerQuestion]);
        }
    }

    // show result of Quiz
    public void result(View view) {

        String fan;
        int i;

        Intent intent = new Intent(this, ResultActivity.class);

        // check of checkbox 1,2 and 3 add 1 to st score
        for(i=0;i<3;i++) {
            if (checkBoxAnswer[i].isChecked()) {
                st++;
            }
        }
        // check of checkbox 4, 5, 6 and 7 add 1 to sw score
        for(i=3;i<7;i++) {
            if (checkBoxAnswer[i].isChecked()) {
                sw++;
            }
        }
        // check of checkbox 8 add 1 to bob score
        if(checkBoxAnswer[i].isChecked()){
            bob++;
        }

        if (sw > st && sw > bob) {
            fan = "sw";
        }
        else if (st > sw && st > bob){
            fan = "st";
        }
        else {
            fan = "bob";
        }

        intent.putExtra(KEY_MESSAGE, fan);
        intent.putExtra(MainActivity.KEY_NAME, name);
        startActivity(intent);
    }

    public void loadLastQuestion()
    {
        setContentView(R.layout.activity_quiz_last_question);

        checkBoxAnswer[0] = (CheckBox) findViewById(R.id.checkBox1);
        checkBoxAnswer[1] = (CheckBox) findViewById(R.id.checkBox2);
        checkBoxAnswer[2] = (CheckBox) findViewById(R.id.checkBox3);
        checkBoxAnswer[3] = (CheckBox) findViewById(R.id.checkBox4);
        checkBoxAnswer[4] = (CheckBox) findViewById(R.id.checkBox5);
        checkBoxAnswer[5] = (CheckBox) findViewById(R.id.checkBox6);
        checkBoxAnswer[6] = (CheckBox) findViewById(R.id.checkBox7);
        checkBoxAnswer[7] = (CheckBox) findViewById(R.id.checkBox8);
    }
}
