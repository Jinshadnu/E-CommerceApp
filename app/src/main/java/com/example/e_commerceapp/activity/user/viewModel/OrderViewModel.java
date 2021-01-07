package com.example.e_commerceapp.activity.user.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerceapp.activity.user.pojo.Order;
import com.example.e_commerceapp.activity.user.repository.OrderRepository;

import java.util.List;

public class OrderViewModel extends ViewModel {
    public OrderRepository orderRepository;


    public OrderViewModel() {
        this.orderRepository=new OrderRepository();
    }

    public LiveData<List<Order>> getOrders(){
        return orderRepository.getOrders();
    }
}

