package com.example.guia3listas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    public static List<String> listNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNom = new ArrayList<String>();
    }

    public void VerLista(View v) {
        if(listNom == null || listNom.size() == 0){
            new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("NO HAY NADA EN LA LISTA").show();
        }else{
            Intent in = new Intent(this, Lista.class);
            startActivity(in);
        }
    }

    public void AddNombre(View v){
        Intent in = new Intent(this, Registro.class);
        startActivity(in);
    }

    public void VerDatos(View v){
        Intent in = new Intent(this, Datos.class);
        startActivity(in);
    }

}
