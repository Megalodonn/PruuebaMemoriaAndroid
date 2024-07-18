package com.example.memoriaapi;

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
import java.util.Random;

public class JuegoMemoria extends AppCompatActivity implements Runnable, View.OnClickListener {

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
        setContentView(R.layout.juegomemorias);

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
        failuresL3j = (TextView) findViewById(R.id.failureesPlayerL3);

    }
    public void startl3 (View i){
          if (!running){
              running=true;
          }
    }

    public void restartl3(View r){
        scoreL3j.setText("0");
        failuresL3j.setText("0");

        img1.setImageDrawable(null);
        img2.setImageDrawable(null);
        img3.setImageDrawable(null);
        img4.setImageDrawable(null);
        img5.setImageDrawable(null);
        img6.setImageDrawable(null);
        img7.setImageDrawable(null);
        img8.setImageDrawable(null);
        img9.setImageDrawable(null);
        img10.setImageDrawable(null);
    }

    @Override
    public void onClick(View view) {

        //switch (view.getId()){

        //    case R.id.exitL3:{
        //        System.exit(0);
         //       break;
       //     }
        //}
    }

    private Handler bridge = new Handler(){
        @Override
        public void handleMessage(Message msg){
            //Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.trasparente);
            //imgButtons[valueSelected].setImageBitmap(bmp);
            //valueSelected=-1;
            //imgButtons[clearValue].setImageBitmap(bmp);
        }
    };

    private void disorderCards(){
        Random rnd = new Random();
        int aux, indexAux;
        for (int i=0; i < values.length; i++){
            aux=values[i];
            indexAux = rnd.nextInt(5);

            values[i] = values[indexAux];
            values[indexAux] = aux;
        }
    }
    private void controller (int option, ImageButton img){
        Bitmap bmp = null;
        option--;
        switch (values[option]){
            case 1: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.capri); break;
            case 2: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.geminis); break;
            case 3: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.leo); break;
            case 4: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.libra); break;
            case 5: bmp = BitmapFactory.decodeResource(getResources(), R.drawable.virgo); break;
        }
        if (valueSelected == -1){
            valueSelected = option;
            img.setImageBitmap(bmp);
        }
        else {
            if (values[valueSelected] == values [option]){
                score ++;
                scoreL3j.setText((score + ""));

                Toast.makeText(this, "you got it",100).show();
                img.setImageBitmap(bmp);
                valueSelected = -1;
            }
            else{
                failures ++;
                failuresL3j.setText((failures+ ""));
                clearValue = option;
                Toast.makeText(this, "Try again",100).show();
                img.setImageBitmap(bmp);
                Thread thread = new Thread(this);
                thread.start();
            }
        }
    }

    public void startGame(){
        img1 = (ImageButton) findViewById(R.id.iv_1l3);
        img2 = (ImageButton) findViewById(R.id.iv_2l3);
        img3 = (ImageButton) findViewById(R.id.iv_3l3);
        img4 = (ImageButton) findViewById(R.id.iv_4l3);
        img5 = (ImageButton) findViewById(R.id.iv_5l3);
        img6 = (ImageButton) findViewById(R.id.iv_6l3);
        img7 = (ImageButton) findViewById(R.id.iv_7l3);
        img8 = (ImageButton) findViewById(R.id.iv_8l3);
        img9 = (ImageButton) findViewById(R.id.iv_9l3);
        img10 = (ImageButton) findViewById(R.id.iv_10l3);
    }

    public  void  addEventsCards(){
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img1);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img2);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img3);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img4);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img5);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img6);
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img7);
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img8);
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img9);
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller(1,img10);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //int id = item.getItemId();
        //if (id == R.id.action_setting){

        //}
        return  super.onOptionsItemSelected(item);
    }

    @Override
    public void run() {
        SystemClock.sleep(150);
        Message msg = new Message();
        msg.obj = 10;
        bridge.sendMessage(msg);
    }
}
