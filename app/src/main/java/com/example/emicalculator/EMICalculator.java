package com.example.emicalculator;
public class EMICalculator {

    //Parameters required to calculate EMI :
    //1. Principal (P) 2. Monthly interest rate (r) 3.Loan tenure in months (n)

    //EMI = (P*r*(1+r)^n)/(1+r)^n - 1

    public double CalculateEMI(String Principal, String rate, String tenure){

        double P = Double.parseDouble(Principal);
        double r = Double.parseDouble(rate);
        double n = Double.parseDouble(tenure);

        r = r/(12*100);
        n = n*12;

        double base = 1.0 + r;
        double exponent = n;

        double result = Math.pow(base,exponent); //(1+r)^n

        double EMI = (P * r * result)/(result-1);
        double scale = Math.pow(10,2);


        return Math.ceil(EMI*scale)/scale;
    }


}
