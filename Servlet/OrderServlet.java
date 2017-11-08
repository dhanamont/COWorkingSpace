/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Order;
import model.Room;
import model.Table;
/**
 *
 * @author admin
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            
            //********* Start Input ***********
            
            //User_ID จะได้รู้ว่าเป็น Order ของใคร
            String userID = (String) request.getAttribute("User_ID");
            
            //Space_ID
            String spaceID = (String)session.getAttribute("id");

            //Table_ID --> จะได้รู้ว่าเป็นโต๊ะไหน 
            String tableID = request.getParameter("table").substring(request.getParameter("table").indexOf("xxx"));
            
            //Order_Date
            String orderDate = request.getParameter("order_date").substring(request.getParameter("order_date").indexOf("xxx"));
                                  
            //Start Time & End Time
            int startOrderTime = Integer.parseInt(request.getParameter("StartTime"));
            int endOrderTime = Integer.parseInt(request.getParameter("EndTime"));
            String dot = ".00";
            
            // Order status --> WAITING, PAID ไว้ให้ผปก.เปลี่ยนสถานะการจ่ายเงินของลูกค้า
            String orderStatus = "WAITING";
            
            //******** End input *********
            
            try {
                //Create Object
                Room room = new Room();
                Order order = new Order();
                Table table = new Table();
                
                //Create OrderID
                String orderID = order.getOrderID();
                
                //Table เอาไว้หาว่า table นี้อยู่ room ไหน จะได้รู้ราคา ไปคิด total price
                String roomID = table.getRoomID(tableID);
                
                //Price_of_Ticket จากตาราง Room
                Float totalPrice = room.getPrice(roomID);
                
                //สร้าง Array ของ Start to End Time
                ArrayList<String> orderTime = new ArrayList<>();
                
                for(int countTime = startOrderTime ; startOrderTime <= endOrderTime; countTime++ ){                   
                    String hour = String.valueOf(countTime);
                    String time = hour.concat(dot);
                    orderTime.add(time);
                }
                                
                //ส่งค่าไปให้ java class เอาเข้า DB
                order.insertOrder(orderID, orderStatus, totalPrice, orderDate, orderTime, userID, tableID);
               
                //Set Attribute
                session.setAttribute("userID", userID);
                session.setAttribute("spaceID", spaceID);
                session.setAttribute("orderID", orderID);
                session.setAttribute("orderStatus", orderStatus);
                session.setAttribute("totalPrice", totalPrice);
                session.setAttribute("orderDate", orderDate);
                session.setAttribute("orderDatetime", order.getDateTime());
                session.setAttribute("startTime", startOrderTime);
                session.setAttribute("endTime", endOrderTime);
                session.setAttribute("orderID", orderID);
                session.setAttribute("tableID", tableID);                           
                session.setAttribute("roomID", roomID);
                session.setAttribute("roomName", room.getRoomName());
                
                // ส่งข้อมูลการจองไป Show หน้า Ordering เพื่อให้ตรวจสอบ
                RequestDispatcher obj = request.getRequestDispatcher("Ordering.jsp");
                obj.forward(request, response);
                
            } catch (Exception ex) {
                Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
