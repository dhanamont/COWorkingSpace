<%-- 
    Document   : Myproperty
    Created on : Nov 1, 2017, 10:17:48 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GARO ESTATE | Property  page</title>
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
        <link rel="stylesheet" href="assets/css/lightslider.min.css">
        <link rel="stylesheet" href="assets/css/style.css">


        <link rel="stylesheet" href="assets/css/datepicker.css">
        <script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>

        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script> 
        <script src="http://code.gijgo.com/1.5.0/js/gijgo.js" type="text/javascript"></script> 

        <link href="http://code.gijgo.com/1.5.0/css/gijgo.css" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css" />

        <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
        
       


    </head>
    <body>

        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <!-- Body content -->



        <!-- DataSource Connect -->
        <sql:setDataSource var="it58070122_se" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se"
                           user="it58070122_se" password="chFKW9lGV"/>

        <% String Role_ID = (String) session.getAttribute("Role_ID");%>
        <% String Username = (String) session.getAttribute("Username");%>
        <% String id = (String) session.getAttribute("Space_ID");%>
        <% String User_ID = (String) session.getAttribute("User_ID");%>
        


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
                        <li class="wow fadeInDown" data-wow-delay="0.2s"><a class="" href="PropertiesServlet">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a class="" href="index.jsp#about" id="about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="index.jsp#contact">Contact</a></li>
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
        <% }%>
        <!-- End Navbar Entrepreneur -->



        <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title"><%= session.getAttribute("Space_Name")%></h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->

        <!-- property area -->
        <div class="content-area single-property" style="background-color: #FCFCFC;">

            <div class="container">

                <div class="clearfix padding-top-40">

                    <div class="col-md-8 single-property-content ">
                        <div class="row">
                            <div class="light-slide-item">            
                                <div class="clearfix">
                                    <ul id="image-gallery" class="gallery list-unstyled cS-hidden">
                                        <li data-thumb="<%= request.getAttribute("Picture_cover")%>"> 
                                            <img src="<%= request.getAttribute("Picture_cover")%>" />
                                        </li>
                                        <c:forEach var="pic" items="${requestScope.Picture_room}" varStatus="picture" >
                                            <li data-thumb="${pic}"> 
                                                <img src="${pic}" />
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="single-property-wrapper">
                            <div class="single-property-header">                                          
                                <h1 class="property-title pull-left"><%= session.getAttribute("Space_Name")%></h1>
                            </div>

                            <div class="property-meta entry-meta clearfix ">   
                                <h4 class="s-property-title">Description</h4>
                                <div class="s-property-content">
                                    <p><%= request.getAttribute("Description")%></p>
                                </div>
                            </div>
                            <!-- .property-meta -->
                            <% System.out.println(id);%>
                            <div>
                                <table id="allre1-dt" class="table table-striped" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>Room Name</th>
                                            <th>Price</th>
                                            <th></th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="rname" items="${requestScope.Room_Name}" varStatus="loop1" >
                                            <tr>
                                                <td>${rname}</td>
                                                <td>${requestScope.Price[loop1.index]}</td>                               
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- End description area  -->

                            <div class="section additional-details">

                                <h4 class="s-property-title">Service Details</h4>

                                <ul class="additional-details-list clearfix">
                                    <li>
                                        <table id="allre1-dt" class="table table-striped" cellspacing="0" width="100%">
                                            <c:forEach var="sname" items="${requestScope.Service_Name}" >
                                                <tbody>
                                                    <tr>
                                                        <td>${sname}</td>
                                                    </tr>
                                                </tbody>
                                            </c:forEach>
                                        </table>
                                    </li>
                                </ul>
                            </div>  
                            <!-- End additional-details area  -->
                            <!---------------------ภาพพิมพ์เขียว----------------------->
                            <div class="section propertmap"> 
                                <h4 class="s-property-title">Prototype</h4> 
                                <div>
                                    <img src="<%= request.getAttribute("Prototype")%>"> 
                                </div>
                            </div>

                            <!------------------------------------------------------->


                            <!------------------------map----------------------->
                            <div class="section propertmap"> 
                                <h4 class="s-property-title" class="fa fa-map-marker"><i class="fa fa-map-marker">Maps</i></h4> 
                                <div>
                                    <%= request.getAttribute("Map")%>
                                </div>
                            </div>
                            <!-- End map area  -->
                        </div>
                    </div>

                    <div class="col-md-4 p0">
                        <aside class="sidebar sidebar-property blog-asside-right">
                            <!------------------------ข้อมูลผู้ประกอบการ------------------------>
                            <div class="dealer-widget">
                                <div class="dealer-content">
                                    <div class="inner-wrapper">

                                        <div class="clear">

                                            <div class="col-xs-8 col-sm-8 ">
                                                <h3 class="dealer-name">
                                                    <a><%= request.getAttribute("Contact_name")%></a><br>
                                                </h3>
                                            </div>
                                        </div>

                                        <div class="clear">
                                            <ul class="dealer-contacts">                                       
                                                <li><i class="pe-7s-map-marker strong"> </i><%= request.getAttribute("Company_name")%></li>
                                                <li><i class="pe-7s-mail strong"> </i> <%= request.getAttribute("Email")%></li>
                                                <li><i class="pe-7s-call strong"> </i> <%= request.getAttribute("Phone")%></li>
                                            </ul>

                                        </div>

                                    </div>
                                </div>
                            </div>




                            <!------------------------------------ส่วนจอง------------------------------------------------------->
                            <div class="panel panel-default sidebar-menu similar-property-wdg wow fadeInRight animated">

                                <div class="panel panel-default sidebar-menu wow fadeInRight animated" >
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Reserving</h3>
                                        <h4><b><%= session.getAttribute("Space_Name")%></b></h4>
                                    </div>
                                    <div class="panel-body search-widget">
                                        
                                                    <form action="CheckOrderServlet" method="POST" class="form-inline">
                                                    <!------------------------------------------------------------------------>
                                               
                                                    <fieldset>
                                                        <div class="row">
                                                        <!----------------Table------------------------------------------------>
                                                    <div class="col-xs-12">

                                                        <select id="TableID" name="tableID" class="selectpicker subcat">
                                                            <option value selected disabled>Select Your Table</option>
                                                            <!--ดึงข้อมูลมาใส่ในdropdown-------------------------------------------------->
                                                             <c:forEach var="tableid" items="${requestScope.Table_ID}" >
                                                                        <option value="${tableid}">${tableid}</option>
                                                                </c:forEach>
                                                            <!------------------------------------------------------------------------>
                                                        </select>

                                                    </div>
                                                        </div>
                                                    </fieldset>

                                            <fieldset>
                                                <div class="row">
                                                <div class="col-xs-12">
                                                    <input id="datepicker" data-width="320px" name="Date" type="text" placeholder="Select your Date"/>
                                                    <script>
                                                        $('#datepicker').datepicker({
                                                            format: 'yyyy-mm-dd',

                                                        });
                                                    </script> 
                                                </div>
                                                </div>
                                            </fieldset>

                                            <fieldset>
                                                <div class="row">
                                                    <div class="col-xs-6">

                                                        <select id="Start_Time" name="Start_Time" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Select Your Start Time">
                                                            <!--ดึงข้อมูลมาใส่ในdropdown------------------------------------------------------->
                                                            <c:forEach items="${Time}" var="item2" varStatus="Stime">
                                                                <option value="${Time[Stime.index]}">${Time[Stime.index]}</option>
                                                            </c:forEach>
                                                            <!------------------------------------------------------------------------>
                                                        </select>
                                                    </div>
                                                    <div class="col-xs-6">

                                                        <select id="End_Time" name="End_Time" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Select Your Time">

                                                            <!--ดึงข้อมูลมาใส่ในdropdown--------------------------------------------------->
                                                            <c:forEach items="${Time}" var="item3" varStatus="Etime">
                                                                <option value="${Time[Etime.index]}">${Time[Etime.index]}</option>
                                                            </c:forEach>
                                                            <!------------------------------------------------------------------------>
                                                        </select>
                                                    </div>
                                                </div>
                                            </fieldset>
                                                   

                                            <fieldset >
                                                <div class="row">
                                                    <div class="col-xs-12">  
                                                        <input class="button btn largesearch-btn" value="Reserve" type="submit">
                                                    </div>  
                                                </div>

                                            </fieldset>
                                        
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </aside>
                    </div>
                </div>
                </form>        
            </div>

        </div>


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
                                <p>Lorem ipsum dolor cum necessitatibus su quisquam molestias. Vel unde, blanditiis.</p>
                                <ul class="footer-adress">
                                    <li><i class="pe-7s-map-marker strong"> </i> 9089 your adress her</li>
                                    <li><i class="pe-7s-mail strong"> </i> email@yourcompany.com</li>
                                    <li><i class="pe-7s-call strong"> </i> +1 908 967 5906</li>
                                </ul>
                            </div>
                        </div>
                        

                    </div>
                </div>
            </div>

        </div>
        
        
        <script src="assets/js/vendor/modernizr-2.6.2.min.js"></script>
        <script src="assets/js/jquery-1.10.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-hover-dropdown.js"></script>
        <script src="assets/js/category.js"></script>
        <script src="assets/js/easypiechart.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.js"></script>
        <script src="assets/js/icheck.min.js"></script>
        <script src="assets/js/price-range.js"></script>
        <script type="text/javascript" src="assets/js/lightslider.min.js"></script>
        <script src="assets/js/main.js"></script>

        <script>
                                                            $(document).ready(function () {

                                                                $('#image-gallery').lightSlider({
                                                                    gallery: true,
                                                                    item: 1,
                                                                    thumbItem: 9,
                                                                    slideMargin: 0,
                                                                    speed: 500,
                                                                    auto: true,
                                                                    loop: true,
                                                                    onSliderLoad: function () {
                                                                        $('#image-gallery').removeClass('cS-hidden');
                                                                    }
                                                                });
                                                            });
        </script>
        
    </body>
</html>
