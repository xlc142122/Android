package com.pasenger.fragmentbestpractice.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pasenger.fragmentbestpractice.R;
import com.pasenger.fragmentbestpractice.entity.News;

import java.util.List;

/**
 * Created by Pasenger on 15/10/9.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private int resourceId;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;

        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }else{
            view = convertView;
        }

        TextView titleText = (TextView) view.findViewById(R.id.news_title);
        titleText.setText(news.getTitle());

        Log.d("NewsAdapter", "getView: id:" + R.id.news_title + ", title:" + news.getTitle());

        return view;
    }
}