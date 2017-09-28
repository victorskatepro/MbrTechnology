package com.victorsaico.mbrtechnology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.victorsaico.mbrtechnology.models.Usuario;
import com.victorsaico.mbrtechnology.repositorys.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

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
        List<Usuario>  users= new ArrayList<>();
        users.add(new Usuario("berrosqui","12345","ricardo","tecnico"));
        users.add(new Usuario("fernando","1234","luis","supervisor"));
        users.add(new Usuario("alejandro","123","alejandro","cliente"));
        UsuarioRepository.getInstance().setUsuarios(users);

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
    }
    public void Validaruser(){
        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
      String respues =  usuarioRepository.validarUsuario(email1, password1);
       switch (respues){
           case "paso":
               Intent i = new Intent(this, MainActivity.class);
               i.putExtra("rol", email1);
               startActivity(i);
               break;
           case "nada":
               Toast.makeText(this, respues, Toast.LENGTH_SHORT).show();
               new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                       .setTitleText("Oops")
                       .setContentText("Usuario no registrado")
                       .show();
       }
    }
}
