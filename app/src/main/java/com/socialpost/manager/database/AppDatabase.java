package com.socialpost.manager.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.socialpost.manager.room_db.AllCategoryDAO;
import com.socialpost.manager.room_db.Converters;
import com.socialpost.manager.room_db.MediaContentDAO;
import com.socialpost.pojo.AllCategoryListItemPojo;
import com.socialpost.pojo.base.BaseMediaContentPojo;

@Database(entities = {AllCategoryListItemPojo.class, BaseMediaContentPojo.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract AllCategoryDAO allCategoryDAO();
    public abstract MediaContentDAO mediaContentDao();

}