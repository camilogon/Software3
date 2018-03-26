<%-- 
    Document   : addEditorial
    Created on : 28/03/2017, 08:10:07 PM
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/editorial.htm" />">Listado de productos</a></li>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">

                    <form:form method="post" commandName="editorial">
                        <h1>Complete el formulario</h1>

                        <form:errors path="*" element="div" cssClass="alert alert-danger" />

                        <p>
                            <form:label path="nombre">Nombre:</form:label>
                            <form:input path="nombre" cssClass="form-control" />

                        </p>

                        <p>
                            <form:label path="correoContacto">Correo Contacto</form:label>
                            <form:input path="correoContacto" cssClass="form-control" />
                        </p>
                        
                        <p>
                            <form:label path="telefonoContacto">Telefono Contacto</form:label>
                            <form:input path="telefonoContacto" cssClass="form-control" />
                        </p>
                        
                        <p>
                            <form:label path="direccion">Direccion</form:label>
                            <form:input path="direccion" cssClass="form-control" />
                        </p>
                        <hr />
                        <input type="submit" value="Enviar" class="btn btn-danger" />
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
