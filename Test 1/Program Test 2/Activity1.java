package eecs.pt2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    public void buttonClicked(View v)
    {
        View weightView = findViewById(R.id.input);
        EditText weightEdit = (EditText) weightView;
        String input = weightEdit.getText().toString();


        M1 model = new M1();
        boolean ans = model.isPalindrome(input);
        String answer = Boolean.toString(ans);

        // passes the answer back to the view
        ((TextView) findViewById(R.id.output)).setText(answer);


    }
}
