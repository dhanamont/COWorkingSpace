/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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


/**
 *
 * @author admin
 */
@WebServlet(name = "ViewDetailServlet", urlPatterns = {"/ViewDetailServlet"})
public class ViewDetailServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession();
            String orderID = request.getParameter("id");
            System.out.println("Order ID = " + orderID);
            //Create object
                Order order = new Order();
                order.viewDetailOrder(orderID);
            
            String Type_Name = order.getType_Name(orderID);
            String Room_Name = order.getRoom_Name(orderID);
            String Table_ID = order.getTable_ID(orderID);
            String Total_price = order.getTotal_price(orderID);
            String Order_Status = order.getOrder_Status(orderID);
            String Order_Date = order.getOrder_Date(orderID);
            
                
                
            //------ Change Status
            String buttonValue = request.getParameter("buttonValue");
            System.out.println("BUTTON : " + buttonValue);
            
            if (buttonValue != null) {
                System.out.println(buttonValue);
                System.out.println(orderID);
                if (buttonValue.equals("CANCEL")) {
                    order.UpdateStatusCancel(orderID);
                } else if (buttonValue.equals("PAID")) {
                    order.UpdateStatusPAID(orderID);
                }
                response.sendRedirect("OrderListServlet");
                return;
            } else {
                buttonValue = Order_Status;
                System.out.println("button: null change to "+buttonValue);
            }
            
            //------ set attribute request  
            request.setAttribute("Order_ID", orderID);
            request.setAttribute("Type_Name", Type_Name);
            request.setAttribute("Room_Name", Room_Name);
            request.setAttribute("Table_ID", Table_ID);
            request.setAttribute("Total_price", Total_price);
            request.setAttribute("Order_Status", Order_Status);
            request.setAttribute("Order_Date", Order_Date);
            
            //----- send to data-concert.jsp
            request.getRequestDispatcher("ViewDetail.jsp").forward(request, response);
                
            
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
