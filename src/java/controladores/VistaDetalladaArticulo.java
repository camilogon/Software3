/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAOs.DAOArticulo;
import DAOs.DAOAutor;
import DAOs.DAOCategoria;
import DAOs.DAOEditorial;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import javax.servlet.http.HttpServletRequest;
import modelos.Articulo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author team Script
 */
@Controller
public class VistaDetalladaArticulo {

    private DAOArticulo daoAr;
    private DAOAutor daoAutor;
    private DAOEditorial daoEditorial;
    private DAOCategoria daoCategoria;

    public VistaDetalladaArticulo() {
        daoAr = new DAOArticulo();
        daoAutor = new DAOAutor();
        daoEditorial = new DAOEditorial();
        daoCategoria = new DAOCategoria();
    }

    
    @RequestMapping("VistaDetalladaArticulo.htm")
    public ModelAndView home(HttpServletRequest request) {
        int idArt = Integer.parseInt(request.getParameter("id"));
        Articulo ar = daoAr.seleccionarArticulo(idArt);
        ar.setAutor(daoAutor.seleccionarAutor(Integer.parseInt(ar.getAutor())).getNombre());
        ar.setEditorial(daoEditorial.seleccionarEditorial(Integer.parseInt(ar.getEditorial())).getNombre());
        ar.setCategoria(daoCategoria.SeleccionarCategoria(Integer.parseInt(ar.getCategoria())).getNombre());
        ar.setIdArticulo(idArt);
        ModelAndView mav = new ModelAndView();
        String imgn = Base64.encode(ar.getFoto());
        mav.addObject("articulo", ar);
        mav.addObject("imagen", imgn);
        mav.setViewName("VistaDetalladaArticulo");
        return mav;
    }

}
