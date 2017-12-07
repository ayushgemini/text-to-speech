package comblog.wixsite.ayushgemini.texttospeech;


import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends Activity implements
        TextToSpeech.OnInitListener {
    /**
     * Called when the activity is first created.
     */

    private TextToSpeech textToSpeech;
    private Button btnSpeak;
    private EditText edtText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        getView();
        setListner();

    }
    private void getView(){
        // link the front end widget id's to backend
        textToSpeech = new TextToSpeech(this, this);

        btnSpeak = (Button) findViewById(R.id.btn_speech);

        edtText = (EditText) findViewById(R.id.edt_text);
    }
    private void setListner(){
        // button on click event
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown textToSpeech!
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = textToSpeech.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {
        // get data from edit text box

        String text = edtText.getText().toString();

        //noinspection deprecation
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
        //textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}