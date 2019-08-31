package com.example.guia3listas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import static com.example.guia3listas.MainActivity.listNom;

public class Registro extends AppCompatActivity {

    EditText edtNombre;
    TextView porcentaje;
    Handler h = new Handler();
    ProgressBar proBar;
    int i = 0;
    boolean isActivo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtNombre = findViewById(R.id.edtNombre);
        porcentaje = findViewById(R.id.porcentaje);
        proBar = findViewById(R.id.proBar);
    }

    public void GuardarRegistro(View v){
        if(edtNombre.getText().toString().isEmpty()){
            new AlertDialog.Builder(this).setTitle("¡Aviso!").setMessage("Digite un nombre").show();
        } else if(!isActivo){
            Thread hr = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(i <= 100){
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                porcentaje.setText(i +" %");
                                proBar.setProgress(i);
                            }
                        });
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(i == 100) {
                            listNom.add(edtNombre.getText().toString());
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    new AlertDialog.Builder(Registro.this).setTitle("¡Aviso!").setMessage("Guardo exitosamente. \n¿Desea agregar otro nombre?")
                                            .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {   //Cerrar
                                                    finish();
                                                }
                                            })
                                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {// Add otro
                                                    isActivo = false;
                                                    i  = 0;
                                                    porcentaje.setText("");
                                                    edtNombre.setText("");
                                                    proBar.setProgress(0);
                                                }
                                            }).show();
                                }
                            });
                        }
                        i++;
                        isActivo = true;
                    }
                }
            });
            hr.start();
        }
    }
}
