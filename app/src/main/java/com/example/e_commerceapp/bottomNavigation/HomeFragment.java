package com.example.e_commerceapp.bottomNavigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.adapter.CategoriesAdapter;
import com.example.e_commerceapp.bottomNavigation.adapter.ImageSliderAdapter;
import com.example.e_commerceapp.bottomNavigation.adapter.OffersAdapter;
import com.example.e_commerceapp.bottomNavigation.pojo.Categories;
import com.example.e_commerceapp.bottomNavigation.pojo.Offers;
import com.example.e_commerceapp.bottomNavigation.viewModel.CategoryViewModel;
import com.example.e_commerceapp.bottomNavigation.viewModel.OffersViewModel;
import com.example.e_commerceapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    public FragmentHomeBinding homeBinding;
    public CategoryViewModel categoryViewModel;
    public CategoriesAdapter categoriesAdapter;
    public OffersViewModel offersViewModel;
    public OffersAdapter offersAdapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        categoryViewModel= ViewModelProviders.of((FragmentActivity)this.getActivity()).get(CategoryViewModel.class);
        offersViewModel=ViewModelProviders.of((FragmentActivity)this.getActivity()).get(OffersViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeBinding.layoutBase.toolbar.setTitle("Home");
        homeBinding.layoutBase.textTitle.setText("Home");


        homeBinding.recyclerCategories.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        homeBinding.recyclerCategories.setHasFixedSize(true);

        homeBinding.recyclerPopularProducts.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        homeBinding.recyclerPopularProducts.setHasFixedSize(true);

        setValuesToFields();

        getCategories();
        getOffers();
        return homeBinding.getRoot();
    }

    private void setValuesToFields() {
        //banner image
        List<String> bannerList = new ArrayList<>();
        bannerList.add("1");
        bannerList.add("2");
        bannerList.add("3");
        homeBinding.rlBanner.setVisibility(View.VISIBLE);
        homeBinding.vpImage.setAdapter(new ImageSliderAdapter(getActivity(), bannerList));

        homeBinding.cpImage.setViewPager(homeBinding.vpImage);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        homeBinding.cpImage.setRadius(5 * density);

        homeBinding.vpImage.startAutoScroll();
        homeBinding.vpImage.setInterval(5000);
        homeBinding.vpImage.setCycle(true);
        homeBinding.vpImage.setStopScrollWhenTouch(true);

        // Pager listener over indicator
        homeBinding.cpImage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    public void getCategories(){
        categoryViewModel.getCategories().observe((LifecycleOwner) this.getActivity(), new Observer<List<Categories>>() {
            @Override
            public void onChanged(List<Categories> categories) {
                categoriesAdapter=new CategoriesAdapter(getActivity(),categories);
                homeBinding.recyclerCategories.setAdapter(categoriesAdapter);
            }
        });
    }

    public void getOffers(){
        offersViewModel.getOffers().observe((LifecycleOwner) this.getActivity(), new Observer<List<Offers>>() {
            @Override
            public void onChanged(List<Offers> offers) {
                offersAdapter=new OffersAdapter(getActivity(),offers);
                homeBinding.recyclerPopularProducts.setAdapter(offersAdapter);
            }
        });
    }
}