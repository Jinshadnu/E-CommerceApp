package com.example.e_commerceapp.bottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.databinding.ActivityHomeBinding;
import com.example.e_commerceapp.util.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
public ActivityHomeBinding homeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        homeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        homeBinding.bottomNavigationView.setOnNavigationItemSelectedListener(this);

        openFragment(new HomeFragment(), Constants.HOME_FRAGMENT_TAG);

    }

    @Override
    protected void onResume() {
        super.onResume();
        openFragment(new HomeFragment(), Constants.HOME_FRAGMENT_TAG);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigationHome:
                openFragment(new HomeFragment(), Constants.HOME_FRAGMENT_TAG);
                break;
            case R.id.navigationCart:
                openFragment(new CartFragment(), Constants.CART_FRAGMENT_TAG);
                break;
            case R.id.navigationFavorite:
                openFragment(new FavouriteFragment(), Constants.FAVOURITE_FRAGMENT_TAG);
                break;
            case R.id.navigationProfile:
                openFragment(new ProfileFragment(), Constants.PROFILE_FRAGMENT_TAG);
                break;
        }
        return true;
    }

    private void openFragment(Fragment fragment, String tag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.layoutFragment,fragment,tag);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}