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
 * @author jirpinya
 */
public class Order {

    Connection con;

    public String SpaceID;
    public String Space_Name;

    public Order() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    private String Order_ID;

    public void createOrder_ID() {
        try {
            Statement stmt = con.createStatement();
            String numOrd = "Select count(Order_ID) from Order";
            ResultSet numOrd1 = stmt.executeQuery(numOrd);
            numOrd1.next();
            String numOrder = numOrd1.getString("count(Order_ID)");
            for (int i = numOrder.length(); i < 3; i++) {
                Order_ID += "0";
            }
            Order_ID += numOrder;

        } catch (SQLException ex) {
        }
    }

    public String getOrder_ID() {
        createOrder_ID();
        return Order_ID;
    }

    public float getTotalPrice(String Order_ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Select Total_Price from Order where Order_ID = '" + Order_ID + "'";
            ResultSet rs1 = stmt.executeQuery(sql);
            rs1.next();
            float Total_Price = rs1.getFloat("Total_Price");
            return Total_Price;
        } catch (SQLException ex) {
        }
        return 0;
    }

    public void insertOrder(String Order_ID, String Order_Status,String Order_Date,String Start_Time,String End_Time, float Total_Price, String User_ID, String Table_ID) {
        try {
            Statement stmt = con.createStatement();
            String insorder = "Insert into Order values('" + Order_ID + "', '" + Order_Status + "', '" + Total_Price + "',NOW(), '" + User_ID + "', '" + Order_Date + "', '" + Start_Time 
                    + "', '" + End_Time+ "', '" + User_ID + "', '" + Table_ID + "')";
            stmt.executeUpdate(insorder);
        } catch (SQLException ex) {
        }
    }

    public void deleteOrder(String Order_ID) {
        try {
            Statement stmt = con.createStatement();
            String delorder = "Delete From Order Where Order_ID = '" + Order_ID + "'";
            stmt.executeUpdate(delorder);

        } catch (SQLException ex) {
        }
    }


    public void showAllOrder(String Space_ID, ArrayList<String> User_ID, ArrayList<String> Order_ID, ArrayList<String> Order_Status, ArrayList<String> Order_Datetime, ArrayList<String> Total_Price) {
        try {
            Statement stmt = con.createStatement();
            String sh = "SELECT DISTINCT User.User_ID, r.User_ID , Order_ID, Order_Datetime, Order_Status, Total_Price, Concert_ID, Concert_Name "
                    + "FROM User "
                    + "JOIN Order r USING (User_ID) "
                    + "JOIN Table USING (Table_ID) "
                    + "JOIN Room USING (Room_ID) "
                    + "JOIN Type_space USING (Type_ID) "
                    + "JOIN Space USING (Space_ID) "
                    + "WHERE (User.User_ID = r.User_ID ) and (Space_ID = '" + Space_ID + "');";
            ResultSet cn = stmt.executeQuery(sh);

            while (cn.next()) {
                Space_Name = cn.getString("Space_Name");
                SpaceID = cn.getString("Space_ID");
                Order_ID.add(cn.getString("Order_ID"));
                User_ID.add(cn.getString("User_ID"));
                Order_Datetime.add(cn.getString("Order_Datetime"));
                Order_Status.add(cn.getString("Order_Status"));
                Total_Price.add(cn.getString("Total_Price"));
            }

        } catch (SQLException ex) {
        }
    }

    public String getSpaceID() {
        return SpaceID;
    }

    public String getSpace_Name() {
        return Space_Name;
    }


    public void UpdateStatusPAID(String Order_ID) {
        try {
            Statement stmt = con.createStatement();
            String sqls = "Update Order SET Order_Status = 'PAID' WHERE Order_ID = '" + Order_ID + "'";
            stmt.executeUpdate(sqls);

        } catch (SQLException ex) {
        }
    }

}
