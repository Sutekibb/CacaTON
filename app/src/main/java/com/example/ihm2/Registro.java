package com.example.ihm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity{
    private Button registrar;

    private EditText user, password, passwordRepeated;

    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);

        registrar = (Button) findViewById(R.id.button_registro);
        user = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.Password);
        passwordRepeated = (EditText) findViewById(R.id.PasswordRepeated);
        texto = (TextView) findViewById(R.id.textView);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = user.getText().toString();
                String contra = password.getText().toString();
                String contraRep = passwordRepeated.getText().toString();

                if (contra.isEmpty() || contraRep.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no deben estar vacías", Toast.LENGTH_SHORT).show();
                } else if (!contra.equals(contraRep)) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                } else {
                    texto.setText("Bienvenido, " + usuario + ", puedes iniciar sesión");
                    DB db = new DB(getApplicationContext(), null, null, 1);
                    String mensaje = db.guardar(usuario, contra);
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}