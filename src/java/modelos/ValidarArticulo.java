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
public class ValidarArticulo implements Validator {

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
        Articulo articulo = (Articulo) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo",
                "required.titulo", "El campo Nombre es Obligatorio.");
        if (articulo.getTitulo().length() > 100) {
            errors.rejectValue("titulo", "titulo.incorrect",
                    "El titulo del articulo excede el limite de caracteres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precio",
                "required.precio", "El campo requiere un precio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cantidad",
                "required.cantidad", "El campo requiere la cantidad de articulos.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fecha",
                "required.fecha", "El campo requiere una calidicacion.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formato",
                "required.formato", "El debe tener un formato.");
        if (articulo.getTitulo().length() > 100) {
            errors.rejectValue("formato", "formato.incorrect",
                    "El formato del articulo excede el limite de caracteres");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ISBN",
                "required.ISBN", "El campo debe tener un ISBN.");
        if (articulo.getTitulo().length() > 100) {
            errors.rejectValue("ISBN", "ISBN.incorrect",
                    "El ISBN del articulo excede el limite de caracteres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "foto",
                "required.foto", "Debe cargar una foto para el articulo.");

    }

}
