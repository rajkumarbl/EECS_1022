package ca.roumani.stocktrader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Field[] fields = R.array.class.getFields();

        LinearLayout output = (LinearLayout) findViewById(R.id.output);
        output.removeAllViews();
        for( int i = 0; i < fields.length; i++)
        {

            String s = fields[i].getName();
            if (! s.contains("$"))
            {
                TextView textView = new TextView(this);
                textView.setText(s);
                output.addView(textView);
            }
        }

    }

    public void buttonClicked(View v)
    {
        this.finish();
    }
}
