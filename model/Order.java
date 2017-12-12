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
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private String Order_Date;
    private String Start_Time;
    private String End_Time;
    private String Order_Status;
    private String Type_Name;
    private String Room_Name;
    private String Table_ID;
    private String Total_price;

    public void createOrder_ID() {
        try {
            Statement stmt = con.createStatement();
            String numOrd = "Select count(Order_ID) from Ordering";
            ResultSet numOrd1 = stmt.executeQuery(numOrd);
            numOrd1.next();
            String numOrder = numOrd1.getString("count(Order_ID)");
            Order_ID = "R";
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

//    public float getTotalPrice(String Order_ID) {
//        try {
//            Statement stmt = con.createStatement();
//            String sql = "Select Total_Price from Ordering where Order_ID = '" + Order_ID + "'";
//            ResultSet rs1 = stmt.executeQuery(sql);
//            rs1.next();
//            float Total_Price = rs1.getFloat("Total_Price");
//            return Total_Price;
//        } catch (SQLException ex) {
//        }
//        return 0;
//    }

    public void insertOrder(String Order_ID, String Order_Status,float Total_Price,Date Order_Date,Time Start_Time,Time End_Time, String User_ID, String Table_ID) {
        try {
            DateFormat toDate = new SimpleDateFormat("yyyy-MM-dd");
            Statement stmt = con.createStatement();
            String insorder = "Insert into Ordering values('" + Order_ID + "', '" 
                    + Order_Status + "', '" + Total_Price + "',NOW(), '" + toDate.format(Order_Date) + "', '" + Start_Time 
                    + "', '" + End_Time+ "', '" + User_ID + "', '" + Table_ID + "')";
            stmt.executeUpdate(insorder);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteOrder(String Order_ID) {
        try {
            Statement stmt = con.createStatement();
            String delorder = "Delete From Ordering Where Order_ID = '" + Order_ID + "'";
            stmt.executeUpdate(delorder);

        } catch (SQLException ex) {
        }
    }


    public void showAllOrderEnt(String User_ID, ArrayList<String> Order_ID, ArrayList<String> Type_Name, ArrayList<String> Order_Status) {
        try {
            Statement stmt = con.createStatement();
            String sh = "Select y.Type_Name, r.Order_Status, r.Order_ID\n"
                    + "FROM `User` u JOIN `Space` s USING (User_ID)\n"
                    + "JOIN Type_Space y USING (Space_ID)\n"
                    + "JOIN Room o USING (Type_ID)\n"
                    + "JOIN `Table` t USING (Room_ID)\n"
                    + "JOIN Ordering r USING (Table_ID)\n"
                    + "WHERE u.User_ID = '" + User_ID + "' ";
            ResultSet cn = stmt.executeQuery(sh);
            while (cn.next()) {
                Order_ID.add(cn.getString("Order_ID"));
                Type_Name.add(cn.getString("Type_Name"));
                Order_Status.add(cn.getString("Order_Status"));
                
           }
            System.out.print(Order_ID);
                System.out.print(Type_Name);
                System.out.print(Order_Status);
            cn.close();
        } catch (SQLException ex){
            System.out.print(ex);
        }
    }
    
    public void viewDetailOrder(String Order_ID) {
        try {
            Statement stmt = con.createStatement();
            String sh = "SELECT CONCAT(u.Fname, \" \", u.Fname) AS `Name`, y.Type_Name, o.Room_Name, t.Table_ID,\n" +
                        "r.Order_Status, r.Total_Price, r.Order_Date\n" +
                        "FROM `User` u\n" +
                        "JOIN `Space` s USING (User_ID)\n" +
                        "JOIN Type_Space y USING (Space_ID)\n" +
                        "JOIN Room o USING (Type_ID)\n" +
                        "JOIN `Table` t USING (Room_ID)\n" +
                        "JOIN Ordering r USING (Table_ID)\n" +
                        "WHERE r.Order_ID = '"+Order_ID+"' ;";
            ResultSet cn = stmt.executeQuery(sh);
            cn.next();
                Type_Name = cn.getString("Type_Name");
                Room_Name = cn.getString("Room_Name");
                Table_ID = cn.getString("Table_ID");
                Order_Status = cn.getString("Order_Status");
                Total_price = cn.getString("Total_Price");
                Order_Date = cn.getString("Order_Date");
            cn.close();
        } catch (SQLException ex){
            System.out.print(ex);
        }
    }

    public String getOrder_Date(String Order_ID) {
        viewDetailOrder(Order_ID);
        return Order_Date;
    }

    public String getOrder_Status(String Order_ID) {
        viewDetailOrder(Order_ID);
        return Order_Status;
    }

    public String getType_Name(String Order_ID) {
        viewDetailOrder(Order_ID);
        return Type_Name;
    }

    public String getRoom_Name(String Order_ID) {
        viewDetailOrder(Order_ID);
        return Room_Name;
    }

    public String getTable_ID(String Order_ID) {
        viewDetailOrder(Order_ID);
        return Table_ID;
    }

    public String getTotal_price(String Order_ID) {
        viewDetailOrder(Order_ID);
        return Total_price;
    }
    
    

//    public String getSpaceID() {
//        return SpaceID;
//    }
//
//    public String getSpace_Name() {
//        return Space_Name;
//    }
//    
//    public String getOrder_Date(){
//        return Order_Date;
//    }
//    
//    public String getStart_Time(){
//        return Start_Time;
//    }
//    
//    public String getEnd_Time(){
//        return End_Time;
//    }
//    
//    public String getOrder_Status(){
//        return Order_Status;
//    }

    public void UpdateStatusPAID(String Order_ID) {
        try {
            Statement stmt = con.createStatement();
            String sqls = "Update Ordering SET Order_Status = 'PAID' WHERE Order_ID = '" + Order_ID + "'";
            stmt.executeUpdate(sqls);
        } catch (SQLException ex) {
        }
    }
    public void UpdateStatusCancel(String Order_ID) {
        try {
            Statement stmt = con.createStatement();
            String sqls = "Update Ordering SET Order_Status = 'CANCEL' WHERE Order_ID = '" + Order_ID + "'";
            stmt.executeUpdate(sqls);
        } catch (SQLException ex) {
        }
    }
    
    
    //*-- test check table avaliable
    public String checkTable(Time Start_Time,Time End_Time, Date Order_Date, String Table_ID) throws SQLException, ClassNotFoundException{
        String check = "false";
        
        /* 1.ถ้าเวลา end อยู่ก่อนเวลา start */
        if(Start_Time.after(End_Time)){
            return check;
        }
        
        /* 2.check overlap time */
        check = new Order().isOverlap(Start_Time, End_Time, Order_Date, Table_ID);
        
    return check;           
    }
    
    
    public String isOverlap(Time Start_Time, Time End_Time, Date Order_Date, String Table_ID) throws SQLException {
        
        DateFormat toDate = new SimpleDateFormat("yyyy-MM-dd");
        String check = "true";
        
        Statement stmt = con.createStatement();
        String sql = "SELECT Order_ID FROM Ordering\n"
                + "WHERE (Order_Date ='" + toDate.format(Order_Date) + "')AND(Table_ID ='" + Table_ID + "') \n"
                + "AND (\n"
                + "((Start_Time <= '" + Start_Time + "') AND (End_Time > '" + Start_Time + "'))\n"
                + "OR\n"
                + "((Start_Time < '" + End_Time + "') AND (End_Time >= '" + End_Time + "'))\n"
                + "OR\n"
                + "((Start_Time >= '" + Start_Time + "') AND (End_Time <= '" + End_Time + "'))\n"
                + "oR\n"
                + "((Start_Time <= '" + Start_Time + "') AND (End_Time >= '" + End_Time + "'))\n"
                + ");\n";
        
        ResultSet ch = stmt.executeQuery(sql);
        String list = "";
        while (ch.next()) {
            System.out.println("Following reservation list is overlapped");
            list += ch.getString("Order_ID") + " \n";
            //System.out.println(ch.getInt("Order_ID"));
        }
        ch.last();
        Integer count = ch.getRow();
        if (count == 0) {
            check = "false"; //There isn't overlapped.
            System.out.println("There isn't overlapped");
        } else {
            check += count + " Order ID : " + list + ")";
        }
        return check;
    }
    
//    public void getHistory(String userID) {
//        try {
//            Statement stmt = con.createStatement();
//            String sql = "Select Order_Date, Start_Time, End_Time, Order_Status from Ordering where User_ID = '" + userID + "' ";
//            ResultSet rs = stmt.executeQuery(sql);
//            rs.next();
//            Order_Date = rs.getString("Order_Date");
//            Start_Time = rs.getString("Start_Time");
//            End_Time = rs.getString("End_Time");
//            Order_Status = rs.getString("Order_Status");
//        } catch (SQLException ex) {
//            
//        }
//    }
//    
   
}

    

