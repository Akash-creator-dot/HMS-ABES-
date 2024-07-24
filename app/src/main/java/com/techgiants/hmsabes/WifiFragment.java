package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class WifiFragment extends Fragment {
    private Button btnConnect;
    private EditText edtAdm, edtPass;

    // TODO: Rename parameter arguments, choose na

    public WifiFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wifi, container, false);
        btnConnect = view.findViewById(R.id.btnConnect);
        edtAdm = view.findViewById(R.id.edtAdm);
        edtPass = view.findViewById(R.id.edtPass);

        btnConnect.setOnClickListener(v -> {
            String admissionNumber = edtAdm.getText().toString();
            String password = edtPass.getText().toString();

            Intent intent = new Intent(getContext(), WifiWeb.class);
            intent.putExtra("admissionNumber", admissionNumber);
            intent.putExtra("password", password);
            startActivity(intent);
        });
        return view;
    }
}