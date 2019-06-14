package edu.cftic.fichapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Creditos extends AppCompatActivity {

    private RecyclerView recView;

    private ArrayList<Programador> datos;

    private AdapterCreditos adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creeditos);

        Uri uri = Uri.parse(
                "android.resource://"
                        + getPackageName()
                        + "/"
                        + R.raw.programadores
        );

        // Display the raw resource uri in text view
        Log.d("MIAPP", "URI of the image : \n" + uri.toString());
        try {
            InputStream ins = getResources().openRawResource(R.raw.programadores);

            InputStreamReader br = new InputStreamReader(ins, "UTF-8");
            Gson gson = new Gson();

            final Type tipoEnvoltorioEmpleado = new TypeToken<ArrayList<Programador>>() {
            }.getType();
            datos = gson.fromJson(br, tipoEnvoltorioEmpleado);
            Log.d("MIAPP", "tamaño de datos" + datos.size());
            recView = (RecyclerView) findViewById(R.id.RecView);
            recView.setHasFixedSize(true); //mejora el rendimiento, es aconsejable ponerlo

            adaptador = new AdapterCreditos(datos, this);

            recView.setAdapter(adaptador);

            recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            recView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickGithub(View view) {
        Uri webpage = Uri.parse((String) view.getTag());
        OpenWebPage(webpage);
    }

    private void OpenWebPage(Uri webpage) {
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        String pregunta = "Con que app quieres continuar";
        Intent chooser = Intent.createChooser(intent, pregunta);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void clickLinkedin (View view){
        if( view.getVisibility() == View.VISIBLE) {
            Uri webpage = Uri.parse((String) view.getTag());
            OpenWebPage(webpage);
        }
    }
}
