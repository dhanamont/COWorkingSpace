<%-- 
    Document   : ReservationList
    Created on : Dec 10, 2017, 2:42:43 PM
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
        
        <!-- DataSource Connect -->
        <sql:setDataSource var="it58070122_se" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se"
                           user="it58070122_se" password="chFKW9lGV"/>
                    
        <sql:query var="orderList" dataSource="${it58070122_se}">
            SELECT CONCAT(u.Fname, " ",u.Lname) AS `Name`, y.Type_Name, o.Room_Name, t.Table_ID,
            r.Order_Status, r.Total_Price, r.Order_Date
            FROM `User` u
            JOIN `Space` s USING (User_ID)
            JOIN Type_Space y USING (Space_ID)
            JOIN Room o USING (Type_ID)
            JOIN `Table` t USING (Room_ID)
            JOIN Ordering r USING (Table_ID)
            WHERE u.User_ID = ? ;
            <sql:param value="${User_ID}"/>
        </sql:query>
            
            <c:forEach var="row" items="${orderList.rows}">
                <c:out value="${row.Name}"/> <br>
                <c:out value="${row.Type_Name}"/> <br>
                <c:out value="${row.Room_Name}"/> <br>
                <c:out value="${row.Table_ID}"/> <br>
                <c:out value="${row.Order_Status}"/> <br>
                <c:out value="${row.Total_Price}"/> <br>
                <c:out value="${row.Order_Date}"/> <br>
                <h1>+++++++++++++++++++++++++++++++++</h1>
            </c:forEach>
    </body>
</html>
