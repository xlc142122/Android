package com.pasenger.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.pasenger.fragmentbestpractice.fragment.NewsContentFragment;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String title, String content){
        Intent intent = new Intent(context, NewsContentActivity.class);

        intent.putExtra("title", title);
        intent.putExtra("content", content);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");

        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(title, content);
    }
}
