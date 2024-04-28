package com.example.mishvaarobooeet;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView ans;
    private double numA, numB, numC, discriminant, division, root1, root2;
    private ImageView parabola;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize ans TextView
        ans = findViewById(R.id.Answer);
        parabola= findViewById(R.id.parabola);

        Intent intent = getIntent();
        if (intent != null) {
            numA = intent.getDoubleExtra("numA", 0);
            numB = intent.getDoubleExtra("numB", 0);
            numC = intent.getDoubleExtra("numC", 0);
            // Calculate the discriminant and the divider
            discriminant = (numB * numB) - (4 * numA * numC);
            division = 2 * numA;

            // Prepare the quadratic formula string with numbers
            String formula = String.format("x = (-%.2f ± √(%.2f² - 4*%.2f*%.2f)) / (2*%.2f)", numB, numB, numA, numC, numA);

            // Display the formula
            ans.setText("Quadratic Formula:\n" + formula + "\n\n");

            // Check if we are dividing by 0 ie - no solution
            if (division == 0){
                ans.append("\nNo soluton found: Dividng by 0");
            }
            else if (discriminant==0 && numA>0){
                parabola.setImageResource(R.drawable.smileyparabola);
            }
            else if (discriminant>0 && numA>0){
                parabola.setImageResource(R.drawable.fallingsmileyparabola);
            }
            else if (discriminant<0 && numA>0){
                parabola.setImageResource(R.drawable.flyingsmileyparabola);
            }
            else if (discriminant==0 && numA<0){
                parabola.setImageResource(R.drawable.sadparabola);
            }
            else if (discriminant>0 && numA<0){
                parabola.setImageResource(R.drawable.fallingsadparabola);
            }
            else if (discriminant<0 && numA<0){
                parabola.setImageResource(R.drawable.flyingsadparabola);
            }
            // Calculate the roots using the quadratic formula
            if (discriminant > 0 && division != 0) {
                // Two real and distinct roots
                root1 = ((0-numB) + (Math.sqrt(discriminant))) / (2 * numA);
                root2 = ((0-numB) - (Math.sqrt(discriminant))) / (2 * numA);
                ans.append("\nx1 = " + root1 + "\nx2 = " + root2);
            } else if (discriminant == 0 && division != 0) {
                // One real root (repeated)
                double root = -numB / (2 * numA);
                ans.append("Root:\n" + "x = " + root);
            }
            else {
                ans.append("\nNo soluton found: Discriminant is numA negative number");
            }

        }
    }

    public void goback(View view) {
        Intent ti = new Intent(MainActivity2.this, MainActivity.class);
        ti.putExtra("root1", root1);
        ti.putExtra("root2", root2);
        ti.putExtra("discriminant", discriminant);
        ti.putExtra("numA", numA);
        ti.putExtra("numB", numB);
        ti.putExtra("numC", numC);
        setResult(Activity.RESULT_OK,ti);
        finish();
    }
}

