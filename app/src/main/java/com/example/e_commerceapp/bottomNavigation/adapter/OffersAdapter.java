package com.example.e_commerceapp.bottomNavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.pojo.Offers;
import com.example.e_commerceapp.databinding.LayoutPopularProductsBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersViewHolder> {
    public Context context;
    public List<Offers> offersList;

    public OffersAdapter(Context context, List<Offers> offersList) {
        this.context = context;
        this.offersList = offersList;
    }

    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPopularProductsBinding popularProductsBinding= DataBindingUtil.inflate(from(context), R.layout.layout_popular_products,parent,false);
        return new OffersViewHolder(popularProductsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersViewHolder holder, int position) {
     Offers offers=offersList.get(position);
     holder.popularProductsBinding.setOffers(offers);
     holder.popularProductsBinding.cardPopularproducts.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public class OffersViewHolder extends RecyclerView.ViewHolder {
        public LayoutPopularProductsBinding popularProductsBinding;
        public OffersViewHolder(@NonNull LayoutPopularProductsBinding popularProductsBinding) {
            super(popularProductsBinding.getRoot());
            this.popularProductsBinding=popularProductsBinding;
        }
    }
}
