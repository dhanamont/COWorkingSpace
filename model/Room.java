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
public class Room {
    Connection con;
    public Room() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    private String Room_ID;
    private String RoomName;
    private String Price;
    private String RoomName2;
    private String Price2;
    private String NumofTable;
    private ArrayList<String> Room_Name = new ArrayList<String>();
    private ArrayList<String> RoomID = new ArrayList<String>();
    
     public String createRoom_ID() {
        try {
            Statement stmt = con.createStatement();
            String numSpa = "SELECT COUNT(Room_ID)+1 'ID' from Room";
            ResultSet numSpa1 = stmt.executeQuery(numSpa);
            numSpa1.next();
            Room_ID = numSpa1.getString("ID");
            return Room_ID;
        } catch (SQLException ex) {
            System.out.println("createRoomID: "+ex);
        }
        return null;
        
    }
    
   public void insertRoom(String Room_ID, String Room_Name, int NumofTable, String Picture_room, float Price, String Type_ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Insert into Room values('" + Room_ID + "', '" + Room_Name + "', " + NumofTable 
                    + ", '" + Picture_room + "', " + Price + ", '" + Type_ID +"');";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("insertRoom: "+ex);
        }
    }
    
    
   public void getRoomList(ArrayList<String> RoomID, ArrayList<String> RoomName,ArrayList<Float> Price,ArrayList<String> Picture_room, String Type_ID) {
        try {
            Statement stmt = con.createStatement();
            String table = "SELECT Room_ID, Room_Name, Price, Picture_room FROM Room WHERE Type_ID = '" + Type_ID + "';";
            ResultSet rs1 = stmt.executeQuery(table);
            while(rs1.next()){
                RoomID.add(rs1.getString("Room_ID"));
                RoomName.add(rs1.getString("Room_Name"));
                Picture_room.add(rs1.getString("Picture_room"));
                Price.add(rs1.getFloat("Price"));
            }
        } catch (SQLException ex) {
        }
    }
    
//    public void RoomDetail(String Room_ID1){
//        try {
//            Statement stmt = con.createStatement();
//            String room = "SELECT Room_ID, Room_Name, NumofTable, Price FROM Room WHERE Room_ID = '" + Room_ID1 + "';";
//            ResultSet rs1 = stmt.executeQuery(room);
//            rs1.next();
//            Room_ID = rs1.getString("Room_ID");
//            RoomName = rs1.getString("Room_Name");
//            NumofTable = rs1.getString("NumofTable");
//            Price = rs1.getString("Price");
//        } catch (SQLException ex) {
//        }
//    }
   public void RoomDetail(String Type_ID){
        try {
            Statement stmt = con.createStatement();
            String room = "SELECT Room_ID, Room_Name, NumofTable, Price FROM Room WHERE Type_ID = '" + Type_ID + "';";
            ResultSet rs1 = stmt.executeQuery(room);
            rs1.next();
            Room_ID = rs1.getString("Room_ID");
            RoomName = rs1.getString("Room_Name");
            NumofTable = rs1.getString("NumofTable");
            Price = rs1.getString("Price");
        } catch (SQLException ex) {
        }
    }
    
    public String getRoomID(String Room_Name) {
         try {
            Statement stmt = con.createStatement();
            String room = "SELECT Room_ID FROM Room WHERE Room_Name = '" + Room_Name + "';";
            ResultSet rs1 = stmt.executeQuery(room);
            rs1.next();
            Room_ID = rs1.getString("Room_ID");
            
        } catch (SQLException ex) {
            System.out.println("getRoomID: "+ex);
        }
        return Room_ID;
    }

    public String getRoom_ID(String Type_ID) {
        RoomDetail(Type_ID);
        return Room_ID;
    }

    public String getRoomName(String Type_ID) {
        RoomDetail(Type_ID);
        return RoomName;
    }

    public String getPrice(String Room_ID1) {
        RoomDetail(Room_ID1);
        return Price;
    }
    
    public void checkRoomName2(String Room_ID){
        try {
            Statement stmt = con.createStatement();
            String room = "SELECT Room_Name, Price FROM Room WHERE Room_ID = '" + Room_ID + "';";
            ResultSet rs1 = stmt.executeQuery(room);
            rs1.next();
            RoomName2 = rs1.getString("Room_Name");
            Price2 = Float.toString((rs1.getFloat("Price")));
            
            System.out.println("null Price : " + Price2);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
    
    public String getRoomName2(String Room_ID){
        checkRoomName2(Room_ID);
        return RoomName2;
        
    }
    
    public String getPrice2(String Room_ID){
        checkRoomName2(Room_ID);
        return Price2;
    }
   
}
