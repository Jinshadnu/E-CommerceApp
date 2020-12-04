package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.e_commerceapp.databinding.ActivityMainBinding;
import com.example.e_commerceapp.register.RegisterActivity;

public class MainActivity extends AppCompatActivity {
public ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainBinding.buttonLogin.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
        });

    }
}