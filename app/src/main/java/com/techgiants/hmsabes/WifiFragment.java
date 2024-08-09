package com.techgiants.hmsabes;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;

public class WifiFragment extends Fragment {

    private LinearLayout saveCredential;
    private MaterialCardView connect;
    private BottomSheetDialog saveCredentialDialog;
    private SharedPreferences sharedPreferences;
    private LottieAnimationView lottieConnect;
    private ImageView imageViewConnect;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wifi, container, false);

        saveCredential = view.findViewById(R.id.saveCredential);
        connect = view.findViewById(R.id.connect);
        lottieConnect = view.findViewById(R.id.lottieAnimationView);
        imageViewConnect = view.findViewById(R.id.imageViewConnect);

        sharedPreferences = requireActivity().getSharedPreferences("StudentInfo", Context.MODE_PRIVATE);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimation();
                checkWifiConnect();
                // checkCredential();
            }
        });

        saveCredential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSaveCredentialDialog();
            }
        });

        return view;
    }

    private void showSaveCredentialDialog() {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Fill Credential");
        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.save_credential_dialog_layout, null);
        builder.setView(customLayout);

        final EditText editTextUsername = customLayout.findViewById(R.id.Username);
        final EditText editTextPassword = customLayout.findViewById(R.id.Password);
        final Button save = customLayout.findViewById(R.id.saveBtn);

        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");
        editTextUsername.setText(username);
        editTextPassword.setText(password);

        // create and show the alert dialog
        final AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        // add a button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", editTextUsername.getText().toString());
                editor.putString("password", editTextPassword.getText().toString());
                editor.apply();
                Toast.makeText(requireContext(), "Credential Saved Successfully!", Toast.LENGTH_SHORT).show();

                // Dismiss the dialog
                dialog.dismiss();
            }
        });
    }

    private void checkWifiConnect() {
        // Check if Wi-Fi is connected
        boolean isWifiConnected = isWiFiConnected();

        if (!isWifiConnected) {
            // If Wi-Fi is not connected, prompt the user to open Wi-Fi settings
            Toast.makeText(requireContext(), "Wi-Fi is not connected. Please enable Wi-Fi.", Toast.LENGTH_LONG).show();
            // Open Wi-Fi settings
            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Wifi is Connected then Login to WIFI SERVER
                    // Pass the username and password to another activity
                    String username = sharedPreferences.getString("username", "");
                    String password = sharedPreferences.getString("password", "");
                    Intent intent = new Intent(requireContext(), LoginToWifiActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            },1600);
        }
    }

    private boolean isWiFiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) requireContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (capabilities != null) {
                    return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
                }
            } else {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                return networkInfo != null && networkInfo.isConnected();
            }
        }
        return false;
    }

    private void lottieAnimation() {
        imageViewConnect.setVisibility(View.GONE);
        connect.setCardBackgroundColor(requireContext().getColor(R.color.transparent));
        connect.setCardElevation(0);
        connect.setUseCompatPadding(false);
        connect.setStrokeWidth(0);
        lottieConnect.setVisibility(View.VISIBLE);
        lottieConnect.playAnimation();
        lottieConnect.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {
                imageViewConnect.setVisibility(View.VISIBLE);
                connect.setVisibility(View.VISIBLE);
                lottieConnect.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
            }
        });
    }
}
