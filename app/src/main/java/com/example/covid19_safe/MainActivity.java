package com.example.covid19_safe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    private FadingTextView fadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fadingTextView = findViewById(R.id.fading_text_view);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}