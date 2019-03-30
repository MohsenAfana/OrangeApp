package com.dev.orangeapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.dev.orangeapp.Channels.ChannelListActivity;
import com.dev.orangeapp.Channels.ChannelPlayer;
import com.dev.orangeapp.VideoClub.SeriesPlayer1;
import com.dev.orangeapp.VideoClub.VideoClub;
import com.dev.orangeapp.VideoClub.VideoListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Menu2 extends AppCompatActivity {

    @BindView(R.id.TVScreen)
    LinearLayout TVScreenLayout;
    @BindView(R.id.VideClubLayout)
    LinearLayout VideClubLayout;
    @BindView(R.id.SettingsLayout)
    LinearLayout SettingsLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu1);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    }

    @OnClick(R.id.TVScreen)
    public void onTVScreenLayoutClicked() {
        Intent TvScreenIntent = new Intent(this, ChannelListActivity.class);
        startActivity(TvScreenIntent);
    }

    @OnClick(R.id.VideClubLayout)
    public void onVideClubLayoutClicked() {
        Intent VideoClubIntent = new Intent(this, SeriesPlayer1.class);
        startActivity(VideoClubIntent);
    }

    @OnClick(R.id.SettingsLayout)
    public void onSettingsLayoutClicked() {
        Intent SettingsIntent = new Intent(this,Settings.class);
        startActivity(SettingsIntent);
    }


}
