<%-- 
    Document   : ViewDetail
    Created on : Dec 10, 2017, 7:49:07 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- ต้องส่งค่า Order_ID มาให้ ViewDetailServlet -->
        <form name="ViewDetailServlet" method="post" action="ViewDetailServlet">
            <input type="submit" class="btn btn-default" name="buttonValue" value="PAID"></button>
            <input type="submit" class="btn btn-default" name="buttonValue" value="CANCEL"></button>
        </form>
    </body>
</html>
