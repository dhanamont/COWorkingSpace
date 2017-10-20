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
import model.Account;
import model.User;
import model.Entrepreneur;


/**
 *
 * @author admin
 */
@WebServlet(name = "SignUpEnt", urlPatterns = {"/SignUpEnt"})
public class SignUpEnt extends HttpServlet {

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
            /** Create String **/
            String User_IDE;
            
            /** รับค่า input จาก jsp **/
            String usernameE = request.getParameter("usernameE");
            String passwordE = request.getParameter("passwordE");
            String fnameE = request.getParameter("FnameE");
            String lnameE = request.getParameter("LnameE");
            String emailE = request.getParameter("EmailE");
            String companyName = request.getParameter("Company_Name");
            String phoneCompany = request.getParameter("Phone_Company");
            
            try {
                //Create object
                Account account = new Account();
                User user = new User();
                Entrepreneur entrepreneur = new Entrepreneur();
                
                //Create User_ID จาก java class
                User_IDE = account.createUser_ID();
                
                //เอาค่าเข้า java class
                account.insertAccount(User_IDE, "ENT", usernameE, passwordE);
                user.insertUser(User_IDE, fnameE, lnameE, emailE);
                entrepreneur.insertEntrepreneur(User_IDE, companyName, phoneCompany, "WAITING");
                

                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            } catch (Exception ex) {
                Logger.getLogger(SignUpEnt.class.getName()).log(Level.SEVERE, null, ex);
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
