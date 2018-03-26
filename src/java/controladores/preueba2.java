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
 * @author camilo
 */
@Controller
public class preueba2 {

    @RequestMapping("prueba2.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("prueba2");
        return mav;
    }

}
