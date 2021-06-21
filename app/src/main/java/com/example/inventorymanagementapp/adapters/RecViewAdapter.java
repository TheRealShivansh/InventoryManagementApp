package com.example.inventorymanagementapp.adapters;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventorymanagementapp.R;
import com.example.inventorymanagementapp.databinding.ItemListBinding;
import com.example.inventorymanagementapp.interfaces.MyDao;
import com.example.inventorymanagementapp.model.DataModel;
import com.example.inventorymanagementapp.model.RoomDB;
import com.example.inventorymanagementapp.viewmodels.ItemViewModel;
import com.example.inventorymanagementapp.views.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    List<DataModel> dataModelList;
    MyDao myDao;
    Context context;

    public RecViewAdapter(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    public RecViewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemListBinding itemListBinding = ItemListBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(itemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecViewAdapter.ViewHolder holder, int position) {

        DataModel currentItem = dataModelList.get(position);
        holder.itemListBinding.setDataModel(currentItem);
        holder.itemListBinding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB database = RoomDB.getInstance(context);
                database.myDao().delete(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemListBinding itemListBinding;

        public ViewHolder(@NonNull @NotNull ItemListBinding itemListBinding) {
            super(itemListBinding.getRoot());
            this.itemListBinding = itemListBinding;
        }
    }
}
