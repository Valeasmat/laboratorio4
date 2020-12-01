/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.service;

import edu.cibertec.capitulo4.dao.repository.AuditoriaRepositorio;
import edu.cibertec.capitulo4.dao.repository.MatriculaRepositorio;
import edu.cibertec.capitulo4.entity.AuditoriaEntity;
import edu.cibertec.capitulo4.entity.MatriculaEntity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Adminfoco
 */
@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepositorio matriculaRepositorio;
    @Autowired
    private AuditoriaRepositorio auditoriaRepositorio;

    public List<MatriculaEntity> listaTodas() {
        return matriculaRepositorio.findAll();
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void grabarMatricula(MatriculaEntity me) {
        matriculaRepositorio.save(me);
        AuditoriaEntity ae= new AuditoriaEntity(0,new Date(Calendar.getInstance().getTimeInMillis()),null,"Insertando Matricula "+me.getIdmatricula());
        auditoriaRepositorio.save(ae);
    }
}
