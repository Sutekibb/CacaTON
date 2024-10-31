package com.example.ihm2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Buscar_Eliminar_Actualizar extends AppCompatActivity {

    EditText buscar, password, confirmPassword;
    TextView nombre, contra;
    Button botonBuscar, botonEliminar, botonActualizar, botonELiminarBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buscar_elminar_actualizar);
        buscar = findViewById(R.id.buscar);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmpassword);
        nombre = findViewById(R.id.nombre);
        contra = findViewById(R.id.contra);
        botonBuscar = findViewById(R.id.boton_buscar);
        botonEliminar = findViewById(R.id.boton_eliminar);
        botonActualizar = findViewById(R.id.boton_actualizar);
        botonELiminarBD = findViewById(R.id.boton_eliminarBD);

        DB db = new DB(getApplicationContext(), null, null, 1);
        botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = buscar.getText().toString();
                String[] datos = db.search_reg(search);

                if ("Encontrado".equals(datos[2])) {
                    nombre.setText("Usuario: " + datos[0]);
                    contra.setText("Contraseña: " + datos[1]);
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                    nombre.setText("");
                    contra.setText("");
                }
            }
        });

        botonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = buscar.getText().toString();
                String nuevaPassword = password.getText().toString();
                String confirmPasswordText = confirmPassword.getText().toString();

                if (nuevaPassword.isEmpty() || confirmPasswordText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no pueden estar vacías", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!nuevaPassword.equals(confirmPasswordText)) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                String mensaje = db.actualizarPassword(search, nuevaPassword);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
                nombre.setText("Usuario: " + search);
                contra.setText("Contraseña: " + nuevaPassword);
            }
        });

        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = buscar.getText().toString();
                String mensaje = db.eliminarUsuario(search);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();

                if (db.contarUsuarios() == 0) {
                    Intent intent = new Intent(Buscar_Eliminar_Actualizar.this, Sesion.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        botonELiminarBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.eliminarTodo();
                Toast.makeText(getApplicationContext(), "Todos los usuarios eliminados", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Buscar_Eliminar_Actualizar.this, Sesion.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
