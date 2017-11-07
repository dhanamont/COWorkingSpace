/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
            
            //Number of People --> หรือว่านับโต๊ะ?????
            String numPeople = request.getParameter("number_of_people").substring(0, request.getParameter("number_of_people").indexOf("xxx"));
            int numOfPeople = Integer.parseInt(request.getParameter("numPeople"));
            
            //Start Time & End Time
            String startOrderTime = request.getParameter("StartTime");
            String endOrderTime = request.getParameter("EndTime");
            
            // Order status --> WAITING, PAID ไว้ให้ผปก.เปลี่ยนสถานะการจ่ายเงินของลูกค้า
            String orderStatus = "WAITING";
            
            //******** End input *********
            
            try {
                //Room
                Room room = new Room();

                //Create OrderID
                Order order = new Order();
                String orderID = order.getOrderID();
                
                //Table เอาไว้หาว่า table นี้อยู่ room ไหน จะได้รู้ราคา ไปคิด total price
                Table table = new Table();
                String roomID = table.getRoomID(tableID);
                
                //Price_of_Ticket จากตาราง Room
                Float price = room.getPrice(roomID); 
                Float totalPrice = price * numOfPeople;
                
                //ส่งค่าไปให้ java class เอาเข้า DB
                order.insertOrder(orderID, orderStatus, totalPrice, numOfPeople, orderDate, startOrderTime, endOrderTime, userID, tableID);
               
                //Set Attribute
                session.setAttribute("userID", userID);
                session.setAttribute("spaceID", spaceID);
                session.setAttribute("orderID", orderID);
                session.setAttribute("orderStatus", orderStatus);
                session.setAttribute("totalPrice", totalPrice);
                session.setAttribute("numOfPeople", numOfPeople);
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
