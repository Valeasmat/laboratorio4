/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.capitulo4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Adminfoco
 */
@Controller
public class SaludoController {
    
    /*@RequestMapping("saludo")
    public String saludar(Model modelo){
        modelo.addAttribute("mensaje","Bienvenido desde el controlador");
        return "saludo";
    }*/
    
    /*@RequestMapping("saludo")
    public ModelAndView saludar(){
        ModelAndView mv= new ModelAndView();
        mv.addObject("mensaje","Bienvenido desde el MVC");
        mv.setViewName("saludo");
        return mv;
    }*/
    
    @RequestMapping("saludo")
    public ModelAndView saludar(){
        return new ModelAndView("saludo","mensaje","Bienvenido desde el MVC(corto)");
    }
}
