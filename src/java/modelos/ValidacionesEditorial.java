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
public class ValidacionesEditorial implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        return Editorial.class.isAssignableFrom(type);
    }

    /**
     *
     * @param o objeto a validar
     * @param errors imlementacion clase Errors de spring
     */
    @Override
    public void validate(Object o, Errors errors) {
        Editorial ed = (Editorial) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre", "El campo nombre es obligatorio");
        if (ed.getNombre().length() > 50) {
            errors.rejectValue("nombre", "telefono.incorrect",
                    "El nombre del catalogo excede el limite de caracteres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correoContacto", "required.correoContacto", "El campo correoContacto es obligatorio");
        if (!(ed.getCorreoContacto() != null && ed.getCorreoContacto().isEmpty())) {
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(ed.getCorreoContacto());
            if (!matcher.matches()) {
                errors.rejectValue("correo", "correo.incorrect",
                        "El Correo electrónico " + ed.getCorreoContacto() + " no es válido");
            }
        }
    }

}
