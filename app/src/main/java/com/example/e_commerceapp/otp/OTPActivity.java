package com.example.e_commerceapp.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.HomeActivity;
import com.example.e_commerceapp.databinding.ActivityOTPBinding;

public class OTPActivity extends AppCompatActivity {
public ActivityOTPBinding otpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        otpBinding= DataBindingUtil.setContentView(this,R.layout.activity_o_t_p);

        otpBinding.buttonVerify.setOnClickListener(view -> {
            startActivity(new Intent(OTPActivity.this,HomeActivity.class));
        });
    }
}