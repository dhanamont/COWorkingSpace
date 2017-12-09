/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

/**
 *
 * @author admin
 */
@WebServlet(name = "CheckOrderServlet", urlPatterns = {"/CheckOrderServlet"})
public class CheckOrderServlet extends HttpServlet {

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
            
//            String spaceName = "";
//            String 
//            
            /********* Start Input ***********/
            String userID = (String) session.getAttribute("User_ID");
            String username = (String) session.getAttribute("Username");
            String spaceName = (String) request.getAttribute("spaceName");
            String typeName = (String) request.getAttribute("typeName");
            String roomID = (String) request.getAttribute("roomID");
            String roomName = (String) request.getAttribute("roomName");
            String tableID = request.getParameter("table").substring(request.getParameter("table").indexOf("xxx") + 1);
            //order date
           
            String orderDate = request.getParameter("order_date").substring(request.getParameter("order_date").indexOf("xxx")+ 1);   
            
            
            //Start Time & End Time
            String startTime = request.getParameter("StartTime"); 
            String endTime = request.getParameter("EndTime");
            
            
            try {
                //Create Object
                Room room = new Room();
                
                
                //float price = room.getPrice("roomID");
                float price = 500;
                
                //Set Attribute
                session.setAttribute("userID", userID);
                session.setAttribute("username", username);
                session.setAttribute("orderDate", orderDate);
                session.setAttribute("startTime", startTime);
                session.setAttribute("endTime", endTime);
                session.setAttribute("tableID", tableID);
                
                request.setAttribute("spaceName", spaceName);
                request.setAttribute("typeName", typeName);
                request.setAttribute("roomID", roomID);
                request.setAttribute("roomName", roomName);
                request.setAttribute("price", price);
                
                
//                session.setAttribute("spaceName", spaceName);
//                session.setAttribute("typeName", typeName);
//                session.setAttribute("roomID", roomID);
//                session.setAttribute("roomName", roomName);
//                session.setAttribute("tableID", tableID);
//                session.setAttribute("price", price);
//                session.setAttribute("orderDate", orderDate);
//                session.setAttribute("startTime", startTime);
//                session.setAttribute("endTime", endTime);

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
            Logger.getLogger(CheckOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CheckOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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
