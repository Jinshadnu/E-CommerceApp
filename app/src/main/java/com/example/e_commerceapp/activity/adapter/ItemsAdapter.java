package com.example.e_commerceapp.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.pojo.Items;
import com.example.e_commerceapp.activity.products.ProductDetailsActivity;
import com.example.e_commerceapp.databinding.LayoutSubitemsBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    public Context context;
    public List<Items> itemsList;

    public ItemsAdapter(Context context, List<Items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutSubitemsBinding subitemsBinding= DataBindingUtil.inflate(from(context), R.layout.layout_subitems,parent,false);
        return new ItemViewHolder(subitemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
      Items items=itemsList.get(position);
      holder.subitemsBinding.setSubitems(items);
      holder.subitemsBinding.cardViewItem.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));
      holder.subitemsBinding.cardViewItem.setOnClickListener(v -> {
          context.startActivity(new Intent(context.getApplicationContext(), ProductDetailsActivity.class));
      });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public LayoutSubitemsBinding subitemsBinding;
        public ItemViewHolder(@NonNull LayoutSubitemsBinding subitemsBinding) {
            super(subitemsBinding.getRoot());
            this.subitemsBinding=subitemsBinding;
        }
    }
}
