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
 * @author lenovo
 */
public class Service {
    Connection con;

    public Service() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    private String Service_ID;
    
    public String createService_ID() {
        try {
            Statement stmt = con.createStatement();
            String numSpa = "SELECT COUNT(Service_ID)+1 'ID' FROM Service";
            ResultSet numSpa1 = stmt.executeQuery(numSpa);
            numSpa1.next();
            Service_ID = numSpa1.getString("ID");
return Service_ID;
        } catch (SQLException ex) {
            System.out.println("createServiceID: "+ex);
        }
        return null;
        
    }
    
    public void insertService(String Service_ID, String Service_Name, String Space_ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Insert into Service values('" + Service_ID + "', '" + Service_Name + "', '" + Space_ID + "');";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("insertService: "+ex);
        }
    }
    
}
