package com.socialpost.manager.room_db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.List;

@Dao
public interface MediaContentDAO {

    @Query("SELECT * FROM BaseMediaContentPojo")
    List<BaseMediaContentPojo> getAll();

    @Query("SELECT * FROM BaseMediaContentPojo where category_list_id=:categoryListId")
    List<BaseMediaContentPojo> getAll(String categoryListId);

    @Insert
    void insert(BaseMediaContentPojo task);
 
    @Delete
    void delete(BaseMediaContentPojo task);
 
    @Update
    void update(BaseMediaContentPojo task);
    
}