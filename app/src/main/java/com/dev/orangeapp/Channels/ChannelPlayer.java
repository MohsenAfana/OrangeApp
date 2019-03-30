package com.dev.orangeapp.Channels;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dev.orangeapp.R;
import com.dev.orangeapp.VideoClub.SeriesPlayer1;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class ChannelPlayer extends AppCompatActivity implements GestureDetector.OnGestureListener {

    public static final int SWIPE_THRESHOLD = 100;
    public static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private PlayerView playerView;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;
    private ProgressBar loading;
    private ExoPlayer player;
    private View decorView;
    private int uiOptions;

    ConcatenatingMediaSource concatenatingMediaSource;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_channel);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        playerView = findViewById(R.id.video_view);
        loading = findViewById(R.id.loading);

///////////Hiding NavigationAndNotificationBar///////////////////////////
        uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);
///////////Hiding NavigationAndNotificationBar///////////////////////////
        gestureDetector = new GestureDetector(this);
    }

    public void onStart() {
        super.onStart();
        //--------------------------------------
        //Creating default track selector
        //and init the player
        TrackSelection.Factory adaptiveTrackSelection = new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter());
        player = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(ChannelPlayer.this),
                new DefaultTrackSelector(adaptiveTrackSelection),
                new DefaultLoadControl());

        //init the player
        playerView.setPlayer(player);

        //-------------------------------------------------
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(ChannelPlayer.this,
                Util.getUserAgent(ChannelPlayer.this, "Exo2"), defaultBandwidthMeter);

        //-----------------------------------------------
        //Create media source
        String hls_url = "http://stream1.orange.ps:1933/live/TVMBC-DRAMA/playlist.m3u8";
        String hls_url2 = "http://stream1.orange.ps:1933/live/MBC-Bollywood/playlist.m3u8";
        String hls_url3 = "http://stream1.orange.ps:1933/live/TVMBC-4/playlist.m3u8";
        String hls_url4 = "http://stream1.orange.ps:1933/live/TVMBC-Action/playlist.m3u8";
        String hls_url5 = "http://stream1.orange.ps:1933/live/TVMBC-4/playlist.m3u8";
        String hls_url6 = "http://stream1.orange.ps:1933/live/MBC-Bollywood/playlist.m3u8";
        String hls_url7 = "http://stream1.orange.ps:1935/tv/Dubai-TV/playlist.m3u8";
        String hls_url8 = "http://stream1.orange.ps:1933/live/TVMBC-DRAMA/playlist.m3u8";

        Uri[] links = {Uri.parse(hls_url), Uri.parse(hls_url2), Uri.parse(hls_url3), Uri.parse(hls_url4),
                    Uri.parse(hls_url5), Uri.parse(hls_url6), Uri.parse(hls_url7), Uri.parse(hls_url8)};
        Uri uri = Uri.parse(hls_url);
        Uri uri2 = Uri.parse(hls_url2);
        Uri uri3 = Uri.parse(hls_url3);
        Uri uri4 = Uri.parse(hls_url4);
        Uri uri5 = Uri.parse(hls_url5);
        Uri uri6 = Uri.parse(hls_url6);
        Uri uri7 = Uri.parse(hls_url7);
        Uri uri8 = Uri.parse(hls_url8);

        Handler mainHandler = new Handler();

        MediaSource mediaSource = new HlsMediaSource(uri, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource1 = new HlsMediaSource(uri2, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource3 = new HlsMediaSource(uri3, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource4 = new HlsMediaSource(uri4, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource5 = new HlsMediaSource(uri5, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource6 = new HlsMediaSource(uri6, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource7 = new HlsMediaSource(uri7, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource8 = new HlsMediaSource(uri8, dataSourceFactory, mainHandler, null);

        MediaSource[] sources = {mediaSource, mediaSource1, mediaSource3, mediaSource4, mediaSource5, mediaSource6, mediaSource7, mediaSource8};
        concatenatingMediaSource = new ConcatenatingMediaSource(sources);
        player.prepare(concatenatingMediaSource);
        player.setPlayWhenReady(playWhenReady);

        player.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                switch (playbackState) {
                    case ExoPlayer.STATE_READY:
                        loading.setVisibility(View.GONE);
                        break;
                    case ExoPlayer.STATE_BUFFERING:
                        loading.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }


        });
        player.seekTo(currentWindow, playbackPosition);
        player.prepare(concatenatingMediaSource, true, false);
    }

    private void releasePlayer() {
        if (player != null) {
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            playWhenReady = player.getPlayWhenReady();
            player.release();
            player = null;
        }
    }

    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            releasePlayer();
        }
    }


    public void onStop() {
        super.onStop();

        if (Util.SDK_INT > 23) {
            releasePlayer();
        }
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
        boolean result = false;
        float diffY = moveEvent.getY() - downEvent.getY();
        float diffX = moveEvent.getX() - downEvent.getX();
        // which was greater?  movement across Y or X?
        if (Math.abs(diffX) > Math.abs(diffY)) {
            // right or left swipe
            if (Math.abs(diffX)> SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    Toast.makeText(this,"you just Swipe_Right", Integer.parseInt("1")).show();
                } else {
                    Toast.makeText(this,"you just Swipe_Left", Integer.parseInt("1")).show();

                }

                result = true;
            }
        } else {
            // up or down swipe
            if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY)> SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    Intent intent=new Intent(this, SeriesPlayer1.class);
                    startActivity(intent);
                } else {
                    Intent intent=new Intent(this, SeriesPlayer1.class);
                    startActivity(intent);
                }
                result = true;
            }
        }

        return result;
    }

    private void onSwipeLeft() {
        Toast.makeText(this,"Swipe Left",Toast.LENGTH_LONG).show();
    }
    private void onSwipeRight() {
        Toast.makeText(this,"Swipe Right",Toast.LENGTH_LONG).show();
    }

    private void onSwipeBottom() {
        Toast.makeText(this,"Swipe Bottom",Toast.LENGTH_LONG);
    }
    private void onSwipeTop() {
        Toast.makeText(this,"Swipe Top",Toast.LENGTH_LONG);

    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("test", "onTouchEvent: "+event.toString());
    return gestureDetector.onTouchEvent(event);

    }
}
