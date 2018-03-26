/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author team Script
 */
public class UsuariosValidar implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        return Usuarios.class.isAssignableFrom(type);
    }

    /**
     *
     * @param o objeto a validar
     * @param errors imlementacion clase Errors de spring
     */
    @Override
    public void validate(Object o, Errors errors) {
        Usuarios usuarios = (Usuarios) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
                "required.nombre", "El campo Nombre es Obligatorio.");
        if (usuarios.getNombre().length() > 50) {
            errors.rejectValue("nombre", "nombre.incorrect",
                    "El nombre " + usuarios.getNombre() + " eposee mas de 50 caracateres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido",
                "required.nombre", "El campo apellido es Obligatorio.");
        if (usuarios.getApellido().length() > 50) {
            errors.rejectValue("apellido", "apellido.incorrect",
                    "El apellido " + usuarios.getNombre() + " eposee mas de 50 caracateres");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo",
                "required.correo", "El campo Correo electrónico es Obligatorio.");

        if (!(usuarios.getCorreo() != null && usuarios.getCorreo().isEmpty())) {
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(usuarios.getCorreo());
            if (!matcher.matches()) {
                errors.rejectValue("correo", "correo.incorrect",
                        "El Correo electrónico " + usuarios.getCorreo() + " no es válido");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contrasena",
                "required.contrasena", "El campo contrasena es Obligatorio.");
        if (usuarios.getNombre().length() > 100 || usuarios.getNombre().length() < 7) {
            errors.rejectValue("contresena", "contrasena.incorrect",
                    "La contraseña debe tener ente 7 y 100 caracteres");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono",
                "required.telefono", "El campo Teléfono es Obligatorio.");
        if (usuarios.getTelefono().length() > 20) {
            errors.rejectValue("telefono", "telefono.incorrect",
                    "El telefono " + usuarios.getNombre() + " eposee mas de 20 caracateres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo",
                "required.tipo", "El campo tipo es Obligatorio.");
        if (usuarios.getTipo().length() > 20) {
            errors.rejectValue("tipo", "tipo.incorrect",
                    "El tipo " + usuarios.getNombre() + " eposee mas de 20 caracateres");
        }
    }
}
