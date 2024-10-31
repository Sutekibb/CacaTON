package com.example.ihm2;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private ImageButton calculadora, videos, reports, config;
    private EditText busqueda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        calculadora = (ImageButton) findViewById(R.id.calculator_button);
        videos = (ImageButton) findViewById(R.id.button_documents);
        reports = (ImageButton) findViewById(R.id.button_reports);
        busqueda = (EditText) findViewById(R.id.search_box);
        config = (ImageButton) findViewById(R.id.button_config);
        reports.setOnClickListener(this);
        calculadora.setOnClickListener(this);
        videos.setOnClickListener(this);
        config.setOnClickListener(this);

        // Agregar listener para detectar "Enter" en el teclado
        busqueda.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    handleSearch(); // Llamada al método de búsqueda
                    return true;
                }
                return false;
            }
        });
    }

    @Override

    public void onClick(View view) {
        if (view.getId() == R.id.calculator_button) {
            Intent intentCalculadora = new Intent(Menu.this, Calculator.class);
            startActivity(intentCalculadora);
        } else if (view.getId() == R.id.button_documents){
            Intent intentDocuments = new Intent(Menu.this, Videos.class);
            startActivity(intentDocuments);
        }
        else if (view.getId() == R.id.button_reports){
            Intent intentReports = new Intent(Menu.this, Reports.class);
            startActivity(intentReports);
        }
        else if (view.getId() == R.id.button_config){
            Intent intentConfig = new Intent(Menu.this, Buscar_Eliminar_Actualizar.class);
            startActivity(intentConfig);
        }
    }

    private void handleSearch() {
        String query = busqueda.getText().toString().trim();

        if (query.equalsIgnoreCase("calculadora") || query.equalsIgnoreCase("Calculadora")) {
            Intent intentCalculadora = new Intent(Menu.this, Calculator.class);
            startActivity(intentCalculadora);
        } else if (query.equalsIgnoreCase("videos") || query.equalsIgnoreCase("Videos") || query.equalsIgnoreCase("Documentacio")
        || query.equalsIgnoreCase("documentacion")) {
            Intent intentVideos = new Intent(Menu.this, Videos.class);
            startActivity(intentVideos);
        } else if (query.equalsIgnoreCase("reportes") || query.equalsIgnoreCase("reportes")) {
            Intent intentReports = new Intent(Menu.this, Reports.class);
            startActivity(intentReports);
        } else {
            Toast.makeText(this, "No se encontró", Toast.LENGTH_SHORT).show();
        }
    }
}