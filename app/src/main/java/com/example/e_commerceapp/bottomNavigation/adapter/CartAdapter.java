package com.example.e_commerceapp.bottomNavigation.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.pojo.Cart;
import com.example.e_commerceapp.databinding.LayoutCartBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
public Context context;
public List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutCartBinding cartBinding= DataBindingUtil.inflate(from(context), R.layout.layout_cart,parent,false);
        return  new CartViewHolder(cartBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
     Cart cart=cartList.get(position);
     holder.cartBinding.setCartItems(cart);
     holder.cartBinding.cardViewCart.setAnimation(AnimationUtils.loadAnimation(context,R.anim.item_fall_down));
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        public LayoutCartBinding cartBinding;
        public CartViewHolder(@NonNull LayoutCartBinding cartBinding) {
            super(cartBinding.getRoot());
            this.cartBinding=cartBinding;
        }
    }
}
