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
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author test
 */
public class Space {
    Connection con;

    public Space() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    private String User_ID;
    private String Space_ID;
    private String SpaceName;
    private String Start_Time;
    private String End_Time;
    private String Place;
    private String Map;
    private String Address;
    private String Picture_Cover;
    private String Picture_Poster;
    private String Description;
    private ArrayList<ArrayList<String>> spaceSet = new ArrayList<ArrayList<String>>();
    private ArrayList<String> node_Detail = new ArrayList<String>();
    private ArrayList<String> openDate = new ArrayList<String>();
    private ArrayList<String> openTime = new ArrayList<String>();

    public String createSpace_ID() {
        try {
            Statement stmt = con.createStatement();
            String numSpa = "SELECT COUNT(Space_ID)+1 from Space";
            ResultSet numSpa1 = stmt.executeQuery(numSpa);
            numSpa1.next();
            String Space_ID = numSpa1.getString("count(Space_ID)+1");

        } catch (SQLException ex) {
        }
        return Space_ID;
    }

    
    public void getSpaceList(ArrayList<String> SpaceID, ArrayList<String> Entrepreneur_Name, ArrayList<String> Space_Name, ArrayList<Timestamp> DateTime){
        try {
            Statement stmt = con.createStatement();
            String SpaceTable = "SELECT Space_ID, Space_Name, CONCAT(Fname,\" \",Lname) AS 'Name', DateTime \n" 
                    + "FROM `User` \n"
                    + "JOIN `Space` USING (User_ID)\n"
                    + "ORDER BY DateTime DESC;";
            ResultSet rs0 = stmt.executeQuery(SpaceTable);
            while (rs0.next()) {
                SpaceID.add(rs0.getString("Space_ID"));
                Space_Name.add(rs0.getString("Space_Name"));
                Entrepreneur_Name.add(rs0.getString("Name"));
                DateTime.add(rs0.getTimestamp("DateTime"));
            }

        } catch (SQLException ex) {
        }
    }

    public void insertSpace(String Space_ID, String Space_Name, String Address, String Place, 
            String User_ID, String Map, String Description, String Picture_cover, String Picture_poster, 
            Time Start_Time, Time End_Time) {
        try {
            Statement stmt = con.createStatement();
            String sql = "Insert into `Space` values('" + Space_ID + "', '" + Space_Name + "', '" 
                    + Address + "', '" + Place + ", " + Picture_poster + "', '" + Picture_cover + "', NOW(), '" 
                    + Start_Time + "', '" + End_Time + "', '" + Map + "', '" + Description + "', '" + User_ID+"';";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
        }
    }

    public String getSpace_Name(String Space_ID) {
        try {
            Statement stmt = con.createStatement();
            String sql_ = "Select Space_Name from `Space` where Space_ID = '" + Space_ID + "'";

            ResultSet rs = stmt.executeQuery(sql_);
            rs.next();
            SpaceName = rs.getString("Space_Name");
            return SpaceName;
        } catch (SQLException ex) {
        }
        return null;
    }

    public void SpaceDetail(String Space_ID) {
        try {
            Statement stmt = con.createStatement();
            String SpaceDetail = "SELECT Space_Name, Start_Time, End_Time, "
                    + "Picture_Cover, Picture_Poster, Description, Address, Place, Map "
                    + "FROM `Space` "
                    + "Where Space_ID = '" + Space_ID + "';";
            ResultSet rs2 = stmt.executeQuery(SpaceDetail);
            rs2.next();
            SpaceName = rs2.getString("Space_Name");
            this.Place = rs2.getString("Place");
            this.Start_Time = rs2.getString("Start_Time");
            this.End_Time = rs2.getString("End_Time");
            this.Address = rs2.getString("Address");
            this.Map = rs2.getString("Map");
            this.Description = rs2.getString("Description");
            this.Picture_Cover = rs2.getString("Picture_Cover");
            this.Picture_Poster = rs2.getString("Picture_Poster");

        } catch (SQLException ex) {
        }
    }
    
    
    public void getService_Name(ArrayList<String> Service_Name, String Space_ID) {
        try {
            Statement stmt = con.createStatement();
            String table = "SELECT Service_Name FROM Service WHERE Space_ID = '" + Space_ID + "';";
            ResultSet rs1 = stmt.executeQuery(table);
            while (rs1.next()){
                Service_Name.add(rs1.getString("Service_Name"));
            }
        } catch (SQLException ex) {
        }
    }
    
