package com.dev.orangeapp.VideoClub;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.dev.orangeapp.R;
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

import butterknife.ButterKnife;

public class SeriesPlayer1 extends AppCompatActivity {

    private PlayerView playerView;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;
    private ProgressBar loading;
    private ExoPlayer player;
    private  View decorView;
    private  int uiOptions;
    ConcatenatingMediaSource concatenatingMediaSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        playerView = findViewById(R.id.playSeries_playerView);
        loading = findViewById(R.id.loadinSeries_playerView);

///////////Hiding NavigationAndNotificationBar///////////////////////////
        uiOptions=(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY );

        decorView=getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);
///////////Hiding NavigationAndNotificationBar///////////////////////////
    }
    public void onStart() {
        super.onStart();
        //--------------------------------------
        //Creating default track selector
        //and init the player
        TrackSelection.Factory adaptiveTrackSelection = new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter());
        player = ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(SeriesPlayer1.this),
                new DefaultTrackSelector(adaptiveTrackSelection),
                new DefaultLoadControl());

        //init the player
        playerView.setPlayer(player);

        //-------------------------------------------------
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        // Produces DataSource instances through which media data is loaded.
        final DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(SeriesPlayer1.this,
                Util.getUserAgent(SeriesPlayer1.this, "Exo2"), defaultBandwidthMeter);

        //-----------------------------------------------
        //Create media source

        String hls_url =  "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/1.mp4/playlist.m3u8";
        String hls_url2 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/2.mp4/playlist.m3u8";
        String hls_url3 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/3.mp4/playlist.m3u8";
        String hls_url4 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/4.mp4/playlist.m3u8";
        String hls_url5 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/5.mp4/playlist.m3u8";
        String hls_url6 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/6.mp4/playlist.m3u8";
        String hls_url7 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/7.mp4/playlist.m3u8";
        String hls_url8 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/8.mp4/playlist.m3u8";
        String hls_url9 = "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/9.mp4/playlist.m3u8";
        String hls_url10= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/10.mp4/playlist.m3u8";
        String hls_url11= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/11.mp4/playlist.m3u8";
        String hls_url12= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/12.mp4/playlist.m3u8";
        String hls_url13= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/13.mp4/playlist.m3u8";
        String hls_url14= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/14.mp4/playlist.m3u8";
        String hls_url15= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/15.mp4/playlist.m3u8";
        String hls_url16= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/16.mp4/playlist.m3u8";
        String hls_url17= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/17.mp4/playlist.m3u8";
        String hls_url18= "http://dl3.aflamy.ps:1935/TEST/_definst_/mp4:/dl1-15/GoodDoctor1/18.mp4/playlist.m3u8";



        Uri[] links = {Uri.parse(hls_url),Uri.parse(hls_url2),Uri.parse(hls_url3),Uri.parse(hls_url4),Uri.parse(hls_url5),
                Uri.parse(hls_url6),Uri.parse(hls_url7),Uri.parse(hls_url8),Uri.parse(hls_url9),Uri.parse(hls_url10),
                Uri.parse(hls_url11),Uri.parse(hls_url12),Uri.parse(hls_url13),Uri.parse(hls_url14),Uri.parse(hls_url15),
                Uri.parse(hls_url16),Uri.parse(hls_url17),Uri.parse(hls_url18)};


        Uri uri = Uri.parse(hls_url);
        Uri uri2 = Uri.parse(hls_url2);
        Uri uri3 = Uri.parse(hls_url3);
        Uri uri4 = Uri.parse(hls_url4);
        Uri uri5 = Uri.parse(hls_url5);
        Uri uri6 = Uri.parse(hls_url6);
        Uri uri7 = Uri.parse(hls_url7);
        Uri uri8 = Uri.parse(hls_url8);
        Uri uri9 = Uri.parse(hls_url9);
        Uri uri10 = Uri.parse(hls_url10);
        Uri uri11 = Uri.parse(hls_url11);
        Uri uri12 = Uri.parse(hls_url12);
        Uri uri13 = Uri.parse(hls_url13);
        Uri uri14 = Uri.parse(hls_url14);
        Uri uri15 = Uri.parse(hls_url15);
        Uri uri16 = Uri.parse(hls_url16);
        Uri uri17 = Uri.parse(hls_url17);
        Uri uri18 = Uri.parse(hls_url18);


        Handler mainHandler = new Handler();
        MediaSource mediaSource = new HlsMediaSource(uri, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource2 = new HlsMediaSource(uri2, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource3 = new HlsMediaSource(uri3, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource4 = new HlsMediaSource(uri4, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource5 = new HlsMediaSource(uri5, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource6 = new HlsMediaSource(uri6, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource7 = new HlsMediaSource(uri7, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource8 = new HlsMediaSource(uri8, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource9 = new HlsMediaSource(uri9, dataSourceFactory, mainHandler, null);
        MediaSource mediaSource10 = new HlsMediaSource(uri10,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource11 = new HlsMediaSource(uri11,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource12 = new HlsMediaSource(uri12,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource13 = new HlsMediaSource(uri13,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource14 = new HlsMediaSource(uri14,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource15 = new HlsMediaSource(uri15,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource16 = new HlsMediaSource(uri16,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource17 = new HlsMediaSource(uri17,dataSourceFactory, mainHandler, null);
        MediaSource mediaSource18 = new HlsMediaSource(uri18,dataSourceFactory, mainHandler, null);





        MediaSource[] sources = {mediaSource,mediaSource2,mediaSource3,mediaSource4, mediaSource5, mediaSource6,
                                mediaSource7,mediaSource8, mediaSource9, mediaSource10,mediaSource11,mediaSource12,
                                mediaSource13,mediaSource14,mediaSource15,mediaSource16,mediaSource17,mediaSource18};
        concatenatingMediaSource= new ConcatenatingMediaSource(sources);
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


}
