package com.example.acco;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;

public class AedlActivity extends MainMenu {

    ListView OrdreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aedl);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.content_aedl);
        //ArrayList<llistaJugadors>Mylist=new ArrayList<>();
        adlAdapter adapter = new adlAdapter(this, repositoriAedl.getInstance().getLeads());

        OrdreView=findViewById(R.id.listadl);
        OrdreView.setAdapter(adapter);



    }

}
