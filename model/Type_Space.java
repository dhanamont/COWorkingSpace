/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author test
 */
public class Type_Space {
    Connection con;
    public Type_Space() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    private String Type_Name;
    private String Prototype;
    private String Type_ID;
    
    public String createType_ID() {
        try {
            Statement stmt = con.createStatement();
            String numSpa = "SELECT COUNT(Type_ID)+1 from Type_Space";
            ResultSet numSpa1 = stmt.executeQuery(numSpa);
            numSpa1.next();
            Type_ID = numSpa1.getString("count(Type_ID)+1");

        } catch (SQLException ex) {
        }
        return Type_ID;
    }
    
    public void insertType_Space(String Type_ID, String Type_Name, int NumofRoom, String Prototype, String Space_ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Insert into Type_Space values('" + Type_ID + "', '" + Type_Name + "', '" 
                    + NumofRoom + "', '" + Prototype + ", " + Space_ID +"';";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
        }
    }
    
    public void TypeDetail(String SpaceID) {
        try {
            Statement stmt = con.createStatement();
            String Type_table = "SELECT Type_ID, Type_Name, Prototype FROM Type_Space WHERE Space_ID = '" + SpaceID + "';";
            ResultSet rs1 = stmt.executeQuery(Type_table);
            rs1.next();
            Type_ID = rs1.getString("Type_ID");
            Type_Name = rs1.getString("Type_Name");
            Prototype = rs1.getString("Prototype");
        } catch (SQLException ex) {
        }
    }

    public String getType_ID(String Space_ID) {
        TypeDetail(Space_ID);
        return Type_ID;
    }

    public String getType_Name(String Space_ID) {
        TypeDetail(Space_ID);
        return Type_Name;
    }

    public String getPrototype(String Space_ID) {
        TypeDetail(Space_ID);
        return Prototype;
    }

    
    
}
