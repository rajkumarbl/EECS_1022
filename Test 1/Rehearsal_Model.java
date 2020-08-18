package eecs.test;


import java.io.PrintStream;
import java.util.Scanner;

public class Model
{
    public static final int DEFAULT_HEIGHT =2;
    public static final int DEFAULT_WIDTH=4;

    private int height,width;

    public Model()
    {
        this.height = DEFAULT_HEIGHT;
        this.width = DEFAULT_WIDTH;
    }

    public Model(int side)
    {
        this.height = side;
        this.width = side;
    }

    public Model(int w,int h)
    {
        this.height = h;
        this.width = w;
    }

    public double computeDiagonal()
    {
        double diag;
        diag = Math.sqrt(Math.pow(this.height,2)+ Math.pow(this.width,2));
        return diag;
    }

    public boolean equals(Model other)
    {
        boolean ans;
        ans = (this.width == other.width) && (this.height == other.height);
        return ans;
    }

    public int getHeight()
    {
        return this.height;
    }

    public java.lang.String getWidth(int n)
    {
        return String.format("%0" + n + "d", this.width);
    }

    public void setHeight(java.lang.String h)
    {
        this.height = Integer.parseInt(h);
    }

    public java.lang.String toString()
    {
        String result;
        result = "I am a Model instance of size " + (this.width*this.height);
        return result;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        Model m1 = new Model();
        System.out.println(m1.computeDiagonal());

        Model m2 = new Model(5);
        System.out.println(m2.getHeight());
        m2.setHeight("4");
        System.out.println(m2.getHeight());

        Model m3 = new Model(5,4);
        System.out.println(m3.getWidth(4));
        System.out.println(m3.toString());

        System.out.println(m3.equals(m2));

    }




}
