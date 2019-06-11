package edu.cftic.fichapp;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the uri of the image from raw folder
        Uri uri = Uri.parse(
                "android.resource://"
                        + getPackageName()
                        + "/"
                        + R.raw.programadores
        );

        // Display the raw resource uri in text view
        Log.d( "MIAPP","URI of the image : \n"+uri.toString());
        try {
            InputStream ins = getResources().openRawResource(R.raw.programadores);

            InputStreamReader br = new InputStreamReader(ins, "UTF-8");
            Gson gson = new Gson();
            //gson.fromJson()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
