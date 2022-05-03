package com.socialpost.Util;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.socialpost.manager.MyApplication;

public class Utility {


    public static void LoadImageWithCallback(ImageView imageView, ProgressBar progressBar, String url, RequestListener<Drawable> imageLoadCallback) {
        Glide.with(MyApplication.getInstance().getApplicationContext())
                .load(url)
                .listener(imageLoadCallback==null?getListener(progressBar):imageLoadCallback)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    private static   RequestListener<Drawable> getListener(ProgressBar progressBar) {
        ProgressBar progressBar1=progressBar;
     return    new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                progressBar1.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                progressBar1.setVisibility(View.GONE);
                return false;
            }
        };
    }
    public interface ImageLoadCallback {
        void onImageLoadError();

    }
}
