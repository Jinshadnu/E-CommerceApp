package com.example.e_commerceapp.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.databinding.ActivityChangepasswordBinding;
import com.example.e_commerceapp.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends AppCompatActivity {
public ActivityForgotPasswordBinding forgotPasswordBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        forgotPasswordBinding= DataBindingUtil.setContentView(this,R.layout.activity_forgot_password);

        forgotPasswordBinding.layoutBase.textTitle.setText("Forgot Password");

        forgotPasswordBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
    }
}