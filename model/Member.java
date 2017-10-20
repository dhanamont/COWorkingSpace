/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author test
 */
public class Member {
     Connection conn;

    public Member() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/coworking_db", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    public void UpdateMember(String strPhoneNum, String strGen, String strAddress, String strIDcard, String strBDate, String LoginID) {
        try {
            Statement stmt = conn.createStatement();
            String sql1 = "Update Member set Phone_Number='" + strPhoneNum + "', Gender='" + strGen + "', Address='" + strAddress + "',IDcard='" + strIDcard + "', Birth_Date='" + strBDate + "' where User_ID='" + LoginID + "';";
            stmt.executeUpdate(sql1);

        } catch (SQLException ex) {
        }
    }

    public void insertMember(String User_ID, String phone, String address, String card) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Insert into Member values('" + User_ID + "', '" + phone + "', '" + address + "', '" + card + "', NULL)";
            
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
        }
    }
}
