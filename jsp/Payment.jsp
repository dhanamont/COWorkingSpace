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
                           user="it58070122_se" password="chFKW9IGV"/>
        
        <% String Role_ID = (String) session.getAttribute("Role_ID");%>
        <% String Username = (String) session.getAttribute("Username");%>

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
                        <li class="wow fadeInDown" data-wow-delay="0.3s"><a href="#about" data-scroll="true">About</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="#contact">Contact</a></li>
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
                        <h1 class="page-title">PAYMENT</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->

        <!-- property area -->
        <form action="PaymentServlet" method="POST"> 
        <div class="content-area submit-property" style="background-color: #FCFCFC;">&nbsp;
                <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <address>
                        <strong>Co-Working Space</strong>
                        <br>
                        3 Thanon Chalong Krung
                        <br>
                        Lat Krabang, BKK 10520
                        <br>
                        <p>Phone: (02) 329 8000 
                    </address>
                    
                    
                    
                    
                    
                    
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <p>
                        <em><td width="100%">&nbsp;<b>Date:</b>&nbsp; <font color="#000000">
                    <%= new java.util.Date() %></font></td></em>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h1>Receipt</h1>
                </div>
                </span>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Reservation</th>
                            <th>#</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="col-md-9"><em><%= request.getAttribute("Service_Name")%> (<%= request.getAttribute("Type_Name")%>, <%= request.getAttribute("Room_Name")%>, <%= request.getAttribute("Table_ID")%>) </em></h4></td>
                            <td class="col-md-1" style="text-align: center"> 1 </td>
                            <td class="col-md-1 text-center"><%= request.getAttribute("Price")%></td>
                            <td class="col-md-1 text-center"><%= request.getAttribute("Price")%></td>
                        </tr>

                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td class="text-right"><h4><strong>Total: </strong></h4></td>
                            <td class="text-center text-danger"><h4><strong><%= request.getAttribute("Price")%></strong></h4></td>
                            
                        </tr>
                        
                        
                    </tbody>
                </table>
                <%--<button type='submit' class='btn btn-success btn-lg btn-block' name='pay'>
                    Pay Now   <span class="glyphicon glyphicon-chevron-right"></span>
                </button>--%>
            </div>
                            <div class="wizard-header">
            <center><h3><b>CHOOSE</b> PAYMENT METHOD</h3></center><br>
            <div>
                
                
                
                
                
                
                
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#credit">Credit Card</a></li>
                <li><a data-toggle="tab" href="#bill">Bill Payment</a></li>
            </ul>

            <!--Step1-->
            <div class="tab-content"><br>

                <div id="credit" name="tab-content" class="tab-pane fade in active">
                       <label for="contactChoice1"><b>Credit Card</b></label>
                       <img src="assets/img/creditcard.png" alt="" class="wow pulse" data-wow-delay="1s"><br><br>
                       <label>Card Number</label>
                       <input type="input" class="form-control" placeholder="Valid Card Number" name="cardnum"/>
                       <label>CVV</label>
                       <input type="input" class="form-control" placeholder="CVV" name="cvv"/><br>                   
                </div>
            
            <!--Step2-->

                <div id="bill" name="tab-content" class="tab-pane fade">
                       <label for="contactChoice2"><b>Bill Payment</b></label><br>
                        <label>Take your barcode to a store and follow these steps:</label><br>
                        <label>1. Tell the cashier you want to pay any amount</label><br>
                        <label>2. Cashier enters payment amount and presses LOAD button</label><br>
                        <label>3. Have cashier scan this barcode:</label><br>
                        <center><img src="assets/img/barcode.png" alt="" width="450" height="47" class="wow pulse" data-wow-delay="1s"></center><br><br>
                                  
                </div>
            </div>
                <button type='submit' class='btn btn-success btn-lg btn-block' name='pay'>
                    Pay Now   <span class="glyphicon glyphicon-chevron-right"></span>
                        </button>       
                
                
        
        
        
        
        
        
       
        


        
        
        
        
        
        
        

        </div>
        </div>
        </div>
        </div>
        </div>
        
        
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
        </form>

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
                                    <li><a href="submit-property.html">Submit Co-working </a></li> 
                                    <li><a href="contact.html">Contact us</a></li> 
                                    <li><a href="faq.html">fqa</a>  </li> 
                                    <li><a href="faq.html">Terms </a>  </li> 
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
