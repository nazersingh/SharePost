package com.socialpost.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.socialpost.R;
import com.socialpost.base.BaseActivity;
import com.socialpost.base.BaseViewModel;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public class BasePlayVideoActivity<T> extends BaseActivity<BaseViewModel> {

    int videoIdPosition;
    private Lifecycle lifecycle;
    private ArrayList<BaseMediaContentPojo> arrayList=new ArrayList<>();
    private YouTubePlayerView youtubePlayerView;
    String TAG=this.getClass().getSimpleName();
    private View mBtnPreviousVideo,mBtnNextVideo;
    private YouTubePlayer youTubePlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_videos_player);
        youtubePlayerView = findViewById(R.id.youtube_player_view_);
        mBtnPreviousVideo = findViewById(R.id.previous_video);
        mBtnNextVideo = findViewById(R.id.next_video);
        lifecycle =getLifecycle();
//        getLifecycle().addObserver(youtubePlayerView);






//        mBtnPreviousVideo.setOnClickListener(this::onPreviousClick);
//        mBtnNextVideo.setOnClickListener(this::onNextClick);

        youtubePlayerView.addYouTubePlayerListener(abstractYouTubePlayerListener);
//        youtubePlayerView.ui.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG, "onTouch: " );
//                switch (event.getAction())
//                {
//                    case MotionEvent.ACTION_UP:
//                        Log.e(TAG, "onTouch: action up" );
//                        fullSystemUiTimer();
//                        break;
//                }
//                return false;
//            }
//        });
        youtubePlayerView.getPlayerUiController().showYouTubeButton(false);
        youtubePlayerView.getPlayerUiController().showFullscreenButton(false);
        youtubePlayerView.getPlayerUiController().setCustomAction1(getResources().getDrawable(R.drawable.cast_ic_notification_skip_prev),this::playPreviousVideo);
        youtubePlayerView.getPlayerUiController().setCustomAction2(getResources().getDrawable(R.drawable.cast_ic_expanded_controller_skip_next),this::playNextVideo);

        youtubePlayerView.enterFullScreen();

    }

    private final AbstractYouTubePlayerListener abstractYouTubePlayerListener=new AbstractYouTubePlayerListener() {
        @Override
        public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState state) {
            super.onStateChange(youTubePlayer, state);
            Log.e("PlayVideoActivity", "onStateChange: "+state );

            switch (state)
            {
                case ENDED:
                    callNextVideo();
                    break;
            }

        }
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        youtubePlayerView.release();
    }
    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }

    private void playNextVideo(View view)
    {
        callNextVideo();
    }
    private void callNextVideo()
    {
        fullSystemUiTimer();
        youTubePlayer.pause();
        videoIdPosition=videoIdPosition+1;
        if(videoIdPosition<arrayList.size()) {
            youTubePlayer.loadVideo(arrayList.get(videoIdPosition).getYouTubeVideoId(), 1);
        }
    }
    private void callPreviousVideo()
    {
        fullSystemUiTimer();
        youTubePlayer.pause();
        videoIdPosition=videoIdPosition-1;
        if(videoIdPosition>0&&videoIdPosition<arrayList.size()) {
            youTubePlayer.loadVideo(arrayList.get(videoIdPosition).getYouTubeVideoId(), 1);
        }
    }
    private void playPreviousVideo(View view)
    {
        callPreviousVideo();
    }

    protected void onVideoListFetched(ArrayList<BaseMediaContentPojo> mediaContentPojos) {
        arrayList=mediaContentPojos;
        loadVideoUrl(arrayList.get(videoIdPosition).getYouTubeVideoId());
    }

    @Override
    public BaseViewModel getViewModel() {
        return new ViewModelProvider(this).get(BaseViewModel.class);
    }
    protected void loadVideoUrl(String youTubeVideoId) {
        Log.e(TAG, "loadVideoUrl: "+youTubeVideoId );
        youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                BasePlayVideoActivity.this.youTubePlayer=youTubePlayer;
                youTubePlayer.loadVideo(youTubeVideoId, 0);
            }
        });
    }
    protected void loadVideoPlayList(String youTubeVideoPlayListId) {
        Log.e(TAG, "loadVideoUrl: "+youTubeVideoPlayListId );
        youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                BasePlayVideoActivity.this.youTubePlayer=youTubePlayer;

                youTubePlayer.cueVideo(youTubeVideoPlayListId,0);
            }
        });
    }
    private final Handler fullScreenHandler=new Handler();
    private void fullSystemUiTimer()
    {
        fullScreenHandler.removeCallbacks(fullscreenRunnable);
        fullScreenHandler.postDelayed(fullscreenRunnable,5000);
    }
    private final Runnable fullscreenRunnable=new Runnable() {
        @Override
        public void run() {
            hideSystemUI();
        }
    };

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}
