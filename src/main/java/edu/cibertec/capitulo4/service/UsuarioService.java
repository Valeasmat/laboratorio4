/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.service;

import edu.cibertec.capitulo4.dao.UsuarioDAO;
import edu.cibertec.capitulo4.dao.repository.UsuarioRepositorio;
import edu.cibertec.capitulo4.entity.UsuarioEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adminfoco
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    public UsuarioEntity validarLogin(UsuarioEntity usuario){
        UsuarioEntity rpta=null;
        
        Optional<UsuarioEntity> busqueda=usuarioRepositorio.findById(usuario.getUsuario());
        if (busqueda.isPresent()){
            if(!busqueda.get().getClave().equalsIgnoreCase(usuario.getClave())){
                rpta=null;
            }else {
                rpta=busqueda.get();
            }
        }
        return rpta;
    }
    
    public void insertaUsuario(UsuarioEntity ue){
        usuarioDAO.insertaUsuario(ue);
    }
    
    public List<UsuarioEntity> getListaUsuarios(){
        return usuarioDAO.getListaUsuarios();
    }
    
    public UsuarioEntity getUsuario(String codigo) {
        return usuarioDAO.getUsuario(codigo);
    }
}
