package com.example.myapplication;


import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AI{


    private static final String TAG = "MyApp";

 /*
    static void sin(String[] result){
        //String[] result = new String[73];
        int[][] array = new int[15][73];
        for (short z = -36; z < 37; z++) {
            short x = 0;
            x = (short)(Math.sin(z* Math.PI / 18) * 6);
            if ((x < 8) && (x > -8)) {
                array[7 - x][z+36] = 1;
            }
        }
        for (short i = 0; i < 14; i++) {
            for (short z = 0; z < 73; z++) {
                if(z == 0){
                    result[i] =  " ";
                }
                if (array[i][z] == 1) {
                    result[i] +=  '@';
                }
                else{
                    if (z == 36) {
                        result[i] += "|";
                    }
                    else if (i == 7) {
                        result[i] += "-";
                    }
                    else {
                        result[i] += " ";
                    }
                }
            }
        }
        //return result;
    }
*/

    static MediaPlayer mPlayer;


    public static String getAnswer(Context context, String question){
        ArrayList<String> answer = new ArrayList<>();
        question = question.toLowerCase();
        switch(question){
            case "сколько сейчас":
            case "точное время":
            case "часы":
            case "время":
            case "который час":
            case "сколько времени":
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                String time = timeFormat.format(new Date());
                answer.add("Точное время: " + time + ", сэр");
                break;
            case "кто ты":
            case "имя":
            case "как тебя зовут":
            case "твое имя":
            case "твоё имя":
                answer.add("Мое имя - Ыыыыы");
                break;
            case "синус":
                /*
                answer.add("\n");
                String[] a = new String[73];
                sin(a);
                for(int i = 0; i<a.length; i++){
                    //Log.i(TAG, a[i]);
                    answer.add(a[i]+"\n");
                }
                 */
                answer.add("Функция не работает");
                break;
            case "русские вперед":
            case "русские":
            case "тесса":
            case "вперед":
            case "русские вперёд":
            case "вперёд":
            case "вайолет":
                answer.add("Запускаю");
                mPlayer = MediaPlayer.create(context, R.raw.music);
                mPlayer.start();
                break;
            default:
                answer.add("НЕПОНЯЯТНО");
        }
        if(answer.size()>0){
            return String.join("," , answer);
        }
        return new String();
    }
}

