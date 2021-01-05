package com.example.e_commerceapp.bottomNavigation.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.pojo.Wishlist;

import java.util.ArrayList;
import java.util.List;

public class WishlistRepository {

    public WishlistRepository() {
    }

    public LiveData<List<Wishlist>> getWishlist(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<Wishlist> wishlists=new ArrayList<>();
        wishlists.add(new Wishlist(R.drawable.iphone1,"Iphone11 Pro","Rs.1100000"));
        wishlists.add(new Wishlist(R.drawable.galaxyf41,"Samsung Galaxyf41","Rs.900000"));
        wishlists.add(new Wishlist(R.drawable.iphone1,"Iphone11 Pro","Rs.1100000"));

       mutableLiveData.setValue(wishlists);

       return mutableLiveData;


    }
}
