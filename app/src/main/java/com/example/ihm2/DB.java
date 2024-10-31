package com.example.ihm2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, "BaseDatos", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE Datos(nombre TEXT PRIMARY KEY, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS Datos");
        onCreate(db);
    }

    public String guardar(String nombre, String password){
        String mensaje = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", nombre);
        contenedor.put("password", password);

        try{
            database.insertOrThrow("Datos", null, contenedor);
            mensaje = "Ingresado correctamente";
        } catch (SQLException e) {
            mensaje = "Error al ingresar el usuario";
        } finally {
            database.close();
        }
        return mensaje;
    }

    public String[] search_reg(String buscar) {
        String[] datos = new String[3];
        SQLiteDatabase database = this.getReadableDatabase();
        String q = "SELECT nombre, password FROM Datos WHERE nombre=?";
        Cursor registros = database.rawQuery(q, new String[]{buscar});

        if (registros != null && registros.moveToFirst()) {
            datos[0] = registros.getString(0);  // nombre
            datos[1] = registros.getString(1);  // password
            datos[2] = "Encontrado";
        } else {
            datos[2] = "No encontrado";
        }

        if (registros != null) registros.close();
        database.close();
        return datos;
    }

    public String actualizarPassword(String nombre, String nuevaPassword) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("password", nuevaPassword);
        int filasAfectadas = database.update("Datos", valores, "nombre=?", new String[]{nombre});
        database.close();

        return filasAfectadas > 0 ? "Contraseña actualizada" : "Usuario no encontrado";
    }

    public String eliminarUsuario(String nombre) {
        SQLiteDatabase database = this.getWritableDatabase();
        int filasAfectadas = database.delete("Datos", "nombre=?", new String[]{nombre});
        database.close();

        return filasAfectadas > 0 ? "Usuario eliminado" : "Usuario no encontrado";
    }

    public void eliminarTodo() {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("Datos", null, null);
        database.close();
    }

    public int contarUsuarios() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM Datos", null);
        int cantidadUsuarios = 0;

        if (cursor.moveToFirst()) {
            cantidadUsuarios = cursor.getInt(0);
        }
        cursor.close();
        database.close();

        return cantidadUsuarios;
    }
}
