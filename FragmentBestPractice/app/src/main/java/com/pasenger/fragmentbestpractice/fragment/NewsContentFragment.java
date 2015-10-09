package com.pasenger.fragmentbestpractice.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pasenger.fragmentbestpractice.R;

/**
 * Created by Pasenger on 15/10/9.
 */
public class NewsContentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.news_content_frag, container, false);

        return view;
    }

    public void refresh(String title, String content){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);

        TextView titleView = (TextView) view.findViewById(R.id.news_title);
        TextView contentView = (TextView) view.findViewById(R.id.news_content);

        titleView.setText(title);
        contentView.setText(content);
    }

}
