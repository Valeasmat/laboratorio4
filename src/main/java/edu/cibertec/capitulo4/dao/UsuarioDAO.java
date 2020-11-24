/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.dao;

import edu.cibertec.capitulo4.entity.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Adminfoco
 */
@Repository
public class UsuarioDAO {
    
    private static List<UsuarioEntity> listaUsuarios;
    
    static{
        listaUsuarios=new ArrayList<>();
        listaUsuarios.add(new UsuarioEntity("jose","12345","Jose Perez"));
        listaUsuarios.add(new UsuarioEntity("maria","54321","Maria Qusipe"));
        listaUsuarios.add(new UsuarioEntity("yaddif","58475","Yaddif Medina"));
        listaUsuarios.add(new UsuarioEntity("olga","po54d","Olga Ibarra"));
    }
    
    public void insertaUsuario(UsuarioEntity ue){
        listaUsuarios.add(ue);
    }
    
    public List<UsuarioEntity> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public UsuarioEntity getUsuario(String codigo){
        UsuarioEntity rpta=null;
        
        for(UsuarioEntity usuario: listaUsuarios){
            if(usuario.getUsuario().equalsIgnoreCase(codigo)){
                rpta=usuario;
                break;
            }
        }
        return rpta;
    }
    
    public UsuarioEntity validaLogin(UsuarioEntity usuario){
        if (usuario.getUsuario().equalsIgnoreCase("user")&&
                usuario.getClave().equals("12345")){
            usuario.setNombreCompleto("Nombre completo del usuario");
        }
        else usuario=null;
        return usuario;
    }
    
}
