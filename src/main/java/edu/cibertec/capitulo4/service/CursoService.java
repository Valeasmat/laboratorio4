/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.service;

import edu.cibertec.capitulo4.dao.repository.CursoRepositorio;
import edu.cibertec.capitulo4.entity.CursoEntity;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Adminfoco
 */
@Service
public class CursoService {
    @Autowired
    private CursoRepositorio cursoRepositorio;

    public List<CursoEntity> consultaPorEstado(int estado) {
        return cursoRepositorio.consultaPorEstado(estado);
    }

    public List<CursoEntity> abiertoIncompleto() {
        return cursoRepositorio.abiertoIncompleto();
    }

    public List<CursoEntity> consultaPorFecha(Date fecha) {
        return cursoRepositorio.consultaPorFecha(fecha);
    }

    public List<CursoEntity> consultaFaltantes(Integer cantidad) {
        return cursoRepositorio.consultaFaltantes(cantidad);
    }
    
}
