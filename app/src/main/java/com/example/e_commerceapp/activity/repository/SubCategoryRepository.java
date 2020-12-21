package com.example.e_commerceapp.activity.repository;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.pojo.Items;
import com.example.e_commerceapp.activity.pojo.SubCategories;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SubCategoryRepository {

    public SubCategoryRepository() {
    }

    public LiveData<List<SubCategories>> getSubCategories(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<SubCategories> subCategoriesList=new ArrayList<>();
        subCategoriesList.add(new SubCategories("Samsung"));
        subCategoriesList.add(new SubCategories("I-Phone"));
        subCategoriesList.add(new SubCategories("Huawei"));
        subCategoriesList.add(new SubCategories("Real Me"));
        subCategoriesList.add(new SubCategories("Vivo"));
        subCategoriesList.add(new SubCategories("Nokia"));

        mutableLiveData.setValue(subCategoriesList);

        return mutableLiveData;
    }

    public LiveData<List<Items>> getItems(){
        MutableLiveData mutableLiveData=new MutableLiveData();
        List<Items> itemsList=new ArrayList<>();
        itemsList.add(new Items(100,"Iphone 11", R.drawable.iphone1,"15000.00"));
        itemsList.add(new Items(101,"Note 10", R.drawable.note10,"25000.00"));
        itemsList.add(new Items(102,"Note 10", R.drawable.note10,"50000.00"));
        itemsList.add(new Items(101,"Galaxy f41", R.drawable.galaxyf41,"25000.00"));
        itemsList.add(new Items(101,"Note 10", R.drawable.note10,"25000.00"));


        mutableLiveData.setValue(itemsList);

        return mutableLiveData;
    }
}
