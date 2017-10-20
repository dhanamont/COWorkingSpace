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
public class User {
     Connection conn;

    public User() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/coworking_db", 
                "it58070122_se",
                "chFKW9lGV");
    }
    private String User_ID;
    private String Fname;
    private String Lname;
    private String Email;
    private String Phone_Number;
    private String Address;
    private String IDcard;
    
        public void UpdateUser(String strFName, String strLName, String strEmail, String UserID) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Update User set Fname='" + strFName + "', Lname='" + strLName + "', Email='" + strEmail + "' where User_ID='" + UserID + "';";
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
        }
    }

    public void insertUser(String User_ID1, String fname, String lname, String email) {
        try {
            Statement stmt = conn.createStatement();
            String sql2 = "Insert into User values('" + User_ID1 + "', '" + fname + "', '" + lname + "', '" + email + "')";
            stmt.executeUpdate(sql2);
        } catch (SQLException ex) {
        }
    }


    public String getFname(String UserID, String Role) {
        return Fname;
    }

    public String getLname(String UserID, String Role) {
        return Lname;
    }

    public String getEmail(String UserID, String Role) {
        return Email;
    }

    public String getPhone_Number(String UserID, String Role) {
        return Phone_Number;
    }

    public String getAddress(String UserID, String Role) {
        return Address;
    }

    public String getIDcard(String UserID, String Role) {
        return IDcard;
    }
}
