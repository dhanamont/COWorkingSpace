/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           
            
            HttpSession session = request.getSession();
            
            String userID = (String) session.getAttribute("userID");
            String username = (String) session.getAttribute("username");
            String spaceName = (String) session.getAttribute("spaceName");
            String typeName = (String) session.getAttribute("typeName");
            String tableID = (String) session.getAttribute("tableID");
            String roomID = (String) session.getAttribute("roomID");
            String roomName = (String) session.getAttribute("roomName");
            
            //************order date***************
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String dateS = (String) session.getAttribute("orderDate");
            Date orderDate = (Date) df.parse(dateS);
           
            //***********Start Time & End Time*************
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            String startTime = (String) session.getAttribute("startTime");
            Time startOrderTime = new Time(df2.parse(startTime).getTime());
            String endTime = (String) session.getAttribute("endTime");
            Time endOrderTime = new Time(df2.parse(endTime).getTime());
            String orderStatus = "WAITING";
            //******** End input *********
            //System.out.println("roomID");
            //System.out.println(orderDate);
            //System.out.println(startOrderTime);
            
            try {
                //*******Create Object**********
                Order order = new Order();
                Room room = new Room();
                               
                
                //*******check overlap time and time error******
                String check = order.checkTable(startOrderTime, endOrderTime, orderDate, tableID);
                String loop = "eiei";
                
                if(check.equals("false")){ //false = ไม่ overlap
                    //*****create order_id*******
                    
                    String orderID = order.getOrder_ID();
                    
                    //float price = room.getPrice("Room_ID");
                    float price = 500;
                    loop = "YESSSSSS";
                    
                    //*********insert data in DB***********
                    order.insertOrder(orderID, orderStatus, price, orderDate, startOrderTime, endOrderTime, userID, tableID);
                    
                    //*********set attribute**********
                    session.setAttribute("orderID", orderID);
                    session.setAttribute("price", price);
                    
                }
                else if(check.equals("true")){
                    loop = "NO";
                    response.sendRedirect("index.jsp");
                    return;
                }
                else{
                    response.sendRedirect("index.jsp");
                    return;
                }
                
                //********Test set attribute**********
                request.setAttribute("spaceName", spaceName);
                request.setAttribute("typeName", typeName);
                request.setAttribute("roomID", roomID);
                request.setAttribute("roomName", roomName);
                //request.setAttribute("tableID", tableID); 
                //request.setAttribute("orderDate", roomID);
                //request.setAttribute("startTime", startTime);
                //request.setAttribute("endTime", endTime);
                request.setAttribute("loop", loop);
                request.setAttribute("check", check);
                
                //********ส่งข้อมูลการจองไป Show หน้า Ordering เพื่อให้ตรวจสอบ**********
                RequestDispatcher obj = request.getRequestDispatcher("Test.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
