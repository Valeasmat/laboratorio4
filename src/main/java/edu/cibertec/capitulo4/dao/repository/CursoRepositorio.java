/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.dao.repository;

import edu.cibertec.capitulo4.entity.CursoEntity;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Adminfoco
 */
public interface CursoRepositorio  extends JpaRepository<CursoEntity, Integer> {
    //Consulta de Cursos por estado     
    @Query("SELECT c FROM CursoEntity c WHERE c.estado = ?1")
    public List<CursoEntity> consultaPorEstado(int estado);          
    //Consulta de Cursos abiertos pero aún no completos     
    //Lo trae desde el NamedQuery de la entidad !!     
    public List<CursoEntity> abiertoIncompleto();          
    //Consulta de Cursos después de la fecha X     
    @Query("SELECT c FROM CursoEntity c WHERE c.fechaInicio >= :fecha")     
    public List<CursoEntity> consultaPorFecha(@Param("fecha") Date fecha);         
    //Consulta de Cursos a los que les falta X números de alumnos para llenarse     
    //Nativa !!     
    @Query(value = "SELECT * FROM Curso WHERE alumnosMin - alumnosAct = :cantidad",              
            nativeQuery = true)     
    public List<CursoEntity> consultaFaltantes(@Param("cantidad") Integer cantidad);
    
}
