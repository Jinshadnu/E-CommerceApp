package com.example.e_commerceapp.bottomNavigation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerceapp.bottomNavigation.pojo.Wishlist;
import com.example.e_commerceapp.bottomNavigation.repository.WishlistRepository;

import java.util.List;

public class WishlistViewModel extends ViewModel {
    public WishlistRepository wishlistRepository;

    public WishlistViewModel() {
        this.wishlistRepository=new WishlistRepository();
    }

    public LiveData<List<Wishlist>> getWishlist(){
        return wishlistRepository.getWishlist();
    }
}
