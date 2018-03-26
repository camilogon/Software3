<%-- 
    Document   : Venta
    Created on : 11/06/2017, 10:42:11 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">

                <p>
                    <a href="<c:url value= "aniadirArticulo.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Editorial</th>
                            <th>autor</th>
                            <th>Categoria</th>
                            <th>Titulo</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Calificacion</th>
                            <th>Oferta</th>
                            <th>% Oferta</th>
                            <th>Idioma</th>
                            <th>FechaEdcion</th>
                            <th>Formato</th>
                            <th>ISBN</th>
                            <th>Foto</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${datos}" var="datos">
                        <tr>
                            <td><c:out value="${datos.idArticulo}" /></td>
                        <td><c:out value="${datos.autor}" /></td>
                        <td><c:out value="${datos.editorial}" /></td>
                        <td><c:out value="${datos.categoria}" /></td>
                        <td><c:out value="${datos.titulo}" /></td>
                        <td><c:out value="${datos.precio}" /></td>
                        <td><c:out value="${datos.cantidad}" /></td>
                        <td><c:out value="${datos.calificacion}" /></td>
                        <td><c:out value="${datos.oferta}" /></td>
                        <td><c:out value="${datos.porcentajeOferta}" /></td>
                        <td><c:out value="${datos.idioma}" /></td>
                        <td><c:out value="${datos.fechaEdicion}" /></td>
                        <td><c:out value="${datos.formato}" /></td>
                        <td><c:out value="${datos.ISBN}" /></td>
                        <td><c:out value="${datos.foto}" /></td>
                        <td>
                            <a href="<c:url value="editarArticulo.htm?id=${datos.idArticulo}" />"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                            <a href="<c:url value="eliminarArticulo.htm?id=${datos.idArticulo}" />"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
