package com.socialpost.pojo.base;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public class BaseCategoryPojo implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "categoryText")
    private String categoryText;
}
