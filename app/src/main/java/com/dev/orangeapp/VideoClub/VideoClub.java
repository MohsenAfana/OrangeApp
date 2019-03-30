package com.dev.orangeapp.VideoClub;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.dev.orangeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoClub extends AppCompatActivity {

    @BindView(R.id.playSeries)
    ImageView playSeries;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_club);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

    @OnClick(R.id.playSeries)
    public void onViewClicked() {
        Intent startSeries= new Intent(this,SeriesPlayer1.class);
        startActivity(startSeries);

    }
}



