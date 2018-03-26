<%-- 
    Document   : Carrito
    Created on : 26/05/2017, 11:16:42 AM
    Author     : Usuario
--%>

<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="modelos.Articulo"%>
<%@page import="controladores.ArticuloControlador"%>
<%@page import="modelos.ArticuloCarrito"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
    LinkedList<ArticuloCarrito> articulosCarrito = sesion.getAttribute("carrito") == null ? null : (LinkedList<ArticuloCarrito>) sesion.getAttribute("carrito");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
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
        <div class="wrapper" >
            <br><br><br><br><br>  
            <div class="container content-center" id="divTabla" name="divTabla">
                <table class="table table-bordered col-lg-12 col-12 ">
                    <thead data-background-color="blue">
                        <tr> 
                            <th class="">Artículo</th>
                            <th class="">Precio</th>
                            <th class="">Cantidad</th>
                            <th class="">Total</th>
                            <th class=""></th>                           
                        </tr>
                    </thead>

                    <%
                        ArticuloControlador ac = new ArticuloControlador();
                        double total = 0;
                        if (articulosCarrito != null) {
                            for (ArticuloCarrito a : articulosCarrito) {

                                Articulo producto = ac.selectArticulo(a.getIdArticulo());
                                total += a.getCantidad() * producto.getPrecio();
                                String imgnCodificada = Base64.encode(producto.getFoto());
                    %>
                    <tbody>
                        <tr>
                            <td>
                                <img class="img-rounded" src="data:image/jpg;base64,<%=imgnCodificada%>" width="120"/>
                                <h4><%=producto.getTitulo()%></h4>
                                <p>Id: <%=a.getIdArticulo()%></p>
                            </td>
                            <td>
                                <h4>$<%=producto.getPrecio()%></h4>
                            </td>
                            <td>
                                <h4><%=a.getCantidad()%></h4>
                            </td>
                            <td>
                                <h4>$<%=Math.round(a.getCantidad() * producto.getPrecio() * 100.0) / 100.0%></h4>
                            </td>
                            <td >
                                <span id="idArticulo" style="display:none"><%=a.getIdArticulo()%></span>
                                <a href="" id="delete"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                            </td>
                        </tr>
                    </tbody>

                    <%      }%>


                </table>
                <%}
                    if (articulosCarrito != null && articulosCarrito.isEmpty()) {%>
                <span>No hay articulos en el carrito</span>                
                <%}%>
            </div>



            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <h2 ><a href="javascript:window.history.go(-2)">Seguir comprando</a></h2>
                    </div>
                    <div class="col-lg-6 col-md-12">
                        <form action="Ventas1" method="post">
                            <button class="btn btn-primary offset-9" type="submit">
                                <i class="fa fa-exchange"></i> Comprar
                            </button>
                        </form>
                    </div> 

                </div> 

            </div>        
        </div> 
        <div class="container"></div>
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
                        document.write(new Date().getFullYear());
                    </script>, Designed by
                    <a  target="_blank">Old Jhony's</a>. Coded by
                    <a  target="_blank">Old Jhony's</a>.
                </div>
            </div>
        </footer>

        <script src="./assets/js/jquery-3.2.1.min.js"></script>
        <script src="./assets/js/Carrito.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
        <script type="text/javascript">
                        $(document).ready(function () {
                            // the body of this function is in assets/js/now-ui-kit.js
                            nowuiKit.initSliders();
                        });

                        function scrollToDownload() {

                            if ($('.section-download').length != 0) {
                                $("html, body").animate({
                                    scrollTop: $('.section-download').offset().top
                                }, 1000);
                            }
                        }
        </script>
    </body>
</html>
