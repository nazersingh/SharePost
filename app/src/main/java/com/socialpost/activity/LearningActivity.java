package com.socialpost.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.socialpost.R;
import com.socialpost.Util.Constants;
import com.socialpost.adapter.MediaAdapter;
import com.socialpost.base.BaseActivity;
import com.socialpost.base.BaseViewModel;
import com.socialpost.callback.AdapterCallback;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public class LearningActivity extends BaseActivity<BaseViewModel> {

    private  final String TAG = this.getClass().getSimpleName();
    private RecyclerView mRecyclerView;
    private ArrayList<BaseMediaContentPojo> allCategoryListItemPojo=new ArrayList<>();
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
        // TODO I need to get all the categories of Selected Categories Like : Music, Language learning in which language
        String id=getIntent().hasExtra(Constants.CATEGORY_ID)?getIntent().getStringExtra(Constants.CATEGORY_ID):"";
        String lang=getIntent().hasExtra(Constants.CATEGORY_Lang)?getIntent().getStringExtra(Constants.CATEGORY_Lang):"";

//        getViewModel().getMotivationalCategoryData(id,lang);
//        getViewModel().onMediaContentFetched().observe(this,this::onMediaContentListFetched);
    }
    private void onMediaContentListFetched(ArrayList<BaseMediaContentPojo> allCategoryListItemPojoList) {

        setPostCategoryAdapter(allCategoryListItemPojoList);
    }

    public void setPostCategoryAdapter(ArrayList<BaseMediaContentPojo> allCategoryListItemPojo) {

        this.allCategoryListItemPojo=allCategoryListItemPojo;
        Log.e(TAG, "setPostCategoryAdapter: "+allCategoryListItemPojo.size() );
        if (mRecyclerView.getAdapter() == null) {
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            MediaAdapter adapter = new MediaAdapter(allCategoryListItemPojo, mediaAdapterItemClickCallback);
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
           // shareTextMessage(allCategoryListItemPojo.get(adapterPosition).getText());
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
}
