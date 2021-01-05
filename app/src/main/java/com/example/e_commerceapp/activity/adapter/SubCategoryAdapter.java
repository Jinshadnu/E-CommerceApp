package com.example.e_commerceapp.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.SubCategoryActivity;
import com.example.e_commerceapp.activity.pojo.SubCategories;
import com.example.e_commerceapp.activity.products.ProductDetailsActivity;
import com.example.e_commerceapp.databinding.LayoutSubcategoryBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder> {
    public Context context;
    public List<SubCategories> subCategoriesList;

    public SubCategoryAdapter(Context context, List<SubCategories> subCategoriesList) {
        this.context = context;
        this.subCategoriesList = subCategoriesList;
    }

    @NonNull
    @Override
    public SubCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutSubcategoryBinding subcategoryBinding= DataBindingUtil.inflate(from(context), R.layout.layout_subcategory,parent,false);
        return new SubCategoryViewHolder(subcategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryViewHolder holder, int position) {
     SubCategories subCategories=subCategoriesList.get(position);
     holder.subcategoryBinding.setSubcategories(subCategories);
     holder.subcategoryBinding.cardSubcategory.setOnClickListener(v -> {
         context.startActivity(new Intent(context.getApplicationContext(), SubCategoryActivity.class));
     });
    }

    @Override
    public int getItemCount() {
        return subCategoriesList.size();
    }

    public class SubCategoryViewHolder extends RecyclerView.ViewHolder {
        public LayoutSubcategoryBinding subcategoryBinding;
        public SubCategoryViewHolder(@NonNull LayoutSubcategoryBinding subcategoryBinding) {
            super(subcategoryBinding.getRoot());
            this.subcategoryBinding=subcategoryBinding;
        }
    }
}
