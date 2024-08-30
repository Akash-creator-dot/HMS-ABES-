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
    CardView cardelect, cardplum, cardcarp, cardpest, cardsweeper,cardwelder,cardwifi;
    TextView txtcarpanter, textpest, txtplum, txtsweeper, txtelect,txtwelder,txtwifi;

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
        cardcarp = view.findViewById(R.id.complainsarpanter);
        cardplum = view.findViewById(R.id.complainplumber);
        cardelect = view.findViewById(R.id.complainselectrician);
        cardsweeper = view.findViewById(R.id.complainsweeper);
        cardwelder=view.findViewById(R.id.complainwelder);
        cardwifi=view.findViewById(R.id.complainwifiinternetimg);
        txtwelder=view.findViewById(R.id.complainweldertxt);
        txtwifi=view.findViewById(R.id.complainwifiinternettxt);
        cardpest = view.findViewById(R.id.complainpesticide);

        cardcarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivityall(txtcarpanter.getText().toString());
            }
        });

        cardplum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivityall(txtplum.getText().toString());
            }
        });

        cardelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivityall(txtelect.getText().toString());
            }
        });

        cardsweeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivitysome(txtsweeper.getText().toString());
            }
        });

        cardpest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivitysome(textpest.getText().toString());
            }
        });
        cardwelder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivityall(txtwelder.getText().toString());
            }
        });
        cardwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startComplainsDetailActivitysome(txtwifi.getText().toString());
            }
        });

        return view;
    }

    private void startComplainsDetailActivityall(String complainType) {
        Intent intent = new Intent(getContext(), complaininsideall.class);
        intent.putExtra("complains", complainType);
        startActivity(intent);
    }
    private void startComplainsDetailActivitysome(String complainType) {
        Intent intent = new Intent(getContext(), complaininsidesome.class);
        intent.putExtra("complains", complainType);
        startActivity(intent);
    }
}
