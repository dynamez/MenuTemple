package com.example.dynam.menutemple;



import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Calendar;
import java.util.HashMap;


public class MainActivity extends BaseActivity {
private VideoView video;
    ProgressDialog prgDialog;
    HashMap<String, String> queryValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sushi = (ImageButton)findViewById(R.id.imageButton2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MenuReaderDbHelper dbHelper = new MenuReaderDbHelper(this);
        //dbHelper.deleteBook();
       //dbHelper.createDatabase();
        //video = (VideoView)findViewById(R.id.videoView);
        //final MediaController mediaController=new MediaController(this);
       // Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.ejemplo);
        //video.setVideoURI(uri);

        /*video.setMediaController(mediaController);
        mediaController.setMediaPlayer(video);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                int duration = video.getDuration();
                video.requestFocus();
                //video.start();
                mediaController.show();
            }
        });*/
        // Initialize Progress Dialog properties
        prgDialog = new ProgressDialog(this);
        prgDialog.setMessage("Transferring Data from Remote MySQL DB and Syncing SQLite. Please wait...");
        prgDialog.setCancelable(false);
        // BroadCase Receiver Intent Object
        Intent alarmIntent = new Intent(getApplicationContext(), SampleBC.class);
        // Pending Intent Object
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Alarm Manager Object
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        // Alarm Manager calls BroadCast for every Ten seconds (10 * 1000), BroadCase further calls service to check if new records are inserted in
        // Remote MySQL DB
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 5000, 10 * 1000, pendingIntent);
        alarmManager.cancel(pendingIntent);

        ImageButton btn1 = (ImageButton)findViewById(R.id.imageButton);
        ImageButton btn2 = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton btn3 = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton btn4 = (ImageButton)findViewById(R.id.imageButton4);
        ImageButton btn5 = (ImageButton)findViewById(R.id.imageButton5);
        ImageButton btn6 = (ImageButton)findViewById(R.id.imageButton6);


        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se ha realizado la llamada al Garzón", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.imageButton:
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("imagen", R.layout.content_appetizer);
                    startActivity(intent);
                    break;
                case R.id.imageButton2:
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("imagen", R.layout.content_categoria);
                    startActivity(intent);
                    break;
                case R.id.imageButton3:
                    intent = new Intent(MainActivity.this, MenuActivity.class).putExtra("categoria", "izakaya");
                    startActivity(intent);
                    break;
                case R.id.imageButton4:
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("imagen", R.layout.content_especialidades);
                    //System.out.println(R.layout.content_especialidades);
                    startActivity(intent);
                    break;
                case R.id.imageButton5:
                    intent = new Intent(MainActivity.this, MenuActivity.class).putExtra("categoria", "postres");
                    startActivity(intent);
                    break;
                case R.id.imageButton6:
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("imagen", R.layout.content_bar);
                    startActivity(intent);
                    break;
            }

        }
    };







        //noinspection SimplifiableIfStatement


}
