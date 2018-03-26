/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author pc
 */
@Controller
public class Prueba {

    @RequestMapping("prueba.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("prueba");
        return mav;
    }

}
