/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Member {
     Connection conn;

    public Member() throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");       
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.conn = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    public void UpdateMember(String strPhoneNum, String strAddress, String strIDcard, String UserID) {
        try {
            Statement stmt = conn.createStatement();
            String sql1 = "Update Member set Phone_Number='" + strPhoneNum + "', Address='" + strAddress + "',IDcard='" + strIDcard + "' where User_ID='" + UserID + "';";
            stmt.executeUpdate(sql1);

        } catch (SQLException ex) {
        }
    }

    public void insertMember(String User_ID, String card) {
        try {
            PreparedStatement insertMem = conn.prepareStatement("insert into Member values(?,?,?,?)");
      
            insertMem.setString(1, User_ID);
            insertMem.setString(2, " ");
            insertMem.setString(3, " ");
            insertMem.setString(4, card);
            insertMem.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("MEMBER SQL ERROR");
        }
    }
}