    public void PropertiesBoxSearch(String Place, String Type_Name) {
        try {
            Statement stmt = con.createStatement();
            String getBox = "SELECT Space_ID, Space_Name, Picture_Poster, Place, Type_ID, Type_Name "
                    + "FROM `Space` "
                    + "JOIN Type_Space USING (Space_ID) "
                    + "WHERE Place = '"+Place+"' AND Type_Name= '"+Type_Name+"' "
                    + "ORDER BY DateTime DESC;";
            ResultSet rs2 = stmt.executeQuery(getBox);
            while (rs2.next()) {
                getNode_Detail().add(rs2.getString("Picture_Poster"));
                getNode_Detail().add(rs2.getString("Space_ID"));
                getNode_Detail().add(rs2.getString("Space_Name"));
                getNode_Detail().add(rs2.getString("Place"));
                getNode_Detail().add(rs2.getString("Type_ID"));
                getNode_Detail().add(rs2.getString("Type_Name"));
                
                getSpaceSet().add(getNode_Detail());

            }

        } catch (SQLException ex) {
            System.out.println("Error: "+ex);
        }
    }
     public void PropertiesBox() {
        try {
            Statement stmt = con.createStatement();
            String getBox = "SELECT Space_Name, Place, Picture_poster, Space_ID, Type_ID, Type_Name "
                    +"FROM `Space` "
                    + "JOIN Type_Space USING (Space_ID) "
                    + "ORDER BY DateTime DESC;";
            ResultSet rs2 = stmt.executeQuery(getBox);
            while (rs2.next()) {
                getNode_Detail().add(rs2.getString("Picture_Poster"));
                getNode_Detail().add(rs2.getString("Space_ID"));
                getNode_Detail().add(rs2.getString("Space_Name"));
                getNode_Detail().add(rs2.getString("Place"));
                getNode_Detail().add(rs2.getString("Type_ID"));
                getNode_Detail().add(rs2.getString("Type_Name"));

                getSpaceSet().add(getNode_Detail());

            }

        } catch (SQLException ex) {
        }
    }
    
    public void getOpenDate(ArrayList<String> openDate,String Space_ID) {
        try {
            Statement stmt = con.createStatement();
            String viewDate = "SELECT `Date` \n"
                + "FROM `Space` s\n"
                + "JOIN `Date` d \n"
                + "ON (d.Space_ID = '"+ Space_ID +"') \n"
                + "ORDER BY s.DateTime desc;";
            ResultSet rs2 = stmt.executeQuery(viewDate);
            while(rs2.next()){
                openDate.add(rs2.getString("OpenDate"));
            }
        } catch (SQLException ex) {
        }
    }
    
