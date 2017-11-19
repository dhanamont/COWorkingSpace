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
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author test
 */
public class Entrepreneur {

    Connection conn;

    public Entrepreneur() throws SQLException, ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.conn = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }

    private String Company_name;
    private String Contact_name;
    private String Phone;
    private String Email;
    private String Status;

    public void UpdateContactPerson(String strPhonenum, String UserID) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "Update Entrepreneur set Phone_company='" + strPhonenum + "' where User_ID='" + UserID + "';";
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
        }
    }

    public void insertEntrepreneur(String User_ID, String comName, String phoneCom, String status) {
        try {
            Statement stmt = conn.createStatement();
            String sql3 = "Insert into Entrepreneur values('" + User_ID + "', '" + comName + "', '" + phoneCom + "', '" + status + "', NOW())";
            stmt.executeUpdate(sql3);
        } catch (SQLException ex) {
        }
    }

    public void EntrepreneurDetail(String User_ID) {
        try {
            Statement stmt = conn.createStatement();
            String Ent_table = "SELECT User_ID, Company_name, u.Fname, u.Lname, u.Email, Phone_company, Status\n" +
                    "FROM Entrepreneur\n" +
                    "JOIN User u\n" +
                    "USING(User_ID)\n" +
                    "WHERE User_ID = '"+User_ID+"'";
            ResultSet rs5 = stmt.executeQuery(Ent_table);
            while (rs5.next()){
            //--------- Entrepreneur's Detail
            Company_name = rs5.getString("Company_name");
            Contact_name = rs5.getString("Fname") + " " + rs5.getString("Lname");
            Status = rs5.getString("Status");
            Email = rs5.getString("Email");
            Phone = rs5.getString("Phone_company");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     public void showAllRequests(ArrayList<String> Company_Name, ArrayList<String> Status, ArrayList<Timestamp> Date_Time, ArrayList<String> Contact_name) {
        try {
            Statement stmt = conn.createStatement();
            String Company_table = "SELECT Company_name, Status, DateTime, u.Fname, u.Lname "
                    + "FROM Entrepreneur JOIN User u USING (User_ID) ORDER BY DateTime DESC;";
            ResultSet rs1 = stmt.executeQuery(Company_table);

            while (rs1.next()) {
                Company_Name.add(rs1.getString("Company_Name"));
                Status.add(rs1.getString("Status"));
                Date_Time.add(rs1.getTimestamp("DateTime"));
                Contact_name.add(rs1.getString("Fname") + " " + rs1.getString("Lname"));
            }
            rs1.close();
        } catch (SQLException ex) {
        }
    }
     
     public void AcceptedRequests(ArrayList<String> Company_NameAc, ArrayList<Timestamp> Date_TimeAc, ArrayList<String> Contact_nameAc) {
        try {
            Statement stmt = conn.createStatement();
            String ConcertAc_table = "SELECT Company_Name, DateTime, Fname, Lname "
                    + "FROM Entrepreneur JOIN User USING (User_ID) WHERE Status = 'ACCEPTED' ORDER BY DateTime DESC;";
            ResultSet rs2 = stmt.executeQuery(ConcertAc_table);
            while (rs2.next()) {
                Company_NameAc.add(rs2.getString("Company_Name"));
                Date_TimeAc.add(rs2.getTimestamp("DateTime"));
                Contact_nameAc.add(rs2.getString("Fname") + " " + rs2.getString("Lname"));
            }
            rs2.close();
        } catch (SQLException ex) {
        }
    }

    public void updateStatusCANCELED(String User_ID) {
        try {
            String status = "UPDATE Entreprener\n"
                    + "SET Status = 'CANCELED'\n"
                    + "WHERE User_ID = '" + User_ID + "' ;";
            PreparedStatement preparedStmt = conn.prepareStatement(status);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateStatusACCEPTED(String User_ID) {
        try {
            String status = "UPDATE Entrepreneur\n"
                    + "SET Status = 'ACCEPTED'\n"
                    + "WHERE User_ID = '" + User_ID + "' ;";
            PreparedStatement preparedStmt = conn.prepareStatement(status);
            preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
       public String getUser_ID(String CompanyName) {
        try {
            Statement stmt = conn.createStatement();
            String Concert_table = "SELECT User_ID FROM Entrepreneur WHERE Company_name = '" + CompanyName + "';";
            ResultSet rs1 = stmt.executeQuery(Concert_table);
            while(rs1.next()){
                String User_ID = rs1.getString("User_ID");
                return User_ID;
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public String getCompany_name(String User_ID) {
        EntrepreneurDetail(User_ID);
        return Company_name;
    }

    public String getContact_name(String User_ID) {
        EntrepreneurDetail(User_ID);
        return Contact_name;
    }

    public String getStatus(String User_ID) {
        EntrepreneurDetail(User_ID);
        return Status;
    }

    public String getPhone(String User_ID) {
        EntrepreneurDetail(User_ID);
        return Phone;
    }

    public String getEmail(String User_ID) {
        EntrepreneurDetail(User_ID);
        return Email;
    }
}
