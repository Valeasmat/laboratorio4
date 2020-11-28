/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.controller;

import edu.cibertec.capitulo4.entity.CursoEntity;
import edu.cibertec.capitulo4.entity.MatriculaEntity;
import edu.cibertec.capitulo4.entity.UsuarioEntity;
import edu.cibertec.capitulo4.service.CursoService;
import edu.cibertec.capitulo4.service.MatriculaService;
import edu.cibertec.capitulo4.service.UsuarioService;
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
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("matriculaMostrar")
    public ModelAndView matriculaMostrar() {
        ModelAndView mv = new ModelAndView("matricula", "listaMat", matriculaService.listaTodas());
        mv.addObject("listaUsu", usuarioService.getListaUsuarios());
        mv.addObject("listaCur", cursoService.consultaPorEstado(0));
        return mv;
    }

    @RequestMapping("matriculaGrabar")
    public ModelAndView matriculaGrabar(MatriculaEntity entity, HttpServletRequest request) {
        CursoEntity ce = new CursoEntity();
        ce.setIdcurso(Integer.parseInt(request.getParameter("cmbCurso")));
        UsuarioEntity ue = new UsuarioEntity();
        ue.setUsuario(request.getParameter("cmbUsuario"));
        entity.setCurso(ce);
        entity.setUsuario(ue);
        matriculaService.grabarMatricula(entity);
        return new ModelAndView("redirect:matriculaMostrar.htm");
    }

}
