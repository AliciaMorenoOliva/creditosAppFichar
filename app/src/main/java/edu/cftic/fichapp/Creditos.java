package edu.cftic.fichapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Creditos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creeditos);
        // Get the uri of the image from raw folder
        Uri uri = Uri.parse(
                "android.resource://"
                        + getPackageName()
                        + "/"
                        + R.raw.programadores
        );

        // Display the raw resource uri in text view
        Log.d( "MIAPP","URI of the image : \n"+uri.toString());
    }
}
