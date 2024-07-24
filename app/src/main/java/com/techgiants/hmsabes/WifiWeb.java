package com.techgiants.hmsabes;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WifiWeb extends AppCompatActivity {

    private WebView webView;
    private String admissionNumber;
    private String password;
    private boolean loginAttempted = false; // Add a flag to track login attempts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wifi_web);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve data from Intent
        Intent intent = getIntent();
        admissionNumber = intent.getStringExtra("admissionNumber");
        password = intent.getStringExtra("password");

        webView = findViewById(R.id.webView);
        setupWebView();
        loginToWebsite();
    }

    private void setupWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Enable DOM storage if needed

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (!loginAttempted) { // Check if login has not been attempted yet
                    String script = "document.getElementById('username').value = '" + admissionNumber + "';" +
                            "document.getElementById('password').value = '" + password + "';" +
                            "document.getElementById('loginbutton').click();";
                    webView.evaluateJavascript(script, null);
                    loginAttempted = true; // Set the flag to true after attempting login
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, android.webkit.SslErrorHandler handler, android.net.http.SslError error) {
                // Handle SSL errors properly in production
                handler.proceed(); // Ignore SSL certificate errors (use with caution)
            }
        });
    }

    private void loginToWebsite() {
        webView.loadUrl("https://192.168.1.254:8090/");
    }
}
