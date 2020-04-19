package com.example.acco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;

import java.util.List;

public class adlAdapter extends ArrayAdapter {


    public adlAdapter(@NonNull Context context, List objects) {

        super(context, 0, objects);
    }

        /*public adlAdapter(@NonNull Observer<String> context, int resource, @NonNull List objects) {
            super((Context) context, resource, objects);
        }

    public jugadorsAdapter(@NonNull Context context, List objects) {

        super(context, 0, objects);
    }*/

/*
     la receta a seguir sería:

Obtener referencia del componente LayoutInflater.
Inflar el layout del ítem si el view no existe
Obtén las instancias de los views a modificar
Obtén la instancia actual de la fuente de datos, extrae sus valores y haz el setup en los views.
     */


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Obtener inflater
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Get the data item for this position

// Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_aedl, parent, false);
            }
            // Referencias UI.
            ImageView ipPhoto = convertView.findViewById(R.id.Photo);
            TextView poble = convertView.findViewById(R.id.Poble);
            TextView direccio =  convertView.findViewById(R.id.Adreça);
            TextView email = convertView.findViewById(R.id.email);
            TextView telefon = convertView.findViewById(R.id.telefon);

            llista_aedl aedls = (llista_aedl) getItem(position);

            // Setup.
            Glide.with(getContext()).load(aedls.getIpPhoto()).into(ipPhoto);
            poble.setText(aedls.getPoble());
            direccio.setText(aedls.getDireccio());
            email.setText(aedls.getEmail());
            telefon.setText(aedls.getTelefon());


// Return the completed view to render on screen
            return convertView;
        }

    }

