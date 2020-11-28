/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.dao.repository;

import edu.cibertec.capitulo4.entity.MatriculaEntity; 
import org.springframework.data.jpa.repository.JpaRepository; 
/**
 *
 * @author Adminfoco
 */
public interface MatriculaRepositorio extends JpaRepository<MatriculaEntity, Integer> {
    
}
