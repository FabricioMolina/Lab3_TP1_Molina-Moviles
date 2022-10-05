package com.ragnar.lab3_tp1_molina.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.ragnar.lab3_tp1_molina.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context){
        if(sp == null){
            sp = context.getSharedPreferences("datos", 0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();

        editor.putLong("dni", usuario.getDni());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("email", usuario.getEmail());
        editor.putString("contraseña", usuario.getContraseña());
        editor.commit();
    }
    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "null");
        String nombre = sp.getString("nombre", "null");
        String email = sp.getString("email", "null");
        String contraseña = sp.getString("contraseña", "null");

        Usuario user = new Usuario(dni,nombre,apellido,email,contraseña);
        return user;
    }

    public static Usuario login(Context context,String mail, String pass){
        Usuario user = null;
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "Sin Definir");
        String nombre = sp.getString("nombre", "Sin Definir");
        String email = sp.getString("email", "Sin Definir");
        String contraseña = sp.getString("contraseña", "Sin Definir");

        if(email.equals(mail) && contraseña.equals(pass)){
            user = new Usuario(dni,nombre,apellido,email,contraseña);
        }
        return user;
    }

}
