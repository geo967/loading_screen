package com.example.bakeryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Handler handler;
    Button nextButton;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.id_progress_bar);
        nextButton = findViewById(R.id.id_next_button);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (progressBar.getProgress() < 100) {
                    progressBar.setProgress(progress);
                    progress++;
                    handler.postDelayed(this, 10);
                    if (progress == 99)
                        nextButton.setVisibility(View.VISIBLE);
                }
            }
        }, 10);
    }

    public void alertHandler(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Terms and Conditions");
        builder.setMessage("If you do not agree to the T&C of the app you must uninstall and discontinue its use");
        builder.setPositiveButton("I Agree", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        builder.create().show();
    }
}