package com.example.persistencia;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Notas {

    private Context contexto;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public Notas(Context context){
        contexto = context;
        sp = contexto.getSharedPreferences("nota", MODE_PRIVATE);
        editor = sp.edit();
    }

    public void salva(String texto){
        editor.putString("nota", texto);
        editor.commit();
    }

    public String retorna(){
        return sp.getString("nota","");

    }
}
