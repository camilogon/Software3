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
import conexion.conexion;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelos.Articulo;
import modelos.ValidarArticulo;
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
public class ArticuloControlador {

    private ValidarArticulo validarArticulo;
    private DAOArticulo daoar;
    private DAOAutor daoau;
    private DAOEditorial daoed;
    private DAOCategoria cate;

    public ArticuloControlador() {
        this.validarArticulo = new ValidarArticulo();
        conexion con = new conexion();
        this.daoau = new DAOAutor();
        this.daoed = new DAOEditorial();
        this.cate = new DAOCategoria();
        this.daoar = new DAOArticulo();

    }

    @RequestMapping(value = "Articulo.htm", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        List datos = this.daoar.seleccionarArticulo();
        mav.addObject("datos", datos);
        mav.setViewName("Articulo");
        mav.addObject("Articulo", new Articulo());
        return mav;
    }

    @RequestMapping(value = "VerArticulos.htm", method = RequestMethod.GET)
    public ModelAndView home1() {
        boolean recomendados = false;

        List<Articulo> datos = this.daoar.seleccionarArticulosVistaDetallada(recomendados);
        List<String> codigosImagenes = codificarImagenes(datos);
        recomendados = true;
        List<Articulo> datos2 = this.daoar.seleccionarArticulosVistaDetallada(recomendados);
        List<String> codigosImagenes2 = codificarImagenes(datos2);
        return mapeoCatalogoVirtual(datos, codigosImagenes, datos2, codigosImagenes2);
    }

    public ModelAndView mapeoCatalogoVirtual(List<Articulo> datos,List<String> codigosImagenes,List<Articulo> datos2,List<String> codigosImagenes2) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("datos", datos);
        mav.addObject("imagenes", codigosImagenes);
        mav.addObject("datos2", datos2);
        mav.addObject("imagenes2", codigosImagenes2);
        mav.setViewName("VerArticulos");
        return mav;
    }

    /**
     *
     * @param articulos lista de articulos retornados de la clase DAOArticulo
     * @return una lista de String que representa cada archivo como una cadena
     * codificada en Base64
     */
    private List<String> codificarImagenes(List<Articulo> articulos) {
        List<String> codigosImagenes = new LinkedList<>();
        for (Articulo a : articulos) {
            codigosImagenes.add(Base64.encode(a.getFoto()));
        }
        return codigosImagenes;
    }

    @RequestMapping("eliminarArticulo.htm")
    public ModelAndView home(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.daoar.eliminaArticulo(id);
        return new ModelAndView("redirect:/Admin.htm");
    }

    /**
     * *
     * en este metodo Capturamos los datos de los autores de la editorial y de
     * las categorias
     *
     * @return retorna un mapeo de la informacion mencionada anteriormete a la
     * vsita
     */
    @RequestMapping(value = "aniadirArticulo.htm", method = RequestMethod.GET)
    public ModelAndView form() {
        List datos = this.daoau.seleccionarNombreAutores();
        List datos2 = this.daoed.seleccionarNombreEditorial();
        List datos3 = this.cate.seleccionarNombresCategorias();
        return MapearDatosArticulo(datos, datos2, datos3);
    }

    /**
     * *
     * mapea los datos de los autores, editoriales,y categorias
     *
     * @param datos datos de los autores
     * @param datos2 datos de las editoriales
     * @param datos3 datos de las categorias
     * @return retorna el mapeo de la informacion mencionada anteriormente
     */
    public ModelAndView MapearDatosArticulo(List datos, List datos2, List datos3) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("datos", datos);
        mav.addObject("datos2", datos2);
        mav.addObject("datos3", datos3);
        mav.setViewName("aniadirArticulo");
        mav.addObject("Articulo", new Articulo());
        return mav;
    }

    /**
     * valida los datos del articulo y si no hay errores guarda un nuevo archivo
     * mediante la clase DAOArticulo
     *
     * @param a Intancia de articulo a añadir
     *
     * @return un objeto de la clase ModelAndView redireccionando a la vista
     * correspondiente
     */
    @RequestMapping(value = "aniadirArticulo.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("Articulo") Articulo a,
            BindingResult result,
            SessionStatus status
    ) {
        this.validarArticulo.validate(a, result);
        if (result.hasErrors()) {
            List datos = this.daoau.seleccionarNombreAutores();
            List datos2 = this.daoed.seleccionarNombreEditorial();
            List datos3 = this.cate.seleccionarNombresCategorias();
            return MapearDatosArticulo(datos, datos2, datos3);
        } else {
            daoar.guardarArticulo(a);
            return new ModelAndView("redirect:/Admin.htm");
        }
    }

    /**
     * *
     * mapea los datos de los autores editoriales categorias y los datos del
     * articulo que se modificara
     *
     * @param datos nombre autores
     * @param datos2 nombre editoriales
     * @param datos3 nombres categoria
     * @param datos4 Articulo que se modificara
     * @param id id del articulo que se modificara
     * @return retorna el mapeo de los datos anteriores
     */
    public ModelAndView MapearEdicionArticulos(List datos, List datos2, List datos3, Articulo datos4, int id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("datos", datos);
        mav.addObject("datos2", datos2);
        mav.addObject("datos3", datos3);
        mav.addObject("datos4", datos4);
        mav.setViewName("editarArticulo");
        mav.addObject("Articulo", new Articulo(id, datos4.getEditorial(), datos4.getAutor(), datos4.getCategoria(),
                datos4.getTitulo(), datos4.getPrecio(), datos4.getCantidad(), datos4.getCalificacion(), datos4.getOferta(),
                datos4.getPorcentajeoferta(), datos4.getFecha(), datos4.getFormato(), datos4.getISBN(), datos4.getIdioma(),
                datos4.getFoto()));
        return mav;
    }

    @RequestMapping(value = "editarArticulo.htm", method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        List datos = this.daoau.seleccionarNombreAutores();
        List datos2 = this.daoed.seleccionarNombreEditorial();
        List datos3 = this.cate.seleccionarNombresCategorias();
        int id = Integer.parseInt(request.getParameter("id"));
        Articulo datos4 = selectArticulo(id);
        return MapearEdicionArticulos(datos, datos2, datos3, datos4, id);
    }

    /**
     * valida los datos del articulo y si no hay errores edita un articulo
     * mediante la clase DAOArticulo
     *
     * @param ar el articulo a editar
     * @return un objeto de la clase ModelAndView redireccionando a la vista
     * correspondiente
     */
    @RequestMapping(value = "editarArticulo.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("Articulo") Articulo ar,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        this.validarArticulo.validate(ar, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            List datos = this.daoau.seleccionarNombreAutores();
            List datos2 = this.daoed.seleccionarNombreEditorial();
            List datos3 = this.cate.seleccionarNombresCategorias();
            int id = Integer.parseInt(request.getParameter("id"));
            Articulo datos4 = this.selectArticulo(id);
            return MapearEdicionArticulos(datos, datos2, datos3, datos4, id);
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            this.daoar.editarArticulo(ar, id);
            return new ModelAndView("redirect:/Admin.htm");
        }

    }

    public Articulo selectArticulo(int id) {
        return daoar.seleccionarArticulo(id);
    }

}
