package com.example.acco;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventsActivity extends MainMenu {

    private FirebaseDatabase database;
    private DatabaseReference eventsRef;
    private ArrayList<eventsBean> llistaEvents;
    private ListView myEventsListView;
    private eventsBean myEvents;
    private String myRef = "myBikes";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    database= FirebaseDatabase.getInstance();
    eventsRef = database.getReference(myRef);
// The list of events
    llistaEvents = new ArrayList<>();
// The listener to the RTDB
    eventsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                llistaEvents.clear();
                for (DataSnapshot biciSnapshot : dataSnapshot.getChildren()) {
                    myEvents = biciSnapshot.getValue(eventsBean.class);
// Add event to the list
                    llistaEvents.add(myEvents);
                }
// Into the onDataChange method!! No interface for now.
// Array of strings for the adapter: Adding space
                String[] listViewTitol = new String[llistaEvents.size()];
                String[] listViewCategoria = new String[llistaEvents.size()];
                String[] listViewData = new String[llistaEvents.size()];
                String[] listViewHora = new String[llistaEvents.size()];
                String[] listViewLocalitat = new String[llistaEvents.size()];
                String[] listViewEnllaç = new String[llistaEvents.size()];


                int[] listViewFoto = new int[llistaEvents.size()]; //
// Reading the bike's information
                for (int i = 0; i < llistaEvents.size(); i++) {
                    listViewTitol[i] = llistaEvents.get(i).getTitol();
                    listViewCategoria[i] = llistaEvents.get(i).getCategoria();
                    listViewData[i] = llistaEvents.get(i).getData();
                    listViewHora[i] = llistaEvents.get(i).getHora();
                    listViewLocalitat[i] = llistaEvents.get(i).getLocalitat();
                    listViewEnllaç[i] = llistaEvents.get(i).getEnllaç();
                }

// Preparing the HashMap for the adapter
                    List<HashMap<String, String>> aList = new ArrayList<>();
                    for (int i = 0; i < llistaEvents.size(); i++) {
                        HashMap<String, String> hm = new HashMap<String, String>();
                        hm.put("listview_titol", listViewTitol[i]);
                        hm.put("listview_categoria", listViewCategoria[i]);
                        hm.put("listview_data", listViewData[i]);
                        hm.put("listview_hora", listViewHora[i]);
                        hm.put("listview_localitat", listViewLocalitat[i]);
                        hm.put("listview_Enllaç", listViewEnllaç[i]);
                    }
                    String[] from = {"listview_titol", "listview_categoria", "listview_data",
                            "listview_data", "listview_hora", "listview_localitat", "listview_enllaç"};
                    int[] to = {R.id.listview_item_titol, R.id.listview_item_categoria,
                            R.id.listview_item_data, R.id.listview_item_hora, R.id.listview_item_localitat, R.id.listview_item_enllaç};
                    SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.item_event_list, from, to);

                    myEventsListView = findViewById(R.id.listEvents);
// The adapter
                    myEventsListView.setAdapter(simpleAdapter);

                }

                    @Override
                    public void onCancelled (DatabaseError databaseError){
                    }


    });

}
}

