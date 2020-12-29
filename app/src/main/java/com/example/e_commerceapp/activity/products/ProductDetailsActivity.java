package com.example.e_commerceapp.activity.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity {
public ActivityProductDetailsBinding productDetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        productDetailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_product_details);


        productDetailsBinding.layoutBase.textTitle.setText("Product Details");

        productDetailsBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

    }
}