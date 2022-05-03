package com.socialpost.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.socialpost.R;
import com.socialpost.Util.Constants;
import com.socialpost.adapter.StoryListAdapter;
import com.socialpost.base.BaseActivity;
import com.socialpost.base.BaseViewModel;
import com.socialpost.callback.AdapterCallback;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public class StoriesList extends BaseActivity<BaseViewModel> {

    private  final String TAG = this.getClass().getSimpleName();
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_list_content);

        setUpLayout();
    }
    @Override
    public BaseViewModel getViewModel() {
        return new ViewModelProvider(this).get(BaseViewModel.class);
    }
    private void setUpLayout() {

        Toolbar mToolbar=findViewById(R.id.toolbar);
        ImageView imageView2=findViewById(R.id.imgCategory);
        mRecyclerView = findViewById(R.id.recyclerView);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String url="https://source.unsplash.com/1600x900/?motivational";
        Glide.with(this).load(url).into(imageView2);

        String id=getIntent().hasExtra(Constants.CATEGORY_ID)?getIntent().getStringExtra(Constants.CATEGORY_ID):"";

        getViewModel().getAllStories(id); //TODO Type of Story Category
        getViewModel().onAllStoriesListFetched().observe(this,this::onAllStoriesListFetched);
    }
    private void onAllStoriesListFetched(ArrayList<BaseMediaContentPojo> allStoriesList) {
        setStoryListAdapter(allStoriesList);
    }

    public void setStoryListAdapter(ArrayList<BaseMediaContentPojo> allStoriesList) {

        if (mRecyclerView.getAdapter() == null) {
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            StoryListAdapter adapter = new StoryListAdapter(allStoriesList, mediaAdapterItemClickCallback,onClickListener);
            mRecyclerView.setAdapter(adapter);
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
    private final AdapterCallback mediaAdapterItemClickCallback=new AdapterCallback() {
        @Override
        public void onLikeClick(int adapterPosition) {
            Log.e(TAG, "onLikeClick: "+adapterPosition );
        }

        @Override
        public void onShareClick(int adapterPosition) {
            Log.e(TAG, "onShareClick: "+adapterPosition );
            shareTextMessage("Test share Message");
        }
    };

    private void shareTextMessage(String Message)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, Message);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private final View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BaseMediaContentPojo mediaContentPojo= (BaseMediaContentPojo) v.getTag();
            Intent intent=new Intent(StoriesList.this,StoryDetailActivity.class);
            intent.putExtra(Constants.INTENT_SHARE_STORY_HEADING,mediaContentPojo.getStoryName());
            intent.putExtra(Constants.INTENT_SHARE_STORY_DETAIL,mediaContentPojo.getStoryDetail());
            intent.putExtra(Constants.INTENT_SHARE_STORY_MOREL,mediaContentPojo.getStoryMorel());
            startActivity(intent);
        }
    };
}