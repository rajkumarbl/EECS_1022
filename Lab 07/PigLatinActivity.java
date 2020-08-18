package ca.roumani.piglatin;


import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;

public class PigLatinActivity extends AppCompatActivity implements TextToSpeech.OnInitListener
{

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pig_latin);
        this.tts = new TextToSpeech(this, this);
    }

    public void onInit(int initStatus)
    {
        if (initStatus != TextToSpeech.ERROR)
        {
            if (tts.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
            {
                tts.setLanguage(Locale.US);
            }
        } else
        {
            Toast.makeText(this, "Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }

    public void say(String s)
    {
        if (tts != null)
        {
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void speakButton(View v)
    {
        View inputView = findViewById(R.id.input);
        EditText inputEdit = (EditText) inputView;
        String input = inputEdit.getText().toString();


        PigLatinModel model = new PigLatinModel();
        model.setEnglish(input);

        String answer = model.getPig();

        // passes the answer back to the view
        ((TextView) findViewById(R.id.convertedText)).setText(answer);
        say(answer);
    }

    public void clearButton(View v)
    {
        EditText editText = (EditText)findViewById(R.id.input);
        editText.setText("");

        ((TextView) findViewById(R.id.convertedText)).setText("");

    }

    public void convertButton(View v)
    {
        View inputView = findViewById(R.id.input);
        EditText inputEdit = (EditText) inputView;
        String input = inputEdit.getText().toString();
        say(input);

        PigLatinModel model = new PigLatinModel();
        model.setEnglish(input);

        String answer = model.getPig();

        // passes the answer back to the view
        ((TextView) findViewById(R.id.convertedText)).setText(answer);


    }
}

