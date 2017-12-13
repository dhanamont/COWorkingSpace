<%-- 
    Document   : entRequestList
    Created on : Nov 16, 2017, 11:09:19 PM
    Author     : test
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
        <% if (Role_ID == null || Role_ID.equals("MEM") || Role_ID.equals("ENT")) { %>
            <% response.sendRedirect("index.jsp");%>
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
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a class="" href="index.jsp#about" id="about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="index.jsp#contact">Contact</a></li>
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
        <% } %>
        <!-- Start page header -->
         <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">Entrepreneur Request list</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header --> 
        
        <!-- property area -->
        <div class="content-area user-profiel" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">   
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1 profiel-container">

                        <form action="EntRequestList" method="POST">
                            <div class="profiel-header">
                                <h3>
                                    <b>ENTREPRENEUR</b> REQUEST LIST <br>
                                    <small>Manage entrepreneur request list.</small>
                                </h3>
                                <hr>
                            </div>
                            <div class="clear col-sm-offset-1">
                                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#allre1" aria-controls="allre1" role="tab" data-toggle="tab">All Request</a></li>
                        <li role="presentation"><a href="#accept1" aria-controls="accept1" role="tab" data-toggle="tab">Accepted Request</a></li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        
                        <!-- SHOW ALL CONCERT REQUEST -->
                        <div role="tabpanel" class="tab-pane fade in active" id="allre1">
                            <p><h2>All Request</h2></p>
                            <table id="allre1-dt" class="table table-striped" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Company name</th>
                                        <th>Entrepreneur</th>
                                        <th>Status</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="cname" items="${requestScope.Company_Name}" varStatus="loop" >
                                    <tr>
                                        <!-- Company name Column -->
                                        <td>${cname}</td>
                                        <!-- Contact name Column -->
                                        <td>${requestScope.Contact_name[loop.index]}</td>
                                        <!-- Status Column -->
                                        <td>                                      
                                            <c:choose>
                                                <c:when test="${requestScope.Status[loop.index] == 'CANCELED'}">
                                                    <span class="label label-danger">CANCELED</span>
                                                </c:when>
                                                <c:when test="${requestScope.Status[loop.index] == 'ACCEPTED'}">
                                                    <span class="label label-success">ACCEPTED</span>
                                                </c:when>
                                                <c:when test="${requestScope.Status[loop.index] == 'WAITING'}">
                                                    <span class="label label-warning">WAITING</span>
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <!-- Button View Detail Column -->
                                        <td><a class="btn btn-finish btn-primary" href="EntrepreneurDetail?id=${cname}">View Detail</a></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                                    
                       <!-- SHOW ALL ACCEPTED CONCERT -->
                        <div role="tabpanel" class="tab-pane fade" id="accept1">
                            <p><h2>Accepted Request</h2></p>
                            <table id="accept1-dt" class="table table-striped" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Company name</th>
                                        <th>Entrepreneur</th>
                                        <th>Status</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="ACcname" items="${requestScope.Company_NameAc}" varStatus="loopAC" >
                                    <tr>
                                        <!-- Company name Column -->
                                        <td>${ACcname}</td>
                                        <!-- Contact name Column -->
                                        <td>${requestScope.Contact_nameAc[loopAC.index]}</td>
                                        <!-- Status Column -->
                                        <td><span class="label label-success">ACCEPTED</span></td>
                                        <!-- Button View Detail Column -->
                                        <td><a class="btn btn-finish btn-primary" href="EntrepreneurDetail?id=${ACcname}" >View Detail</a></td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                            <br>
                    </form>

                </div>
            </div><!-- end row -->

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
