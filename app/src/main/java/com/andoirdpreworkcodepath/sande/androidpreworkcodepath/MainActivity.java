package com.andoirdpreworkcodepath.sande.androidpreworkcodepath;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // message text view
        final TextView message = (TextView) findViewById(R.id.helloMessage);

        // root view
        final View rootView = findViewById(R.id.rootView);

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
                message.setText("Hello From Kotten");
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
        String originalMessage = "Hello From Sander";
        int originalTextColor = Color.rgb(0, 0, 0); // black
        int originalViewColor = Color.rgb(238,238,238); // grey / #eeeeee

        // set values
        message.setText(originalMessage);
        message.setTextColor(originalTextColor);
        rootView.setBackgroundColor(originalViewColor);
    }
}
