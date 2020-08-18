package ca.roumani.rex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v)
    {
        CheckBox lc,dc,ac;
        boolean l = false,d = false, a = false;
        lc = (CheckBox)findViewById(R.id.letter);
        dc = (CheckBox)findViewById(R.id.digit);
        ac = (CheckBox)findViewById(R.id.anchor);

        RexModel rm = new RexModel();

        if(lc.isChecked())
        {
           l = true;
        }

        if(dc.isChecked())
        {
            d = true;
        }

        if(ac.isChecked())
        {
            a = true;
        }
        rm.setLetter(l);
        rm.setDigit(d);
        rm.setAnchor(a);
        rm.generate();
         String answer =  rm.getRex();
        ((TextView) findViewById(R.id.regex)).setText(answer);

    }

}
