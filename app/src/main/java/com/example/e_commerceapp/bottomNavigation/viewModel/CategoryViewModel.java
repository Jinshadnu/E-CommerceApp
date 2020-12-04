package com.example.e_commerceapp.bottomNavigation.viewModel;

import com.example.e_commerceapp.bottomNavigation.pojo.Categories;
import com.example.e_commerceapp.bottomNavigation.repository.CategoryRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CategoryViewModel extends ViewModel {
public CategoryRepository categoryRepository;

    public CategoryViewModel() {
        this.categoryRepository=new CategoryRepository();
    }

    public LiveData<List<Categories>> getCategories(){
        return categoryRepository.getCategories();
    }
}
