package com.example.g02;

import static com.example.g02.MainActivity.lstPersonas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.g02.clases.Persona;

public class MostrarListaActivity extends AppCompatActivity {

    private ListView lsvPersonas;
    ArrayAdapter<Persona> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);

        lsvPersonas = findViewById(R.id.lsvPersona);

        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, lstPersonas);

        lsvPersonas.setAdapter(arrayAdapter);

        lsvPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Persona SeleccionarPersona = lstPersonas.get(posicion);

                Intent intent = new Intent(MostrarListaActivity.this, EditarPersonaActivity.class);
                intent.putExtra("persona", SeleccionarPersona);
                intent.putExtra("posicion", posicion);
                startActivity(intent);
            }
        });

        lsvPersonas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MostrarListaActivity.this);
                builder.setTitle("Eliminar Persona");
                builder.setMessage("¿Estás seguro de que deseas eliminar a esta persona?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        lstPersonas.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstPersonas);
        arrayAdapter.notifyDataSetChanged();
        lsvPersonas.setAdapter(arrayAdapter);
    }
}