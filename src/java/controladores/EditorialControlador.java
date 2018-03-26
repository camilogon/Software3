/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAOs.DAOEditorial;
import conexion.conexion;
import javax.servlet.http.HttpServletRequest;
import modelos.Editorial;
import modelos.ValidacionesEditorial;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author team Script
 */
@Controller
public class EditorialControlador {

    private DAOEditorial dao;
    private ValidacionesEditorial validar;

    public EditorialControlador() {
        conexion con = new conexion();
        this.dao = new DAOEditorial();
        this.validar = new ValidacionesEditorial();
    }

    @RequestMapping("editorial.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("datos", this.dao.seleccionarEditorial());
        mav.setViewName("editorial");
        return mav;
    }

    @RequestMapping("deleteEditorial.htm")
    public ModelAndView home(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("idEditorial"));
        this.dao.eliminarEditorial(id);
        return new ModelAndView("redirect:/editorial.htm");
    }

    @RequestMapping(value = "editEditorial.htm", method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("idEditorial"));
        Editorial datos = selectEditorial(id);
        mav.setViewName("editEditorial");
        mav.addObject("editorial", new Editorial(id, datos.getNombre(), datos.getCorreoContacto(), datos.getTelefonoContacto(), datos.getDireccion()));
        return mav;
    }

    @RequestMapping(value = "editEditorial.htm", method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("editorial") Editorial e, BindingResult result, SessionStatus status, HttpServletRequest request) {
        validar.validate(e, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("idEditorial"));
            Editorial datos = this.selectEditorial(id);
            mav.setViewName("editEditorial");
            mav.addObject("editorial", new Editorial(id, datos.getNombre(), datos.getCorreoContacto(), datos.getTelefonoContacto(), datos.getDireccion()));
            return mav;
        } else {
            int id = Integer.parseInt(request.getParameter("idEditorial"));
            this.dao.editarEditorial(e, id);
            return new ModelAndView("redirect:/editorial.htm");
        }

    }

    private Editorial selectEditorial(int id) {
        return this.dao.seleccionarEditorial(id);
    }

    @RequestMapping(value = "addEditorial.htm", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addEditorial");
        mav.addObject("editorial", new Editorial());
        return mav;
    }

    @RequestMapping(value = "addEditorial.htm", method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("editorial") Editorial e, BindingResult result, SessionStatus status) {
        validar.validate(e, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addEditorial");
            mav.addObject("editorial", new Editorial());
            return mav;
        } else {
            this.dao.guardarEditorial(e);
            return new ModelAndView("redirect:/editorial.htm");
        }
    }

}
