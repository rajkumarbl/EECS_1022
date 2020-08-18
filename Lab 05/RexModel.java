package ca.roumani.rex1;


import java.util.Random;

/**
 * Created by user on 3/4/17.
 */
public class RexModel
{
    public static final int SET_SIZE = 3;
    private Random rng;
    private String reg,let="",dig="",quan="";
    private boolean b1,b2,b3;
    private String[] anc = {"",""};

    public RexModel()
    {
        this.reg="";
        this.b1 = true;
        this.b2 = true;
        this.b3 = true;
    }

    public boolean doesMatch(java.lang.String s)
    {
        if (s.matches(reg))
        {
            return true;
        }
        else
        {
            return  false;
        }

    }

    public void generate(int repeat)
    {
        boolean check;
        this.reg = "";
        for (int i = 0; i<= repeat; i++)
        {
            if(b1 = true)
            {
                genLetter();
            }
            if(b2= true)
            {
                genDigit();
            }
            if(b3= true)
            {
                this.anc[1] = "^";
                this.anc[2] = "$";
            }
        }

    }

    public java.lang.String getRex()
    {
        this.reg = this.anc[1]+this.let+this.dig+this.anc[2];
        return this.reg;
    }

    private void genDigit()
    {
        genQuantifier();
        if (this.rng.nextDouble() < 0.5)
        {
            this.dig = "[0-9]";
            this.dig = this.dig + this.quan;
        }
        else
        {
            int digiit = 100+rng.nextInt(900);
            this.dig = "["+digiit+"]";
            this.dig = this.dig +this.quan;
        }
    }

    private void genLetter()
    {
        genQuantifier();
        if (rng.nextDouble()<0.5)
        {
            let = "[a-z]";
            this.let = this.let + this.quan;
        }
        else
        {
            char c1 = (char)(rng.nextInt(26)+'a');
            char c2 = (char)(rng.nextInt(26)+'a');
            char c3 = (char)(rng.nextInt(26)+'a');
            this.let = "["+c1+c2+c3+"]";
            this.let = let + this.quan;

        }
    }

    private void genQuantifier()
    {
        int quanX = 1+ this.rng.nextInt(3);
        String x = "{"+quanX+"}";
        String star ="*";
        String plus = "+";
        String question = "?";
        double prob= rng.nextDouble();
        if (prob <0.5)
        {
            this.quan = x;
        }
        else if (prob < 0.5+(1/6.0))
        {
            this.quan = star;
        }
        else if (prob <0.5+(2/6.0))
        {
            this.quan = plus;
        }
        else
        {
            this.quan = question;
        }
    }

    public void setLetter(boolean letter)
    {
        if(letter= true)
        {
            this.b1 = true;
        }
        else
        {
            this.b1 = false;
        }
    }

    public void setDigit(boolean digit)
    {
        if(digit= true)
        {
            this.b1 = true;
        }
        else
        {
            this.b1 = false;
        }
    }

    public void setAnchor(boolean anchor)
    {
        if(anchor= true)
        {
            this.b3 = true;
        }

        else
        {
            this.b3 = false;
        }
    }

    public static void main(String[] args)
    {
        RexModel rm = new RexModel();
        rm.setLetter(true);
        rm.setDigit(true);
        rm.setAnchor(true);
        rm.generate(1);
        String answer =  rm.getRex();
        System.out.println(answer);
    }
}