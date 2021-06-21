package com.example.inventorymanagementapp.viewmodels;


import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.inventorymanagementapp.model.DataModel;
import com.example.inventorymanagementapp.model.RoomDB;

import java.util.List;

public class ItemViewModel extends ViewModel {

    public LiveData<List<DataModel>> allItems;
    RoomDB database;

    public ItemViewModel() {
    }

    public ItemViewModel(Application application) {


    }

    public void insert(DataModel dataModel, Application application) {
        this.database = RoomDB.getInstance(application);
        database.myDao().insert(dataModel);
    }

    public void delete(DataModel dataModel, Application application){
        this.database = RoomDB.getInstance(application);
        database.myDao().delete(dataModel);
    }

    public LiveData<List<DataModel>> getAllItems(Application application) {
        this.database = RoomDB.getInstance(application);
        allItems = database.myDao().getAllItems();
        return allItems;
    }

    public LiveData<List<DataModel>> getAllItemsAsc(Application application){
        this.database = RoomDB.getInstance(application);
        allItems = database.myDao().getAllItemsAsc();
        return allItems;
    }

    public LiveData<List<DataModel>> getAllItemsDesc(Application application){
        this.database = RoomDB.getInstance(application);
        allItems = database.myDao().getAllItemsDesc();
        return allItems;
    }

    public LiveData<List<DataModel>> getAllItemsOnline(Application application){
        this.database = RoomDB.getInstance(application);
        allItems = database.myDao().getAllItemsOnline();
        return allItems;
    }

    public LiveData<List<DataModel>> getAllItemsOffline(Application application){
        this.database = RoomDB.getInstance(application);
        allItems = database.myDao().getAllItemsOffline();
        return allItems;
    }


}
