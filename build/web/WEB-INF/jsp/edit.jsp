<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Editar Info</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm" />">Listado de usuarios</a></li>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar</div>
                <div class="panel-body">
                   
                        <form:form method="post" commandName="usuarios">
                            <h1>Complete el formulario de edición</h1>
                            
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            
                            <p>
                                <form:label path="nombre">Nombre:</form:label>
                                <form:input path="nombre" cssClass="form-control" />
                                
                            </p>
                            
                            <p>
                                <form:label path="apellido">Apellido</form:label>
                                <form:input path="apellido" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="correo">Correo</form:label>
                                <form:input path="correo" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="contrasena">Contraseña</form:label>
                                <form:input path="contrasena" cssClass="form-control" />
                            </p>

                            <p>
                                <form:label path="nomUsuario">Nombre Usuario</form:label>
                                <form:input path="nomUsuario" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="telefono">Teléfono</form:label>
                                <form:input path="telefono" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="tipo">Tipo</form:label>
                                <form:input path="tipo" cssClass="form-control" />
                            </p>                            
                            <hr />
                            <input type="submit" value="Enviar" class="btn btn-danger" />
                        </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
