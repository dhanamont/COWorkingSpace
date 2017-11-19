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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Entrepreneur;

/**
 *
 * @author test
 */
@WebServlet(name = "EntrepreneurDetail", urlPatterns = {"/EntrepreneurDetail"})
public class EntrepreneurDetail extends HttpServlet {

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
            String CompanyName = request.getParameter("id");
            HttpSession session = request.getSession();

            Entrepreneur ent = new Entrepreneur();
            String User_ID = ent.getUser_ID(CompanyName);
            

            //--------- Entrepreneur's Detail
            String Company_name = ent.getCompany_name(User_ID);
            String Contact_name = ent.getContact_name(User_ID);
            String Email = ent.getEmail(User_ID);
            String Phone = ent.getPhone(User_ID);
            String Status = ent.getStatus(User_ID);
            
            //------ Change Status
            String SelectBTN = (String) request.getParameter("btn");
            if (SelectBTN != null) {
                System.out.println(SelectBTN);
                System.out.println(User_ID);
                if (SelectBTN.equals("CANCEL")) {
                    ent.updateStatusCANCELED(User_ID);
                } else if (SelectBTN.equals("ACCEPT")) {
                    ent.updateStatusACCEPTED(User_ID);
                }
                response.sendRedirect("EntRequestList");
                return;
            } else {
                SelectBTN = Status;
            }
            
            //------ set attribute request  
            request.setAttribute("Company_name", Company_name);
            request.setAttribute("Contact_name", Contact_name);
            request.setAttribute("Email", Email);
            request.setAttribute("Phone", Phone);
            request.setAttribute("Status", Status);
            
            //----- send to data-concert.jsp
            request.getRequestDispatcher("entDetail.jsp").forward(request, response);
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
            Logger.getLogger(EntrepreneurDetail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntrepreneurDetail.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EntrepreneurDetail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EntrepreneurDetail.class.getName()).log(Level.SEVERE, null, ex);
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
