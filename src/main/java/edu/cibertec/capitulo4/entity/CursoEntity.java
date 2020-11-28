/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.entity;

import java.sql.Date; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 *
 * @author Adminfoco
 */
@Entity
@Table(name = "curso")
@NamedQuery(name = "CursoEntity.abiertoIncompleto", query = "SELECT c FROM CursoEntity c WHERE c.alumnosMin > c.alumnosAct and c.estado=1")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;
    private String nomCurso;
    private Date fechaInicio;
    private Integer alumnosMin;
    private Integer alumnosAct;
    private Integer estado;

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getAlumnosMin() {
        return alumnosMin;
    }

    public void setAlumnosMin(Integer alumnosMin) {
        this.alumnosMin = alumnosMin;
    }

    public Integer getAlumnosAct() {
        return alumnosAct;
    }
    
    public void setAlumnosAct(Integer alumnosAct) {
        this.alumnosAct = alumnosAct;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

}
