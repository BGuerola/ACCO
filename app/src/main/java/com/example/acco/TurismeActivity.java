package com.example.acco;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TurismeActivity extends MainMenu {

    WebView navegador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turisme);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navegador = findViewById(R.id.webturisme);
        navegador.setWebViewClient(new WebViewClient());
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.loadUrl("http://www.mancohortasud.es/serveis/unitat-digualtat/assessorament-en-plans-digualtat");

    }

}
