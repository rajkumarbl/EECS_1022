package ca.roumani.tabulator;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TabulatorActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabulator);
    }

    public void buttonClicked(View v)
    {

        View fromView = findViewById(R.id.from);
        EditText fromEdit = (EditText) fromView;
        String from = fromEdit.getText().toString();

        View uptoView = findViewById(R.id.upto);
        EditText uptoEdit = (EditText) uptoView;
        String upto = uptoEdit.getText().toString();

        View incView = findViewById(R.id.inc);
        EditText incEdit = (EditText) incView;
        String inc = incEdit.getText().toString();

          int f1,u1,inc1;
          f1 = Integer.parseInt(from);
          u1 = Integer.parseInt(upto);
          inc1 = Integer.parseInt(inc);

        TableLayout tlayout=(TableLayout) findViewById(R.id.tableLayout);
        tlayout.setGravity(Gravity.CENTER);

        tlayout.removeAllViews();

        TextView hd1=new TextView(this);
        TextView hd2=new TextView(this);
        TextView hd3=new TextView(this);
        TextView hd4=new TextView(this);
        TextView hd5=new TextView(this);
        TextView hd6=new TextView(this);

        TableRow row0=new TableRow(this);
        row0=new TableRow(this);

        hd1.setText("Income");
        hd1.setTypeface(hd1.getTypeface(), Typeface.BOLD);
        row0.addView(hd1);
        hd2.setText("Tax");
        hd2.setTypeface(hd2.getTypeface(), Typeface.BOLD);
        row0.addView(hd2);
        hd3.setText("Avg");
        hd3.setTypeface(hd3.getTypeface(), Typeface.BOLD);
        row0.addView(hd3);
        hd4.setText("Mgn");
        hd4.setTypeface(hd4.getTypeface(), Typeface.BOLD);
        row0.addView(hd4);
        hd5.setText("CPP");
        hd5.setTypeface(hd5.getTypeface(), Typeface.BOLD);
        row0.addView(hd5);
        hd6.setText("Ei");
        hd6.setTypeface(hd6.getTypeface(), Typeface.BOLD);
        row0.addView(hd6);

        tlayout.addView(row0);

        for(;f1 <= u1;)
        {
            TAXModel model = new TAXModel();
            model.setIncome(f1);
            String a1 = model.getTax();
            String a2 = model.getAverageRate();
            String a3 = model.getMarginalRate();
            String a4 = model.getCPP();
            String a5 = model.getEI();


            TableRow row=new TableRow(this);

            TextView text1=new TextView(this);
            TextView text2=new TextView(this);
            TextView text3=new TextView(this);
            TextView text4=new TextView(this);
            TextView text5=new TextView(this);
            TextView text6=new TextView(this);


            for (int i=0;i<=0;i+= 2)
            {
                row=new TableRow(this);
                text1=new TextView(this);
                text2=new TextView(this);
                text3=new TextView(this);
                text4=new TextView(this);
                text5=new TextView(this);
                text6=new TextView(this);

                String tmpStr = Integer.toString(f1);

                text6.setText(tmpStr);
                row.addView(text6);
                text1.setText(a1);
                row.addView(text1);
                text2.setText(a2);
                row.addView(text2);
                text3.setText(a3);
                row.addView(text3);
                text4.setText(a4);
                row.addView(text4);
                text5.setText(a5);
                row.addView(text5);

                tlayout.addView(row);
            }

            f1 = f1 + inc1;
        }

    }
}