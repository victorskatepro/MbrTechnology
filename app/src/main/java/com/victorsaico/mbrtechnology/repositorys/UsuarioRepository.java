package com.victorsaico.mbrtechnology.repositorys;

import android.util.Log;

import com.victorsaico.mbrtechnology.LoginActivity;
import com.victorsaico.mbrtechnology.models.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JARVIS on 25/09/2017.
 */

public class UsuarioRepository {
private static UsuarioRepository _INSTANCE = null;
    private static final String TAG = LoginActivity.class.getSimpleName();

    private UsuarioRepository(){
    }

    public static UsuarioRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new UsuarioRepository();
        return _INSTANCE;
    }
    private List<Usuario> usuarios = new ArrayList<>();
    public List<Usuario> getUsuarios(){
        return  this.usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    public String validarUsuario(String username, String password){
        String respuesta = null;
        Log.d(TAG, username);
        boolean acceso = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                acceso = true;
            }
        }
        if(acceso){
            respuesta = "paso";
        } else {
            respuesta = "nada";
        }
        return respuesta;
    }
    public String Asignar(String email){
        String rol1 = null;
        boolean rol = false;
        for (Usuario usuario :usuarios) {
             if(usuario.getUsername().equals(email)){
                 rol1 = usuario.getRol().toString();
                 rol = true;
                 break;
             }
        }
        return rol1;
    }
}
