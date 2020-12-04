package com.example.e_commerceapp.bottomNavigation.viewModel;

import com.example.e_commerceapp.bottomNavigation.pojo.Cart;
import com.example.e_commerceapp.bottomNavigation.repository.CartRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CartViewModel extends ViewModel {
    public CartRepository cartRepository;

    public CartViewModel() {
        this.cartRepository=new CartRepository();
    }

    public LiveData<List<Cart>> getCart(){
        return cartRepository.getCart();
    }
}
