package com.example.dynam.menutemple;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class VideoTempleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_temple);
        final VideoView videotemple = (VideoView)findViewById(R.id.videotemple);
        Uri path = Uri.parse("android.resource://com.example.dynam.menutemple/"
                + R.raw.videotemple);
        videotemple.setVideoURI(path);
        final MyMediaController videoController = new MyMediaController(this, (FrameLayout) findViewById(R.id.controllerAnchor));
        videoController.setMediaPlayer(videotemple);
        videoController.setAnchorView(videotemple);
        videoController.setPadding(0, 0, 0, 340);

        videotemple.setMediaController(videoController);

        videotemple.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {


            @Override
            public void onPrepared(MediaPlayer mp) {
                videotemple.start();

                FrameLayout controllerAnchor = (FrameLayout) findViewById(R.id.controllerAnchor);
                videoController.setAnchorView(controllerAnchor);
                videoController.show(0);
            }


        });
    }

    public class MyMediaController extends MediaController
    {
        private FrameLayout anchorView;

        public MyMediaController(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public MyMediaController(Context context, boolean useFastForward) {
            super(context, useFastForward);
        }

        public MyMediaController(Context context) {
            super(context);
        }

        public MyMediaController(Context context, FrameLayout anchorView)
        {
            super(context);
            this.anchorView = anchorView;
        }

        @Override
        protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld)
        {
            super.onSizeChanged(xNew, yNew, xOld, yOld);

            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) anchorView.getLayoutParams();
            lp.setMargins(0, 0, 20, yNew);


            anchorView.setLayoutParams(lp);
            anchorView.requestLayout();
        }
        @Override
        public void show(int timeout) {
            super.show(0);
        }

    }
}
