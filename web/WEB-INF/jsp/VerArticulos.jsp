<%-- 
    Document   : VerArticulos
    Created on : 25/05/2017, 10:16:34 AM
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"   %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="./assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Distribuidora circulo Caldas</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- CSS Files -->
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="./assets/css/now-ui-kit.css" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="./assets/css/demo.css" rel="stylesheet" />

        <script src="./assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
        <script src="./assets/js/core/tether.min.js" type="text/javascript"></script>
        <script src="./assets/js/core/bootstrap.min.js" type="text/javascript"></script>
        <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
        <script src="./assets/js/plugins/bootstrap-switch.js"></script>
        <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
        <script src="./assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
        <!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
        <script src="./assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
        <!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
        <script src="./assets/js/now-ui-kit.js" type="text/javascript"></script>

    </head>
    <body class="index-page">
        <nav class="navbar navbar-toggleable-md bg-primary fixed-top navbar-transparent " color-on-scroll="300" >
            <div class="container" style="background:#0B337F">            
                <div class="navbar-translate">
                    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar bar1"></span>
                        <span class="navbar-toggler-bar bar2"></span>
                        <span class="navbar-toggler-bar bar3"></span>
                    </button>

                    <a class="navbar-brand" href="index.htm" rel="tooltip" title="Designed by Invision. Coded by Creative Tim" data-placement="bottom" target="_blank">
                        <img class="d-block" src="assets/img/small.png"> 
                    </a>
                </div>


                <div class="collapse navbar-collapse justify-content-end" id="navigation" data-nav-image="./assets/img/blurred-image-1.jpg">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">		
                                <i class="now-ui-icons education_agenda-bookmark"></i>
                                <p>Libros </p>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="VerArticulos.htm">A-Z</a>
                                <a class="dropdown-item" href="#">Autor</a>
                                <a class="dropdown-item" href="#">Categoria</a>
                                <a class="dropdown-item" href="#">Editorial</a>
                                <a class="dropdown-item" href="#">Género</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="VerCatalogos.htm" target="_blank">
                                <i class="now-ui-icons files_single-copy-04"></i>
                                <p>Catalogo</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)" onclick="scrollToDownload()">
                                <i class="now-ui-icons users_single-02"></i>
                                <p>Usuario</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Carrito.htm" target="_blank">
                                <i class="now-ui-icons shopping_cart-simple"></i>
                                <p>Compras</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="wrapper ">  
            <div class="page-header clear-filter" filter-color="blue">
                <div class="page-header-image" data-parallax="true">
                </div>
                <div class="container" style="height:100px"></div>
                <div class="container">
                    <h1>Recomendados</h1>
                    <div class="row">
                        <c:forEach var="i" begin="0" end="${fn:length(datos2)-1}">
                            <div class="col-lg-3 col-md-12">
                                <a href="<c:url value="VistaDetalladaArticulo.htm?id=${datos2.get(i).idArticulo}"/>">
                                <!--<img src="<c:out value="${datos2.get(i).foto}" />" alt="Thumbnail Image" class="rounded img-raised img-responsive" width='50%' height='50%'>-->
                                    <img src="data:image/jpg;base64,<c:out value="${imagenes2.get(i)}" />" alt="Thumbnail Image" class="rounded img-raised img-responsive" width='50%' height='50%'>
                                </a>
                                <p>
                                <h6> <c:out value="${datos2.get(i).titulo}"/></h6>
                                <p>
                                <h5>$ <c:out value="${datos2.get(i).precio}"/></h5>
                            </div>
                        </c:forEach>
                    </div>         
                </div>
            </div>      
        </div>
        
        <div class="wrapper ">  
            <div class="page-header clear-filter" filter-color="blue">
                <div class="page-header-image" data-parallax="true">
                </div>
                <div class="container" style="height:100px"></div>
                <div class="container">
                    <h1>Productos</h1>
                    <div class="row">
                        <c:forEach var="i" begin="0" end="${fn:length(datos)-1}">
                            <div class="col-lg-3 col-md-12">
                                <a href="<c:url value="VistaDetalladaArticulo.htm?id=${datos.get(i).idArticulo}"/>">
                                <!--<img src="<c:out value="${datos.get(i).foto}" />" alt="Thumbnail Image" class="rounded img-raised img-responsive" width='50%' height='50%'>-->
                                    <img src="data:image/jpg;base64,<c:out value="${imagenes.get(i)}" />" alt="Thumbnail Image" class="rounded img-raised img-responsive" width='50%' height='50%'>
                                </a>
                                <p>
                                <h6> <c:out value="${datos.get(i).titulo}"/></h6>
                                <p>
                                <h5>$ <c:out value="${datos.get(i).precio}"/></h5>
                            </div>
                        </c:forEach>
                    </div>         
                </div>
            </div>      
        </div>
        <footer class="footer" data-background-color="blue">
            <div class="container">
                <nav>
                    <ul>
                        <li>
                            <a href="https://prezi.com/y5jaybl15bd0/circulo-de-lectores/">
                                Acerca de nosotros
                            </a>
                        </li>                    
                        <li>
                            <a class="nav-link" rel="tooltip" title="Añadenos en Facebook" data-placement="bottom" href="https://www.facebook.com/Circulo-De-Lectores-1031583493553042/" target="_blank">
                                <i class="fa fa-facebook-square"></i>
                                <p class="hidden-lg-up">Facebook</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" rel="tooltip" title="Siguenos en Twitter" data-placement="bottom" href="https://twitter.com/circulolectores?lang=es" target="_blank">
                                <i class="fa fa-twitter-square"></i>
                                <p class="hidden-lg-up">Twitter</p>
                            </a>
                        </li>                        
                        <li class="nav-item">
                            <a class="nav-link" rel="tooltip" title="Google Plus" data-placement="bottom" href="https://plus.google.com/118199712389274858466" target="_blank">
                                <i class="fa fa-google-plus"></i>
                                <p class="hidden-lg-up">Google plus</p>
                            </a>
                        </li>                        
                    </ul>
                </nav>
                <div class="copyright">
                    &copy;
                    <script>
                        document.write(new Date().getFullYear())
                    </script>, Designed by
                    <a  target="_blank">Old Jhony's</a>. Coded by
                    <a  target="_blank">Old Jhony's</a>.
                </div>
            </div>
        </footer> 
    </body>

</html>
