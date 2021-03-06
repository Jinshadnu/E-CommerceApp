package com.example.e_commerceapp.activity.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.adapter.SubCategoryAdapter;
import com.example.e_commerceapp.activity.viewModel.SubCategoryViewModel;
import com.example.e_commerceapp.databinding.ActivitySubCategoryBinding;
import com.example.e_commerceapp.databinding.ActivitySubCatgBinding;
import com.example.e_commerceapp.util.GridSpacingItemDecoration;

public class SubCatgActivity extends AppCompatActivity {
public ActivitySubCatgBinding subCatgBinding;
    public SubCategoryViewModel subCategoryViewModel;
    public SubCategoryAdapter subCategoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        subCatgBinding= DataBindingUtil.setContentView(this,R.layout.activity_sub_catg);

        subCatgBinding.layoutBase.textTitle.setText("Select SubCategory");

        subCatgBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        subCategoryViewModel= ViewModelProviders.of(this).get(SubCategoryViewModel.class);

        subCatgBinding.recyclerSubcategory.setLayoutManager(new GridLayoutManager(this,2));
        subCatgBinding.recyclerSubcategory.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), true));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        subCatgBinding.recyclerSubcategory.addItemDecoration(dividerItemDecoration);
        subCatgBinding.recyclerSubcategory.setHasFixedSize(true);

        getSubCategoris();

    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void getSubCategoris(){
        subCategoryViewModel.getSubCategories().observe((LifecycleOwner)this, subCategories -> {
            subCategoryAdapter=new SubCategoryAdapter(this,subCategories);
            subCatgBinding.recyclerSubcategory.setAdapter(subCategoryAdapter);
        });
    }
}