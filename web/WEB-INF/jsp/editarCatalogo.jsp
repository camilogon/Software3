<%-- 
    Document   : editarCatalogo
    Created on : 24-may-2017, 19:17:47
    Author     : camilo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <link rel="stylesheet" href="/resources/demos/style.css"/>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <script>
            $(function () {
                $("#datepicker").datepicker({'dateFormat': "yy-mm-dd", });
            });
        </script>
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div class="container">
            <center>
                <div class="panel panel-primary">
                    <div class="panel-heading">cargar catalogo</div>
                    <div class="panel-body">

                        <form:form method="post" commandName="CargarCatalogo">
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            <p>
                            <form:label path="nombre">Nombre: </form:label>
                            <form:input path="nombre" cssClass="form-control" />
                            </p>

                            <p>
                            <form:label path="fecha">Fecha: </form:label>
                            <form:input path="fecha" type="text" cssClass="form-control" placeholder="fecha"  id="datepicker"/> 
                            </p>
                            <p>
                            <form:label path="editorial">Editorial: </form:label>
                            <form:select path="editorial" cssClass="form-control">
                                <c:forEach items="${datos}" var="datos">
                                    <option><c:out value="${datos.nombre}"/></option>
                                </c:forEach>
                            </form:select> 
                            </p>
                            <p>
                            <form:label path="archivo">Catalogo:  </form:label>
                            <form:input path="archivo" type="file" cssClass="form-control"/> 
                            </p>

                            <P>
                                <input type="submit" value="Enviar" class="btn btn-danger" />
                            </P>
                        </form:form>
                    </div>
                </div>

            </center>
        </div>

    </body>
</html>

