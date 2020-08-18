package ca.roumani.mcalc;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class McalcActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcalc);
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

        if (principle.length() > 0 && month.length() > 0 && interest.length() > 0)
        {
            Model model = new Model(principle, month, interest);
            String pay = model.computePayment();
            String exPay = model.exactPay();
            String answer = pay + "," + "\n" + exPay;

            // passes the answer back to the view
            ((TextView) findViewById(R.id.answer)).setText(answer);
        } else if (principle.length() <= 0)
        {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Please enter a Valid Principle");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "ok",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });


            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else if (month.length() <= 0)
        {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Please enter a Valid Amortization");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "ok",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });


            AlertDialog alert11 = builder1.create();
            alert11.show();
        } else if (interest.length() <= 0)
        {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Please enter a Valid Interest");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "ok",
                    new DialogInterface.OnClickListener()
                    {
                        public void onClick(DialogInterface dialog, int id)
                        {
                            dialog.cancel();
                        }
                    });


            AlertDialog alert11 = builder1.create();
            alert11.show();
        }
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

        Model model = new Model(principle, month, interest);
        String answer = model.yuPay();

        ((TextView)findViewById(R.id.yuanswer)).setText(answer);

    }
}
