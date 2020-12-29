package com.example.e_commerceapp.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.databinding.ActivityRegisterBinding;
import com.example.e_commerceapp.otp.OTPActivity;

public class RegisterActivity extends AppCompatActivity {
public ActivityRegisterBinding registerBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        registerBinding= DataBindingUtil.setContentView(this,R.layout.activity_register);

        registerBinding.constraintRegister.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_transition_animation));
        registerBinding.buttonRegister.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, OTPActivity.class));
        });

    }
}