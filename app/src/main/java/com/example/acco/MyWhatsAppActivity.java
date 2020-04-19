package com.example.acco;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyWhatsAppActivity extends MainMenu {
    EditText textToSend;
    TextView textSent, textReceived;
    FirebaseDatabase database;
    DatabaseReference sendTextRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// The Firebase DB connexion
        database = FirebaseDatabase.getInstance();
        sendTextRef = database.getReference("text");
// The elements of the layout
        textToSend = findViewById(R.id.textToSend);
        textReceived = findViewById(R.id.textReceived);
        textSent = findViewById(R.id.textSent);
// Read a message from the database
        sendTextRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                textReceived.append(value + "\n");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void sendText(View view) {
        String aux = " > " + textToSend.getText().toString();
        sendTextRef.setValue(aux);
// Add to the sent messages
        aux += "\n";
        textSent.append(aux);

    }
}