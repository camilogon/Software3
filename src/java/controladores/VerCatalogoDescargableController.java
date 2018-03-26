/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.Catalogo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author team Script
 */
@Controller
@RequestMapping("VerCatalogoDescargable.htm")
public class VerCatalogoDescargableController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("VerCatalogoDescargable");
        mav.addObject("VerCatalogoDescargable", new Catalogo());
        return mav;
    }
}
