package com.example.inventorymanagementapp.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inventorymanagementapp.R;
import com.example.inventorymanagementapp.adapters.RecViewAdapter;
import com.example.inventorymanagementapp.databinding.FragmentListBinding;
import com.example.inventorymanagementapp.model.DataModel;
import com.example.inventorymanagementapp.viewmodels.ItemViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListFragment extends Fragment {

    FragmentListBinding fragmentListBinding;
    RecViewAdapter adapter;
    TextView status;

    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentListBinding = FragmentListBinding.inflate(inflater,container,false);
        return fragmentListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        status = fragmentListBinding.recyclerView.findViewById(R.id.availability);
        ItemViewModel itemViewModel;
        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        adapter = new RecViewAdapter(getContext());
        NavController navController = Navigation.findNavController(view);

        LiveData<List<DataModel>> s = itemViewModel.getAllItems(getActivity().getApplication());
        s.observe(getViewLifecycleOwner(), new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModels) {
                adapter = new RecViewAdapter(dataModels);
                fragmentListBinding.recyclerView.setAdapter(adapter);
            }
        });

        fragmentListBinding.arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListBinding.arrowUp.setBackgroundColor(getResources().getColor(R.color.teal_700));
                fragmentListBinding.arrowDown.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.offline.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.online.setBackgroundColor(getResources().getColor(R.color.white));
                LiveData<List<DataModel>> data = itemViewModel.getAllItemsAsc(getActivity().getApplication());
                data.observe(getViewLifecycleOwner(), new Observer<List<DataModel>>() {
                    @Override
                    public void onChanged(List<DataModel> dataModels) {
                        adapter = new RecViewAdapter(dataModels);
                        fragmentListBinding.recyclerView.setAdapter(adapter);
                    }
                });

            }
        });

        fragmentListBinding.arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListBinding.arrowUp.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.arrowDown.setBackgroundColor(getResources().getColor(R.color.teal_700));
                fragmentListBinding.offline.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.online.setBackgroundColor(getResources().getColor(R.color.white));
                LiveData<List<DataModel>> data1 = itemViewModel.getAllItemsDesc(getActivity().getApplication());
                data1.observe(getViewLifecycleOwner(), new Observer<List<DataModel>>() {
                    @Override
                    public void onChanged(List<DataModel> dataModels) {
                        adapter = new RecViewAdapter(dataModels);
                        fragmentListBinding.recyclerView.setAdapter(adapter);
                    }
                });
            }
        });

        fragmentListBinding.online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListBinding.arrowDown.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.arrowUp.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.offline.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.online.setBackgroundColor(getResources().getColor(R.color.teal_700));
                LiveData<List<DataModel>> data2 = itemViewModel.getAllItemsOnline(getActivity().getApplication());
                data2.observe(getViewLifecycleOwner(), new Observer<List<DataModel>>() {
                    @Override
                    public void onChanged(List<DataModel> dataModels) {
                        adapter = new RecViewAdapter(dataModels);
                        fragmentListBinding.recyclerView.setAdapter(adapter);
                    }
                });
            }
        });

        fragmentListBinding.offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListBinding.arrowDown.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.arrowUp.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.online.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.offline.setBackgroundColor(getResources().getColor(R.color.teal_700));
                LiveData<List<DataModel>> data2 = itemViewModel.getAllItemsOffline(getActivity().getApplication());
                data2.observe(getViewLifecycleOwner(), new Observer<List<DataModel>>() {
                    @Override
                    public void onChanged(List<DataModel> dataModels) {
                        adapter = new RecViewAdapter(dataModels);
                        fragmentListBinding.recyclerView.setAdapter(adapter);
                    }
                });
            }
        });

        fragmentListBinding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentListBinding.arrowDown.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.arrowUp.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.online.setBackgroundColor(getResources().getColor(R.color.white));
                fragmentListBinding.offline.setBackgroundColor(getResources().getColor(R.color.white));
                LiveData<List<DataModel>> s = itemViewModel.getAllItems(getActivity().getApplication());
                s.observe(getViewLifecycleOwner(), new Observer<List<DataModel>>() {
                    @Override
                    public void onChanged(List<DataModel> dataModels) {
                        adapter = new RecViewAdapter(dataModels);
                        fragmentListBinding.recyclerView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}