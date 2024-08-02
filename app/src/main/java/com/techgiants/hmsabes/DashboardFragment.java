package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
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
    private CircleImageView wifilogo, leavelogo, ticketlogo, profilelogo,Help;
    CardView circulations,messmenu,canteenmenu,academiccalander;

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

        // Correctly cast CircleImageView
        wifilogo = view.findViewById(R.id.dashwifilogo);
        leavelogo = view.findViewById(R.id.dashleavelogo);
        ticketlogo = view.findViewById(R.id.dashcomplainslogo);
        profilelogo = view.findViewById(R.id.dashprofilelogo);
        Help = view.findViewById(R.id.dashhelplogo);
        circulations=view.findViewById(R.id.circulations);
        academiccalander=view.findViewById(R.id.academiccalander);
        messmenu=view.findViewById(R.id.messmenu);
        canteenmenu=view.findViewById(R.id.canteenmenu);

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
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag(new WifiFragment());
            }
        });
        circulations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Circulations.class));
            }
        });
        academiccalander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),AcademicCalander.class));
            }
        });
        messmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MessMenu.class));
            }
        });
        canteenmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),CanteenMenu.class));
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
