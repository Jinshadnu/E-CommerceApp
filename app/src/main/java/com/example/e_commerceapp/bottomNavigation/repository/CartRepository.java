package com.example.e_commerceapp.bottomNavigation.repository;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.pojo.Cart;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CartRepository {

    public CartRepository() {
    }

    public LiveData<List<Cart>> getCart(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<Cart> cartList=new ArrayList<>();
        cartList.add(new Cart("Britex Watch","750", R.drawable.watch));
        cartList.add(new Cart("Dc Shoe","950", R.drawable.shoes));
        cartList.add(new Cart("Britex Watch","750", R.drawable.watch));



        mutableLiveData.setValue(cartList);

        return mutableLiveData;
    }
}
