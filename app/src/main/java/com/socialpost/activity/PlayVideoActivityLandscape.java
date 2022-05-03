package com.socialpost.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.socialpost.Util.Constants;
import com.socialpost.base.BaseViewModel;

public class PlayVideoActivityLandscape extends BasePlayVideoActivity<BaseViewModel> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String id=getIntent().hasExtra(Constants.CATEGORY_ID)?getIntent().getStringExtra(Constants.CATEGORY_ID):"";
        String lang=getIntent().hasExtra(Constants.CATEGORY_Lang)?getIntent().getStringExtra(Constants.CATEGORY_Lang):"";
        String subCategory=getIntent().hasExtra(Constants.CATEGORY_SUB_ID)?getIntent().getStringExtra(Constants.CATEGORY_SUB_ID):"";
        videoIdPosition=getIntent().hasExtra(Constants.Video_ID_Position)?getIntent().getIntExtra(Constants.Video_ID_Position,0):0;

        getViewModel().getVideos(id,subCategory,lang);
        getViewModel().onVideosListFetched().observe(this,this::onVideoListFetched);
    }
}
