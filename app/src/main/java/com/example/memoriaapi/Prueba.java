package com.example.memoriaapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class Prueba extends AppCompatActivity implements Runnable, View.OnClickListener {
    Button ExitL3j;
    private boolean running;
    private long pauseoffset;
    private Chronometer Chronometer3;
    private ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;
    private TextView scoreL3j, failuresL3j;
    private int score, failures;
    private int []values = {1,2,3,4,5,1,2,3,4,5};
    private ImageButton imgButtons[];
    private int valueSelected = -1;
    private int clearValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        score =0;
        failures =0;
        //startGame();
        imgButtons = new ImageButton[] {img1,img2,img3,img4,img5,img6,img7,img8,img9,img10};
        //disorderCards();
        //R.id.exitL3
        ExitL3j = (Button) findViewById(R.id.exitL3);
        ExitL3j.setOnClickListener(this);

        //addEventsCards();
        scoreL3j = (TextView) findViewById(R.id.ScorePlayerL3);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void run() {

    }
}