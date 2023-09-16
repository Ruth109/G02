package com.example.g02;
import com.example.g02.clases.Persona;
import static com.example.g02.MainActivity.lstPersonas;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarPersonaActivity extends AppCompatActivity{
    EditText edtNombre, edtApellido, edtEdad, edtCorreo;
    Button btnProcesar, btnModififcar;
    private Persona persona;
    int posicion, idPersona;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        //posicion = getIntent().getIntExtra("posicion", -1);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtEdad = findViewById(R.id.edtEdad);
        edtCorreo = findViewById(R.id.edtCorreo);
        btnProcesar = findViewById(R.id.btnProcesar);
        btnModififcar = findViewById(R.id.btnModificar);

        Intent intent = getIntent();
        posicion = intent.getIntExtra("posicion", 0);
        idPersona = intent.getIntExtra("idPersona", 0);
        if(intent != null && intent.hasExtra("persona")) {
            persona = (Persona) intent.getSerializableExtra("persona");
        }

        if(persona != null){
            edtNombre.setText(persona.getNombrePersona());
            edtApellido.setText(persona.getApellidoPersona());
            edtEdad.setText(String.valueOf(persona.getEdadPersona()));
            edtCorreo.setText(persona.getCorreoPersona());
        }

        btnModififcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstPersonas.set(posicion, new Persona(idPersona,edtNombre.getText().toString(),edtApellido.getText().toString(),Integer.parseInt(edtEdad.getText().toString()),edtCorreo.getText().toString()));
                Toast.makeText(EditarPersonaActivity.this, "Modificacion Exitosa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
