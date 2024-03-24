package com.example.ejercicio_2_3_sharon_salazar;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ejercicio_2_3_sharon_salazar.transaccion.transaccion;

import java.util.ArrayList;

public class listaFotos  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListView simpleGridView = (ListView) findViewById(R.id.listView);

        SQLiteConexion help = new SQLiteConexion(this, transaccion.NameDataBase, null, 1);
        ArrayList<Fotografias> listaFotos = new ArrayList<>();
        Cursor c= help.getAll();
        int i=0;
        if(c.getCount()>0)
        {
            c.moveToFirst();
            while(c.isAfterLast()==false)
            {
                byte[] bytes=c.getBlob(c.getColumnIndexOrThrow(transaccion.blobFoto));
                String descripcion = c.getString(c.getColumnIndexOrThrow(transaccion.descripcion));

                Fotografias fotografia = new Fotografias(BitmapFactory.decodeByteArray(bytes, 0, bytes.length), descripcion);
                listaFotos.add(fotografia);
                c.moveToNext();
                i++;
            }

            Adaptador myAdapter=new Adaptador(this,R.layout.activity_vista_fotos,listaFotos);
            simpleGridView.setAdapter(myAdapter);
        }
    }
}
