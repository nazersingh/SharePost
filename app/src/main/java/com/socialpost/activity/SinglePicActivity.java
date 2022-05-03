package com.socialpost.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.socialpost.R;
import com.socialpost.Util.Constants;
import com.socialpost.base.BaseActivity;
import com.socialpost.base.BaseViewModel;

public class SinglePicActivity extends BaseActivity<BaseViewModel> {

    private String TAG=this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_pic_activity);

        ImageView mImgPic=findViewById(R.id.img_single_pic);
        ImageView mBtnRefresh=findViewById(R.id.refresh);
        String mainCategory=getIntent().hasExtra(Constants.CATEGORY_ID)?getIntent().getStringExtra(Constants.CATEGORY_ID):"";
        String id=getIntent().hasExtra(Constants.CATEGORY_SUB_ID)?getIntent().getStringExtra(Constants.CATEGORY_SUB_ID):"";

        String url="https://source.unsplash.com/700x1400?beautifull girls";
        Glide.with(this).load(url).into(mImgPic);
        mBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestOptions requestOptions = new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE) // because file name is always same
                        .skipMemoryCache(true);
//                Picasso.get().invalidate(url);
//                Picasso.get().load(url).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE);
//                Picasso.get().load(url).into(mImgPic);
//                Glide.with(SinglePicActivity.this).load(url).into(mImgPic);
                Glide.with(SinglePicActivity.this)
                        .load(url)
                        .apply(requestOptions)
                        .into(mImgPic);
            }
        });
    }


}
