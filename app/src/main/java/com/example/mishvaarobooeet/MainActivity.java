package com.example.mishvaarobooeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private double numA;
    private double numB;
    private double numC;
    private EditText InputA;
    private EditText InputB;
    private EditText InputC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputA = findViewById(R.id.InputA);
        InputB = findViewById(R.id.InputB);
        InputC = findViewById(R.id.InputC);
    }
    public static int get_rand() {
        Random rand = new Random();
        return (int) Math.floor(Math.random() * (89) + 10);
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

        startActivity(si);
    }

}