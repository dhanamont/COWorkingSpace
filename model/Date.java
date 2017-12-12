/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author test
 */
public class Date {
    Connection con;
    public Date() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    private String Date_ID;
    
    public String createDate_ID() {
        try {
            Statement stmt = con.createStatement();
            String numSpa = "SELECT COUNT(Date_ID)+1 from `Date`";
            ResultSet numSpa1 = stmt.executeQuery(numSpa);
            numSpa1.next();
            Date_ID = numSpa1.getString("count(Date_ID)+1");

        } catch (SQLException ex) {
        }
        return Date_ID;
    }
    
}
