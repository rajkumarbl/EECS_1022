package ca.roumani.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        View weightView = findViewById(R.id.weightBox);
        EditText weightEdit = (EditText) weightView;
        String weight = weightEdit.getText().toString();

        View heightView = findViewById(R.id.heightBox);
        EditText heightEdit = (EditText) heightView;
        String height = heightEdit.getText().toString();

        BMIModel model = new BMIModel(weight, height);
        String bmi = model.getBMI();
        String lbs = model.getWeightInPound();
        String answer = "Your Weight in pound is " + lbs + " and your BMI is " + bmi + ".";

        // passes the answer back to the view
        ((TextView) findViewById(R.id.answer)).setText(answer);


    }
}















