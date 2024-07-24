package com.techgiants.hmsabes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LoginToWifiActivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    private boolean isErrorOccurred = false;
    private boolean isLoginAttempted = false; // Prevent multiple login attempts
    private AlertDialog errorDialog; // Reference to the error dialog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_to_wifi);

        // Set up the custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back); // Optional, you can provide a custom back arrow icon
        }

        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);

        setupWebView();
        loginToWebsite();
    }

    private void setupWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Enable DOM storage if needed

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                // Show the progress bar when page loading starts
                progressBar.setVisibility(View.VISIBLE);
                isErrorOccurred = false;
                isLoginAttempted = false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // Hide the progress bar when page loading finishes
                progressBar.setVisibility(View.GONE);

                if (!isErrorOccurred && !isLoginAttempted) {
                    isLoginAttempted = true; // Prevent multiple login attempts
                    String username = getIntent().getStringExtra("username");
                    String password = getIntent().getStringExtra("password");

                    webView.evaluateJavascript(
                            "document.getElementById('username').value = '" + username + "';" +
                                    "document.getElementById('password').value = '" + password + "';" +
                                    "document.getElementById('loginbutton').click();",
                            null
                    );



                    if (errorDialog != null && errorDialog.isShowing()) {
                        errorDialog.dismiss(); // Dismiss the error dialog if showing
                    }
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                isErrorOccurred = true;
                progressBar.setVisibility(View.GONE);
                showErrorDialog();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, android.webkit.SslErrorHandler handler, android.net.http.SslError error) {
                isErrorOccurred = true;
                progressBar.setVisibility(View.GONE);
                handler.proceed(); // Ignore SSL certificate errors (use with caution)
                showErrorDialog();
            }
        });
    }

    private void loginToWebsite() {
        webView.loadUrl("https://192.168.1.254:8090/");
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Connection Error");
        builder.setMessage("Unable to load the page. Please check your Wi-Fi connection.");

        builder.setPositiveButton("Open Wi-Fi Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Go Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.setNeutralButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                loginToWebsite();
            }
        });

        builder.setCancelable(false);
        errorDialog = builder.create();
        errorDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Go back to the previous activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
