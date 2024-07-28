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
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://4.bp.blogspot.com/-8U-yeWQyT-g/XvEld2GJKQI/AAAAAAAAAQU/EaqkAB8h8g0kDDDowQ3-2MxvHU1R7S6_QCLcBGAsYHQ/s1600/hands.jpg", "And people do that.", ScaleTypes.FIT));

        // Find the ImageSlider view and set the image list
        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        // Correctly cast CircleImageView
        wifilogo = view.findViewById(R.id.dashwifilogo);
        leavelogo = view.findViewById(R.id.dashleavelogo);
        ticketlogo = view.findViewById(R.id.dashcomplainslogo);
        profilelogo = view.findViewById(R.id.dashprofilelogo);
        circulationslogo = view.findViewById(R.id.dashcirculationslogo);
        eventslogo = view.findViewById(R.id.dasheventslogo);

        wifilogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag(new WifiFragment());
            }
        });
        leavelogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag(new LeaveFragment());
            }
        });
        ticketlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag(new ComplainsFragment());
            }
        });
        profilelogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag(new ProfileFragment());
            }
        });
        circulationslogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag(new WifiFragment());
            }
        });
        eventslogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag(new WifiFragment());
            }
        });

        return view;
    }

    public void frag(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containeer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
