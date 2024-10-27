package com.example.ihm2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private ImageButton calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        calculadora = (ImageButton) findViewById(R.id.calculator_button);
        calculadora.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.calculator_button) {
            Intent intentCalculadora = new Intent(Menu.this, Calculator.class);
            startActivity(intentCalculadora);
        }
    }
}