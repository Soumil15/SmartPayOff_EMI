package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button EMIBtn = findViewById(R.id.CalculateEMI);
        EMICalculator Emi =  new EMICalculator();
        EditText PrincipalAmt = findViewById(R.id.editTextPrincipal);
        EditText InterestRate = findViewById(R.id.editTextInterest);

        EditText Tenure = findViewById(R.id.editTextTenure);



        EMIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                String P = PrincipalAmt.getText().toString();
                String r = InterestRate.getText().toString();
                String n = Tenure.getText().toString();




                double EMI = 0.0;
                EMI = Emi.CalculateEMI(P,r,n);

                String Amt = String.valueOf(EMI);


                Intent intent = new Intent(MainActivity.this,Result.class);
                intent.putExtra("EMI",Amt);
                intent.putExtra("rate",r);
                intent.putExtra("tenure",n);
                intent.putExtra("mortgage",P);
                startActivity(intent);








            }
        });


    }
}