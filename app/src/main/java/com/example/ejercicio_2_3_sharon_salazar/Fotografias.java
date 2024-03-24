package com.example.ejercicio_2_3_sharon_salazar;
import android.graphics.Bitmap;

public class Fotografias {

    Bitmap foto;
    String descripcion;

    public Fotografias(Bitmap foto, String descripcion)
    {
        this.foto = foto;
        this.descripcion = descripcion;
    }


    public Bitmap getFoto(){return foto;}

    public String getDescripcion()
    {
        return descripcion;
    }

}
