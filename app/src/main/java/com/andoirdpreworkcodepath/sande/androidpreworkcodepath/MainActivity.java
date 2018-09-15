package com.andoirdpreworkcodepath.sande.androidpreworkcodepath;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // message text view
        final TextView message = (TextView)findViewById(R.id.helloMessage);

        // root view
        final View rootView = findViewById(R.id.rootView);

        // editor input
        final EditText input = (EditText)findViewById(R.id.editTextField);

        // error message
        final TextView error = (TextView)findViewById(R.id.error);

        // change text color
        findViewById(R.id.changeTextColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setTextColor(getRandomColor());
            }
        });

        // change view color
        findViewById(R.id.changeViewColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootView.setBackgroundColor(getRandomColor());
            }
        });

        // change text string
        findViewById(R.id.changeTextStringButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setText("Hello To CodePath!");
            }
        });

        // change text string on input
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // show error message if true
                if (input.getText().toString().length() > 20) {
                    error.setText("Message can only contain 20 characters!");
                }

                // set text
                else {
                    error.setText("");
                    message.setText(input.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // reset to original app state
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(message, rootView);
            }
        });
    }

    // generate a random color
    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    // reset app state
    public void reset(TextView message, View rootView) {

        // original values of app
        String originalMessage = "Hello From Sander!";
        int originalTextColor = getResources().getColor(R.color.colorBlack);
        int originalViewColor = getResources().getColor(R.color.colorGrey);

        // set values
        message.setText(originalMessage);
        message.setTextColor(originalTextColor);
        rootView.setBackgroundColor(originalViewColor);
    }
}
