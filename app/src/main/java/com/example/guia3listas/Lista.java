package com.example.guia3listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.guia3listas.MainActivity.listNom;

public class Lista extends AppCompatActivity {

    private ListView listNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        if(listNom==null || listNom.size()==0){
            Toast.makeText(this, "Lista VACIA", Toast.LENGTH_SHORT).show();
        }else{
            listNombres = findViewById(R.id.listNombres);

            listNombres.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listNom));

            listNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    if(position >= 0 && position < listNom.size()){
                        Toast.makeText(Lista.this, "El nombre seleccionado es: " + listNom.get(position),
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

        }



    }
}
