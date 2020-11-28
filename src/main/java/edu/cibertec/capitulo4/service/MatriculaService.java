/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.service;

import edu.cibertec.capitulo4.dao.repository.MatriculaRepositorio;
import edu.cibertec.capitulo4.entity.MatriculaEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Adminfoco
 */
@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepositorio matriculaRepositorio;

    public List<MatriculaEntity> listaTodas() {
        return matriculaRepositorio.findAll();
    }

    public void grabarMatricula(MatriculaEntity me) {
        matriculaRepositorio.save(me);
    }
}
