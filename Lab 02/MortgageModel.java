package ca.roumani.mortgage;

import java.io.PrintStream;
import java.util.Scanner;

import hr.YumModel;

public class MortgageModel
{
    private double principle;
    private int month;
    private double interest;


    public MortgageModel(String p, String m, String i)
    {
        this.principle = Double.parseDouble(p);
        this.month = Integer.parseInt(m);
        this.interest = Double.parseDouble(i);
    }

    public String computePayment()
    {
        int n = this.month * 12;
        double r = (this.interest / 100) / 12;
        double p = this.principle;
        double index = n*(n-1)*r*r/2;
        index = index +1 + n * r;
        index = 1/ index;
        index = 1- index;
        index = (r * p)  / index;
        String result = String.format("%.2f",index);
        return result;
    }


    public String YUMComputePayment()
    {

        YumModel YM = new YumModel();
        String amortization1= Integer.toString(this.month);
        String interest1=Double.toString(this.interest);
        String Principl=Double.toString(this.principle);
        YM.setPrinciple(Principl);
        YM.setInterest(String.valueOf(interest));
        YM.setAmortization(String.valueOf(month));

        return YM.getFormattedPayment(2, true,"$");    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        MortgageModel model = new MortgageModel("700000", "25", "2.75");
        output.println(model.computePayment());

    }

}

