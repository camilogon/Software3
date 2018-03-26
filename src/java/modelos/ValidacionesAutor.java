/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.ValidationEventHandler;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author team Script
 */
public class ValidacionesAutor implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Autor.class.isAssignableFrom(type);
    }

    /**
     * 
     * @param o objeto a validar
     * @param errors imlementacion clase Errors de spring
     */
    @Override
    public void validate(Object o, Errors errors) {
        Autor usuarios = (Autor) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
                "required.nombre", "El campo Nombre es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion",
                "required.tipo", "El campo descripcion es Obligatorio.");
        if (usuarios.getDescripcion().length() > 200) {
            errors.rejectValue("correo", "descripcion.incorrect",
                    "la descripcion excede el limites de caracteres");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recomendado",
                "required.recomendado", "El campo Correo electrónico es Obligatorio.");
        if (usuarios.getRecomendado().length() > 200) {
            errors.rejectValue("correo", "recomendado.incorrect",
                    "el campo recomendado excede el limites de caracteres");
        }
    }

}
