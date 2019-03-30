package com.dev.orangeapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dev.orangeapp.Models.TvCategory;

import java.util.ArrayList;

public class TVCategoryAdapter extends ArrayAdapter<TvCategory> {
    public TVCategoryAdapter(Context context, int resource, ArrayList<TvCategory>tvCategories) {
        super(context, resource,tvCategories);

    }

    @Override
    public View getView(int position,View convertView ,ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    static class  ViewHolder{
        public TextView title;
        public  TextView number;
    }
}
