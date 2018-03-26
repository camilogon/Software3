package controladores;

import DAOs.DAOCategoria;
import java.util.List;
import conexion.conexion;
import javax.servlet.http.HttpServletRequest;
import modelos.Categoria;
import modelos.ValidacionesCategoria;
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
public class CategoriaControlador {

    private ValidacionesCategoria CategoriaValidar;
    private DAOCategoria categoria;

    public CategoriaControlador() {
        conexion con = new conexion();
        this.CategoriaValidar = new ValidacionesCategoria();
        this.categoria = new DAOCategoria();
    }

    @RequestMapping("categoria.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        List datos = this.categoria.seleccionarCategorias();
        mav.addObject("datos", datos);
        mav.setViewName("categoria");
        return mav;
    }

    @RequestMapping(value = "addCategoria.htm", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addCategoria");
        mav.addObject("categoria", new Categoria());
        return mav;
    }

    @RequestMapping(value = "addCategoria.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("categoria") Categoria a,
            BindingResult result,
            SessionStatus status
    ) {
        this.CategoriaValidar.validate(a, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addCategoria");
            mav.addObject("categoria", new Categoria());
            return mav;
        } else {
            this.categoria.guardarCategoria(a);
            return new ModelAndView("redirect:/Admin.htm");
        }

    }

    @RequestMapping("deleteCategoria.htm")
    public ModelAndView home(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        categoria.eliminarCategoria(id);
        return new ModelAndView("redirect:/Admin.htm");
    }

    @RequestMapping(value = "editCategoria.htm", method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Categoria datos = this.categoria.SeleccionarCategoria(id);
        mav.setViewName("editCategoria");
        mav.addObject("categoria", new Categoria(id, datos.getNombre(), datos.getDescripcion(), datos.getInfluencia()));
        return mav;
    }

    @RequestMapping(value = "editCategoria.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("categoria") Categoria u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        this.CategoriaValidar.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("id"));
            Categoria datos = this.categoria.SeleccionarCategoria(id);
            mav.setViewName("editCategoria");
            mav.addObject("categoria", new Categoria(id, datos.getNombre(), datos.getDescripcion(), datos.getInfluencia()));
            return mav;
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            this.categoria.editarCategoria(u, id);
            return new ModelAndView("redirect:/Admin.htm");
        }

    }

}
