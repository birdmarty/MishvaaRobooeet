package com.example.mishvaarobooeet;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView ans;
    private double numA;
    private double numB;
    private double numC;
    private double root1;
    private double root2;
    private double ansblud;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize ans TextView
        ans = findViewById(R.id.Answer);

        Intent intent = getIntent();
        if(intent != null) {
            numA = intent.getDoubleExtra("numA", 0);
            numB = intent.getDoubleExtra("numB", 0);
            numC = intent.getDoubleExtra("numC", 0);

            // Calculate the discriminant
            double discriminant = numB * numB - 4 * numA * numC;

            // Prepare the quadratic formula string with numbers
            String formula = String.format("x = (-%.2f ± √(%.2f² - 4*%.2f*%.2f)) / (2*%.2f)", numB, numB, numA, numC, numA);

            // Display the formula
            ans.setText("Quadratic Formula:\n" + formula + "\n\n");

            // Calculate the roots using the quadratic formula
            if (discriminant > 0) {
                // Two real and distinct roots
                root1 = (-numB + Math.sqrt(discriminant)) / (2 * numA);
                root2 = (-numB - Math.sqrt(discriminant)) / (2 * numA);
                ans.append("Roots:\n" + "x1 = " + root1 + "\nx2 = " + root2);
            } else if (discriminant == 0) {
                // One real root (repeated)
                double root = -numB / (2 * numA);
                ans.append("Root:\n" + "x = " + root);
            } else {
                // Complex roots
                double realPart = -numB / (2 * numA);
                double imaginaryPart = Math.sqrt(-discriminant) / (2 * numA);
                ans.append("Roots:\n"
                        + "x1 = " + realPart + " + " + imaginaryPart + "i\n"
                        + "x2 = " + realPart + " - " + imaginaryPart + "i");
            }
        }
    }

    public void goback(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra("root1", root1); // Assuming root1 and root2 are accessible here
        intent.putExtra("root2", root2);
        intent.putExtra("numA", numA);
        intent.putExtra("numB", numB);
        intent.putExtra("numC", numC);
        startActivity(intent);
    }
}

