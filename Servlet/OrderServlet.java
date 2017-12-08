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
            
            //********* Start Input ***********
//            String userID = (String) session.getAttribute("User_ID");
//            String username = (String) session.getAttribute("Username");
//            String spaceID = (String)session.getAttribute("id");
//            String spaceName = (String) session.getAttribute("spaceName");
//            String roomID = (String) session.getAttribute("roomID");
//            String roomName = (String) session.getAttribute("roomName");
            String userID = "M001";
            String tableID = request.getParameter("table").substring(request.getParameter("table").indexOf("xxx") + 1);
            //order date
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String date = request.getParameter("order_date").substring(request.getParameter("order_date").indexOf("xxx")+ 1);   
            Date orderDate = (Date) df.parse(date);
            
            //Start Time & End Time
            DateFormat df2 = new SimpleDateFormat("HH:mm");
            String startTime = request.getParameter("StartTime"); 
            Time startOrderTime = new Time(df2.parse(startTime).getTime());
            String endTime = request.getParameter("EndTime");
            Time endOrderTime = new Time(df2.parse(endTime).getTime());
            String orderStatus = "WAITING";
            //******** End input *********
          
            try {
                //Create Object
                Order order = new Order();
                //Room room = new Room();

                //check overlap time and time error
                String result = order.checkTable(startOrderTime, endOrderTime, orderDate, tableID);
                String check = "eiei";
                
                if(result.equals("false")){ //false = ไม่ overlap
                    //create order_id
                    //String orderID = order.getOrder_ID();
                    String orderID = "R001";
                    //ขาด java class
                    //float price = room.getPrice("Room_ID");
                    float price = 500;
                    check = "YESSSSSS";
                    
                    //insert data in DB
                    order.insertOrder(orderID, orderStatus, price, orderDate, startOrderTime, endOrderTime, userID, tableID);
                    
                    //setAttribute
                    session.setAttribute("orderID", orderID);
                    session.setAttribute("price", price);
                    
                }
                else if(result.equals("true")){
                    check = "NO";
                    response.sendRedirect("index.jsp");    
                }
                else{
                    response.sendRedirect("index.jsp");  
                }

                //Set Attribute
                session.setAttribute("userID", userID);
                //session.setAttribute("spaceID", spaceID);
                session.setAttribute("orderStatus", orderStatus);
                session.setAttribute("orderDate", orderDate);
                session.setAttribute("startTime", startOrderTime);
                session.setAttribute("endTime", endOrderTime);
                session.setAttribute("tableID", tableID);
                session.setAttribute("result", result);
                session.setAttribute("check", check);
                

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
