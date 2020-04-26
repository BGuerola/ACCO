package com.example.acco;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
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

        OrdreView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                buildDialog();
            }
        });
    }

    public void buildDialog (){
        final ImageView image = new ImageView(this);
        AlertDialog.Builder builder =new AlertDialog.Builder(this);

        builder.setTitle("Comunicació");
        builder.setMessage("Vols contactar? xat o correu");
        builder.setPositiveButton("Xat", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), MyWhatsAppActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Correu", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                String textoEmail= "provisional";//esto tiene que ir por Bundle o algo
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"email1@ekiketa.es"});
                emailIntent.putExtra(Intent.EXTRA_CC, new String[]{"email2@ekiketa.es"});
                //emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{"email3@ekiketa.es"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "El asunto del email");
                //Recordad que la barra invertida más "n" es un salto de linea "n" así, escribiremos el email con varios saltos de linea.
                String textoApp = "Envio un email desde mi App de androidnnnCreado gracias a:nhttp://ekiketa.es";
                emailIntent.putExtra(Intent.EXTRA_TEXT, textoEmail);
                emailIntent.setType("message/rfc822");
                //Damos la opción al usuario que elija desde que app enviamos el email.
                startActivity(Intent.createChooser(emailIntent, "Selecciona aplicación..."));
            }
        });

        builder.setNeutralButton("Cancelar", null);
        builder.setView(image);
        builder.create();
        builder.show();
    }
    }


