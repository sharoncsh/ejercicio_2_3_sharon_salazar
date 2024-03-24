package com.example.ejercicio_2_3_sharon_salazar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ejercicio_2_3_sharon_salazar.transaccion.transaccion;

public class SQLiteConexion extends SQLiteOpenHelper{

    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(transaccion.CreateTableFotos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(transaccion.DropeTableFotos);
        onCreate(db);
    }

    public Cursor getAll() {
        return(getReadableDatabase().rawQuery("SELECT * FROM fotos",null));
    }
    public void insert(byte[] bytes, String descripcion)
    {
        ContentValues cv = new ContentValues();

        cv.put(transaccion.blobFoto,bytes);
        cv.put(transaccion.descripcion,descripcion);
        Log.e("inserted", "inserted");
        getWritableDatabase().insert(transaccion.tablaFotos,transaccion.idFoto,cv);

    }
    public byte[] getImage(Cursor c)
    {
        return(c.getBlob(1));
    }

}
