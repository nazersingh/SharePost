package com.socialpost.manager.room_db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.socialpost.pojo.AllCategoryListItemPojo;

import java.util.List;

@Dao
public interface AllCategoryDAO {

    @Query("SELECT * FROM AllCategoryListItemPojo")
    List<AllCategoryListItemPojo> getAll();

    @Insert
    void insert(AllCategoryListItemPojo task);

    @Delete
    void delete(AllCategoryListItemPojo task);

    @Update
    void update(AllCategoryListItemPojo task);
}
