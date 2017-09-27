package com.victorsaico.mbrtechnology;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private String username;
    private String password;
    private EditText email;
    private EditText passwordlogin;
    private String password1, email1;
    private Button btnInciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.edtemail);
        passwordlogin = (EditText) findViewById(R.id.edtpassword);
        btnInciar = (Button) findViewById(R.id.btnIniciar);
        List users = new ArrayList<>();
        users.add(new Usuario("alejandro","123","alejandro","cliente"));
        users.add(new Usuario("fernando","1234","luis","supervisor"));
        users.add(new Usuario("berrosqui","12345","ricardo","tecnico"));

        btnInciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReceptarCredenciles();
                 Validaruser();
            }
        });

    }
    public void ReceptarCredenciles(){
        email1 = email.getText().toString();
        password1 = passwordlogin.getText().toString();
        Toast.makeText(this,email1, Toast.LENGTH_SHORT).show();
    }
    public void Validaruser(){
        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        usuarioRepository.validarUsuario(email1, password1);

    }
}
