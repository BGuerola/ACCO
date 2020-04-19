package com.example.acco;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.inici) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        /*if (id == R.id.serveis) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }*/


        if (id == R.id.observatori) {
            Intent intent = new Intent(this, ObserActivity.class);
            startActivity(intent);
        }

        if (id == R.id.orietlaboral) {
            Intent intent = new Intent(this, OrientActivity.class);
            startActivity(intent);
        }

        if (id == R.id.consol) {
            Intent intent = new Intent(this, ConsolActivity.class);
            startActivity(intent);
        }

        if (id == R.id.turisme) {
            Intent intent = new Intent(this, TurismeActivity.class);
            startActivity(intent);
        }

        if (id == R.id.adl) {
            Intent intent = new Intent(this, AedlActivity.class);
            startActivity(intent);
        }

        if (id == R.id.events) {
            Intent intent = new Intent(this, EventsActivity.class);
            startActivity(intent);
        }

        if (id == R.id.personal) {
            Intent intent = new Intent(this, personalActivity.class);
            startActivity(intent);
        }
        if (id == R.id.orientacio) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if (id == R.id.myNotifications) {
            Intent intent = new Intent(this, MyNotificationsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.signOut) {
            Intent intent = new Intent(this, SigninActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
