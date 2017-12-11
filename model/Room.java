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
    private String NumofTable;
    private int i = -1, j = 0;
    private String comp = "";
    private String[] propRoom = new String[50];
    private String[][] roomTableList = new String[50][50];
    
    private ArrayList<String> Room_Name = new ArrayList<String>();
    private ArrayList<String> RoomID = new ArrayList<String>();
    
    
    public void getListProp(String Type_ID) throws SQLException{
        try {
            Statement stmt = con.createStatement();
            String sql =  "SELECT y.Type_ID, y.NumofRoom, r.Room_Name, r.NumofTable, t.Table_ID \n"
                    + "FROM Type_Space y\n"
                    + "JOIN Room r USING (Type_ID)\n"
                    + "JOIN `Table` t USING (Room_ID)\n"
                    + "Where y.Type_ID = '" + Type_ID + "'\n";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                 System.out.println("ก่อน if comp: "+comp);
                System.out.println("Date: "+rs.getString("r.Room_Name"));
                if (!comp.equals(rs.getString("r.Room_Name"))) {
                    i++;
                    propRoom[i] = rs.getString("r.Room_Name");
                    comp = rs.getString("r.Room_Name");
                    j = 0;
                }
                roomTableList[i][j] = rs.getString("t.Table_ID");
                System.out.println(roomTableList[i][j]);
                j++;
                System.out.println("i :"+i+" j: "+j+" comp: "+comp);
            }
            
/*               int NumofRoom = Integer.parseInt(rs.getString("NumofRoom"));
                int NumofTable = Integer.parseInt(rs.getString("NumofTable"));
                for(int i=0; i <= NumofRoom ; i++){
                    
                    for(int j=0; j <= NumofTable ; j++){
                       
                       
                       
                    }
                }         
            }*/
        } catch (SQLException ex) {
        }   
    }
    
    //***************** Return usable value ******************************//
    public String[][] getRoomTableList(String Type_ID) throws SQLException {
        getListProp(Type_ID);
        return roomTableList;
    }
    
    public String createRoom_ID() {
        try {
            Statement stmt = con.createStatement();
            String numSpa = "SELECT COUNT(Room_ID)+1 from Room";
            ResultSet numSpa1 = stmt.executeQuery(numSpa);
            numSpa1.next();
            Room_ID = numSpa1.getString("count(Room_ID)+1");

        } catch (SQLException ex) {
        }
        return Room_ID;
    }
    
    public void insertRoom(String Room_ID, String Room_Name, int NumofTable, String Picture_room, float Price, String Type_ID) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Insert into Room values('" + Room_ID + "', '" + Room_Name + "', '" + NumofTable 
                    + "', '" + Picture_room + "', '" + Price + "', '" + Type_ID +"';";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
        }
    }
    
    public void getRoomList(ArrayList<String> RoomID, ArrayList<String> RoomName,ArrayList<Float> Price, String Type_ID) {
        try {
            Statement stmt = con.createStatement();
            String table = "SELECT Room_ID, Room_Name, Price FROM Room WHERE Type_ID = '" + Type_ID + "';";
            ResultSet rs1 = stmt.executeQuery(table);
            while(rs1.next()){
                RoomID.add(rs1.getString("Room_ID"));
                RoomName.add(rs1.getString("Room_Name"));
                Price.add(rs1.getFloat("Price"));
            }
        } catch (SQLException ex) {
        }
    }
    
    
    
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
    

    public String getRoom_ID(String Type_ID) {
        RoomDetail(Type_ID);
        return Room_ID;
    }

    public String getRoomName(String Type_ID) {
        RoomDetail(Type_ID);
        return RoomName;
    }

    public String getPrice(String Type_ID) {
        RoomDetail(Type_ID);
        return Price;
    }
   
}
