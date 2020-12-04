package com.example.e_commerceapp.bottomNavigation.repository;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.pojo.Categories;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CategoryRepository {
    public LiveData<List<Categories>> getCategories(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<Categories> categories=new ArrayList<>();
        categories.add(new Categories("Mobile", R.drawable.mobile));
        categories.add(new Categories("Electronics", R.drawable.electronics));
        categories.add(new Categories("Mobile", R.drawable.mobile));
        categories.add(new Categories("Mobile", R.drawable.electronics));
        mutableLiveData.setValue(categories);
        return mutableLiveData;
    }
}
