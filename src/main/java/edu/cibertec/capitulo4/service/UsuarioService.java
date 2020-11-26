/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.service;

import edu.cibertec.capitulo4.dao.repository.UsuarioRepositorio;
import edu.cibertec.capitulo4.entity.UsuarioEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adminfoco
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    public UsuarioEntity validarLogin(UsuarioEntity usuario){
        UsuarioEntity rpta=usuarioRepositorio.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
        
        /*UsuarioEntity rpta=null;
        Optional<UsuarioEntity> busqueda=usuarioRepositorio.findById(usuario.getUsuario());
        if (busqueda.isPresent()){
            if(!busqueda.get().getClave().equalsIgnoreCase(usuario.getClave())){
                rpta=null;
            }else {
                rpta=busqueda.get();
            }
        }*/
        return rpta;
    }
    
    public void insertaUsuario(UsuarioEntity ue) {
        usuarioRepositorio.save(ue);
    }

    public void eliminarUsuario(String codigo) {
        usuarioRepositorio.deleteById(codigo);
    }

    public List<UsuarioEntity> getListaUsuarios() {
        return usuarioRepositorio.findAll();
    }
    
    public List<UsuarioEntity> getListaUsuarios(Pageable pagina) {
        return usuarioRepositorio.findAll(pagina).getContent();
    }

    public UsuarioEntity getUsuario(String codigo) {
        UsuarioEntity rpta = null;
        Optional<UsuarioEntity> busqueda = usuarioRepositorio.findById(codigo);
        if (busqueda.isPresent()) {
            rpta = busqueda.get();
        }
        return rpta;
    }
}
