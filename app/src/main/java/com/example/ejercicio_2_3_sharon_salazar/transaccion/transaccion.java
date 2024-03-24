package com.example.ejercicio_2_3_sharon_salazar.transaccion;

public class transaccion {

    public static final String tablaFotos = "fotos";

    public static final String idFoto = "idFoto";

    public static final String blobFoto = "blobFoto";

    public static final String descripcion = "descripcion";

    public static final String CreateTableFotos =
            "CREATE TABLE fotos(idFoto INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "blobFoto BLOB, descripcion TEXT)";

    public static final String DropeTableFotos =
            "DROPE TABLE IF EXISTS fotos";

    public static final String NameDataBase = "DBCapturaFoto";
}
