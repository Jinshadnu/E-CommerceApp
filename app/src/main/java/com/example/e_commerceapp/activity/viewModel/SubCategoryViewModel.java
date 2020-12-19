package com.example.e_commerceapp.activity.viewModel;

import com.example.e_commerceapp.activity.pojo.Items;
import com.example.e_commerceapp.activity.pojo.SubCategories;
import com.example.e_commerceapp.activity.repository.SubCategoryRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class SubCategoryViewModel extends ViewModel {
    public SubCategoryRepository subCategoryRepository;


    public SubCategoryViewModel() {
        subCategoryRepository=new SubCategoryRepository();
    }

    public LiveData<List<SubCategories>> getSubCategories(){
        return subCategoryRepository.getSubCategories();
    }

    public LiveData<List<Items>> getItems(){
        return subCategoryRepository.getItems();
    }
}
