package com.example.e_commerceapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.adapter.ItemsAdapter;
import com.example.e_commerceapp.activity.adapter.SubCategoryAdapter;
import com.example.e_commerceapp.activity.viewModel.SubCategoryViewModel;
import com.example.e_commerceapp.databinding.ActivitySubCategoryBinding;
import com.example.e_commerceapp.util.GridSpacingItemDecoration;

public class SubCategoryActivity extends AppCompatActivity {
public SubCategoryViewModel subCategoryViewModel;
public ActivitySubCategoryBinding subCategoryBinding;
public SubCategoryAdapter subCategoryAdapter;
public ItemsAdapter itemsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        subCategoryBinding= DataBindingUtil.setContentView(this,R.layout.activity_sub_category);



        subCategoryViewModel= ViewModelProviders.of(this).get(SubCategoryViewModel.class);

        subCategoryBinding.recyclerSubCategories.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        subCategoryBinding.recyclerSubCategories.setHasFixedSize(true);

        subCategoryBinding.recyclerProducts.setLayoutManager(new GridLayoutManager(this,2));
        subCategoryBinding.recyclerProducts.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), true));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        subCategoryBinding.recyclerProducts.addItemDecoration(dividerItemDecoration);
        subCategoryBinding.recyclerProducts.setHasFixedSize(true);

        getSubCategoris();

        getItems();
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void getSubCategoris(){
        subCategoryViewModel.getSubCategories().observe((LifecycleOwner)this,subCategories -> {
           subCategoryAdapter=new SubCategoryAdapter(this,subCategories);
           subCategoryBinding.recyclerSubCategories.setAdapter(subCategoryAdapter);
        });
    }

    public void getItems(){
        subCategoryViewModel.getItems().observe((LifecycleOwner)this,items -> {
            itemsAdapter=new ItemsAdapter(this,items);
            subCategoryBinding.recyclerProducts.setAdapter(itemsAdapter);
        });
    }
}