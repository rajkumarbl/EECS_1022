package ca.roumani.taxcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Typeface;


public class TaxActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);
    }

    public void buttonClicked(View v)
    {

        View incomeView = findViewById(R.id.income);
        EditText incomeEdit = (EditText) incomeView;
        String income = incomeEdit.getText().toString();

        int i = Integer.parseInt(income);
        LinearLayout output = (LinearLayout) findViewById(R.id.output);

            TaxModel model = new TaxModel();
            model.setIncome(i);
            String a1 = model.getTax();
            String a2 = model.getAverageRate();
            String a3 = model.getMarginalRate();
            String a4 = model.getCPP();
            String a5 = model.getEI();

            output.removeAllViews();
            TextView taxLabel = new TextView(this);
            taxLabel.setText("Income Tax:");
            output.addView(taxLabel);

            TextView a1Label = new TextView(this);
            a1Label.setText(a1);
            a1Label.setTypeface(a1Label.getTypeface(), Typeface.BOLD);
            output.addView(a1Label);

            TextView avgLabel = new TextView(this);
            avgLabel.setText("Average Rate:");
            output.addView(avgLabel);

            TextView a2Label = new TextView(this);
            a2Label.setText(a2);
            a2Label.setTypeface(a2Label.getTypeface(), Typeface.BOLD);
            output.addView(a2Label);

            TextView marginLabel = new TextView(this);
            marginLabel.setText("Margin Rate:");
            output.addView(marginLabel);


            TextView a3Label = new TextView(this);
            a3Label.setText(a3);
            a3Label.setTypeface(a3Label.getTypeface(), Typeface.BOLD);
            output.addView(a3Label);

            TextView cppLabel = new TextView(this);
            cppLabel.setText("CPP:");
            output.addView(cppLabel);


            TextView a4Label = new TextView(this);
            a4Label.setText(a4);
            a4Label.setTypeface(a4Label.getTypeface(), Typeface.BOLD);
            output.addView(a4Label);

            TextView eiLabel = new TextView(this);
            eiLabel.setText("EI:");
            output.addView(eiLabel);

            TextView a5Label = new TextView(this);
            a5Label.setText(a5);
            a5Label.setTypeface(a5Label.getTypeface(), Typeface.BOLD);
            output.addView(a5Label);


    }
}