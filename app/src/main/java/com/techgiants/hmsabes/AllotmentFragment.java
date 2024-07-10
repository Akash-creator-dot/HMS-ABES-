package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AllotmentFragment extends Fragment {
public AllotmentFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CardView cardvkb,cardckd,cardrkb,carddnb,cardabb;
        TextView txt;
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_allotment, container, false);
        txt=view.findViewById(R.id.allotmentdnbtxt);
        String str=txt.toString();
        cardabb=view.findViewById(R.id.allotmentabb);
        cardckd=view.findViewById(R.id.allotmentckb);
        carddnb=view.findViewById(R.id.allotmentdnb);
        cardvkb=view.findViewById(R.id.allotmentvkb);
        cardrkb=view.findViewById(R.id.allotmentrkb);

        Intent other=new Intent(getContext(),HostelFloor.class);
        Intent dnb=new Intent(getContext(),dnbHostelFloor.class);
        carddnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dnb.putExtra("card","dnb");
                startActivity(dnb);
            }
        });
        cardabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                other.putExtra("card","abb");
                startActivity(other);
            }
        });
        cardckd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                other.putExtra("card","ckb");
                startActivity(other);
            }
        });
        cardvkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                other.putExtra("card","vkb");
                startActivity(other);
            }
        });
        cardrkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                other.putExtra("card","rkb");
                startActivity(other);
            }
        });

        return view;
    }
}