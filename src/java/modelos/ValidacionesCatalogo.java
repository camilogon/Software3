/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author team Script
 */
public class ValidacionesCatalogo implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param o objeto a validar
     * @param errors imlementacion clase Errors de spring
     */
    @Override
    public void validate(Object o, Errors errors) {
        Catalogo cat = (Catalogo) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
                "required.nombre", "El campo Nombre es Obligatorio.");
        if (cat.getNombre().length() > 50) {
            errors.rejectValue("nombre", "telefono.incorrect",
                    "El nombre del catalogo excede el limite de caracteres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha",
                "required.fecha", "La fecha en que se ingreso el Catalogo es obligatoria.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "archivo", "required.archivo", "El catalogo debe ser cargado.");
    }

}
