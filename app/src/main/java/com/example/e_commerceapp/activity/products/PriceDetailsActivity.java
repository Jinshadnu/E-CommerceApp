package com.example.e_commerceapp.activity.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.databinding.ActivityPriceDetailsBinding;

public class PriceDetailsActivity extends AppCompatActivity {
public ActivityPriceDetailsBinding priceDetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        priceDetailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_price_details);

        priceDetailsBinding.layoutBase.textTitle.setText("Price Details");

        priceDetailsBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
    }
}