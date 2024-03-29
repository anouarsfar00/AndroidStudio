package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnStartQuiz = findViewById(R.id.btn_start);
        btnStartQuiz.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }
    private void startQuiz(){
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        startActivityForResult (intent , REQUEST_CODE_QUIZ);}
}