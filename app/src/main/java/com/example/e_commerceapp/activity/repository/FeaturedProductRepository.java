package com.example.e_commerceapp.activity.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.pojo.FeaturedProducts;

import java.util.ArrayList;
import java.util.List;

public class FeaturedProductRepository {

    public FeaturedProductRepository() {
    }

    public LiveData<List<FeaturedProducts>> getFearuredProducts(){
        MutableLiveData mutableLiveData=new
                MutableLiveData();
        List<FeaturedProducts> featuredProducts=new ArrayList<>();
        featuredProducts.add(new FeaturedProducts(R.drawable.watch,"Watch","2% off","Rs.550000/-"));
        featuredProducts.add(new FeaturedProducts(R.drawable.iphone1,"Iphone11pro","2% off","Rs.550000/-"));
        featuredProducts.add(new FeaturedProducts(R.drawable.shoes,"Shoes","2% off","Rs.550000/-"));

        mutableLiveData.setValue(featuredProducts);
        return  mutableLiveData;
    }
}
