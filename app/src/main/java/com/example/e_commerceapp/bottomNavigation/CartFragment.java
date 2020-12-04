package com.example.e_commerceapp.bottomNavigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_commerceapp.R;
import com.example.e_commerceapp.bottomNavigation.adapter.CartAdapter;
import com.example.e_commerceapp.bottomNavigation.pojo.Cart;
import com.example.e_commerceapp.bottomNavigation.viewModel.CartViewModel;
import com.example.e_commerceapp.bottomNavigation.viewModel.CategoryViewModel;
import com.example.e_commerceapp.databinding.FragmentCartBinding;
import com.example.e_commerceapp.databinding.FragmentHomeBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
    public CartViewModel cartViewModel;
    public CartAdapter cartAdapter;
    public FragmentCartBinding cartBinding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        cartViewModel= ViewModelProviders.of((FragmentActivity)this.getActivity()).get(CartViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        cartBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_cart,container,false);

        cartBinding.layoutBase.textTitle.setText("My Cart");

        cartBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        cartBinding.layoutBase.toolbar.setNavigationOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        cartBinding.recyclerCartItems.setHasFixedSize(true);
        cartBinding.recyclerCartItems.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));

        getCartItems();
        return cartBinding.getRoot();
    }

    public void getCartItems(){
        cartViewModel.getCart().observe((LifecycleOwner) this.getActivity(), new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                cartAdapter=new CartAdapter(getActivity(),carts);
                cartBinding.recyclerCartItems.setAdapter(cartAdapter);
            }
        });
    }
}