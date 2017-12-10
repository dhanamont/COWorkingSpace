<%-- 
    Document   : HistoryOrder
    Created on : Dec 9, 2017, 11:08:31 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String User_ID = (String) session.getAttribute("User_ID");%>
        
        
        <%--<h1>History Order eiei</h1>
        payment id = <%= request.getAttribute("paymentID")%> <br>
        payment method = <%= request.getAttribute("paymentMethod")%> <br>
        order id = <%= session.getAttribute("orderID")%> <br>--%>
       
        
        <!-- DataSource Connect -->
        <sql:setDataSource var="it58070122_se" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se"
                           user="it58070122_se" password="chFKW9lGV"/>
                    
        <sql:query var="history" dataSource="${it58070122_se}">
            SELECT r.Order_Date, r.Start_Time, r.End_Time, r.Order_Status, t.Table_ID,
            o.Room_Name, y.Type_Name, s.Space_Name
            From `User` u
            JOIN Ordering r USING (User_ID)
            JOIN `Table` t USING (Table_ID)
            JOIN Room o USING (Room_ID)
            JOIN Type_Space y USING (Type_ID)
            JOIN `Space` s USING (Space_ID)
            WHERE u.User_ID = ? ;
            <sql:param value="${User_ID}"/>
        </sql:query>


        <c:forEach var="row" items="${history.rows}">
            <c:out value="${row.Space_Name}"/> <br>
            <c:out value="${row.Type_Name}"/> <br>
            <c:out value="${row.Room_Name}"/> <br>
            <c:out value="${row.Table_ID}"/> <br>
            <c:out value="${row.Order_Date}"/> <br>
            <c:out value="${row.Start_Time}"/> <br>
            <c:out value="${row.End_Time}"/> <br>
            <c:out value="${row.Price}"/> <br>
            <c:out value="${row.Order_Status}"/> <br>
            <h1>+++++++++++++++++++++++++++++++++</h1>
        </c:forEach>

        
    </body>
</html>

