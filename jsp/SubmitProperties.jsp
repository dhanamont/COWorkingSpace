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
        <title>GARO ESTATE | Submit Co-working</title>
        <meta name="description" content="GARO is a real-estate template">
        <meta name="author" content="Kimarotec">
        <meta name="keyword" content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min.css"> 
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/icheck.min_all.css">
        <link rel="stylesheet" href="assets/css/price-range.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.css">  
        <link rel="stylesheet" href="assets/css/owl.theme.css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css"> 
        <link rel="stylesheet" href="assets/css/wizard.css"> 
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
    </head>
    <body>

        <div id="preloader">
            <div id="status"></div>
        </div>
        
        <!-- DataSource Connect -->
        <sql:setDataSource var="it58070122_se" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se" 
                           user="it58070122_se" password="chFKW9lGV"/>
        
        <% String Role_ID = (String) session.getAttribute("Role_ID");%>
        <% String Username = (String) session.getAttribute("Username");%>
        <% String User_ID = (String) session.getAttribute("User_ID");%>

        <!-- Check Role Entrepreneur-->
        <% if (Role_ID == null) { %>
            <% response.sendRedirect("index.jsp");%>
        <% } else if (Role_ID.equals("ENT")) {%>
        <!-- Start Navbar Entrepreneur -->
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
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a class="" href="index.jsp#about" id="about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="index.jsp#contact">Contact</a></li>
                        <li class="dropdown ymm-sw " data-wow-delay="0.1s">
                            <a class="dropdown-toggle active" data-toggle="dropdown" data-hover="dropdown" data-delay="200"><%= session.getAttribute("Username")%> <b class="caret"></b></a>
                            <ul class="dropdown-menu navbar-nav">
                                <li>
                                    <a href="">Edit Profile</a>
                                </li>
                                <li>
                                    <a href="SubmitProperties.jsp">Submit Co-working</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Reservation list</a>
                                </li>
                                <li>
                                    <a href="index-4.html">Sign out</a>
                                </li>

                            </ul>
                        </li>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <% } %>
        <!-- End Navbar Entrepreneur -->

        <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">Submit new Co-working Space</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->

        <!-- property area -->
        <div class="content-area submit-property" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">
                <div class="clearfix" > 
                    <div class="wizard-container"> 

                        <div class="wizard-card ct-wizard-orange" id="wizardProperty">
                            <form name="SubmitPropertiesServlet" action="SubmitPropertiesServlet" method="POST" enctype="multipart/form-data">                        
                                <div class="wizard-header">
                                    <h3>
                                        <b>Submit</b> YOUR CO-WORKING SPACE<br><br>
                                        <small>It's free and always will be</small>
                                    </h3>
                                </div><br>

                                <ul>
                                    <li><a href="#step1" data-toggle="tab">Step 1 </a></li>
                                    <li><a href="#step2" data-toggle="tab">Step 2 </a></li>
                                    <li><a href="#step3" data-toggle="tab">Step 3 </a></li>
                                    <li><a href="#step4" data-toggle="tab">Finished </a></li>
                                </ul>

                                <div class="tab-content">

                                    <div class="tab-pane" id="step1">
                                        <h4 class="info-text"> Let's start with the basic information </h4>
                                        <div class="row">
                                            <div class="col-sm-12"> 
                                                <div class="col-sm-12">
                                                    <div class="form-group">
                                                        <label>Co-working Space name :</label>
                                                        <input type="input" class="form-control" name="Space_Name">
                                                    </div> 
                                                </div> 
                                            </div>

                                            <div class="col-sm-12">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        
                                                        <label>Place :</label>
                                                        <select id="Place" name="Place" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Select your place">
                                                            <option>Siam</option>
                                                            <option>Silom</option>
                                                            <option>Asok</option>
                                                            <option>Onnut</option>
                                                            <option>Ekkamai</option>
                                                    </select>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Picture poster :</label>
                                                        <input type="file" id="exampleInputFile" name="Picture_poster">
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Picture cover :</label>
                                                        <input type="file" id="exampleInputFile" name="Picture_cover">
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="col-sm-12">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Open date :</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="col-sm-12 padding-top-15">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Monday" name="Open_Date"> Monday
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Tuesday" name="Open_Date"> Tuesday
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>                                                 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Wednesday" name="Open_Date"> Wednesday
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>                                                 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Thursday" name="Open_Date"> Thursday
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div> 
                                            </div> 
                                            <div class="col-sm-12 padding-bottom-15">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Friday" name="Open_Date"> Friday
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Saturday" name="Open_Date"> Saturday
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Sunday" name="Open_Date">  Sunday
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="col-sm-12">
                                            <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Open time</label>
                                                        <select class="selectpicker" name="Start_Time" title="Select open time">
                                                            <option>07:00:00</option>
                                                            <option>08:00:00</option>
                                                            <option>09:00:00</option>
                                                            <option>10:00:00</option>
                                                            <option>11:00:00</option>
                                                            <option>12:00:00</option>
                                                            <option>13:00:00</option>
                                                            <option>14:00:00</option>
                                                            <option>15:00:00</option>
                                                            <option>16:00:00</option>
                                                            <option>17:00:00</option>
                                                            <option>18:00:00</option>
                                                            <option>19:00:00</option>
                                                            <option>20:00:00</option>
                                                            <option>21:00:00</option>
                                                            <option>22:00:00</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Close time</label>
                                                        <select id="lunchBegins" class="selectpicker" name="End_Time" title="Select close time">
                                                            <option>07:00:00</option>
                                                            <option>08:00:00</option>
                                                            <option>09:00:00</option>
                                                            <option>10:00:00</option>
                                                            <option>11:00:00</option>
                                                            <option>12:00:00</option>
                                                            <option>13:00:00</option>
                                                            <option>14:00:00</option>
                                                            <option>15:00:00</option>
                                                            <option>16:00:00</option>
                                                            <option>17:00:00</option>
                                                            <option>18:00:00</option>
                                                            <option>19:00:00</option>
                                                            <option>20:00:00</option>
                                                            <option>21:00:00</option>
                                                            <option>22:00:00</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="col-sm-12">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <label>Services :</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="col-sm-12 padding-top-15">
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Wi-fi" name="Service_Name" > Wi-Fi
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Cafe" name="Service_Name" > Cafe
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                               <input type="checkbox"  value="Parking lot" name="Service_Name" > Parking lot
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <div class="col-sm-3">
                                                    <div class="form-group">
                                                        <div class="checkbox">
                                                            <label>
                                                                <input type="checkbox" value="Photocopier" name="Service_Name" > Photocopier
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div> 
                                            </div> 
                                            
                                            
                                            <br>
                                        </div>
                                    </div>
                                    <!-- End step 1 -->

                                    <div class="tab-pane" id="step2">
                                    <h4 class="info-text"> Add Room of Co-working space Types </h4>
                                    <div class="input_fields_wrap">
                                        <b>Add Type Space</b> <a class="btn btn-success glyphicons glyphicon-plus add_field_button"></a> <br>

                                        <div class="well input_fields_wrap1">
                                            <div class="row">
                                                <div class="col-sm-10 col-sm-offset-1">
                                                    <label>Type name: <small>(required)</small></label><br>  
                                                    <div class="form-group">
                                                    <select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Select type of space" name="Type_name[]">
                                                        <option>Common Room</option>
                                                        <option>Meeting Room</option>
                                                        <option>Private Office</option>
                                                    </select>
                                                    </div>
                                                    <label>Number of room: <small>(required)</small></label><br>  
                                                    <input type="text" class="form-control" name="NumberofRoom[]">
                                                    <label>Prototype: <small>(required)</small></label><br>  
                                                    <input class="form-control" type="file" id="exampleInputFile" name="Prototype">
                                                    <label>Picture Type Space: <small>(required)</small></label><br>  
                                                    <input class="form-control" type="file" id="exampleInputFile" name="Picture_room">
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <p><b>Add Room</b> <a class="btn btn-success glyphicons glyphicon-plus add_field_button1"></a>
                                        <div class="well input_fields_wrap2">
                                            <div class="row">
                                                <div class="col-sm-10 col-sm-offset-1">
                                                    <label>Type name: <small>(required)</small></label><br>  
                                                    <div class="form-group">
                                                    <select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Select type of space" name="Type_name">
                                                        <option>Common Room</option>
                                                        <option>Meeting Room</option>
                                                        <option>Private Office</option>
                                                    </select>
                                                    </div>
                                                    <label>Number of table: <small>(required)</small></label><br>  
                                                    <input type="text" class="form-control" name="NumberofTable[]">
                                                    <label>Price/Hour: <small>(Bath)</small></label><br>  
                                                    <input type="text" class="form-control" name="Price[]">
                                                    <label>Person/Table: <small>(required)</small></label><br>  
                                                    <input type="text" class="form-control" name="NumofPeople[]">
                                                </div>
                                            </div>
                                        </div>


                                        <script>
                                            $(document).ready(function () {
                                                var max_fields = 10; //maximum input boxes allowed
                                                var wrapper = ".input_fields_wrap"; //Fields wrapper
                                                var showtime_wrapper = ".input_fields_wrap1"; //Showtime wrapper
                                                var zone_wrapper = ".input_fields_wrap2"; //Zone wrapper
                                                var addShowtime = ".add_field_button"; //Add showtime button
                                                var addZone = ".add_field_button1"; //Add zone button
                                                var removeField = ".remove_field"; //Remove button
                                                var x = 1; //initlal text box count
                                                $(wrapper).on("click", addShowtime, function (e) { // (Showtime) add Showtime on click
                                                    e.preventDefault();
                                                    if (x < max_fields) { //max input box allowed
                                                        x++; //text box increment
                                                        $(this).closest(wrapper).append('<div class="well input_fields_wrap1"><a href="#" class="btn btn-danger remove_field" style="float:right;"><i class="glyphicon glyphicon-remove"></i></a><div class="row"><div class="col-sm-10 col-sm-offset-1"><label>Type name: <small>(required)</small></label><br><div class="form-group"><select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Select type of space" name="Type_name"><option>Common Room</option><option>Meeting Room</option><option>Private Office</option></select></div><label>Number of room: <small>(required)</small></label><br><input type="text" class="form-control" name="NumberofRoom[]"><label>Prototype: <small>(required)</small></label><br><input class="form-control" type="file" id="exampleInputFile" name="Prototype"><label>Picture Type Space: <small>(required)</small></label><br><input class="form-control" type="file" id="exampleInputFile" name="Picture_room"></div></div></div>'); //add input box
                                                    }
                                                });
                                                $(wrapper).on("click", addZone, function (e) { // (Zone) add zone on click
                                                    e.preventDefault();
                                                    if (x < max_fields) { //max input box allowed
                                                        x++; //text box increment
                                                        $(this).closest(wrapper).append('<div class="well input_fields_wrap2"><a href="#" class="btn btn-danger remove_field" style="float:right;"><i class="glyphicon glyphicon-remove"></i></a><div class="row"><div class="col-sm-10 col-sm-offset-1"><label>Type name: <small>(required)</small></label><br><div class="form-group"><select id="lunchBegins" class="selectpicker" data-live-search="true" data-live-search-style="begins" title="Select type of space" name="Type_name"><option>Common Room</option><option>Meeting Room</option><option>Private Office</option></select></div><label>Number of table: <small>(required)</small></label><br><input type="text" class="form-control" name="NumberofTable[]"><label>Price: <small>(Bath)</small></label><br><input type="text" class="form-control" name="Price[]"><label>Person/Table: <small>(required)</small></label><br><input type="text" class="form-control" name="NumofPeople[]"></div></div></div>'); //add input box
                                                    }
                                                });
                                                $(wrapper).on("click", removeField, function (e) { //user click on remove text
                                                    e.preventDefault();
                                                    $(this).closest('div').remove(); // Remove cloest parent (Zone or Showtime)
                                                    x--;
                                                });
                                            });
                                        </script>

                                    </div>
                                    </div>
                                    <!-- End step 2 -->

                                    <div class="tab-pane" id="step3">
                                        <h4 class="info-text">All change will be appear to your article</h4>
                                    <div class="profiel-header">
                                <hr>
                            </div>

                            <div class="clear">

                                <div class="col-sm-10 col-sm-offset-1">
                                    <div class="form-group">
                                        <label>Description <small>(required)</small></label><br>                                
                                        <textarea type="input" rows="4" cols="127" name="Description"></textarea>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Link Map <small>(required)</small></label>
                                        <input type="input" class="form-control" name="Map">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Address <small>(required)</small></label>
                                        <input type="input" class="form-control" name="Address">
                                    </div>
                                </div>
                                
                            </div>
                                    </div>
                                    <!--  End step 3 -->

                                    <div class="tab-pane" id="step4">                                        
                                        <h4 class="info-text"> Finished and submit </h4>
                                        <div class="row">  
                                            <div class="col-sm-12">
                                                <div class="">
                                                    <p>
                                                        <label><strong>Terms and Conditions</strong></label>
                                                        By accessing or using  CO-WORKING SPACE Service, such as 
                                                        posting your co-working space advertisement with your personal 
                                                        information on our website you agree to the
                                                        collection, use and disclosure of your personal information 
                                                        in the legal proper manner
                                                    </p>

                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" /> <strong>Accept termes and conditions.</strong>
                                                        </label>
                                                    </div> 

                                                </div> 
                                            </div>
                                        </div>
                                    </div>
                                    <!--  End step 4 -->

                                </div>

                                <div class="wizard-footer">
                                    <div class="pull-right">
                                        <input type='button' class='btn btn-next btn-primary' name='next' value='Next' />
                                        <input type='submit' class='btn btn-finish btn-primary ' name='finish' value='Finish' />
                                    </div>

                                    <div class="pull-left">
                                        <input type='button' class='btn btn-previous btn-default' name='previous' value='Previous' />
                                    </div>
                                    <div class="clearfix"></div>                                            
                                </div>	
                            </form>
                        </div>
                        <!-- End submit form -->
                    </div> 
                </div>
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
            </div>

           

        </div>
         <!-- jQuery -->
        <script src="js/jquery.js"></script>

        
        <script src="assets/js/vendor/modernizr-2.6.2.min.js"></script>
        <script src="assets/js//jquery-1.10.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-hover-dropdown.js"></script>
        <script src="assets/js/easypiechart.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.js"></script>
        <script src="assets/js/icheck.min.js"></script>

        <script src="assets/js/price-range.js"></script> 
        <script src="assets/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
        <script src="assets/js/jquery.validate.min.js"></script>
        <script src="assets/js/wizard.js"></script>

        <script src="assets/js/main.js"></script>


    </body>
</html>
