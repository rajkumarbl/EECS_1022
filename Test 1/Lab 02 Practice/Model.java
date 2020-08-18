package ca.roumani.mcalc;

import java.io.PrintStream;
import java.util.Scanner;

import hr.YumModel;

/**
 * Created by user on 2/12/17.
 */
public class Model
{
    private double principle, interest;
    private int month;

    public Model(String p, String m, String i)
    {
        this.principle = Double.parseDouble(p);
        this.month = Integer.parseInt(m);
        this.interest = Double.parseDouble(i);
    }

    public String computePayment()
    {
        int n = this.month*12;
        double r = (this.interest/100)/12;
        double p = this.principle;
        double result;
        result = n*(n -1)*r*r/2;
        result = 1+(n*r)+result;
        result = 1 -(1/result);
        //result = 1 - result;
        result = (r*p)/result;
        String answer = String.format("$"+"%.2f",result);
        return answer;
    }

    public String exactPay()
    {
        int n = this.month*12;
        double r = (this.interest/100)/12;
        double p = this.principle;
        double result;
        result = Math.pow((1+r),-n);
        result = 1 - result;
        result = (r*p)/result;
        String answer = String.format("$"+"%.2f",result);
        return answer;

    }

    public String yuPay()
    {
        YumModel yp = new YumModel();
     String p1 = Double.toString(this.principle);
     String m1 = Integer.toString(this.month);
     String i1 = Double.toString(this.interest);
        yp.setPrinciple(p1);
        yp.setAmortization(m1);
        yp.setInterest(i1);
        String result2 = yp.getFormattedPayment(2,true,"$");
        return result2;

    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        Model m = new Model("700000", "25", "2.75");
        System.out.println(m.computePayment());
        System.out.println(m.yuPay());
        System.out.println(m.exactPay());

    }


}
