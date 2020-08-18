package ca.roumani.piglatin;

import java.util.Arrays;

/**
 * Created by user on 3/10/17.
 */
public class PigLatinModel
{
    private String english,pig;
    private static final String[] clus = {"sh", "gl","ch","ph","tr","br","fr","bl","gr","st","sl","cl","pl","fl","sc","sk","cr","sn","dr","sm","dw","sp","sw","th","kl","tw","wh","pr","wr"};
    private static final char[] vowels = {'a','e','i','o','u'};
    public PigLatinModel()
    {
      this.english="";
        this.pig="";
    }

    public PigLatinModel(java.lang.String text)
    {
        this.english=text;
        this.pig="";
    }

    public java.lang.String getEnglish()
    {
        String result= this.english;
        return result;
    }

    public void setEnglish(java.lang.String text)
    {
        this.english=text;
    }

    public java.lang.String getPig()
    {
        translate();
        return this.pig;
    }

    public void translate()
    {
        String x = this.english;
        String[] a = x.split(" ");
        String b = "";
        for (int i =0;i < a.length; i++)
        {
            char ch2 = a[i].charAt(0);
            String a2 = a[i].substring(0,2);

            if(ch2=='A' || ch2=='E' || ch2=='I' || ch2=='O' || ch2=='U' ||
                    ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o' || ch2=='u')
            {
                b = String.valueOf(b) + a[i] + "way" + " ";
            }
            else if (Arrays.asList(clus).contains(a2))
            {
                b = String.valueOf(b) + a[i].substring(2, a[i].length()) + a[i].substring(0,2) + "ay"+ " ";
            }
             else
             {
                 b = String.valueOf(b) + a[i].substring(1, a[i].length()) + a[i].charAt(0) + "ay"+" ";
             }

        }
        this.pig = b;
    }


    public static void main(String[] args)
    {
        PigLatinModel pl = new PigLatinModel("this is test");
        System.out.println(pl.getPig());
    }
}
