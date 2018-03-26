package controladores;

import DAOs.DAOUsuario;
import conexion.conexion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import modelos.Usuarios;
import modelos.UsuariosValidar;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author team Script
 */
public class HomeController {

    private JdbcTemplate jdbcTemplate;
    private UsuariosValidar usuariosValidar;
    private DAOUsuario dao;

    public HomeController() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
        this.usuariosValidar = new UsuariosValidar();
        this.dao = new DAOUsuario();
    }

    @RequestMapping("home.htm")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("datos", this.dao.select());
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add");
        mav.addObject("usuarios", new Usuarios());
        return mav;
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("usuarios") Usuarios u,
            BindingResult result,
            SessionStatus status
    ) {
        this.usuariosValidar.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("add");
            mav.addObject("usuarios", new Usuarios());
            return mav;
        } else {
            this.dao.save(u);
            return new ModelAndView("redirect:/home.htm");
        }

    }

    @RequestMapping("delete.htm")
    public ModelAndView home(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        this.dao.detelte(id);
        return new ModelAndView("redirect:/home.htm");
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        Usuarios datos = this.selectUsuario(id);
        mav.setViewName("edit");
        mav.addObject("usuarios",
                new Usuarios(id, datos.getNombre(), datos.getApellido(),
                        datos.getCorreo(), datos.getContrasena(), datos.getNomUsuario(),
                        datos.getTelefono(), datos.getTipo()));
        return mav;
    }

    @RequestMapping(value = "edit.htm", method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("usuarios") Usuarios u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        this.usuariosValidar.validate(u, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            Usuarios datos = this.selectUsuario(id);
            mav.setViewName("edit");
            mav.addObject("usuarios", new Usuarios(id, datos.getNombre(), datos.getApellido(), datos.getCorreo(), datos.getContrasena(), datos.getNomUsuario(), datos.getTelefono(), datos.getTipo()));
            return mav;
        } else {
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            this.dao.editUsuarios(u, id);
            return new ModelAndView("redirect:/home.htm");
        }

    }

    public Usuarios selectUsuario(int id) {
        return dao.selectUsuario(id);
    }

}
