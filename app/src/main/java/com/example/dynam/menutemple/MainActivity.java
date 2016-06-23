package com.example.dynam.menutemple;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends BaseActivity {
private VideoView video;
    public ArrayList<MenuTemple> customlist = new ArrayList<MenuTemple>();
    ProgressDialog prgDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sushi = (ImageButton)findViewById(R.id.imageButton2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MenuReaderDbHelper dbHelper = new MenuReaderDbHelper(this);
        //dbHelper.deleteBook();
        dbHelper.createDatabase();
        int toastDurationInMilliSeconds = 10000;
        final Toast toast = Toast.makeText(this, "Haz click en el logo para ver nuestra presentación", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 140);
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
            public void onTick(long millisUntilFinished) {
                toast.show();
            }
            public void onFinish() {
                toast.cancel();
            }
        };
        //toast.setText("Haz click en el logo para ver nuestra presentación");

        toast.show();
        toastCountDown.start();
        //toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
        //customlist=dbHelper.getAllBooks("appetizer_frio");
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

        // BroadCase Receiver Intent Object
        int alarmid = 0;
        Intent alarmIntent = new Intent(getApplicationContext(), SampleBC.class);
        alarmIntent.putExtra("alarmid", alarmid);
        // Pending Intent Object
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), alarmid, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Alarm Manager Object
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        // Alarm Manager calls BroadCast for every Ten seconds (10 * 1000), BroadCase further calls service to check if new records are inserted in
        // Remote MySQL DB
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 5000, 10 * 1000, pendingIntent);
        // alarmManager.cancel(pendingIntent);
        ImageView logo = (ImageView) findViewById(R.id._group_);
        ImageView btn1 = (ImageView) findViewById(R.id.imageButton);
        ImageView btn2 = (ImageView) findViewById(R.id.imageButton2);
        ImageView btn3 = (ImageView) findViewById(R.id.imageButton3);
        ImageView btn4 = (ImageView) findViewById(R.id.imageButton4);
        ImageView btn5 = (ImageView) findViewById(R.id.imageButton5);
        ImageView btn6 = (ImageView) findViewById(R.id.imageButton6);


        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        logo.setOnClickListener(onClickListener);


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
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("categoria", R.layout.content_appetizer);
                    startActivity(intent);
                    break;
                case R.id.imageButton2:
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("categoria", R.layout.content_categoria);
                    startActivity(intent);
                    break;
                case R.id.imageButton3:
                    intent = new Intent(MainActivity.this, MenuActivity.class).putExtra("categoria", "izakaya");
                    startActivity(intent);
                    break;
                case R.id.imageButton4:
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("categoria", R.layout.content_especialidades);
                    //System.out.println(R.layout.content_especialidades);
                    startActivity(intent);
                    break;
                case R.id.imageButton5:
                    intent = new Intent(MainActivity.this, MenuActivity.class).putExtra("categoria", "postres");
                    startActivity(intent);
                    break;
                case R.id._group_:
                    intent = new Intent(MainActivity.this, VideoTempleActivity.class).putExtra("categoria", "postres");
                    startActivity(intent);
                    break;
                case R.id.imageButton6:
                    intent = new Intent(MainActivity.this, CategoriaActivity.class).putExtra("categoria", R.layout.content_bar);
                    startActivity(intent);
                    break;
            }

        }
    };







        //noinspection SimplifiableIfStatement


}
