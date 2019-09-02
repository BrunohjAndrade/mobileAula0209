package com.example.persistencia;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("dadosUsuario", MODE_PRIVATE);
        editor = sp.edit();

        texto = (EditText) findViewById(R.id.texto);
    }

    @Override
    protected void onPause(){
        super.onPause();
        editor.putString("nota", texto.getText().toString());
        editor.commit();
        Toast.makeText(this, "texto salvo", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sp.contains("nota")){
            texto.setText(sp.getString("nota",""));
        }else{
            Toast.makeText(this, "Sem nota",Toast.LENGTH_LONG).show();
        }
    }
}
