/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author team Script
 */
@Controller
public class CarritoControlador {

    @RequestMapping("Carrito.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("Carrito");
        return mav;
    }
}
