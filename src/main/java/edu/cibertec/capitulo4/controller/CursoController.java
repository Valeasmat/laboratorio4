/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.controller;

import edu.cibertec.capitulo4.service.CursoService;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Adminfoco
 */
@Controller
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @RequestMapping("cursoMostrar")
    public String cursoMostrar() {
        return "cursoBusqueda";
    }

    @RequestMapping("cursoBusqueda")
    public ModelAndView loginAccion(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("cursoBusqueda");

        String tipoConsulta = request.getParameter("tipo");
        switch (tipoConsulta) {
            case "estado":
                int estado = Integer.parseInt(request.getParameter("estado"));
                mv.addObject("lista", cursoService.consultaPorEstado(estado));
                break;
            case "incompleto":
                mv.addObject("lista", cursoService.abiertoIncompleto());
                break;
            case "porfecha":
                Date fecha = Date.valueOf(request.getParameter("fecha"));
                mv.addObject("lista", cursoService.consultaPorFecha(fecha));
                break;
            case "faltante":
                int faltante = Integer.parseInt(request.getParameter("numero"));
                mv.addObject("lista", cursoService.consultaFaltantes(faltante));
                break;
            default:
                mv.addObject("lista", null);
                break;
        }

        return mv;
    } 
}