    public void SpaceOpenTime(String Space_ID) throws ParseException {
        try {
            Statement stmt = con.createStatement();
            String viewTime = "SELECT Start_Time, End_Time "
                    + "FROM `Space` "
                    + "WHERE Space_ID = '" + Space_ID + "'";
            ResultSet rs2 = stmt.executeQuery(viewTime);
            
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            String[] time = {"7:00:00","8:00:00","9:00:00","10:00:00","11:00:00","12:00:00","13:00:00","14:00:00","15:00:00","16:00:00",
            "17:00:00","18:00:00","19:00:00","20:00:00","21:00:00","22:00:00"};
            rs2.next();
            Time startTime = new Time(df.parse(rs2.getString("Start_Time")).getTime());
            Time endTime = new Time(df.parse(rs2.getString("End_Time")).getTime());
            for (int ctime = 0; ctime < time.length; ctime++){
                Time spaceTime = new Time(df.parse(time[ctime]).getTime());
                //System.out.println("จากลิส "+spaceTime);
                //System.out.println("เริ่ม "+startTime+" จบ "+endTime);
                if(spaceTime.after(startTime) || spaceTime.equals(startTime)){
                    //System.out.println("เข้า "+spaceTime);
                    if(spaceTime.before(endTime) || spaceTime.equals(endTime)){
                        openTime.add(spaceTime.toString());
                    }
                }
                
            }
           //System.out.println("Time: "+openTime);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void showSpaceBox(String User_ID) {
        try {
            Statement stmt = con.createStatement();
            String viewDash = "select User.User_ID , Space.Space_ID , Space.Space_Name , "
                    + "Picture_Poster from User JOIN `Space` Using (User_ID) Where User_ID = '" + User_ID + "'";
            ResultSet rs2 = stmt.executeQuery(viewDash);
            while (rs2.next()) {
                getNode_Detail().add(rs2.getString("Space_Name"));
                getNode_Detail().add(rs2.getString("Picture_Poster"));
                getNode_Detail().add(rs2.getString("Space_ID"));
                getSpaceSet().add(getNode_Detail());
            }

        } catch (SQLException ex) {
        }
    }

   

    public String getPlace(String Space_ID) {
        SpaceDetail(Space_ID);
        return Place;
    }

    
    public ArrayList<String> getOpenTime(String Space_ID) throws ParseException {
        SpaceOpenTime(Space_ID);
        return openTime;
    }

    public String getStart_Time(String Space_ID) {
        SpaceDetail(Space_ID);
        return Start_Time;
    }

    public String getEnd_Time(String Space_ID) {
        SpaceDetail(Space_ID);
        return End_Time;
    }

    public String getAddress(String Space_ID) {
        SpaceDetail(Space_ID);
        return Address;
    }

    public String getMap(String Space_ID) {
        SpaceDetail(Space_ID);
        return Map;
    }

    public String getPicture_Cover(String Space_ID) {
        SpaceDetail(Space_ID);
        return Picture_Cover;
    }

    public String getPicture_Poster(String Space_ID) {
        SpaceDetail(Space_ID);
        return Picture_Poster;
    }
    
    public String getDescription(String Space_ID) {
        SpaceDetail(Space_ID);
        return Description;
    }

    public String getSpace_ID(String Space_Name) {
        try {
            Statement stmt = con.createStatement();
            String Space_table = "SELECT Space_ID FROM `Space` WHERE Space_Name = '" + Space_Name + "';";
            ResultSet rs1 = stmt.executeQuery(Space_table);
            rs1.next();
            Space_ID = rs1.getString("Space_ID");
            return Space_ID;
        } catch (SQLException ex) {
        }
        return null;
    }

    public String getUser_ID(String Space_ID) {
        try {
            Statement stmt = con.createStatement();
            String Space_table = "SELECT User_ID FROM `Space` WHERE Space_ID = '" + Space_ID + "';";
            ResultSet rs1 = stmt.executeQuery(Space_table);
            rs1.next();
            User_ID = rs1.getString("User_ID");
            return User_ID;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    
    public ArrayList<ArrayList<String>> getSpaceSet() {
        return spaceSet;
    }

    /**
     * @param spaceSet the concertSet to set
     */
    public void setSpacetSet(ArrayList<ArrayList<String>> spaceSet) {
        this.spaceSet = spaceSet;
    }

    /**
     * @return the node_Detail
     */
    public ArrayList<String> getNode_Detail() {
        return node_Detail;
    }

    /**
     * @param node_Detail the node_Detail to set
     */
    public void setNode_Detail(ArrayList<String> node_Detail) {
        this.node_Detail = node_Detail;
    }

   
}
