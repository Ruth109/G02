package com.example.g02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.g02.clases.Persona;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Persona> lstPersonas = new ArrayList<>();

    private Button btnAgregarPersona, btnMostrarPersonas, btnMisDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregarPersona = findViewById(R.id.btnIrAgregar);
        btnMostrarPersonas = findViewById(R.id.btnMostrarLista);
        btnMisDatos = findViewById(R.id.btnIrDatos);

        btnAgregarPersona.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AgregarPersonaActivity.class));
        });

        btnMostrarPersonas.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MostrarListaActivity.class));
        });

        btnMisDatos.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MisDatosActivity.class));
        });
    }
}