package com.muhammadsaadameer.hw1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //PUBLIC VARIABLES

    Intent intent, intent2;

    double GPA = 0.0;

    //Button
    Button button;

    //Spinner items
    Spinner spinner1, spinner2, spinner3, spinner4, spinner5;

    //Grades from the spinner
    String grade1, grade2, grade3, grade4, grade5;

    //Credits of the courses
    int c1, c2, c3, c4, c5;

    EditText credit1view, credit2view, credit3view, credit4view, credit5view;

    //Seek Bar
    SeekBar seekBar;

    //TextView for seek bar
    TextView semesterSeekBarView;
    int semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiding title bar using themes xml
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //Grades
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);


        //Button
        button = findViewById(R.id.button1);

        //Seek bar
        seekBar = findViewById(R.id.seekBar);

        //TextView Seek Bar
        semesterSeekBarView = findViewById(R.id.semesterSeekBar);

        //Credits
        credit1view = findViewById(R.id.credits1);
        credit2view = findViewById(R.id.credits2);
        credit3view = findViewById(R.id.credits3);
        credit4view = findViewById(R.id.credits4);
        credit5view = findViewById(R.id.credits5);

        //initializing spinner array
        Spinner[] spinners = {};

        //SpinnerHandler(spinners);

        //Selecting all letter grades from each of the spinner
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade1 = spinner1.getSelectedItem().toString();
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(197,199,201));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade2 = spinner2.getSelectedItem().toString();
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(197,199,201));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade3 = spinner3.getSelectedItem().toString();
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(197,199,201));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade4 = spinner4.getSelectedItem().toString();
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(197,199,201));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grade5 = spinner5.getSelectedItem().toString();
                ((TextView)parent.getChildAt(0)).setTextColor(Color.rgb(197,199,201));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //buttonOnClick shows GPA result
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 = Integer.parseInt(credit1view.getText().toString());
                c2 = Integer.parseInt(credit2view.getText().toString());
                c3 = Integer.parseInt(credit3view.getText().toString());
                c4 = Integer.parseInt(credit4view.getText().toString());
                c5 = Integer.parseInt(credit5view.getText().toString());

                ArrayList<String> gradesArray = new ArrayList<>();
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.my_selected_item, gradesArray);
                adapter.setDropDownViewResource(R.layout.my_dropdown_item);

                Log.d("grade1", grade1);
                gradesArray.add(grade1);
                gradesArray.add(grade2);
                gradesArray.add(grade3);
                gradesArray.add(grade4);
                gradesArray.add(grade5);

                for(String grade : gradesArray){
                    Log.d("grade",grade );
                }
                int[] creditsArray = {c1,c2,c3,c4,c5};
                for(int credit : creditsArray){
                    Log.d("credittt",credit+"" );
                }

                GPA = calcGPA(gradesArray, creditsArray);

                String strGpa = GPA+"";

                //getting Activity
                intent2 = getIntent();

                //Sending data to 2nd activity
                intent = new Intent(MainActivity.this ,SecondActivity.class);
                Bundle b = new Bundle();

                b.putDouble("GPA", GPA);
                b.putInt("Semester", semester);
                intent.putExtras(b);
                Log.d("strGPA", strGpa);

                startActivity(intent);


            }

            private double calcGPA(ArrayList<String> stringArray,int[] creditsArray) {

                double total = 0;


                //total credits
                double totalCredits = 0;
                for (int credit : creditsArray){
                    totalCredits += credit;
                }

                for (String letter : stringArray){
                    double num;
                    if (letter.equals("A")){
                        Log.d("letterValue", letter);
                        num = 4.0*c1;
                        total += num;
                        Log.d("total", total+"");
                        Log.d("num", num+"");
                    }else if (letter.equals("B")){
                        num = 3.0*c1;
                        total += num;
                    }else if (letter.equals("C")){
                        num = 2.0*c1;
                        total += num;
                    }else if (letter.equals("D")){
                        num = 1.0*c1;
                        total += num;
                    }else if (letter.equals("F")){
                        num = 0*c1;
                        total += num;
                    }
                }
                double GPA = total/totalCredits;
                //Log.d("GPA", GPA+"");
                if (GPA == 0.0){
                    return 0;
                }
                return GPA;
            }
        });



        //Changing seek bar text box info
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                semester = seekBar.getProgress();
                semesterSeekBarView.setText("Semester "+semester);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


    }




    //Functions



    //Function for Traversing Spinners
    private void SpinnerHandler(Spinner [] spinners) {
        for (Spinner spinner : spinners){
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedGrade = spinner.getSelectedItem().toString();
                    if(spinner.getId() == R.id.spinner1){

                        grade1 = selectedGrade;

                    } else if(spinner.getId() == R.id.spinner2){
                        grade2 = selectedGrade;
                    } else if(spinner.getId() == R.id.spinner3){
                        grade3 = selectedGrade;
                    } else if(spinner.getId() == R.id.spinner4){
                        grade4 = selectedGrade;
                    } else if(spinner.getId() == R.id.spinner5){
                        grade5 = selectedGrade;
                    }


                    Toast.makeText(MainActivity.this, selectedGrade+" is selected", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }


}