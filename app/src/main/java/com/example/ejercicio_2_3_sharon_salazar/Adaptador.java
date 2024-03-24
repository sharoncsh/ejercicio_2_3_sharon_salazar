package com.example.ejercicio_2_3_sharon_salazar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class Adaptador extends ArrayAdapter<Fotografias>{

    ArrayList<Fotografias> listaFotos = new ArrayList<>();

    public Adaptador(Context context, int textViewResourceId, ArrayList<Fotografias> objects) {
        super(context, textViewResourceId, objects);
        listaFotos = objects;
    }

    @Override
    public int getCount() { return super.getCount();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_vista_fotos, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.img);
        imageView.setImageBitmap(listaFotos.get(position).getFoto());
        TextView textView = (TextView) v.findViewById(R.id.txt);
        textView.setText(listaFotos.get(position).getDescripcion());
        return v;
    }

}
