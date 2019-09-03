package com.example.persistencia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText texto;
    Notas nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (EditText) findViewById(R.id.texto);
        nota = new Notas(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        nota.salva(texto.getText().toString());
        Toast.makeText(this, "texto salvo", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String retorno = nota.retorna();

        if (retorno.equalsIgnoreCase("")){
            Toast.makeText(this, "Sem nota",Toast.LENGTH_LONG).show();
        }else{
            texto.setText(retorno);
        }
    }
}
