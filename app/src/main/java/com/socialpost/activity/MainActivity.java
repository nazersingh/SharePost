package com.socialpost.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.socialpost.R;
import com.socialpost.adapter.PostCategoryTypeAdapter;
import com.socialpost.base.BaseActivity;
import com.socialpost.base.BaseViewModel;
import com.socialpost.pojo.AllCategoryListItemPojo;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<BaseViewModel> {

    private final String TAG = this.getClass().getSimpleName();
    private RecyclerView mRecyclerView;
private CollapsingToolbarLayout collapsingToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpLayout();
    }
    @Override
    public BaseViewModel getViewModel() {
       return new ViewModelProvider(this).get(BaseViewModel.class);
    }
    private void setUpLayout() {

        Toolbar mToolbar=findViewById(R.id.toolbar);
        ImageView imageView2=findViewById(R.id.imgCategory);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getViewModel().onHomeScreenCategoryListFetched().observe(this,this::onHomeScreenCategoryListFetched);
        getViewModel().getHomeScreenCategoryList();

        String url="https://source.unsplash.com/1600x900/?motivational";
        Glide.with(this).load(url).into(imageView2);

        collapsingToolbar =  findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Today is a beautiful day");
//        loadPic("https://source.unsplash.com/1600x900/?motivational",imageView2);
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

    private void loadPic(String url,ImageView imageView)
    {
//        Picasso.with(this).load(url)
//                .into(imageView, new com.squareup.picasso.Callback() {
//                    @Override
//                    public void onSuccess() {
//
//                    }
//
//                    @Override
//                    public void onError() {
//
//                    }
//                });

//        Picasso.get().load(url).into(new Target() {
//            @Override
//            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                Log.e(TAG, "The image was obtained correctly");
//
//                imageView.setImageBitmap(bitmap);
//                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//                    @SuppressWarnings("ResourceType")
//                    @Override
//                    public void onGenerated(Palette palette) {
//                        int vibrantColor = palette.getVibrantColor(R.color.dark_theme);
//                        collapsingToolbar.setContentScrimColor(vibrantColor);
//                        collapsingToolbar.setStatusBarScrimColor(R.color.light_theme_ripple);
//                    }
//                });
//            }
//
//            @Override
//            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//
//            }
//
//            @Override
//            public void onPrepareLoad(Drawable placeHolderDrawable) {
//                Log.e(TAG ,"Getting ready to get the image");
//                //Here you should place a loading gif in the ImageView
//                //while image is being obtained.
//            }
//        });
    }

    private void onHomeScreenCategoryListFetched(ArrayList<AllCategoryListItemPojo> allCategoryListItemPojoList) {

        setPostCategoryAdapter(allCategoryListItemPojoList);
    }

    public void setPostCategoryAdapter(ArrayList<AllCategoryListItemPojo> allCategoryListItemPojo) {
        mRecyclerView = findViewById(R.id.recyclerView);
        if (mRecyclerView.getAdapter() == null) {
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            PostCategoryTypeAdapter adapter = new PostCategoryTypeAdapter(allCategoryListItemPojo);
            mRecyclerView.setAdapter(adapter);
        }
    }



}