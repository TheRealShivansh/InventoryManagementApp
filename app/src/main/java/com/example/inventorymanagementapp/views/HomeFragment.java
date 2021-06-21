package com.example.inventorymanagementapp.views;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.inventorymanagementapp.R;
import com.example.inventorymanagementapp.adapters.RecViewAdapter;
import com.example.inventorymanagementapp.databinding.FragmentHomeBinding;
import com.example.inventorymanagementapp.model.DataModel;
import com.example.inventorymanagementapp.viewmodels.ItemViewModel;

import org.jetbrains.annotations.NotNull;


public class HomeFragment extends Fragment {

    FragmentHomeBinding fragmentHomeBinding;
    RecViewAdapter adapter;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater,container,false);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ItemViewModel itemViewModel;

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        adapter = new RecViewAdapter(getContext());

        NavController navController = Navigation.findNavController(view);
        fragmentHomeBinding.viewInvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_listFragment);
            }
        });

        fragmentHomeBinding.addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_add);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                dialog.show();
                AppCompatButton button = dialog.findViewById(R.id.btn_add);
                EditText editName = dialog.findViewById(R.id.add_name);
                EditText editDesc = dialog.findViewById(R.id.add_desc);
                EditText editPrice = dialog.findViewById(R.id.add_price);
                EditText editUrl = dialog.findViewById(R.id.add_image_url);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        RadioGroup availability = dialog.findViewById(R.id.radioGroup);
                        int selectedId = availability.getCheckedRadioButtonId();
                        String stat = "";
                        if (selectedId == R.id.online) {
                            stat = "Online";
                        } else if (selectedId == R.id.offline) {
                            stat = "Offline";
                        }
                        String finalStat = stat;
                        String sName = editName.getText().toString().trim();
                        String sDesc = editDesc.getText().toString().trim();
                        String sPrice = editPrice.getText().toString().trim();
                        String sImage = editUrl.getText().toString().trim();
                        DataModel dataModel1 = new DataModel(sName, sPrice, sDesc, sImage, finalStat);
                        itemViewModel.insert(dataModel1, getActivity().getApplication());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
            }
        });

    }
}