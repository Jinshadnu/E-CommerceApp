package com.example.e_commerceapp.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.activity.products.PriceDetailsActivity;
import com.example.e_commerceapp.databinding.ActivityShippingAddressBinding;

public class ShippingAddressActivity extends AppCompatActivity {
public ActivityShippingAddressBinding shippingAddressBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_address);
        shippingAddressBinding= DataBindingUtil.setContentView(this,R.layout.activity_shipping_address);

        shippingAddressBinding.layoutBase.textTitle.setText("Shipping Address");

        shippingAddressBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        shippingAddressBinding.btnBuy.setOnClickListener(v -> {
            startActivity(new Intent(ShippingAddressActivity.this, PriceDetailsActivity.class));
        });
    }
}