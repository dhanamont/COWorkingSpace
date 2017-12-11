
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
        <% String roomID = (String) session.getAttribute("Room_ID");%>
        <% String User_ID = (String) session.getAttribute("User_ID");%>
        <% String Order_ID = (String) session.getAttribute("Order_ID");%>
       
       <%-- payment id = <%= request.getAttribute("paymentID")%> <br>
        payment method = <%= request.getAttribute("paymentMethod")%> <br>
        order id = <%= session.getAttribute("orderID")%> <br>--%>

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
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.2s"><a class="" href="propertoes.jsp">Properties</a></li>
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
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="properties.jsp">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="Property.jsp">Property</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%>   <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="index-2.html">Edit Profile</a>
                                </li>
                                <li>
                                    <a href="index-3.html">My orders</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Sign out</a>
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
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="properties.jsp">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%> <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="index-2.html">Properties list</a>
                                </li>
                                <li>
                                    <a href="index-3.html">Application list</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Sign out</a>
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
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="properties.jsp">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%> <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="index-2.html">Edit Profile</a>
                                </li>
                                <li>
                                    <a href="submitproperties.jsp">Submit properties</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Reservation list</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Sign out</a>
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
                        <h1 class="page-title">My History</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->


        <sql:query var="history" dataSource="${it58070122_se}">
            SELECT r.Order_Date, r.Start_Time, r.End_Time, r.Order_Status, t.Table_ID,
            o.Room_Name, y.Type_Name, s.Space_Name, s.Place, o.Price, u.Fname, u.Lname, u.Email, r.Order_ID
            From `User` u
            JOIN Ordering r USING (User_ID)
            JOIN `Table` t USING (Table_ID)
            JOIN Room o USING (Room_ID)
            JOIN Type_Space y USING (Type_ID)
            JOIN `Space` s USING (Space_ID)
            WHERE u.User_ID = ? ;
            <sql:param value="${User_ID}"/>
        </sql:query>

        <!--------------------------------end query------------------------------->

        <!-- StartHistory---->
        <!-- Start History -->
                <div id="menu2" class="tab-pane fade in active">
                    <div class="container">
                        <div class="row" style="width: 200%; margin: 0 auto">
                            <div class="col-xs-12 col-sm-6 col-md-4">
                                <div class="panel-body">
                                    <div class="row ">


                                        <!--____________________________HISTORY___________________________-->

                                        <div class="panel panel-default class">
                                            <div class="panel-heading"><center><b>My HISTORY</b></center></div>
                                        </div>

                                        <!--___Concert1 ___-->
                                        <%! int num = 1;%>
                                        <c:forEach var="row" items="${history.rows}">

                                            <div class="col-lg-12">
                                                <div class="panel panel-info" >
                                                    <div class="panel-body">
                                                        <div class="row" >

                                                            
                                                            <div class="col-lg-6 text-left">
                                                                <h3><c:out value="${row.Space_Name}"/></h3><br>
                                                                <a href="#"><span class="glyphicon glyphicon-time"></span></a>&nbsp; <c:out value="${row.Date}"/> | <c:out value="${row.Start_Time}"/> - <c:out value="${row.End_Time}"/><br>
                                                                <a href="#"><span class="glyphicon glyphicon-map-marker"></span></a>&nbsp; <c:out value="${row.Place}"/><br>
                                                                <br>
                                                            </div>
                                                            <!--------------------------------------More Detailed---------------------------------------->
                                                            <div class="col-lg-6 text-right">
                                                                <button type="button" class="btn btn-link" data-toggle="collapse" data-parent="#accordion" href="#collapse<%= num%>">More Detail <i class="fa fa-angle-down" style="font-size:18px"></i><pse<%= num%>"/button>
                                                            </div>
                                                        </div>
                                                            
                                                        <br>

                                                        <div class="panel-group" id="accordion">
                                                            <div class="panel panel-info">
                                                                <div id="collapse<%= num%>" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <div class="col-lg-6 text-left">
                                                                            <h5><b>Order #<c:out value="${row.Order_ID}"/></b></h5>
                                                                            <h5><b><c:out value="${row.Space_Name}"/></b></h5><br>
                                                                            Order Status: 
                                                                            <c:choose>
                                                                                <c:when test="${row.Order_Status == 'PAID'}">
                                                                                    <button type="button" class="btn btn-success btn-sm">PAID</button><br><br>
                                                                                </c:when>
                                                                                <c:when test="${row.Order_Status == 'WAITING'}">
                                                                                    <button type="button" class="btn btn-warning btn-sm">WAITING</button><br><br>
                                                                                </c:when>
                                                                            </c:choose>


                                                                        </div>
                                                                        <div class="col-lg-6 text-left">
                                                                            <b>Buyer: </b>&nbsp; <c:out value="${row.Fname}"/> <c:out value="${row.Lname}"/><br>
                                                                            <b>Email: </b>&nbsp; <c:out value="${row.Email}"/><br>
                                                                            
                                                                        </div>

                                                                        <!--TABLE-->
                                                                        <div class="row">
                                                                            <div class="col-lg-12"><hr width=100%> <!--Horizontal rule-->
                                                                                <h5>&nbsp;&nbsp;&nbsp;  Order Details</h5>
                                                                                <div class="table-responsive">
                                                                                    <table class="table table-bordered table-hover">
                                                                                        <thead>
                                                                                        <tr>
                                                                                        <th><center>Type Space</center></th>
                                                                                        <th><center>Room Name</center></th>
                                                                                        <th><center>Table ID</center></th>
                                                                                        <th><center>Price</center></th>
                                                                                        </tr>
                                                                                        </thead>
                                                                                        <tbody>

                                                                                            <c:set var="Order_ID" value="${row.Order_ID}"/>


                                                                                            <tr align="center">
                                                                                                <td><c:out value="${row.Type_Name}"/></td>
                                                                                                <td><c:out value="${row.Room_Name}"/></td>
                                                                                                <td><c:out value="${row.Table_ID}"/></td>
                                                                                                <td><c:out value="${row.Price}"/></td>
                                                                                                
                                                                                            </tr>
                                                                                           
                                                                                        </tbody>
                                                                                    </table>
                                                                                </div>
                                                                            </div>
                                                                            
                                                                            
                                                                                                <div class="col-lg-12 text-right"><h6>Order total : &nbsp;<b><c:out value="${row.Price}"/></h6></b></div>
                                                                            
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div> <!-- /.panel-body-->
                                                </div> <!-- /.panel panel-info-->
                                            </div> <!-- /.End Concert1-->
                                            <% num += 1;%>
                                             <hr width="100%"  size="20" color="black" align="center"><p>
                                        </c:forEach>
                                            
                                    </div> <!-- /.row -->
                                </div> <!-- /.panel-body -->
                            </div> <!-- /.col-lg-12 -->
                        </div> <!-- /.row -->
                    </div> <!-- /.container-->
                </div>
            <!------------------------------------------------End History----------------------------------------->
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
                            <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                                <div class="single-footer">
                                    <h4>Last News</h4>
                                    <div class="footer-title-line"></div>
                                    <ul class="footer-blog">
                                        <li>
                                            <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                                <a href="single.html">
                                                    <img src="assets/img/demo/small-proerty-2.jpg">
                                                </a>
                                                <span class="blg-date">12-12-2016</span>

                                            </div>
                                            <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                                <h6> <a href="single.html">Add news functions </a></h6> 
                                                <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                            </div>
                                        </li> 

                                        <li>
                                            <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                                <a href="single.html">
                                                    <img src="assets/img/demo/small-proerty-2.jpg">
                                                </a>
                                                <span class="blg-date">12-12-2016</span>

                                            </div>
                                            <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                                <h6> <a href="single.html">Add news functions </a></h6> 
                                                <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                            </div>
                                        </li> 

                                        <li>
                                            <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                                <a href="single.html">
                                                    <img src="assets/img/demo/small-proerty-2.jpg">
                                                </a>
                                                <span class="blg-date">12-12-2016</span>

                                            </div>
                                            <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                                <h6> <a href="single.html">Add news functions </a></h6> 
                                                <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                            </div>
                                        </li> 


                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                                <div class="single-footer news-letter">
                                    <h4>Stay in touch</h4>
                                    <div class="footer-title-line"></div>
                                    <p>Lorem ipsum dolor sit amet, nulla  suscipit similique quisquam molestias. Vel unde, blanditiis.</p>

                                    <form>
                                        <div class="input-group">
                                            <input class="form-control" type="text" placeholder="E-mail ... ">
                                            <span class="input-group-btn">
                                                <button class="btn btn-primary subscribe" type="button"><i class="pe-7s-paper-plane pe-2x"></i></button>
                                            </span>
                                        </div>
                                        <!-- /input-group -->
                                    </form> 

                                    <div class="social pull-right"> 
                                        <ul>
                                            <li><a class="wow fadeInUp animated" href="https://twitter.com/kimarotec"><i class="fa fa-twitter"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://www.facebook.com/kimarotec" data-wow-delay="0.2s"><i class="fa fa-facebook"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://plus.google.com/kimarotec" data-wow-delay="0.3s"><i class="fa fa-google-plus"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://instagram.com/kimarotec" data-wow-delay="0.4s"><i class="fa fa-instagram"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://instagram.com/kimarotec" data-wow-delay="0.6s"><i class="fa fa-dribbble"></i></a></li>
                                        </ul> 
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="footer-copy text-center">
                    <div class="container">
                        <div class="row">
                            <div class="pull-left">
                                <span> (C) <a href="http://www.KimaroTec.com">KimaroTheme</a> , All rights reserved 2016  </span> 
                            </div> 
                            <div class="bottom-menu pull-right"> 
                                <ul> 
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.2s">Home</a></li>
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.3s">Property</a></li>
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.4s">Faq</a></li>
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.6s">Contact</a></li>
                                </ul> 
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
</html><%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <% String roomID = (String) session.getAttribute("Room_ID");%>
        <% String User_ID = (String) session.getAttribute("User_ID");%>
        <% String Order_ID = (String) session.getAttribute("Order_ID");%>
       
       <%-- payment id = <%= request.getAttribute("paymentID")%> <br>
        payment method = <%= request.getAttribute("paymentMethod")%> <br>
        order id = <%= session.getAttribute("orderID")%> <br>--%>

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
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.2s"><a class="" href="propertoes.jsp">Properties</a></li>
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
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="properties.jsp">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="Property.jsp">Property</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%>   <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="index-2.html">Edit Profile</a>
                                </li>
                                <li>
                                    <a href="index-3.html">My orders</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Sign out</a>
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
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="properties.jsp">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%> <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="index-2.html">Properties list</a>
                                </li>
                                <li>
                                    <a href="index-3.html">Application list</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Sign out</a>
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
                        <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="properties.jsp">Properties</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%> <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="index-2.html">Edit Profile</a>
                                </li>
                                <li>
                                    <a href="submitproperties.jsp">Submit properties</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Reservation list</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Sign out</a>
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
                        <h1 class="page-title">My History</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->


        <sql:query var="history" dataSource="${it58070122_se}">
            SELECT r.Order_Date, r.Start_Time, r.End_Time, r.Order_Status, t.Table_ID,
            o.Room_Name, y.Type_Name, s.Space_Name, s.Place, o.Price, u.Fname, u.Lname, u.Email, r.Order_ID
            From `User` u
            JOIN Ordering r USING (User_ID)
            JOIN `Table` t USING (Table_ID)
            JOIN Room o USING (Room_ID)
            JOIN Type_Space y USING (Type_ID)
            JOIN `Space` s USING (Space_ID)
            WHERE u.User_ID = ? ;
            <sql:param value="${User_ID}"/>
        </sql:query>

        <!--------------------------------end query------------------------------->

        <!-- StartHistory---->
        <!-- Start History -->
                <div id="menu2" class="tab-pane fade in active">
                    <div class="container">
                        <div class="row" style="width: 200%; margin: 0 auto">
                            <div class="col-xs-12 col-sm-6 col-md-4">
                                <div class="panel-body">
                                    <div class="row ">


                                        <!--____________________________HISTORY___________________________-->

                                        <div class="panel panel-default class">
                                            <div class="panel-heading"><center><b>My HISTORY</b></center></div>
                                        </div>

                                        <!--___Concert1 ___-->
                                        <%! int num = 1;%>
                                        <c:forEach var="row" items="${history.rows}">

                                            <div class="col-lg-12">
                                                <div class="panel panel-info" >
                                                    <div class="panel-body">
                                                        <div class="row" >

                                                            
                                                            <div class="col-lg-6 text-left">
                                                                <h3><c:out value="${row.Space_Name}"/></h3><br>
                                                                <a href="#"><span class="glyphicon glyphicon-time"></span></a>&nbsp; <c:out value="${row.Date}"/> | <c:out value="${row.Start_Time}"/> - <c:out value="${row.End_Time}"/><br>
                                                                <a href="#"><span class="glyphicon glyphicon-map-marker"></span></a>&nbsp; <c:out value="${row.Place}"/><br>
                                                                <br>
                                                            </div>
                                                            <!--------------------------------------More Detailed---------------------------------------->
                                                            <div class="col-lg-6 text-right">
                                                                <button type="button" class="btn btn-link" data-toggle="collapse" data-parent="#accordion" href="#collapse<%= num%>">More Detail <i class="fa fa-angle-down" style="font-size:18px"></i><pse<%= num%>"/button>
                                                            </div>
                                                        </div>
                                                            
                                                        <br>

                                                        <div class="panel-group" id="accordion">
                                                            <div class="panel panel-info">
                                                                <div id="collapse<%= num%>" class="panel-collapse collapse">
                                                                    <div class="panel-body">
                                                                        <div class="col-lg-6 text-left">
                                                                            <h5><b>Order #<c:out value="${row.Order_ID}"/></b></h5>
                                                                            <h5><b><c:out value="${row.Space_Name}"/></b></h5><br>
                                                                            Order Status: 
                                                                            <c:choose>
                                                                                <c:when test="${row.Order_Status == 'PAID'}">
                                                                                    <button type="button" class="btn btn-success btn-sm">PAID</button><br><br>
                                                                                </c:when>
                                                                                <c:when test="${row.Order_Status == 'WAITING'}">
                                                                                    <button type="button" class="btn btn-warning btn-sm">WAITING</button><br><br>
                                                                                </c:when>
                                                                            </c:choose>


                                                                        </div>
                                                                        <div class="col-lg-6 text-left">
                                                                            <b>Buyer: </b>&nbsp; <c:out value="${row.Fname}"/> <c:out value="${row.Lname}"/><br>
                                                                            <b>Email: </b>&nbsp; <c:out value="${row.Email}"/><br>
                                                                            
                                                                        </div>

                                                                        <!--TABLE-->
                                                                        <div class="row">
                                                                            <div class="col-lg-12"><hr width=100%> <!--Horizontal rule-->
                                                                                <h5>&nbsp;&nbsp;&nbsp;  Order Details</h5>
                                                                                <div class="table-responsive">
                                                                                    <table class="table table-bordered table-hover">
                                                                                        <thead>
                                                                                        <tr>
                                                                                        <th><center>Type Space</center></th>
                                                                                        <th><center>Room Name</center></th>
                                                                                        <th><center>Table ID</center></th>
                                                                                        <th><center>Price</center></th>
                                                                                        </tr>
                                                                                        </thead>
                                                                                        <tbody>

                                                                                            <c:set var="Order_ID" value="${row.Order_ID}"/>


                                                                                            <tr align="center">
                                                                                                <td><c:out value="${row.Type_Name}"/></td>
                                                                                                <td><c:out value="${row.Room_Name}"/></td>
                                                                                                <td><c:out value="${row.Table_ID}"/></td>
                                                                                                <td><c:out value="${row.Price}"/></td>
                                                                                                
                                                                                            </tr>
                                                                                           
                                                                                        </tbody>
                                                                                    </table>
                                                                                </div>
                                                                            </div>
                                                                            
                                                                            
                                                                                                <div class="col-lg-12 text-right"><h6>Order total : &nbsp;<b><c:out value="${row.Price}"/></h6></b></div>
                                                                            
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div> <!-- /.panel-body-->
                                                </div> <!-- /.panel panel-info-->
                                            </div> <!-- /.End Concert1-->
                                            <% num += 1;%>
                                             <hr width="100%"  size="20" color="black" align="center"><p>
                                        </c:forEach>
                                            
                                    </div> <!-- /.row -->
                                </div> <!-- /.panel-body -->
                            </div> <!-- /.col-lg-12 -->
                        </div> <!-- /.row -->
                    </div> <!-- /.container-->
                </div>
            <!------------------------------------------------End History----------------------------------------->
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
                            <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                                <div class="single-footer">
                                    <h4>Last News</h4>
                                    <div class="footer-title-line"></div>
                                    <ul class="footer-blog">
                                        <li>
                                            <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                                <a href="single.html">
                                                    <img src="assets/img/demo/small-proerty-2.jpg">
                                                </a>
                                                <span class="blg-date">12-12-2016</span>

                                            </div>
                                            <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                                <h6> <a href="single.html">Add news functions </a></h6> 
                                                <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                            </div>
                                        </li> 

                                        <li>
                                            <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                                <a href="single.html">
                                                    <img src="assets/img/demo/small-proerty-2.jpg">
                                                </a>
                                                <span class="blg-date">12-12-2016</span>

                                            </div>
                                            <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                                <h6> <a href="single.html">Add news functions </a></h6> 
                                                <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                            </div>
                                        </li> 

                                        <li>
                                            <div class="col-md-3 col-sm-4 col-xs-4 blg-thumb p0">
                                                <a href="single.html">
                                                    <img src="assets/img/demo/small-proerty-2.jpg">
                                                </a>
                                                <span class="blg-date">12-12-2016</span>

                                            </div>
                                            <div class="col-md-8  col-sm-8 col-xs-8  blg-entry">
                                                <h6> <a href="single.html">Add news functions </a></h6> 
                                                <p style="line-height: 17px; padding: 8px 2px;">Lorem ipsum dolor sit amet, nulla ...</p>
                                            </div>
                                        </li> 


                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 wow fadeInRight animated">
                                <div class="single-footer news-letter">
                                    <h4>Stay in touch</h4>
                                    <div class="footer-title-line"></div>
                                    <p>Lorem ipsum dolor sit amet, nulla  suscipit similique quisquam molestias. Vel unde, blanditiis.</p>

                                    <form>
                                        <div class="input-group">
                                            <input class="form-control" type="text" placeholder="E-mail ... ">
                                            <span class="input-group-btn">
                                                <button class="btn btn-primary subscribe" type="button"><i class="pe-7s-paper-plane pe-2x"></i></button>
                                            </span>
                                        </div>
                                        <!-- /input-group -->
                                    </form> 

                                    <div class="social pull-right"> 
                                        <ul>
                                            <li><a class="wow fadeInUp animated" href="https://twitter.com/kimarotec"><i class="fa fa-twitter"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://www.facebook.com/kimarotec" data-wow-delay="0.2s"><i class="fa fa-facebook"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://plus.google.com/kimarotec" data-wow-delay="0.3s"><i class="fa fa-google-plus"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://instagram.com/kimarotec" data-wow-delay="0.4s"><i class="fa fa-instagram"></i></a></li>
                                            <li><a class="wow fadeInUp animated" href="https://instagram.com/kimarotec" data-wow-delay="0.6s"><i class="fa fa-dribbble"></i></a></li>
                                        </ul> 
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="footer-copy text-center">
                    <div class="container">
                        <div class="row">
                            <div class="pull-left">
                                <span> (C) <a href="http://www.KimaroTec.com">KimaroTheme</a> , All rights reserved 2016  </span> 
                            </div> 
                            <div class="bottom-menu pull-right"> 
                                <ul> 
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.2s">Home</a></li>
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.3s">Property</a></li>
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.4s">Faq</a></li>
                                    <li><a class="wow fadeInUp animated" href="#" data-wow-delay="0.6s">Contact</a></li>
                                </ul> 
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
