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
import java.util.ArrayList;

/**
 *
 * @author test
 */
public class Table {
    Connection con;
    public Table() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    private String Table_ID;
    
    public String createTable_ID() {
        try {
            Statement stmt = con.createStatement();
            String numSpa = "SELECT COUNT(Table_ID)+1 from `Table`";
            ResultSet numSpa1 = stmt.executeQuery(numSpa);
            numSpa1.next();
            Table_ID = numSpa1.getString("count(Table_ID)+1");

        return Table_ID;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public void insertTable(String TableID, int NumofPeople, String Room_ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Insert into `Table` values('" + TableID + "', '" + NumofPeople + "', '" + Room_ID +"';";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
        }
    }
    
    public void getTable_ID(ArrayList<String> TableID, String Room_ID) {
        try {
            Statement stmt = con.createStatement();
            String table = "SELECT Table_ID FROM `Table` WHERE Room_ID = '" + Room_ID + "';";
            ResultSet rs1 = stmt.executeQuery(table);
            while (rs1.next()){
                TableID.add(rs1.getString("Type_ID"));
            }
        } catch (SQLException ex) {
        }
        
    }
}
