package com.fabricodedev.appleido;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    private EditText etNombreUsuario;
    private EditText etContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Ajuste de los bordes de la pantalla, debe ir aquí
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener las referencias de los EditText por su ID
        etNombreUsuario = findViewById(R.id.et_nombre_usuario);
        etContrasena = findViewById(R.id.et_contrasena);

        // Ejemplo: Obtener los datos al presionar un botón
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto de los EditText
                String nombreUsuario = etNombreUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();

                // Aquí puedes usar las variables (por ejemplo, para validar)
                // System.out.println("Usuario: " + nombreUsuario);
                // System.out.println("Contraseña: " + contrasena);
            }
        });
        TextView registroLink = findViewById(R.id.registro_link);

        registroLink.setOnClickListener(v -> {
            // Crea un Intent para ir a la pantalla de registro
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            // Inicia la nueva Activity
            startActivity(intent);
        });
    }
}