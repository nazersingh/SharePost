package com.socialpost.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;

import com.socialpost.base.BaseViewModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayVideoIntent extends BasePlayVideoActivity<BaseViewModel> {
    protected boolean _landscape = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ShareCompat.IntentReader intentReader = new ShareCompat.IntentReader(this);
        if (intentReader.isShareIntent()) {
            String[] emailTo = intentReader.getEmailTo();
            String subject = intentReader.getSubject();
            Log.e(TAG, "onCreate: " + subject );
            Log.e(TAG, "onCreate: " + intentReader.getText());
            String text = intentReader.getHtmlText();
            // Compose an email

            String vidId = getYoutubeId(intentReader.getText().toString());
            Log.e(TAG, "onCreate: id " + vidId);
            loadVideoUrl(vidId);

            if (intentReader.getText().toString().contains("shorts")) {
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else {
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    }

    public static String getYoutubeId(String url) {
        String pattern = "https?:\\/\\/(?:[0-9A-Z-]+\\.)?(?:youtu\\.be\\/|youtube\\.com\\S*[^\\w\\-\\s])([\\w\\-]{11})(?=[^\\w\\-]|$)(?![?=&+%\\w]*(?:['\"][^<>]*>|<\\/a>))[?=&+%\\w]*";

        Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compiledPattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }/*from w  w  w.  j a  va  2 s .c om*/
        return null;
    }

    public boolean isPhone() {
        int layoutSize = getScreenLayoutSize();
        return (layoutSize == Configuration.SCREENLAYOUT_SIZE_SMALL || layoutSize == Configuration.SCREENLAYOUT_SIZE_NORMAL);
    }
    protected int getScreenLayoutSize() {
        return (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}