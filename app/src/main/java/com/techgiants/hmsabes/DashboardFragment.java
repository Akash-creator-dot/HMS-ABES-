package com.techgiants.hmsabes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    public DashboardFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Create image list
        List<SlideModel> imageList = new ArrayList<>();

        // Add images and titles to the list
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://4.bp.blogspot.com/-8U-yeWQyT-g/XvEld2GJKQI/AAAAAAAAAQU/EaqkAB8h8g0kDDDowQ3-2MxvHU1R7S6_QCLcBGAsYHQ/s1600/hands.jpg", "And people do that.", ScaleTypes.FIT));

        // Find the ImageSlider view and set the image list
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        return view;
    }
}