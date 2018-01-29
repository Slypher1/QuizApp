package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textTitle;
    private ImageView imageResult;
    private TextView textResult;

    private String name;
    private String typeFan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String fan = intent.getStringExtra(QuizActivity.KEY_MESSAGE);
        name =intent.getStringExtra(MainActivity.KEY_NAME);

        textTitle = (TextView) findViewById(R.id.title_result);
        imageResult = (ImageView) findViewById(R.id.image_result);
        textResult = (TextView) findViewById(R.id.text_result);

        switch (fan){
            case "sw":
                textTitle.setText(R.string.title_sw);
                imageResult.setImageDrawable(getDrawable(R.drawable.swfan));
                textResult.setText(R.string.result_sw);
                typeFan = getString(R.string.type_sw);
                break;
            case "st":
                textTitle.setText(R.string.title_st);
                imageResult.setImageDrawable(getDrawable(R.drawable.stfan));
                textResult.setText(R.string.result_st);
                typeFan = getString(R.string.type_st);
                break;
            case "bob":
                textTitle.setText(R.string.title_bob);
                imageResult.setImageDrawable(getDrawable(R.drawable.bob));
                textResult.setText(R.string.result_bob);
                typeFan = getString(R.string.type_bob);
                break;
        }
    }

    //this method call mail's app for share result and app
    public void share(View view) {

        String text = getString(R.string.text_mail, name, typeFan);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.title));
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // this method reset app
    public void reset(View view) {
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}
