/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Account {
    Connection conn;

    public Account() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&amp;characterEncoding=utf8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    private String User_ID;
    private String Username;
    private String Password;
    private String Role_ID;
    private String numAccountMem;
    private String numAccountEnt;
    
    public void getAccount(String usernameIn) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Select User_ID, Username, Password, Role_ID from Account where Username = '" + usernameIn + "' ";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            User_ID = rs.getString("User_ID");
            Username = rs.getString("Username");
            Password = rs.getString("Password");
            Role_ID = rs.getString("Role_ID");

        } catch (SQLException ex) {
        }
    }
        public String numAccountMem() {
        try {
            Statement stmt = conn.createStatement();
            String num = "Select count(User_ID) from Account where Role_ID Like'MEM'";
            ResultSet num1 = stmt.executeQuery(num);
            num1.next();
            numAccountMem = num1.getString("count(User_ID)");
            return numAccountMem;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public String numAccountEnt() {
        try {
            Statement stmt = conn.createStatement();
            String num = "Select count(User_ID) from Account where Role_ID Like'ENT'";
            ResultSet num1 = stmt.executeQuery(num);
            num1.next();
            numAccountEnt = num1.getString("count(User_ID)");
            return numAccountEnt;
        } catch (SQLException ex) {
        }
        return null;
    }

    public void insertAccount(String UserID, String role, String username, String password) {
        try {
            
            PreparedStatement inAcc = conn.prepareStatement("insert into Account values(?,?,?,?)");
      
            inAcc.setString(1, username);
            inAcc.setString(2, password);
            inAcc.setString(3, role);
            inAcc.setString(4, UserID);
            inAcc.executeUpdate();
            conn.close();
            //Statement stmt = conn.createStatement();
            //String sql1 = "Insert into Account values('" + username + "', '" + password + "', '" + role + "', '" + UserID + "')";
            
            //stmt.executeUpdate(sql1);
        } catch (SQLException ex) {
            
            System.out.println("Account SQL ERROR");
        }
    }

    public String createMemUser_ID() {
        numAccountMem();
        User_ID = "1";
        for (int i = numAccountMem.length(); i < 3; i++) {
            User_ID += "0";
        }
        User_ID += numAccountMem;
        return User_ID;
    }

    public String createEntUser_ID() {
        numAccountEnt();
        User_ID = "2";
        for (int i = numAccountEnt.length(); i < 3; i++) {
            User_ID += "0";
        }
        User_ID += numAccountEnt;
        return User_ID;
    }

    public String getUser_ID(String usernameIn) {
        getAccount(usernameIn);
        return User_ID;
    }

    public String getUsername(String usernameIn) {
        getAccount(usernameIn);
        return Username;
    }

    public String getPassword(String usernameIn) {
        getAccount(usernameIn);
        return Password;
    }
    
     public String getRole_ID(String usernameIn) {
        getAccount(usernameIn);
        return Role_ID;
    }
    
}
