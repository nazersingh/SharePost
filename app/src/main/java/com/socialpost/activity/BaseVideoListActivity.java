package com.socialpost.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.socialpost.R;
import com.socialpost.Util.Constants;
import com.socialpost.adapter.VideoListAdapter;
import com.socialpost.base.BaseActivity;
import com.socialpost.base.BaseViewModel;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public abstract class BaseVideoListActivity<T> extends BaseActivity<BaseViewModel> {

    private RecyclerView mRecyclerView;
    private Lifecycle lifecycle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_video);


        lifecycle =getLifecycle();
//        getLifecycle().addObserver(youtubePlayerView);

        String id=getIntent().hasExtra(Constants.CATEGORY_ID)?getIntent().getStringExtra(Constants.CATEGORY_ID):"";
        String lang=getIntent().hasExtra(Constants.CATEGORY_Lang)?getIntent().getStringExtra(Constants.CATEGORY_Lang):"";
        String subCategory=getIntent().hasExtra(Constants.CATEGORY_SUB_ID)?getIntent().getStringExtra(Constants.CATEGORY_SUB_ID):"";
        getViewModel().getVideos(id,subCategory,lang);

        mRecyclerView = findViewById(R.id.recyclerView);
        setVideoAdapter(new ArrayList<>());
        getViewModel().onVideosListFetched().observe(this,this::onVideoListFetched);
    }

    private void onVideoListFetched(ArrayList<BaseMediaContentPojo> mediaContentPojos) {
        Log.e("VideosListActivity", "onVideoListFetched: "+mediaContentPojos.size() );
        setVideoAdapter(mediaContentPojos);
    }

    @Override
    public BaseViewModel getViewModel() {
        return new ViewModelProvider(this).get(BaseViewModel.class);
    }

    public void setVideoAdapter(ArrayList<BaseMediaContentPojo> allStoriesList) {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        VideoListAdapter videoListAdapter=new VideoListAdapter(getViewModel(),allStoriesList,adapterCallback);
        mRecyclerView.setAdapter(videoListAdapter);
    }

    public abstract void playVideos(BaseMediaContentPojo mediaContentPojo, int position);

    VideoListAdapter.VideoAdapterCallback adapterCallback=new VideoListAdapter.VideoAdapterCallback() {
        @Override
        public void onItemClickListener(BaseMediaContentPojo mediaContentPojo, int position) {
           playVideos(mediaContentPojo,position);
        }

        @Override
        public void onLikeClick(int adapterPosition) {

        }

        @Override
        public void onShareClick(int adapterPosition) {

        }
    };
}
