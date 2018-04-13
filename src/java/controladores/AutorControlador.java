package controladores;

import DAOs.DAOAutor;
import conexion.conexion;
import javax.servlet.http.HttpServletRequest;
import modelos.Autor;
import modelos.ValidacionesAutor;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class AutorControlador {

    private JdbcTemplate jdbcTemplate;
    private DAOAutor dao;
    ValidacionesAutor AutorValidar;

    public AutorControlador() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        this.dao = new DAOAutor();
        this.AutorValidar = new ValidacionesAutor();
    }

    @RequestMapping("autor.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("datos", dao.seleccionarAutor());
        mav.setViewName("autor");
        return mav;
    }

    @RequestMapping(value = "addAutor.htm", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addAutor");
        mav.addObject("autor", new Autor());
        return mav;
    }

    /**
       valida los datos de un autor y si no hay errores añade uno mediante
     * la clase DAOAutor
     * @param a el autor a añadir
     * 
     * @return 
     */
    @RequestMapping(value = "addAutor.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("autor") Autor a,
            BindingResult result,
            SessionStatus status
    ) {
        this.AutorValidar.validate(a, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addAutor");
            mav.addObject("autor", new Autor());
            return mav;
        } else {
            this.dao.guardarAutor(a);
            return new ModelAndView("redirect:/Admin.htm");
        }
    }

    @RequestMapping("deleteAutor.htm")
    public ModelAndView home(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.dao.eliminarAutor(id);
        return new ModelAndView("redirect:/Admin.htm");
    }

    @RequestMapping(value = "editAutor", method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Autor datos = this.selectUsuario(id);
        mav.setViewName("editAutor");
        mav.addObject("autor", new Autor(id, datos.getNombre(), datos.getDescripcion(), datos.getRecomendado()));
        return mav;
    }

    /**
     * valida los datos de un autor y si no hay errores edita  mediante
     * la clase DAOAutor
     * @param u autor a editar 
     * 
     * @return un objeto de la clase ModelAndView redireccionando a la vista correspondiente
     */
    @RequestMapping(value = "editAutor", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("autor") Autor u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        this.AutorValidar.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("id"));
            Autor datos = this.selectUsuario(id);
            mav.setViewName("editAutor");
            mav.addObject("autor", new Autor(id, datos.getNombre(), datos.getDescripcion(), datos.getRecomendado()));
            return mav;
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            this.dao.editarAutor(u, id);
            return new ModelAndView("redirect:/Admin.htm");
        }

    }

    public Autor selectUsuario(int id) {
        return this.dao.seleccionarAutor(id);
    }

}
