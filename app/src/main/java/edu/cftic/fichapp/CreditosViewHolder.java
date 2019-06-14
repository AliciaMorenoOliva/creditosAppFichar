package edu.cftic.fichapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CreditosViewHolder extends RecyclerView.ViewHolder {

    private ImageView imag_view_imagen;
    private TextView text_view_nombre;
    private ImageButton imageButton_view_github;
    private ImageButton imageButton_view_linkedin;

    public CreditosViewHolder(View itemView) {

        super(itemView);
        imag_view_imagen = (ImageView) itemView.findViewById(R.id.imagen);
        text_view_nombre = (TextView) itemView.findViewById(R.id.nombre);
        imageButton_view_github = (ImageButton) itemView.findViewById(R.id.github);
        imageButton_view_linkedin = (ImageButton) itemView.findViewById(R.id.linkedin);

    }

    public void cargarCreditosEnHolder(Programador programador, Context contexto) {

        imag_view_imagen.setImageResource(R.mipmap.ic_launcher);
        if (null != programador.getImagen()) {
            int drawableResourceId = contexto.getResources().getIdentifier(programador.getImagen().toLowerCase(), "drawable", contexto.getPackageName());
            if( 0 != drawableResourceId) {
                imag_view_imagen.setImageResource(drawableResourceId);
            }
        }

        text_view_nombre.setText(programador.getNombre());


        List<Social> sociales = programador.getSocial();
        imageButton_view_linkedin.setVisibility( View.INVISIBLE);
        for (Social red: sociales) {
            if( !TextUtils.isEmpty( red.getEnlace())) {
                if (red.getRed().toLowerCase().equals("github")) {
                    imageButton_view_github.setTag(red.getEnlace());
                } else if (red.getRed().toLowerCase().equals("linkedin")) {
                    imageButton_view_linkedin.setImageResource(R.drawable.linkedin);
                    imageButton_view_linkedin.setTag(red.getEnlace());
                    imageButton_view_linkedin.setVisibility( View.VISIBLE);
                } else if (red.getRed().toLowerCase().equals("email")) {
                    imageButton_view_linkedin.setImageResource(R.drawable.ic_contact_mail_black_24dp);
                    imageButton_view_linkedin.setTag(red.getEnlace());
                    imageButton_view_linkedin.setVisibility( View.VISIBLE);
                }
            }
        }
    }
}
