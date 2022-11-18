package com.muhammadsaadameer.hw1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Intent intent;
    TextView gpaVal, warningMsg;
    Double gpa;
    TextView textView2;
    int semester;
    AlertDialog.Builder builder;
    String msg1, msg2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Hiding title bar using themes xml
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        builder = new AlertDialog.Builder(this);

        textView2 = findViewById(R.id.textView2);
        warningMsg = findViewById(R.id.warningMsg);


        intent = getIntent();

        Bundle b = intent.getExtras();
        gpa = b.getDouble("GPA");
        semester = b.getInt("Semester");
        Log.d("Double GPA", gpa+"");
        Log.d("Semester: ", semester+"");
//      textView2.setText(gpa + "");

        textView2.setText("Your GPA for Semester " + semester + " is: " + gpa+"");


        msg1 = "Your GPA for Semester ";
        msg2 = " is: ";


        builder.setTitle("Expected GPA:")
                .setMessage(msg1+semester+msg2+gpa)
                .setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(gpa>2.0){
                            warningMsg.setText("Your GPA is above 2.0!");

                            Toast.makeText(SecondActivity.this,"You are safe!", Toast.LENGTH_LONG).show();

                        }
                        else{
                            warningMsg.setText("Your GPA is below 2.0! You need to work hard!");

                            Toast.makeText(SecondActivity.this, "GPA is below 2.0!!!", Toast.LENGTH_LONG).show();


                        }
                    //  finish();
                    }
                }).show();
    }
}