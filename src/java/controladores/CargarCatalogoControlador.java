/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAOs.DAOCatalogo;
import DAOs.DAOEditorial;
import conexion.conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelos.Catalogo;
import modelos.ValidacionesCatalogo;
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

public class CargarCatalogoControlador {

    private ValidacionesCatalogo validacionesCatalogo;
    private DAOEditorial daoed;
    private DAOCatalogo daocat;

    public CargarCatalogoControlador() {
        this.validacionesCatalogo = new ValidacionesCatalogo();
        conexion con = new conexion();
        this.daoed = new DAOEditorial();
        this.daocat = new DAOCatalogo();

    }

    @RequestMapping(value = "VerCatalogos.htm", method = RequestMethod.GET)
    public ModelAndView home1() {
        ModelAndView mav = new ModelAndView();
        List<Catalogo> datos = this.daocat.seleccionarCatalogoVistaGeneral();        
        mav.addObject("datos", datos);        
        mav.setViewName("VerCatalogos");
        return mav;
    }
 
    @RequestMapping(value = "CargarCatalogo.htm", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();        
        mav.addObject("datos2", this.daocat.seleccionarCatalogos());
        mav.setViewName("CargarCatalogo");
        mav.addObject("catalogo", new Catalogo());
        return mav;
    }

    @RequestMapping(value = "anadirCatalogo.htm", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        List datos2 = this.daoed.seleccionarNombreEditorial();
        mav.addObject("datos2", datos2);
        mav.setViewName("anadirCatalogo");
        mav.addObject("CargarCatalogo", new Catalogo());
        return mav;
    }

    /**
     * valida los datos de un catalogo y si no hay errores guarda uno nuevo mediante
     * la clase DAOCatalogo
     * @param a catalogo a guardar
     * 
     * @return un objeto de la calse ModelAndView redireccionando a la vista correspondiente
     */
    @RequestMapping(value = "anadirCatalogo.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("CargarCatalogo") Catalogo a,
            BindingResult result,
            SessionStatus status
    ) {
        if (a.getArchivo() != null) {
            String ruta = "assets/catalogos/";
            a.setArchivo(ruta + a.getArchivo());
        }
        this.validacionesCatalogo.validate(a, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            List datos2 = this.daoed.seleccionarNombreEditorial();
            mav.addObject("datos2", datos2);
            mav.setViewName("anadirCatalogo");
            mav.addObject("CargarCatalogo", new Catalogo());
            return mav;
        } else {
            daocat.guardarCatalogo(a);
            return new ModelAndView("redirect:/Admin.htm");
        }

    }

    @RequestMapping("eliminarCatalogo.htm")
    public ModelAndView home(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.daocat.eliminarCatalogo(id);
        return new ModelAndView("redirect:/Admin.htm");
    }

    
    @RequestMapping(value = "editarCatalogo.htm", method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        List datos = this.daoed.seleccionarNombreEditorial();
        mav.addObject("datos", datos);
        int id = Integer.parseInt(request.getParameter("id"));
        Catalogo cat = selectCatalogo(id);
        mav.setViewName("editarCatalogo");
        mav.addObject("CargarCatalogo", new Catalogo(id,
                cat.getNombre(), cat.getFecha(), cat.getArchivo(), cat.getEditorial()));
        return mav;
    }

    
     /**
     * valida los datos de un catalogo y si no hay errores edita  mediante
     * la clase DAOCatalogo
     
     * 
     * @return un objeto de la clase ModelAndView redireccionando a la vista correspondiente
     */
    @RequestMapping(value = "editarCatalogo.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("CargarCatalogo") Catalogo cat,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        if (cat.getArchivo().length() == 0) {
            int id = Integer.parseInt(request.getParameter("id"));
            Catalogo cata = daocat.seleccionarCatalogo(id);
            if (cata.getArchivo() != null) {
                cat.setArchivo(cata.getArchivo());
            }
        } else {
            String ruta = "assets/catalogos/";
            cat.setArchivo(ruta + cat.getArchivo());
        }
        this.validacionesCatalogo.validate(cat, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("id"));
            Catalogo datos = this.selectCatalogo(id);
            mav.setViewName("editarCatalogo");
            mav.addObject("Catalogo", new Catalogo(id, cat.getNombre(), cat.getFecha(), cat.getArchivo(), cat.getEditorial()));
            return mav;
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            this.daocat.editarCatalogo(cat, id);
            return new ModelAndView("redirect:/Admin.htm");
        }

    }

    public Catalogo selectCatalogo(int id) {
        return daocat.seleccionarCatalogo(id);
    }

}
