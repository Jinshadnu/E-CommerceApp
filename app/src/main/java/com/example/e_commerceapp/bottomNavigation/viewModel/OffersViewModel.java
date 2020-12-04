package com.example.e_commerceapp.bottomNavigation.viewModel;

import com.example.e_commerceapp.bottomNavigation.pojo.Offers;
import com.example.e_commerceapp.bottomNavigation.repository.OffersRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class OffersViewModel extends ViewModel {
    public OffersRepository offersRepository;

    public OffersViewModel() {
        this.offersRepository=new OffersRepository();
    }


    public LiveData<List<Offers>> getOffers()
    {
        return offersRepository.getOffers();
    }
}
