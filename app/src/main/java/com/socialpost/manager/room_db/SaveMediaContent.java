package com.socialpost.manager.room_db;

import android.os.AsyncTask;

import com.socialpost.manager.MyApplication;
import com.socialpost.manager.database.DatabaseClient;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public class SaveMediaContent extends AsyncTask<ArrayList<BaseMediaContentPojo>, Void, Void> {
    ArrayList<BaseMediaContentPojo> arrayList;
    public SaveMediaContent(ArrayList<BaseMediaContentPojo> mediaContentPojos) {
        this.arrayList=mediaContentPojos;
    }

    @Override
        protected Void doInBackground(ArrayList<BaseMediaContentPojo>... mediaContentPojos) {
//            ArrayList<MediaContentPojo> mediaContentPojoList=mediaContentPojos[0];
            for (BaseMediaContentPojo mediaContentPojoItem:arrayList) {
                //adding to database
                DatabaseClient.getInstance(MyApplication.getInstance()).getAppDatabase().mediaContentDao().insert(mediaContentPojoItem);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            finish();
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        }
    }