package com.example.inventorymanagementapp.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inventorymanagementapp.adapters.RecViewAdapter;
import com.example.inventorymanagementapp.databinding.ActivityMainBinding;
import com.example.inventorymanagementapp.model.DataModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding activityMainBinding;
    List<DataModel> dataModelnew;
    RecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        DataModel dataModel;

    }
}