package com.socialpost.adapter;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.socialpost.R;
import com.socialpost.Util.Utility;
import com.socialpost.pojo.base.BaseMediaContentPojo;

public class VideoListItemHolder extends BaseMediaViewHolder{

//    YouTubePlayerView youtubePlayerView;
    private ImageView youtubePlayerView;
    private ProgressBar progressBar;
    BaseMediaContentPojo mediaContentPojo;

    public VideoListItemHolder(View view, BaseMediaContentPojo mediaContentPojo, VideoListAdapter.VideoAdapterCallback mediaAdapterItemClickCallback) {
        super(view, mediaAdapterItemClickCallback);
        this.mediaContentPojo=mediaContentPojo;
        youtubePlayerView = view.findViewById(R.id.iv_video_image);
        progressBar = view.findViewById(R.id.progress_loader);
//        youtubePlayerView = view.findViewById(R.id.youtube_player_view_);

        youtubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mediaAdapterItemClickCallback.onItemClickListener(mediaContentPojo,getAdapterPosition());
            }
        });
    }

    @Override
    public void bind() {

        Utility.LoadImageWithCallback(youtubePlayerView, progressBar, "https://img.youtube.com/vi/" + mediaContentPojo.getYouTubeVideoId() + "/maxresdefault.jpg", new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Utility.LoadImageWithCallback(youtubePlayerView, progressBar, "https://img.youtube.com/vi/" + mediaContentPojo.getYouTubeVideoId() + "/hqdefault.jpg",null);
                    }
                },500);

                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        });
    }

    @Override
    public void onViewModelAttached() {
        //getLifecycle().addObserver(youtubePlayerView);
        showVideo();
    }

    private void showVideo()
    {
//        youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//            @Override
//            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                String videoId = "Hw0JsjGd3_c";
//                youTubePlayer.cueVideo(videoId, 0);
//            }
//        });
    }
}
