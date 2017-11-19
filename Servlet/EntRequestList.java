/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entrepreneur;

/**
 *
 * @author test
 */
@WebServlet(name = "EntRequestList", urlPatterns = {"/EntRequestList"})
public class EntRequestList extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            ArrayList<String> Company_Name = new ArrayList<>();
            ArrayList<String> Status = new ArrayList<>();
            ArrayList<Timestamp> Date_Time = new ArrayList<>();
            ArrayList<String> Contact_name = new ArrayList<>();

            Entrepreneur ent = new Entrepreneur();
            ent.showAllRequests(Company_Name, Status, Date_Time, Contact_name);

            //------ OnlyStatus > ACCEPTED
            ArrayList<String> Company_NameAc = new ArrayList<>();
            ArrayList<Timestamp> Date_TimeAc = new ArrayList<>();
            ArrayList<String> Contact_nameAc = new ArrayList<>();
            ent.AcceptedRequests(Company_NameAc, Date_TimeAc, Contact_nameAc);

            //------ set attribute request
            request.setAttribute("Company_Name", Company_Name);
            request.setAttribute("Status", Status);
            request.setAttribute("Contact_name", Contact_name);
            request.setAttribute("Date_Time", Date_Time);

            request.setAttribute("Company_NameAc", Company_NameAc);
            request.setAttribute("Contact_nameAc", Contact_nameAc);
            request.setAttribute("Date_TimeAc", Date_TimeAc);

            //----- send to data-concert.jsp
            request.getRequestDispatcher("entRequestList.jsp").forward(request, response);
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
            Logger.getLogger(EntRequestList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntRequestList.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EntRequestList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntRequestList.class.getName()).log(Level.SEVERE, null, ex);
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
