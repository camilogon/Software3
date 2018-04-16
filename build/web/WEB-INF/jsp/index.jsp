<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
         <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
 
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
        -->

        <link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/assets/img/apple-icon.png" />">
        <link rel="icon" type="image/png" href="<c:url value="/assets/img/favicon.png" />" >
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Distribuidora circulo Caldas</title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- CSS Files -->
        <link href="<c:url value="/assets/css/bootstrap.min.css" />" rel="stylesheet" />
        <link href="<c:url value="/assets/css/now-ui-kit.css" />" rel="stylesheet" />



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
    <div class="wrapper">  
        <div class="page-header clear-filter" filter-color="blue">
            <div class="page-header-image" data-parallax="true">
            </div>
            <div class="container">
                <div class="content-center brand">
                    <img class="d-block offset-3" src="assets/img/indexImg.png" >
                    <input type="email" class="form-control" placeholder="Buscar..." value="">
                    <h3>Libros, autores, editoriales, encuentra lo que quieras...</h3>
                </div>
            </div>
        </div>  

    </div>                     	

    <!-- Caruosel -->
    <div class="section" id="carousel">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-8">
                    <div id="carouselExampleControls" class="carousel slide">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block" src="assets/img/off1.jpg" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block" src="assets/img/off3.jpg" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block" src="assets/img/off2.jpg" alt="Third slide">

                            </div>
                       	</div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <i class="now-ui-icons arrows-1_minimal-left"></i>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <i class="now-ui-icons arrows-1_minimal-right"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Quienes somos -->
    <div class="section">
        <div class="container text-center">
            <div class="row justify-content-md-center">
                <div class="col-md-12 col-lg-8">
                    <h2 class="title">¿Quiénes somos?</h2>
                    <h5 class="description">Circulo de Lectores es una empresa española con sede en Barcelona, creada en 1962 por Reinhard Mohn, presidente del grupo alemán Bertelsmann y premio Principe de Asturias de Comunicación y Humanidades en 1998, y José Esteve Quintana, fundador de la editorial Vergara, para distribuir, en un modelo de club, libros y productos culturales de calidad en todo el territorio nacional, con el objetivo de ser un punto de encuentro entre autores y lectores y facilitar el acceso a la culta. En Colombia contamos con una sede en Bogotá administrada por Alba Victoria Reyes</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="container text-center">
        <div class="row">
            <div class="col-lg-6 col-md-12">
                <h2 class="title">Misión</h2>
                <h5 class="description">
                    Llevar cultura y entretenimiento a la comunidad Colombiana. Somos una organización innovadora, que a través de equipos de trabajo altamente productivos y motivados, proveemos la cultura con productos y servicios de alta calidad, siendo una empresa socialmente útil y económicamente exitosa.
                </h5>
            </div>
            <div class="col-lg-6 col-md-12">
                <h2 class="title">Visión</h2>
                <h5 class="description">
                    Ser la Empresa número uno en difundir y promover la cultura por medio de Libros y Videos de entretenimiento, información y consulta a la sociedad ecuatoriana.
                </h5>
            </div>            
        </div>      
    </div>

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

</body>
</html>

