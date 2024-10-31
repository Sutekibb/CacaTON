package com.example.ihm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Sesion extends AppCompatActivity implements View.OnClickListener {
    private Button registrar;
    private Button entrar;

    private EditText usuario, contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sesion);
        registrar = (Button) findViewById(R.id.button_registrarse);
        registrar.setOnClickListener(this);

        entrar = (Button) findViewById(R.id.button_entrar);
        entrar.setOnClickListener(this);

        usuario = (EditText) findViewById(R.id.usuario);
        contraseña = (EditText) findViewById(R.id.password);


    }
    @Override
    public void onClick(View view) {
        String user = usuario.getText().toString();
        String pass = contraseña.getText().toString();

        if (view.getId() == R.id.button_registrarse) {
            Intent intentRegistro = new Intent(Sesion.this, Registro.class);
            startActivity(intentRegistro);
        }
        else if (view.getId() == R.id.button_entrar) {
            DB db = new DB(getApplicationContext(), null, null, 1);
            String[] datosUsuario = db.search_reg(user);

            if (datosUsuario[2].equals("Encontrado") && datosUsuario[1].equals(pass)) {
                Toast.makeText(this, "Credenciales correctas", Toast.LENGTH_SHORT).show();
                Intent intentMenu = new Intent(Sesion.this, Menu.class);
                startActivity(intentMenu);
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
