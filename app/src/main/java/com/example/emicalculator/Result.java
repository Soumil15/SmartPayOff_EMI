package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView EMIView = findViewById(R.id.PrincipalViewText);
        TextView MortgageView = findViewById(R.id.MortgageViewTxt);
        TextView InterestView = findViewById(R.id.InterestRateViewText);
        TextView TenureView = findViewById(R.id.AmortizationViewText);


        String CalculatedEMI = getIntent().getStringExtra("EMI");
        String MortgageAmt = getIntent().getStringExtra("mortgage");
        String rate = getIntent().getStringExtra("rate");
        String tenure = getIntent().getStringExtra("tenure");

        MortgageAmt = "$ "+MortgageAmt;
        rate = rate + "%";
        tenure = tenure+" years";
        CalculatedEMI = "$ "+CalculatedEMI;



        EMIView.setText(CalculatedEMI);
        InterestView.setText(rate);
        TenureView.setText(tenure);
        MortgageView.setText(MortgageAmt);



    }
}