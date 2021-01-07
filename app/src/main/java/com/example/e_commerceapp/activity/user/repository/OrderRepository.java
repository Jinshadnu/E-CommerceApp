package com.example.e_commerceapp.activity.user.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.e_commerceapp.activity.user.pojo.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public OrderRepository() {
    }

    public LiveData<List<Order>> getOrders(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<Order> orderList=new ArrayList<>();
        orderList.add(new Order(12122123,"03-01-2021","Rs.12000/-","Pending"));
        orderList.add(new Order(12122123,"03-01-2021","Rs.12000/-","Pending"));
        orderList.add(new Order(12122123,"03-01-2021","Rs.12000/-","Pending"));
        orderList.add(new Order(12122123,"03-01-2021","Rs.12000/-","Pending"));

        mutableLiveData.setValue(orderList);

        return mutableLiveData;

    }
}
