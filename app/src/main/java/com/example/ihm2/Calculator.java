package com.example.ihm2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    private EditText amount, interest, days;
    private TextView res;
    private Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        amount = (EditText) findViewById(R.id.amount);
        interest = (EditText) findViewById(R.id.interes_rate);
        days = (EditText) findViewById(R.id.days);
        calcular = (Button) findViewById(R.id.button_result);
        res = (TextView) findViewById(R.id.resultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double montoPrincipal = Double.parseDouble(amount.getText().toString());
                double tasaInteres = Double.parseDouble(interest.getText().toString());
                int diasAtraso = Integer.parseInt(days.getText().toString());

                // Cálculo del interés por mora
                double interesPorMora = montoPrincipal * (tasaInteres / 100) * (diasAtraso / 365.0);

                // Mostrar el resultado
                res.setText("Interés por Mora: $" + String.format("%.2f", interesPorMora));
            }
        });
    }
}
