<%-- 
    Document   : VistaDetalladaArticulo
    Created on : 25/05/2017, 03:51:11 PM
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
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
    </head>
    <body>
       <!-- <img src="data:image/jpg;base64,<c:out value="${imagen}" />"
        <div>
            <p>
        <c:out value="${articulo.getTitulo()}" />
        <p>
        <c:out value="${articulo.getAutor()}" />
        <p>
        <c:out value="${articulo.getEditorial()}" />
        <p>
        <c:out value="${articulo.getCategoria()}" />
        <form action="AgregarArticulo" method="post">
            <input type="number" id="cantidad" name="cantidad" value="1" min="1">
            <input type="hidden" value="<c:out value="${articulo.getIdArticulo()}"/>" id="idArticulo" name="idArticulo">
            <input type="submit" value="Agregar al carrito">
        </form>
    </div> -->






        <nav class="navbar navbar-toggleable-md bg-primary fixed-top navbar-transparent " color-on-scroll="300" >
            <div class="container" style="background:#0B337F">            
                <div class="navbar-translate">
                    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar bar1"></span>
                        <span class="navbar-toggler-bar bar2"></span>
                        <span class="navbar-toggler-bar bar3"></span>
                    </button>

                    <a class="navbar-brand" href="http://demos.creative-tim.com/now-ui-kit/index.html" rel="tooltip" title="Designed by Invision. Coded by Creative Tim" data-placement="bottom" target="_blank">
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
                            <a class="nav-link" href="#" target="_blank">
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
                            <a class="nav-link" href="./documentation/tutorial-components.html" target="_blank">
                                <i class="now-ui-icons shopping_cart-simple"></i>
                                <p>Compras</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="wrapper">  
            <div class="page-header clear-filter">
                <div class="page-header-image" data-parallax="true"></div>
                <br><br><br><br><br><br><br>
                <div class="container text-left">
                    <div class="row">
                        <div class="col-lg-6 col-md-12">
                            <img class="d-block" src="data:image/jpg;base64,<c:out value="${imagen}" />" width="300"/>
                        </div>
                        <div class="col-lg-6 col-md-12">
                            <h5 style="color:#000000"><c:out value="${articulo.getTitulo()}" /></h5>
                            <h6 style="color:#000000">DESCRIPCION Nunc eu ullamcorper orci. Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque faucibus vestibulum. Nulla at nulla justo, eget luctus tortor. Nulla facilisi. Duis aliquet egestas purus in.</h6>
                            <h6 style="color:#000000"> <c:out value="${articulo.getAutor()}" /></h6>
                            <h6 style="color:#000000"> <c:out value="${articulo.getEditorial()}" /></h6>
                            <h6 style="color:#000000"> <c:out value="${articulo.getCategoria()}" /></h6>
                            <h6 style="color:#000000">$ <c:out value="${articulo.getPrecio()}" /></h6>
                            <h6 style="color:#000000"> <c:out value="${articulo.getISBN()}" /></h6>                            

                            <form action="AgregarArticulo" method="post">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h3 style="color:#000000"> Cantidad</h3>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="input-group form-group-no-border">
                                            <span class="input-group-addon">
                                                <i class="now-ui-icons shopping_box"></i>
                                            </span>
                                            <input type="number" class="form-control" value="1" min="1" id="cantidad" name="cantidad">      					
                                        </div>
                                    </div>
                                </div>
                                <input type="hidden" value="<c:out value="${articulo.getIdArticulo()}"/>" id="idArticulo" name="idArticulo">
                                <button class="btn btn-primary btn-round col-12" type="submit">
                                    <i class="now-ui-icons shopping_cart-simple"></i> Añadir al carrito
                                </button> 
                                <!-- <input type="number" id="cantidad" name="cantidad" value="1" min="1">
                                 <input type="hidden" value="<c:out value="${articulo.getIdArticulo()}"/>" id="idArticulo" name="idArticulo">
                                 <input type="submit" value="Agregar al carrito">-->
                            </form>
                        </div>    
                    </div>
                </div>  
            </div> 
            <div class="section section-tabs">
                <div class="container">
                    <div class="col-12">
                        <p class="category">Tabs with Background on Card</p>
                        <!-- Tabs with Background on Card -->
                        <div class="card">
                            <ul class="nav nav-tabs nav-tabs-neutral justify-content-center" role="tablist" data-background-color="blue">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#home1" role="tab">Comentarios</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#profile1" role="tab">Productos similares</a>
                                </li>

                            </ul>
                            <div class="card-block">
                                <!-- Tab panes -->
                                <div class="tab-content text-center">
                                    <div class="tab-pane active" id="home1" role="tabpanel">
                                        <p>I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at. So when you get something that has the name Kanye West on it, it’s supposed to be pushing the furthest possibilities. I will be the leader of a company that ends up being worth billions of dollars, because I got the answers. I understand culture. I am the nucleus.</p>
                                    </div>
                                    <div class="tab-pane" id="profile1" role="tabpanel">
                                        <p> I will be the leader of a company that ends up being worth billions of dollars, because I got the answers. I understand culture. I am the nucleus. I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at. I think that’s a responsibility that I have, to push possibilities, to show people, this is the level that things could be at. </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- End Tabs on plain Card -->
                    </div>
                </div>
            </div>    
        </div>                   	
        <!-- PROTOTIPO-->




        <!-- fin -->   
        <!-- Pie de pagina -->
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
