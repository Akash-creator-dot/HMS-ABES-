//package com.techgiants.hmsabes;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.Handler;
//import android.view.View;
//import android.widget.Toast;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.airbnb.lottie.LottieAnimationView;
//import com.github.barteksc.pdfviewer.PDFView;
//import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
//
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class AcademicCalander extends AppCompatActivity {
//
//    String pdfUrl;
//    PDFView pdfView;
//    LottieAnimationView lottieAnimationView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_academic_calander);
//
//        pdfUrl = "https://foaaktu.ac.in/pdfs/academic%20calendar%202024-25%20odd.pdf";
//        pdfView = findViewById(R.id.pdfView);
//        lottieAnimationView = findViewById(R.id.animationView);
//
//        pdfView.setVisibility(View.INVISIBLE);
//        lottieAnimationView.setVisibility(View.VISIBLE);
//
//        new loadPdfFromUrl().execute(pdfUrl);
//
//
//    }
//
//    private class loadPdfFromUrl extends AsyncTask<String, Void,InputStream>{
//
//        @Override
//        protected InputStream doInBackground(String... strings) {
//            try {
//                URL url = new URL(pdfUrl);
//                try {
//                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//
//                    if (httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
//                        return new BufferedInputStream(httpURLConnection.getInputStream());
//                    }
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(InputStream inputStream) {
//            super.onPostExecute(inputStream);
//
//            if (inputStream != null){
//
//                pdfView.fromStream(inputStream)
//
//
//                        .onLoad(new OnLoadCompleteListener() {
//                            @Override
//                            public void loadComplete(int nbPages) {
//
//                                final Handler handler = new Handler();
//
//                                handler.postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        pdfView.setVisibility(View.VISIBLE);
//                                        lottieAnimationView.setVisibility(View.GONE);
//
//                                    }
//                                },2000);
//
//
//                            }
//                        })
//                        .load();
//
//            }else {
//                Toast.makeText(AcademicCalander.this, "Failed to Load pdf...", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//
//}