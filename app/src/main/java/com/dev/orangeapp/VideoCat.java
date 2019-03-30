package com.dev.orangeapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class VideoCat extends Activity {
    private Spinner spinner;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_cat);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        addVideoCategoriesOnSpinner();


    }

    private void addVideoCategoriesOnSpinner() {
        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("All categories ");
        list.add("Foreign Movies | أفلام أجنبية ");
        list.add("Foreign Series | مسلسلات أجنبية ");
        list.add("Arabic Movies | أفلام عربية  ");
        list.add("Arabic Series | مسلسلات عربية  ");
        list.add("Turkish Movies | أفلام تركية  ");
        list.add("Turkish Series | مسلسلات تركية  ");
        list.add("Bollywood Movies | أفلام هندية  ");
        list.add("Asian Movies | أفلام أسيوية   ");
        list.add("Asian Series | مسلسلات أسيوية   ");
        list.add("Kids | أطفال ");
        list.add("Islam | إسلاميات  ");
        list.add("برامج رمضانية  ");
        list.add("مسلسلات رمضانية  ");
        list.add("TV Programs | برامج تلفزيونية");
        list.add("3D Movies | ثلاثي الأبعاد  ");
        list.add("Wrestling| مصارعة  ");
        ArrayAdapter<String> orderAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(orderAdapter);
    }


}
