package com.socialpost.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.socialpost.R;
import com.socialpost.Util.Constants;
import com.socialpost.base.BaseActivity;
import com.socialpost.base.BaseViewModel;
import com.socialpost.callback.AdapterCallback;

import java.util.Locale;
import java.util.Set;

public class StoryDetailActivity extends BaseActivity<BaseViewModel> {

    private  final String TAG = this.getClass().getSimpleName();
    private RecyclerView mRecyclerView;
    private TextToSpeech mTextToSpeech;
    private String StoryMatter;
    private  FloatingActionButton playAudioSpeech;
    private int MY_DATA_CHECK_CODE=101;
    private  boolean isLanguageAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_story_detail);

        setUpLayout();
    }
    @Override
    public BaseViewModel getViewModel() {
        return new ViewModelProvider(this).get(BaseViewModel.class);
    }
    private void setUpLayout() {

        Toolbar mToolbar=findViewById(R.id.toolbar);
        ImageView imageView2=findViewById(R.id.img_story);

        TextView mTvDetail=findViewById(R.id.tv_story_detail);
        TextView mTvMorel=findViewById(R.id.tv_morel);
        playAudioSpeech=findViewById(R.id.playAudio);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String detail=getIntent().getStringExtra(Constants.INTENT_SHARE_STORY_DETAIL);
        String heading=getIntent().getStringExtra(Constants.INTENT_SHARE_STORY_HEADING);
        String morel=getIntent().getStringExtra(Constants.INTENT_SHARE_STORY_MOREL);

        StoryMatter=detail+" "+"Morel of the story "+morel;

        CollapsingToolbarLayout collapsingToolbar =  findViewById(R.id.collapsing_toolbar);

        mTvDetail.setText(detail);
        mTvMorel.setText(morel);
        collapsingToolbar.setTitle(heading);


       String url="https://source.unsplash.com/1600x900/?motivational";
        Glide.with(this).load(url).into(imageView2);
        String id=getIntent().hasExtra(Constants.CATEGORY_ID)?getIntent().getStringExtra(Constants.CATEGORY_ID):"";
        mTextToSpeech =new TextToSpeech(getApplicationContext(),listener );

        playAudioSpeech.setOnClickListener(this::playStory);
    }
    TextToSpeech.OnInitListener listener=new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
            Locale loc = new Locale("hi","IN");
//                Locale loc = new Locale("pan","IND");

//                    mTextToSpeech.setLanguage(Locale.UK);


            switch (status)
            {
                case TextToSpeech.LANG_AVAILABLE:
                    Log.i("TAG", "LANG_AVAILABLE");
                    mTextToSpeech.setLanguage(loc );
                    break;
                case TextToSpeech.LANG_COUNTRY_AVAILABLE:
                    Log.i("TAG", "LANG_COUNTRY_AVAILABLE");
                    break;
                case TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE:
                    Log.i("TAG", "LANG_COUNTRY_VAR_AVAILABLE");
                    break;
                case TextToSpeech.ERROR:
                    Log.i("TAG", "LANG_MISSING_DATA");
                    break;
                case TextToSpeech.LANG_NOT_SUPPORTED:
                    Log.i("TAG", "LANG_NOT_SUPPORTED");
                    break;

            }
            Set<Locale> locales=mTextToSpeech.getAvailableLanguages();
            isLanguageAvailable=locales.contains(loc);
            Log.e(TAG, "onInit: "+isLanguageAvailable );
            Log.e(TAG, "setUpLayout: "+mTextToSpeech.getAvailableLanguages().toString() );
        }
    };
    private void openSettings()
    {
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                mTextToSpeech = new TextToSpeech(this, listener);
            } else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
    }

    private void showDialogLanguageNotSupported()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setTitle("Language not supported");
        builder1.setMessage("Please install text to speech language");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "INSTALL",
                (dialog, id) -> {
                    dialog.cancel();
                    openSettings();
                });
        builder1.setNegativeButton(
                "CANCEL",
                (dialog, id) -> dialog.cancel());
        AlertDialog alertDialog = builder1.create();
        alertDialog.show();
    }


    private void playStory(View view) {
        if(isLanguageAvailable) {
            if (mTextToSpeech.isSpeaking()) {
                mTextToSpeech.stop();
                playAudioSpeech.setImageResource(android.R.drawable.ic_media_play);
            } else {
                playAudioSpeech.setImageResource(android.R.drawable.ic_media_pause);
                mTextToSpeech.speak(StoryMatter, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
        else
        {
            showDialogLanguageNotSupported();
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

    public void onPause(){
        if(mTextToSpeech !=null){
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
        }
        super.onPause();
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
}