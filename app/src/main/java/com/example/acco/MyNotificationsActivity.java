package com.example.acco;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.iid.FirebaseInstanceId;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyNotificationsActivity extends MainMenu {

    static TextView txtName, txtMessage;
    static final String CHANNEL_NEWS = "News";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notifications);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtName = findViewById(R.id.textName);
        txtMessage = findViewById(R.id.txtMessage);

        Button getTokenButton =  findViewById(R.id.getTokenButton);
        getTokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get token
                String token = FirebaseInstanceId.getInstance().getToken();
                String msg = getString(R.string.get_registration_token, token);
                Log.i("token", "My token: " + token );
                Toast.makeText(MyNotificationsActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        // The notification
        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            txtMessage.setText(extras.getString("msg"));
            txtName.setText("Hello " + extras.getString("Nom") + " " + extras.getString("Cognom") );
        }
        else {
            txtMessage.setHint("Waiting for the message ...");
            txtName.setHint("Waiting for the name ...");
        }
    }

    public void connectNewsChannel(View view) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "News";
            String description = "My news";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_NEWS, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}