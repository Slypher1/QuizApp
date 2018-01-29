package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NAME = "name";

    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText_name);
    }

    public void start(View view) {

        // control if editText_name is empty
        if (name.getText().toString().trim().length() > 0) {

            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra(KEY_NAME, name.getText());

            startActivity(intent);
        }
        else{

            Toast.makeText(this, R.string.info_result, Toast.LENGTH_SHORT).show();

        }
    }
}
