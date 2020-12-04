package com.example.e_commerceapp.bottomNavigation.repository;

import com.airbnb.lottie.L;
import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.pojo.Categories;
import com.example.e_commerceapp.bottomNavigation.pojo.Offers;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class OffersRepository {
    public LiveData<List<Offers>> getOffers(){
        MutableLiveData mutableLiveData=new MutableLiveData();
        List<Offers> offers=new ArrayList<>();
        offers.add(new Offers("Shoe", R.drawable.shoes));
        offers.add(new Offers("Watch", R.drawable.watch));
        offers.add(new Offers("Shoe", R.drawable.shoes));
        offers.add(new Offers("Watch", R.drawable.watch));
        mutableLiveData.setValue(offers);

        return mutableLiveData;
    }
}
