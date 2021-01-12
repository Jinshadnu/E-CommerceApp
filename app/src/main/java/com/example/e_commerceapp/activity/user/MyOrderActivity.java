package com.example.e_commerceapp.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.user.adapter.OrderAdapter;
import com.example.e_commerceapp.activity.user.viewModel.OrderViewModel;
import com.example.e_commerceapp.databinding.ActivityMyOrderBinding;

public class MyOrderActivity extends AppCompatActivity {
public ActivityMyOrderBinding myOrderBinding;
public OrderViewModel orderViewModel;
public OrderAdapter orderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        myOrderBinding= DataBindingUtil.setContentView(this,R.layout.activity_my_order);

        myOrderBinding.recyclerMyorders.setLayoutManager(new LinearLayoutManager(this));
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL);
//        myOrderBinding.recyclerMyorders.addItemDecoration(dividerItemDecoration);
        myOrderBinding.recyclerMyorders.setHasFixedSize(true);
        orderViewModel= ViewModelProviders.of(this).get(OrderViewModel.class);

        getOrders();
    }

    private void getOrders() {
        orderViewModel.getOrders().observe((LifecycleOwner)this,orders -> {
            orderAdapter=new OrderAdapter(this,orders);
            myOrderBinding.recyclerMyorders.setAdapter(orderAdapter);
        });
    }
}