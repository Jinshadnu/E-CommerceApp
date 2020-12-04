package com.example.e_commerceapp.bottomNavigation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.pojo.Categories;
import com.example.e_commerceapp.databinding.LayoutCategoriesBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    public Context context;
    public List<Categories> categoriesList;

    public CategoriesAdapter(Context context, List<Categories> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCategoriesBinding categoriesBinding= DataBindingUtil.inflate(from(context), R.layout.layout_categories,parent,false);
        return new CategoryViewHolder(categoriesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
     Categories categories=categoriesList.get(position);
     holder.categoriesBinding.setCategories(categories);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public LayoutCategoriesBinding categoriesBinding;
        public CategoryViewHolder(@NonNull LayoutCategoriesBinding categoriesBinding) {
            super(categoriesBinding.getRoot());
             this.categoriesBinding=categoriesBinding;
        }
    }
}
