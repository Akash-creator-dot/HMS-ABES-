package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ComplainsFragment extends Fragment {
    CardView cardelect, cardplum, cardcarp, cardpest, cardsweeper;
    TextView txtcarpanter, textpest, txtplum, txtsweeper, txtelect;
    private String gmail, adm, pass, room, dept, block, name;

    public ComplainsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_complains, container, false);
        txtcarpanter = view.findViewById(R.id.complainscarpantertxt);
        txtelect = view.findViewById(R.id.complainselectriciantxt);
        textpest = view.findViewById(R.id.complainpesticidetxt);
        txtplum = view.findViewById(R.id.complainplumbertxt);
        txtsweeper = view.findViewById(R.id.complainssweepertxt);

        Bundle bundle = getArguments();
        if (bundle != null) {
            gmail = bundle.getString("gmail");
            adm = bundle.getString("adm");
            pass = bundle.getString("pass");
            room = bundle.getString("room");
            dept = bundle.getString("dept");
            block = bundle.getString("block");
            name = bundle.getString("name");
        }

        cardcarp = view.findViewById(R.id.complainsarpanter);
        cardplum = view.findViewById(R.id.complainplumber);
        cardelect = view.findViewById(R.id.complainselectrician);
        cardsweeper = view.findViewById(R.id.complainsweeper);
        cardpest = view.findViewById(R.id.complainpesticide);

        cardcarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivity(txtcarpanter.getText().toString());
            }
        });

        cardplum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivity(txtplum.getText().toString());
            }
        });

        cardelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivity(txtelect.getText().toString());
            }
        });

        cardsweeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivity(txtsweeper.getText().toString());
            }
        });

        cardpest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivity(textpest.getText().toString());
            }
        });

        return view;
    }

    private void startComplainsDetailActivity(String complainType) {
        Intent intent = new Intent(getContext(), ComplainsDetail.class);
//        intent.putExtra("complains", complainType);
//        intent.putExtra("gmail", gmail);
//        intent.putExtra("adm", adm);
//        intent.putExtra("pass", pass);
//        intent.putExtra("room", room);
//        intent.putExtra("dept", dept);
//        intent.putExtra("block", block);
//        intent.putExtra("name", name);
        startActivity(intent);
    }
}
