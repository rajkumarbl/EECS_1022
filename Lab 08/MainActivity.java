package ca.roumani.stocktrader;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v) throws ParseException
    {
        View fromView = findViewById(R.id.from);
        EditText fromEdit = (EditText) fromView;
        String from = fromEdit.getText().toString();

        TableLayout tlayout = (TableLayout) findViewById(R.id.table);

        if (from.contains("sc") || from.contains("pf") || from.contains("tc"))
        {
         Resources res = getResources();
        String[] data = res.getStringArray(res.getIdentifier(from, "array", this.getPackageName()));

            PortfolioAnalyzer pa = new PortfolioAnalyzer("raj", data);
            int a = pa.getPortfolioSize();
            String a1 = Integer.toString(a);
            DecimalFormat df2 = new DecimalFormat("###.##");
            double b1 = pa.getPortfolioMarketValue();
            String b = df2.format(b1);
            DecimalFormat df3 = new DecimalFormat("###.#");
            double c = pa.getPortfolioYield();
            String c2 =df3.format(c);
            String answer = "The " + from + " portfolio consists of " + a1 + " equities." + "\n" + "It has a market value of $" + b + " and a yield of " + c2 + "% (annualized).";

            // passes the answer back to the view
            ((TextView) findViewById(R.id.summary)).setText(answer);

            tlayout.setGravity(Gravity.CENTER);
            tlayout.setStretchAllColumns(true);
            tlayout.setShrinkAllColumns(true);
            tlayout.removeAllViews();

            TextView hd1 = new TextView(this);
            TextView hd2 = new TextView(this);
            TextView hd3 = new TextView(this);
            TextView hd4 = new TextView(this);
            TextView hd5 = new TextView(this);
            TextView hd6 = new TextView(this);

            TableRow row0 = new TableRow(this);
            row0 = new TableRow(this);
            row0.setGravity(Gravity.CENTER_HORIZONTAL);

            hd1.setText("Symbol");
            hd1.setTypeface(hd1.getTypeface(), Typeface.BOLD);
            row0.addView(hd1);
            hd2.setText("Quantity");
            hd2.setTypeface(hd2.getTypeface(), Typeface.BOLD);
            row0.addView(hd2);
            hd3.setText("BookValue");
            hd3.setTypeface(hd3.getTypeface(), Typeface.BOLD);
            row0.addView(hd3);
            hd4.setText("Acquired");
            hd4.setTypeface(hd4.getTypeface(), Typeface.BOLD);
            row0.addView(hd4);
            hd5.setText("MarketValue");
            hd5.setTypeface(hd5.getTypeface(), Typeface.BOLD);
            row0.addView(hd5);
            hd6.setText("Yield");
            hd6.setTypeface(hd6.getTypeface(), Typeface.BOLD);
            row0.addView(hd6);

            tlayout.addView(row0);
            for (int i = 0; i < data.length; i++)
            {
                PortfolioAnalyzer pa1 = new PortfolioAnalyzer("", data);
                StockModel model1 = new StockModel();
                String[] answer1 = model1.getPrtfolio(data[i]);
                TableRow row = new TableRow(this);
                row.setGravity(Gravity.CENTER_HORIZONTAL);

                TextView text1 = new TextView(this);
                TextView text2 = new TextView(this);
                TextView text3 = new TextView(this);
                TextView text4 = new TextView(this);
                TextView text5 = new TextView(this);
                TextView text6 = new TextView(this);


                text1.setText(answer1[0]);
                row.addView(text1);
                text2.setText(answer1[1]);
                row.addView(text2);
                text3.setText(answer1[2]);
                row.addView(text3);
                text4.setText(answer1[3]);
                row.addView(text4);
                text5.setText(answer1[4]);
                row.addView(text5);
                text6.setText(answer1[5]+"%");
                row.addView(text6);

                tlayout.addView(row);
            }


        }

        else if(from.contains("?"))
        {
            Intent intent = new Intent(this, ListActivity.class);
            this.startActivity(intent);
            tlayout.removeAllViews();
        }

        else
        {
            String answer = "Plesae enter a valid portfolio name! for Options enter ?";

            // passes the answer back to the view
            ((TextView) findViewById(R.id.summary)).setText(answer);
            tlayout.removeAllViews();

        }
    }
}
