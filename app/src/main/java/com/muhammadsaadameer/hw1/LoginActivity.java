package com.muhammadsaadameer.hw1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    TextView signInTv;
    Button loginButton;
    Intent intent;
    AlertDialog.Builder builder;
    String usernameVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //hide action and status bar
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        username = findViewById(R.id.usernameTv);
        password = findViewById(R.id.passwordTv);
        loginButton = findViewById(R.id.loginButton);
        signInTv = findViewById(R.id.signInTv);

        ValueAnimator colorAnim;
        // color animation
        colorAnim = ObjectAnimator.ofInt(signInTv, "textColor", Color.RED, Color.BLUE);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();



        builder = new AlertDialog.Builder(this);

        String msg = "Incorrect Login Details";

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("ctis") && password.getText().toString().equals("ctis")){
                    usernameVal = username.getText().toString();
                    intent = new Intent(LoginActivity.this ,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    builder.setTitle("Alert").setMessage(msg).setCancelable(true).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                }
            }
        });


    }
}