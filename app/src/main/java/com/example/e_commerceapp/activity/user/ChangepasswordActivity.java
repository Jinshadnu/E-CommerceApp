package com.example.e_commerceapp.activity.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.databinding.ActivityChangepasswordBinding;

public class ChangepasswordActivity extends AppCompatActivity {
public ActivityChangepasswordBinding changepasswordBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        changepasswordBinding= DataBindingUtil.setContentView(this,R.layout.activity_changepassword);

        changepasswordBinding.layoutBase.textTitle.setText("Change Password");

        changepasswordBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);



    }
}