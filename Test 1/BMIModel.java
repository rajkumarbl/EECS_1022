package ca.roumani.myapplication;

import java.io.PrintStream;
import java.util.Scanner;

public class BMIModel
{
    private double weight;
    private double height;

    public BMIModel(String w, String h)
    {
        this.weight = Double.parseDouble(w);    // turns the string w into a double name weight
        this.height = Double.parseDouble(h);    // turns the string h into a double name height
    }

    public String getBMI()
    {
        double index = this.weight / (this.height * this.height);   // calculate the BMI index
        String result = String.format("%.1f",index);   //round BMI to 1 decimal place and convert back into a string
        return result;
    }

    public String getWeightInPound()
    {
        double pound = 2.20462*this.weight;     //convert kilograms into pounds
        String result = String.format("%.0f",pound);    //round pounds to integer and convert to string
        return result;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        BMIModel model = new BMIModel("100", "1.8");
        output.println(model.getBMI());

        model = new BMIModel("45", "1.35");
        output.println(model.getBMI());

        model = new BMIModel("77", "1.2");
        output.println(model.getBMI());

        model = new BMIModel("130", "2.8");
        output.println(model.getBMI());
    }

}


