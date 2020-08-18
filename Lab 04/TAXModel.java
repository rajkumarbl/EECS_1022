package ca.roumani.tabulator;

import java.io.PrintStream;
import java.util.Scanner;

public class TAXModel
{
    private double income;
    private double tax, average, marginal, cpp, ei;

    public static final double BRACKET_0 = 11475.0;
    public static final double BRACKET_1 = 33808.0;
    public static final double BRACKET_2 = 40895.0;
    public static final double BRACKET_3 = 63823.0;
    public static final double RATE_1 = 22.79 / 100.0;
    public static final double RATE_2 = 33.23 / 100.0;
    public static final double RATE_3 = 45.93 / 100.0;
    public static final double RATE_4 = 52.75 / 100.0;

    public static final double EI_RATE = 1.63 / 100.0;
    public static final double EI_MAX = 836.19;

    public static final double CPP_RATE = 4.95 / 100.0;
    public static final double CPP_MAX = 2564.10;
    public static final double CPP_EXEMPT = 3500.0;

    public TAXModel()
    {

    }

    public void setIncome(int i)
    {
        this.income = i;
    }

    public String getTax()
    {

        if (this.income <=11475)
        {
            tax = 0;

        }
        else if (this.income > 11475 && this.income <= 45283)
        {
            tax = (this.income - 11475)* RATE_1;
        }
        else if (this.income > 45823 && this.income <= 86178)
        {
            tax = (this.income - BRACKET_0 - BRACKET_1) * RATE_2 + 0 + 7704.84 ;

        }
        else if (this.income > 86178 && this.income <= 150001)
        {
            tax = (this.income - BRACKET_0 - BRACKET_1 - BRACKET_2) * RATE_3 + 0 + 7704.84 + 13589.41;

        }
        else if (this.income > 150001)
        {
            tax = (this.income - BRACKET_0 - BRACKET_1 - BRACKET_2 - BRACKET_3) * RATE_4 + 0 + 7704.84 + 13589.41 + 29313.90;

        }

        String result = String.format("%,.2f", tax);
        return result;
    }

    public String getAverageRate()
    {
        average = (tax / this.income) * 100;
        String result = String.format("%.0f", average);
        result = result + "%";
        return result;
    }


    public String getMarginalRate()
    {

        if (this.income <= BRACKET_0)
        {
            marginal = 0;

        }
        else if (this.income > BRACKET_0 && this.income <= 45283)
        {
            marginal = 22.79;

        }
        else if (this.income > 45823 && this.income <= 86178)
        {
            marginal = 33.23;

        }
        else if (this.income > 86178 && this.income <= 150001)
        {
            marginal = 45.93;

        }
        else if (this.income > 150001)
        {
            marginal = 52.75;

        }
        String result = String.format("%.0f", marginal);
        result = result + "%";
        return result;

    }

    public String getCPP()
    {
        double cp = this.income - CPP_EXEMPT;
        cpp = cp * CPP_RATE;

        if (cpp <= CPP_MAX)
        {
            String result = String.format("%,.0f", cpp);
            return result;
        } else
        {
            String result = String.format("%,.0f", CPP_MAX);
            return result;
        }
    }

    public String getEI()
    {
        ei = this.income * EI_RATE;

        if (ei <= EI_MAX)
        {
            String result = String.format("%.0f", ei);
            return result;
        } else
        {
            String result = String.format("%.0f", EI_MAX);
            return result;
        }
    }






    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        TAXModel model = new TAXModel();
        model.setIncome(55000);
        System.out.println(model.getTax());
        System.out.println(model.getAverageRate());
        System.out.println(model.getMarginalRate());
        System.out.println(model.getCPP());
        System.out.println(model.getEI());
    }
}