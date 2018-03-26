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
public class ValidacionesCategoria implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Categoria.class.isAssignableFrom(type);
    }

    /**
     *
     * @param o objeto a validar
     * @param errors imlementacion clase Errors de spring
     */
    @Override
    public void validate(Object o, Errors errors) {
        Categoria categorias = (Categoria) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
                "required.nombre", "El campo Nombre es Obligatorio.");
        if (categorias.getNombre().length() > 50) {
            errors.rejectValue("nombre", "telefono.incorrect",
                    "El nombre del catalogo excede el limite de caracteres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion",
                "required.descripcion", "El campo descripcion es obligatorio.");
        if (categorias.getDescripcion().length() > 200) {
            errors.rejectValue("descripcion", "telefono.incorrect",
                    "El nombre del catalogo excede el limite de caracteres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "influencia",
                "required.influencia", "Influencia es obligatoria.");
        if (categorias.getDescripcion().length() > 200) {
            errors.rejectValue("Influencia", "telefono.incorrect",
                    "El nombre del Influencia excede el limite de caracteres");
        }
    }

}
