package com.socialpost.manager.room_db;

import android.os.AsyncTask;
import android.util.Log;

import com.socialpost.manager.MyApplication;
import com.socialpost.manager.database.DatabaseClient;
import com.socialpost.pojo.AllCategoryListItemPojo;

import java.util.ArrayList;

public class SaveCategoryContent extends AsyncTask<ArrayList<AllCategoryListItemPojo>, Void, Void> {
    ArrayList<AllCategoryListItemPojo> allCategoryListItemPojos;
    public SaveCategoryContent(ArrayList<AllCategoryListItemPojo> allCategoryListItems) {
this.allCategoryListItemPojos=allCategoryListItems;
    }

    @Override
        protected Void doInBackground(ArrayList<AllCategoryListItemPojo>... mediaContentPojos) {
            ArrayList<AllCategoryListItemPojo> mediaContentPojoList=allCategoryListItemPojos;
            for (AllCategoryListItemPojo mediaContentPojoItem:mediaContentPojoList) {
                //adding to database
                DatabaseClient.getInstance(MyApplication.getInstance()).getAppDatabase().allCategoryDAO().insert(mediaContentPojoItem);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.e("SaveCategoryContent", "onPostExecute: done" );
//            finish();
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
        }
    }