package com.socialpost.manager.room_db;

import android.os.AsyncTask;

import com.socialpost.manager.MyApplication;
import com.socialpost.manager.database.DatabaseClient;
import com.socialpost.pojo.AllCategoryListItemPojo;

import java.util.ArrayList;
import java.util.List;

class GetAllCategories extends AsyncTask<Void, Void, List<AllCategoryListItemPojo>> {
 
            @Override
            protected List<AllCategoryListItemPojo> doInBackground(Void... voids) {
                List<AllCategoryListItemPojo>  categoryListItemPojos= (ArrayList<AllCategoryListItemPojo>) DatabaseClient.getInstance(MyApplication.getInstance()).getAppDatabase().allCategoryDAO().getAll();
                return categoryListItemPojos;
            }
 
            @Override
            protected void onPostExecute(List<AllCategoryListItemPojo> tasks) {
                super.onPostExecute(tasks);

            }
        }