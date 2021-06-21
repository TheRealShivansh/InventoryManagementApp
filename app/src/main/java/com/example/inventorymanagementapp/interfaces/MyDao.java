package com.example.inventorymanagementapp.interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.inventorymanagementapp.model.DataModel;

import org.reactivestreams.Publisher;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MyDao {

    @Insert(onConflict = REPLACE)
    void insert(DataModel dataModel);

    @Update
    void update(DataModel dataModel);

    @Delete
    void delete(DataModel dataModel);

    @Query("SELECT * FROM item_table")
    LiveData<List<DataModel>> getAllItems();

    @Query("SELECT * FROM item_table ORDER BY itemPrice ASC")
    LiveData<List<DataModel>> getAllItemsAsc();

    @Query("SELECT * FROM item_table ORDER BY itemPrice DESC")
    LiveData<List<DataModel>> getAllItemsDesc();

    @Query("SELECT * FROM item_table WHERE itemAvailability = 'Online' ")
    LiveData<List<DataModel>> getAllItemsOnline();

    @Query("SELECT * FROM item_table WHERE itemAvailability = 'Offline' ")
    LiveData<List<DataModel>> getAllItemsOffline();

}
