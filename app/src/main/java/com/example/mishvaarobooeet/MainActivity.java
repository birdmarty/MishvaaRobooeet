package com.example.mishvaarobooeet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private double numA;
    private double numB;
    private double numC;
    private EditText InputA;
    private EditText InputB;
    private EditText InputC;
    private TextView ans;
    private final int REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputA = findViewById(R.id.InputA);
        InputB = findViewById(R.id.InputB);
        InputC = findViewById(R.id.InputC);
        ans = findViewById(R.id.tv);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CODE){
            if(resultCode== Activity.RESULT_OK){
                if(data!=null){
                    double a = data.getDoubleExtra("numA", 0);
                    double discriminant = data.getDoubleExtra("discriminant", 0);
                    if (a == 0 || discriminant < 0 ){
                        ans.setText("no solution");
                    }
                    else{
                        double root1 = data.getDoubleExtra("root1", 0);
                        double root2 = data.getDoubleExtra("root2", 0);
                        ans.setText("x1 = "  + root1 + "\nx2 = " + root2);
                    }
                }
                else {
                    Log.i("MainActivity","NO data returned");
                }
            }
            else {
                Log.i("MainActivity","Bad return code");
            }
        }
    }
    public static int get_rand() {
        Random rand = new Random();
        return (int) Math.floor(Math.random() * (401) - 200);
    }
    public void rng(View view) {
        numA = get_rand();
        numB = get_rand();
        numC = get_rand();
        InputA.setText(""+numA);
        InputB.setText(""+numB);
        InputC.setText(""+numC);
    }

    public void Solve(View view) {
        Intent si = new Intent(getApplicationContext(), MainActivity2.class);
        numA = Double.parseDouble(InputA.getText().toString());
        numB = Double.parseDouble(InputB.getText().toString());
        numC = Double.parseDouble(InputC.getText().toString());

        si.putExtra("numA", numA);
        si.putExtra("numB", numB);
        si.putExtra("numC", numC);

        startActivityForResult(si, REQUEST_CODE);
    }

}