package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView chatView;
    private EditText questionText;
    private Button sendButton;
    private TextToSpeech tts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        setContentView(R.layout.activity_main);
        chatView = findViewById(R.id.chatView);
        questionText = findViewById(R.id.questionText);
        sendButton = findViewById(R.id.sendButton);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    tts.setLanguage(new Locale("ru"));
                }
            }
        });
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String question = questionText.getText().toString();
                questionText.setText("");
                //здесь нейронка
                String answer = AI.getAnswer(context, question); //TODO
                chatView.append("\n<<"+question);
                tts.speak(answer, TextToSpeech.QUEUE_FLUSH, null);
                chatView.append("\n>>"+ answer);
            }
        });
    }
}
