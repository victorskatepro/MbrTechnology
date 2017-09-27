package com.victorsaico.mbrtechnology;

import android.util.Log;

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
    public void validarUsuario(String username, String password){
         if(getUsuarios().equals(username) && getUsuarios().equals(password)){
             Log.d(TAG, "Ingresaando a sendExplicit");
         }else {
             Log.d(TAG, "NO INGRESO");
         }
    }
}
