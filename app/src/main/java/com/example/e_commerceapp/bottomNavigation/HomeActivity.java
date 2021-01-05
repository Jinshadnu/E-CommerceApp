package com.example.e_commerceapp.bottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.databinding.ActivityHomeBinding;
import com.example.e_commerceapp.util.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,NavigationView.OnNavigationItemSelectedListener {
public ActivityHomeBinding homeBinding;
public AppBarConfiguration appBarConfiguration;
    private NavController navController;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        homeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        homeBinding.bottomNavigationView.setOnNavigationItemSelectedListener(this);


//
//        homeBinding.layoutBase.imageview.setOnClickListener(v -> {
//            homeBinding.drawerlayout.openDrawer(GravityCompat.START);
//        });

        navigationView=homeBinding.navView;

//        appBarConfiguration =
//                new AppBarConfiguration.Builder(navController.getGraph()) //Pass the ids of fragments from nav_graph which you dont want to show back button in toolbar
//                        .setDrawerLayout(homeBinding.drawerlayout)
//                        .build();



//        navController= Navigation.findNavController(this,R.id.layoutFragment);
//        NavigationUI.setupWithNavController(navigationView, navController);
//        NavigationUI.setupActionBarWithNavController(this, navController); //Setup toolbar with back button and drawer icon according to appBarConfiguration
//        NavigationUI.setupWithNavController(navigationView, navController);


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