package com.example.ihm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    private Button registrar;

    private EditText user, email, password, passwordRepeated;

    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);

        registrar = (Button) findViewById(R.id.button_registro);
        user = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Password);
        passwordRepeated = (EditText) findViewById(R.id.PasswordRepeated);
        texto = (TextView) findViewById(R.id.textView);
        registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String usuario = user.getText().toString();
        texto.setText("Bienvenido " + usuario);
    }
}