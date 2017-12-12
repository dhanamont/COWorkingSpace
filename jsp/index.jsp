<%-- 
    Document   : index
    Created on : Oct 11, 2017, 7:36:11 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Start head -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Co-Working Space</title>
        <meta name="description" content="GARO is a real-estate template">
        <meta name="author" content="Kimarotec">
        <meta name="keyword" content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="assets/css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min.css"> 
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/icheck.min_all.css">
        <link rel="stylesheet" href="assets/css/price-range.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.css">  
        <link rel="stylesheet" href="assets/css/owl.theme.css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
        <!-- End head -->
    </head>
    
    <body>
        <!-- Start Preload -->
        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <!-- End Preload -->
        
        <!-- DataSource Connect -->
        <sql:setDataSource var="it58070122_se" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se" 
                           user="it58070122_se" password="chFKW9IGV"/>
        
        <% String Role_ID = (String) session.getAttribute("Role_ID");%>
        <% String Username = (String) session.getAttribute("Username");%>
              
        <!-- Start Navbar Guest -->
        <% if (Role_ID == null) { %>
        <nav class="navbar navbar-default ">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><img src="assets/img/logo.png" alt=""></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse yamm" id="navigation">
                    <div class="button navbar-right">
                        <button class="navbar-btn nav-button wow bounceInRight login" onclick=" window.open('register.jsp')" data-wow-delay="0.45s">Register / Sign In</button>
                    </div>
                    <ul class="main-nav nav navbar-nav navbar-right">
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.jsp">Home</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="PropertiesServlet">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- End Navbar Guest-->
  
        <!-- Start Navbar Member -->
        <% } else if (Role_ID.equals("MEM")) {%>
        <nav class="navbar navbar-default ">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><img src="assets/img/logo.png" alt=""></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse yamm" id="navigation">

                    <ul class="main-nav nav navbar-nav navbar-right">
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.jsp">Home</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="PropertiesServlet">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%>   <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="MyOrders.jsp">My orders</a>
                                </li>
                                <li>
                                    <a href="SignOutServlet">Sign out</a>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- End Navbar Member-->

        <!-- Start Navbar Admin -->
        <% } else if (Role_ID.equals("ADM")) {%>
        <nav class="navbar navbar-default ">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><img src="assets/img/logo.png" alt=""></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse yamm" id="navigation">

                    <ul class="main-nav nav navbar-nav navbar-right">
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.jsp">Home</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="PropertiesServlet">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%> <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="EntRequestList">Entrepreneur Request list</a>
                                </li>
                                <li>
                                    <a href="SignOutServlet">Sign out</a>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <!-- End Navbar Admin -->

        <!-- Start Navbar Entrepreneur -->
        <% } else if (Role_ID.equals("ENT")) {%>
        <nav class="navbar navbar-default ">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp"><img src="assets/img/logo.png" alt=""></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse yamm" id="navigation">

                    <ul class="main-nav nav navbar-nav navbar-right">
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.jsp">Home</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="PropertiesServlet">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%> <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="SubmitProperties.jsp">Submit properties</a>
                                </li>
                                <li>
                                    <a href="OrderListServlet">Reservation list</a>
                                </li>
                                <li>
                                    <a href="SignOutServlet">Sign out</a>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <% } %>
        <!-- End Navbar Entrepreneur -->
        
        
        

       <!-- Start find area & Slide main picture -->
        <div class="slider-area">
            <div class="slider">
                <div id="bg-slider" class="owl-carousel owl-theme">

                    <div class="item"><img src="assets/img/slide1/slider-image-1.jpg" alt="GTA V"></div>
                    <div class="item"><img src="assets/img/slide1/slider-image-2.jpg" alt="The Last of us"></div>
                    <div class="item"><img src="assets/img/slide1/slider-image-3.jpg" alt="GTA V"></div>

                </div>
            </div>
            <div class="slider-content">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
                        <h2>Co-Working Space</h2>
                        <p>Unlike in a typical office environment, those coworking are usually not employed by the same organization.</p>
                        <div class="search-form wow pulse" data-wow-delay="0.8s">

                            <form name = "PropertiesServlet" action="PropertiesServlet" class=" form-inline" method="POST">
                                <!--button class="btn  toggle-btn" type="button"><i class="fa fa-bars"></i></button-->

                                <div class="form-group">
                                    <!--<select id="lunchBegins" class="selectpicker show-tick form-control" data-live-search="false" data-live-search-style="begins" title="Select your city">-->
                                    <select name="Place" id="basic" class="selectpicker show-tick form-control">
                                        <option> -Place- </option>
                                        <option value="Siam">Siam</option>
                                        <option value="Silom">Silom</option>
                                        <option value="Asok">Asok</option>
                                      
                                    </select>
                                </div>
                                <div class="form-group">                                     
                                    <select name="TypeSpace" id="basic" class="selectpicker show-tick form-control">
                                        <option> -Type Space- </option>
                                        <option value="Common Room">Common Room</option>
                                        <option value="Meeting Room">Meeting Room</option>
                                        <option value="Private Office">Private Office</option>
                                    </select>
                                </div>
                                <button class="btn search-btn" type="submit"><i class="fa fa-search"></i></button>

                                       
                            </form>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End find area & Slide main picture -->
        
               <!-- Start About -->
        <div class="content-area home-area-1 recent-property" style="background-color: #FCFCFC; padding-bottom: 55px;">
            <div class="container" id="about">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        <!-- /.feature title -->
                        <h2>ABOUT</h2>
                        <p>Co-Working Space is a site where people can sit together in the same place. Which is the way to work. The new model is growing now. You can book a place to work in advance through our website, where each place is divided into 3 categories.</p>
                    </div>
                </div>
                <!------------------------------------------รูปห้อง--------------------------------->
                <div class="row ">
                    <div class="proerty-th">
                        <div class="col-xs-2 col-sm-6 col-md-3 col-lg-3 col-lg-offset-2 p0">
                            
                            <div class="box-two proerty-item">
                                <div class="item-thumb">
                                    <a><img src="assets/img/demo/Fueled-Collective-Large-Conference-Room.jpg"></a>
                                </div>
                                <div class="item-entry overflow">
                                    <h5><a>Meeting Room</a></h5>
                                    <div class="dot-hr"></div>
                                    <span class="pull-left"><b>Meeting Room : A conference room for meetings or group work. Can accommodate up to 10 people.</b></span>

                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="proerty-th">
                        <div class="col-sm-6 col-md-3 p0">
                            <div class="box-two proerty-item">
                                <div class="item-thumb">
                                    <a><img src="assets/img/demo/London-WeWork-South-Bank-Lounge.jpg"></a>
                                </div>
                                <div class="item-entry overflow">
                                    <h5><a>Common Room</a></h5>
                                    <div class="dot-hr"></div>
                                    <span class="pull-left"><b>Common Room : is a spacious room for people who want to sit and work with others. Can accommodate a lot of people.</b></span>

                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="proerty-th">
                        <div class="col-sm-6 col-md-3 p0">
                            <div class="box-two proerty-item">
                                <div class="item-thumb">
                                    <a><img src="assets/img/demo/SLABS2flr-14.jpg"></a>
                                </div>
                                <div class="item-entry overflow">
                                    <h5><a>Private Room</a></h5>
                                    <div class="dot-hr"></div>
                                    <span class="pull-left"><b>Private Room : It is a room for people who want to work in private. Can accommodate 1-5 people</b></span>

                                </div>
                            </div>
                        </div>

                    </div>

                    </div>
            </div>
            <!---------------------------------------------------------------------------------------------->   
        </div>

        <!-- End About -->

        <!-- Start Contact -->
        <div class="content-area home-area-1 recent-property" style="background-color: #FCFCFC; padding-bottom: 55px;">
            <div class="container" id="contact">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">

                        <h2>Contact</h2><br>
                        <p>Co-WorkingSpace</p>
                        
                        <i class="pe-7s-map-marker strong"> </i> 9089 your adress her<br>
                        <i class="pe-7s-mail strong"> </i> email@yourcompany.com<br>
                            <i class="pe-7s-call strong"> </i> +1 908 967 5906
                        
                    </div>
                </div>

                
            </div>
        </div>
        <!-- End Contact -->

        <!-- Footer area-->
        <div class="footer-area">

            <div class=" footer">
                <div class="container">
                    <div class="row">

                        <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                            <div class="single-footer">
                                <h4>About us </h4>
                                <div class="footer-title-line"></div>

                                <img src="assets/img/footer-logo.png" alt="" class="wow pulse" data-wow-delay="1s">
                                <p>Co-WorkingSpace</p>
                                <ul class="footer-adress">
                                    <li><i class="pe-7s-map-marker strong"> </i> 9089 your adress her</li>
                                    <li><i class="pe-7s-mail strong"> </i> email@yourcompany.com</li>
                                    <li><i class="pe-7s-call strong"> </i> +1 908 967 5906</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                            <div class="single-footer">
                                <h4>Quick links </h4>
                                <div class="footer-title-line"></div>
                                <ul class="footer-menu">
                                    <li><a href="properties.html">Properties</a>  </li> 
                                    <li><a href="#">Services</a>  </li> 
                                    <li><a href="submit-property.html">Submit property </a></li> 
                                    <li><a href="contact.html">Contact us</a></li> 
                                    <li><a href="faq.html">fqa</a>  </li> 
                                    <li><a href="faq.html">Terms </a>  </li> 
                                </ul>
                            </div>
                        </div>


                   </div>

                    <!-- Start Script -->
                    <script src="assets/js/modernizr-2.6.2.min.js"></script>
                    <script src="assets/js/jquery-1.10.2.min.js"></script> 
                    <script src="bootstrap/js/bootstrap.min.js"></script>
                    <script src="assets/js/bootstrap-select.min.js"></script>
                    <script src="assets/js/bootstrap-hover-dropdown.js"></script>
                    <script src="assets/js/easypiechart.min.js"></script>
                    <script src="assets/js/jquery.easypiechart.min.js"></script>
                    <script src="assets/js/owl.carousel.min.js"></script>
                    <script src="assets/js/wow.js"></script>
                    <script src="assets/js/icheck.min.js"></script>
                    <script src="assets/js/price-range.js"></script>
                    <script src="assets/js/main.js"></script>

                    <script src="assets/js/scrolling.js"></script>
                    <!-- End Script -->

   </body>
</html>
