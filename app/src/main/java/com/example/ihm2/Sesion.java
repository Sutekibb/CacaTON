package com.example.ihm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Sesion extends AppCompatActivity implements View.OnClickListener {
    private Button b;
    private Button c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sesion);
        b = (Button) findViewById(R.id.button_registrarse);
        b.setOnClickListener(this);

        c = (Button) findViewById(R.id.button_entrar);
        c.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        // Verificamos cuál botón fue presionado
        if (view.getId() == R.id.button_registrarse) {
            // Si el botón de "Registrarse" fue presionado
            Intent intentRegistro = new Intent(Sesion.this, Registro.class);
            startActivity(intentRegistro);
        } else if (view.getId() == R.id.button_entrar) {
            // Si el botón de "Entrar" fue presionado
            Intent intentMenu = new Intent(Sesion.this, Menu.class);
            startActivity(intentMenu);
        }
    }
}
