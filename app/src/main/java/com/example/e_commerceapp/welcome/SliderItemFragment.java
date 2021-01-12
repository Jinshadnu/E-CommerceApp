package com.example.e_commerceapp.welcome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.e_commerceapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SliderItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SliderItemFragment extends Fragment {
    private static final String ARG_POSITION = "slider-position";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @StringRes
    private static final int[] PAGE_TITLES =
            new int[] { R.string.find_foods, R.string.fast_delivery, R.string.home_delivery };

    @StringRes
    private static final int[] PAGE_TEXT =
            new int[] {
                    R.string.find_food_description, R.string.fast_delivery_description, R.string.find_food_description
            };
    // prepare all subtitle images arrays
    @StringRes

    private static final int[] PAGE_IMAGE =
            new int[] {
                    R.raw.laptop, R.raw.bicyclelottie, R.raw.homedeliverylottie
            };
    private static final int[] BG_IMAGE = new int[] {
            R.color.colorwhite, R.color.colorwhite,
            R.color.colorwhite
    };
    private int position;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SliderItemFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static SliderItemFragment newInstance(int position) {
        SliderItemFragment fragment = new SliderItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slider_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackground(requireActivity().getDrawable(BG_IMAGE[position]));
        TextView title = view.findViewById(R.id.textView);
        TextView titleText = view.findViewById(R.id.textView2);
        LottieAnimationView imageView = view.findViewById(R.id.imageView);
        // set page title
        title.setText(PAGE_TITLES[position]);
        // set page sub title text
        titleText.setText(PAGE_TEXT[position]);
        // set page image


        imageView.setAnimation(PAGE_IMAGE[position]);

    }
}