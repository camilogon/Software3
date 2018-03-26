<%-- 
    Document   : Admin
    Created on : 27/05/2017, 08:43:12 PM
    Author     : Usuario
--%>

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
        <nav class="navbar navbar-toggleable-md bg-primary  navbar-transparent " color-on-scroll="300" >
            <div class="container" style="background:#0B337F">            
                <div class="navbar-translate">
                    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar bar1"></span>
                        <span class="navbar-toggler-bar bar2"></span>
                        <span class="navbar-toggler-bar bar3"></span>
                    </button>

                    <a class="navbar-brand" href="http://demos.creative-tim.com/now-ui-kit/index.html" rel="tooltip" data-placement="bottom" target="_blank">
                        <img class="d-block " src="assets/img/small.png" >

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
                                <a class="dropdown-item" href="#">A-Z</a>
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
            <div class="container">
                <br>
                <div class="row">
                    <ul class="nav flex-column col-lg-2 col-md-12" data-background-color="blue" >
                        <li class="nav-item text-center">
                            <img class="rounded-circle" style="margin-left:5%;margin-top:5%" src="assets/img/avatar.jpg">
                            <a class="nav-link" href="#"><h6>nombre</h6></a>
                        </li>
                        <li class="nav-item">
                            <button class="btn-link" id="btnArticulo"><h5>Artículo</h5></button>
                        </li>
                        <li class="nav-item">
                            <button class="btn-link" id="btnAutor"><h5>Autor</h5></button>
                        </li>

                        <li class="nav-item">
                            <button class="btn-link" id="btnEditorial"><h5>Editorial</h5></button>
                        </li>             
                        <li class="nav-item">
                            <button class="btn-link" id="btnUsuarios"><h5>Usuarios</h5></button>
                        </li>   
                        <li class="nav-item">
                            <button class="btn-link" id="btnCategoria"><h5>Categoria</h5></button>
                        </li>
                        <li class="nav-item">
                            <button class="btn-link" id="btnCatalogos"><h5>Catalogos</h5></button>
                        </li> 
                    </ul>
                    <div class="col-lg-10 col-md-12"  id="contenido" >

                    </div>
                </div>



            </div>
        </div>      	
        <br>
        <br>   



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
                        document.write(new Date().getFullYear());
                    </script>, Designed by
                    <a  target="_blank">Old Jhony's</a>. Coded by
                    <a  target="_blank">Old Jhony's</a>.
                </div>
            </div>
        </footer>

        <script src="./assets/js/jquery-3.2.1.min.js"></script>
        <script src="./assets/js/Admin.js"></script>        
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

                            if ($('.section-download').length !== 0) {
                                $("html, body").animate({
                                    scrollTop: $('.section-download').offset().top
                                }, 1000);
                            }
                        }
        </script>
    </body>
</html>
