/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4.controller;

import edu.cibertec.capitulo4.entity.UsuarioEntity;
import edu.cibertec.capitulo4.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adminfoco
 */
@Controller
@SessionAttributes("contador")
public class UsuarioController {
    @Autowired     
    private UsuarioService usuarioService; 
 
    @RequestMapping("loginMostrar")     
    public String loginMostrar() {         
        return "login";     
    }
    
    @RequestMapping("loginAccion")     
    public ModelAndView loginAccion(UsuarioEntity usuarioValida) {         
        ModelAndView mv = null;         
        
        UsuarioEntity ue = usuarioService.validarLogin(usuarioValida);         
        if (ue == null) {             
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen. Vuelva a intentar!");         
        } else {             
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());  
            mv.addObject("contador",0);
        }         
        return mv;     
    }
    
    @RequestMapping("usuarioCrear")
    public ModelAndView usuarioCrear(){
        return new ModelAndView("usuarioDatos","usuarioBean",new UsuarioEntity());
        
    }
    
    @RequestMapping("usuarioGrabar")
    public ModelAndView usuarioGrabar(@Valid @ModelAttribute("usuarioBean") UsuarioEntity usuarioValida,
            BindingResult result,ModelMap modelMap){
        
        ModelAndView mv=null;
        
        if (result.hasErrors()){
            mv=new ModelAndView("usuarioDatos","usuarioBean",usuarioValida);
        } else {
            usuarioService.insertaUsuario(usuarioValida);
            int contador =(int)modelMap.get("contador");
            contador++;
            
            mv= new ModelAndView("usuarioLista","lista",usuarioService.getListaUsuarios());
            mv.addObject("contador",contador);
        }
        
        return mv;
    }
    
    @RequestMapping("fotoMostrar")     
    public String fotoMostrar(HttpServletRequest request, 
            Model modelo) {         
        modelo.addAttribute("usuario", usuarioService.getUsuario(request.getParameter("codigoUsuario")));         
        return "fotoUsuario";     
    }
    
    @RequestMapping("fotoGrabar")     
    public ModelAndView fotoGrabar(@RequestParam("archivo") CommonsMultipartFile archivo,             
            @RequestParam("codigoUsuario") String codigoUsuario) {                  
        UsuarioEntity usuario = usuarioService.getUsuario(codigoUsuario);
        usuario.setFoto(archivo.getBytes());                  
        return new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());     
    } 
    
}
