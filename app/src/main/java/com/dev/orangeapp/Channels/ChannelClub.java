package com.dev.orangeapp.Channels;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.dev.orangeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ChannelClub extends AppCompatActivity {


    @BindView(R.id.playChannel)
    ImageView playChannel;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_club);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }


    @OnClick(R.id.playChannel)
    public void onViewClicked() {
        Intent startChannel= new Intent(this,ChannelPlayer.class);
        startActivity(startChannel);
    }



/*
    public void get_json() {
        String cat_json;
        try {
            InputStream cat_input_stream = getAssets().open("cat.json");
            int cat_size = cat_input_stream.available();
            byte[] buffer_cat = new byte[cat_size];
            cat_input_stream.read();
            cat_input_stream.close();
            cat_json = new String(buffer_cat, "UTF-8");
            JSONArray jsonCatArray = new JSONArray(cat_json);
            for (int i = 0; i < jsonCatArray.length(); i++) {
                JSONObject catobj = jsonCatArray.getJSONObject(i);
                if (catobj.getString("id").equals("1")) {
                    cat_num_list.add(catobj.getString("title"));
                }
                if (catobj.getString("id").equals("2")) {
                    cat_num_list.add(catobj.getString("title"));
                }
                if (catobj.getString("id").equals("3")) {
                    cat_num_list.add(catobj.getString("title"));
                }
                if (catobj.getString("id").equals("4")) {
                    cat_num_list.add(catobj.getString("title"));
                }
                if (catobj.getString("id").equals("5")) {
                    cat_num_list.add(catobj.getString("title"));
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
*/


}
