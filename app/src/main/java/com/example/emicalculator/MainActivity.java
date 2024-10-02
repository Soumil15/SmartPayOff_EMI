package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button EMIBtn = findViewById(R.id.CalculateEMI);

        //Initialize an object from the EMICalculator class
        EMICalculator Emi =  new EMICalculator();

        //Capture EditText views
        EditText PrincipalAmt = findViewById(R.id.editTextPrincipal);
        EditText InterestRate = findViewById(R.id.editTextInterest);
        EditText Tenure = findViewById(R.id.editTextTenure);



        EMIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Capture the input in variables

                String P = PrincipalAmt.getText().toString();
                String r = InterestRate.getText().toString();
                String n = Tenure.getText().toString();


                double EMI = 0.0;
                EMI = Emi.CalculateEMI(P,r,n);

                String Amt = String.valueOf(EMI);


                //Declare an explicit intent
                //Intent will be used for : 1. Navigating to Result.java and 2. Passing data to Result.java


                Intent intent = new Intent(MainActivity.this,Result.class);//Navigate to Result.java


                //Pass data to Result.java

                intent.putExtra("EMI",Amt);
                intent.putExtra("rate",r);
                intent.putExtra("tenure",n);
                intent.putExtra("mortgage",P);

                //Start the activity
                startActivity(intent);








            }
        });


    }
}