package com.socialpost.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.socialpost.manager.room_db.Converters;

import java.io.Serializable;
import java.util.ArrayList;
@Entity
public class AllCategoryListItemPojo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "categorySubListId")
    private String categorySubListId;
    @ColumnInfo(name = "categoryText")
    private String categoryText;
    @TypeConverters(Converters.class)
    @ColumnInfo(name = "categorySubList")
    private ArrayList<PostCategoryPojo> categorySubList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCategoryText() {
        return categoryText;
    }

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }



    public String getCategorySubListId() {
        return categorySubListId;
    }

    public void setCategorySubListId(String categorySubListId) {
        this.categorySubListId = categorySubListId;
    }

    public ArrayList<PostCategoryPojo> getCategorySubList() {
        return categorySubList;
    }

    public void setCategorySubList(ArrayList<PostCategoryPojo> categorySubList) {
        this.categorySubList = categorySubList;
    }
}
