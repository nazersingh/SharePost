package com.socialpost.activity;

import android.content.Intent;

import com.socialpost.Util.Constants;
import com.socialpost.base.BaseViewModel;
import com.socialpost.pojo.base.BaseMediaContentPojo;

public class ShortVideosListActivity extends BaseVideoListActivity<BaseViewModel> {


    @Override
    public void playVideos(BaseMediaContentPojo mediaContentPojo, int position) {
        String[] categoryNameArray = mediaContentPojo.getCategory_list_id().split("_");
        String categoryMain = categoryNameArray[0];
        String categoryData = categoryNameArray[1];
        String categoryLanguage = categoryNameArray[3];
        String subCategory = categoryNameArray[2];

        Intent intent=new Intent(ShortVideosListActivity.this, PlayShortVideoActivity.class);
        intent.putExtra(Constants.Video_ID_Position,position);
        intent.putExtra(Constants.CATEGORY_ID, categoryData);
        intent.putExtra(Constants.CATEGORY_SUB_ID, subCategory);
        intent.putExtra(Constants.CATEGORY_Lang, categoryLanguage);
        startActivity(intent);
    }
}
