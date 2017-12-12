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

/**
 *
 * @author admin
 */
public class Payment {
    Connection con;
    
    public Payment() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.util.Properties prop = new java.util.Properties();
        prop.put("charSet","UTF-8");
        this.con = DriverManager.getConnection("jdbc:mysql://ihost.it.kmitl.ac.th:3306/it58070122_se?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8", 
                "it58070122_se",
                "chFKW9lGV");
    }
    
    private String Payment_ID;
    private String numPayment;
    
    public void createPayment_ID() {
        try {
            Statement stmt = con.createStatement();
            String numPay = "Select count(Payment_ID) from Payment where Payment_ID LIKE 'PAY%'";
            ResultSet numPay1 = stmt.executeQuery(numPay);
            numPay1.next();
            String numPayment = numPay1.getString("count(Payment_ID)");
            Payment_ID = "PAY";
            for (int i = numPayment.length(); i < 4; i++) {
                Payment_ID += "0";
            }
            Payment_ID += numPayment;

        } catch (SQLException ex) {
        }
    }

    public String getPayment_ID() {
        createPayment_ID();
        return Payment_ID;
    }
    
    public void insertPayment(String Payment_ID, String Payment_method, String Order_ID) {
        try {
            PreparedStatement inPay = con.prepareStatement("insert into Payment values(?,?,?)");
            inPay.setString(1, Payment_ID);
            inPay.setString(2, Payment_method);
            inPay.setString(3, Order_ID);
            inPay.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
}
