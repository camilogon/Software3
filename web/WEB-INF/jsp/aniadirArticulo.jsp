<%-- 
    Document   : Articulo
    Created on : 24-abr-2017, 15:48:37
    Author     : camilo
--%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/Articulo.htm" />">Listado de productos</a></li>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario</div>
                <div class="panel-body">

                    <form:form method="post" commandName="Articulo">
                        <h1>Formulario articulo</h1>

                        <form:errors path="*" element="div" cssClass="alert alert-danger" />

                        <p>
                            <form:label path="titulo">Titulo</form:label>
                            <form:input path="titulo" cssClass="form-control" />
                        </p>
                        <p>
                            <form:label path="precio">Precio</form:label>
                            <form:input path="precio" cssClass="form-control" />
                        </p>
                        <p>
                            <form:label path="cantidad">Cantidad</form:label>
                            <form:input path="cantidad" cssClass="form-control" />
                        </p>
                        <p>
                            <form:label path="ISBN">ISBN</form:label>
                            <form:input path="ISBN" cssClass="form-control" />
                        </p>
                        <p>
                            <form:label path="porcentajeoferta">Porcentaje Oferta</form:label>
                            <form:input path="porcentajeoferta" cssClass="form-control" />
                        </p>
                        <form:label path="fecha">fecha: </form:label>
                        <form:input path="fecha" type="text" class="form-control" placeholder="fecha" id="datepicker"/> 
                        <p>
                            <form:label path="oferta">Oferta: </form:label>
                            <form:input path="oferta" type="text" class="form-control"/> 
                        </p>
                        <p>
                            <form:label path="editorial">Editorial: </form:label>
                            <form:select path="editorial" class="form-control">
                                <c:forEach items="${datos2}" var="dato2">
                                <option><c:out value="${dato2.nombre}"/></option>
                            </c:forEach>
                        </form:select> 
                        </p>
                        <p>
                            <form:label path="autor">Autor: </form:label>
                            <form:select path="autor" class="form-control">
                                <c:forEach items="${datos}" var="dato">
                                <option><c:out value="${dato.nombre}"/></option>
                            </c:forEach>
                        </form:select> 
                        </p>
                        <p>
                            <form:label path="categoria">Categoria: </form:label>
                            <form:select path="categoria" class="form-control">
                                <c:forEach items="${datos3}" var="dato3">
                                <option><c:out value="${dato3.nombre}"/></option>
                            </c:forEach>
                        </form:select> 
                        </p>
                        <p>
                            <form:label path="formato">formato: </form:label>
                            <form:input path="formato" type="text" class="form-control"/> 
                        </p>
                        <p>
                            <form:label path="idioma">idioma: </form:label>
                            <form:input path="idioma" type="text" class="form-control"/> 
                        </p>
                        <p>
                            <form:label path="foto">foto:  </form:label>
                            <form:input path="foto" type="file" class="form-control"/> 
                        </p>

                        <input type="submit" value="Enviar" class="btn btn-danger" />
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
