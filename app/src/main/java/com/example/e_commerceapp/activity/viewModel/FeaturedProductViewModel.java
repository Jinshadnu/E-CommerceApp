package com.example.e_commerceapp.activity.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerceapp.activity.pojo.FeaturedProducts;
import com.example.e_commerceapp.activity.repository.FeaturedProductRepository;

import java.util.List;

public class FeaturedProductViewModel extends ViewModel {
    public FeaturedProductRepository featuredProductRepository;
    public FeaturedProductViewModel() {
        this.featuredProductRepository = new FeaturedProductRepository();

    }



    public LiveData<List<FeaturedProducts>> getFeaturedProducts(){
        return featuredProductRepository.getFearuredProducts();
    }
}
