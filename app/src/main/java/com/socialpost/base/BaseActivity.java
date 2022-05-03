package com.socialpost.base;

import android.Manifest;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Calendar;

public class BaseActivity<T extends BaseViewModel> extends AppCompatActivity implements ViewModelSource<T> {


private final String TAG = "BaseActivity";


    @Override
    public T getViewModel() {
        return ((ViewModelSource<T>) this).getViewModel();
    }


}
