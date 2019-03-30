package com.dev.orangeapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.dev.orangeapp.Channels.ChannelListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TVCat extends Activity {
    @BindView(R.id.Tv_program_btn)
    Button TvProgramBtn;
    private Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_items);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        addCategoriesOnSpinner();
        addOrderOnSpinner();


    }

    private void addCategoriesOnSpinner() {
        spinner2 = (Spinner) findViewById(R.id.spinner1);
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


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    private void addOrderOnSpinner() {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> order = new ArrayList<String>();
        order.add("By number,ascending ");
        order.add("By number,decending ");
        order.add("By name,ascending ");
        order.add("By name,decending");
        ArrayAdapter<String> orderAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, order);
        orderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(orderAdapter);
    }

    private void searchTvCat() {
        ArrayList<String> searchList = new ArrayList<String>();
        String search = "a";
        int searchListLength = searchList.size();
        for (int i = 0; i < searchListLength; i++) {
            if (searchList.get(i).contains(search)) {
                Toast.makeText(this, "this is the result"
                        + getLocalClassName(), Toast.LENGTH_LONG);
            }
        }
    }


    @OnClick(R.id.Tv_program_btn)
    public void onViewClicked() {
        Intent intent = new Intent(this, ChannelListActivity.class);
        startActivity(intent);
    }
}
