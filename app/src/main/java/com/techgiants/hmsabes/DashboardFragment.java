package com.techgiants.hmsabes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardFragment extends Fragment {
    private CircleImageView wifilogo, leavelogo, ticketlogo, profilelogo, circulationslogo, eventslogo;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Create image list
        List<SlideModel> imageList = new ArrayList<>();

        // Add images and titles to the list
        imageList.add(new SlideModel("https://www.mappls.com/place/HK7TU9_1675002762189_0.png", "ABES Engineering College Established in 2000.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://abes.ac.in/images1/placement2022.jpg", "ABES Engineering College Placement is Better than any other Private College in AKTU", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://i.ytimg.com/vi/vGoiqOA6O2g/maxresdefault.jpg", "It's is In Ghaziabad", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://abes.ac.in/images1/ece/g%20(23).jpg", "Abes offers every student Industrial Visit every year.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://abes.ac.in/images/life/af3.jpg", "Abes has more than 30 computers lab", ScaleTypes.CENTER_CROP));
        // Find the ImageSlider view and set the image list
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);



        return view;
    }
}
