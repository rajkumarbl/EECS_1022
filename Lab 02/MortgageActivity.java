package ca.roumani.mortgage;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class MortgageActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage);
    }

    public void buttonClicked(View v)
    {
        View principleView = findViewById(R.id.pricipleBox);
        EditText principleEdit = (EditText) principleView;
        String principle = principleEdit.getText().toString();

        View monthView = findViewById(R.id.monthBox);
        EditText monthEdit = (EditText) monthView;
        String month = monthEdit.getText().toString();

        View interestView = findViewById(R.id.intBox);
        EditText interestEdit = (EditText) interestView;
        String interest = interestEdit.getText().toString();

        MortgageModel model = new MortgageModel(principle, month, interest);
        String pay= model.computePayment();
        String answer = "$" + pay;

        // passes the answer back to the view
        ((TextView) findViewById(R.id.answer)).setText(answer);


    }

    public void onClick(View v)
    {
        View principleView = findViewById(R.id.pricipleBox);
        EditText principleEdit = (EditText) principleView;
        String principle = principleEdit.getText().toString();

        View monthView = findViewById(R.id.monthBox);
        EditText monthEdit = (EditText) monthView;
        String month = monthEdit.getText().toString();

        View interestView = findViewById(R.id.intBox);
        EditText interestEdit = (EditText) interestView;
        String interest = interestEdit.getText().toString();

        MortgageModel model = new MortgageModel(principle, month, interest);
        String answer = model.YUMComputePayment();

        ((TextView)findViewById(R.id.yuanswer)).setText(answer);

    }
}
