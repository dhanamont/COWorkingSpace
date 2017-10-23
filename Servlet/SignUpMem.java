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
import model.Member;
/**
 *
 * @author admin
 */
@WebServlet(name = "SignUpMem", urlPatterns = {"/SignUpMem"})
public class SignUpMem extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
                           
            /** Create String **/
            String User_IDM;
            
            /** เอา input จาก jsp เข้า java class **/
            String usernameM = request.getParameter("usernameM");
            String passwordM = request.getParameter("passwordM");
            String fnameM = request.getParameter("FnameM");
            String lnameM = request.getParameter("LnameM");
            String emailM = request.getParameter("EmailM");
            String idCardM = request.getParameter("IDcardM");
            
            
            try {
                //Create object 
                Account account = new Account();
                User user = new User();
                Member member = new Member();
                
                //Create User_ID จาก java class
                User_IDM = account.createMemUser_ID();
                
                //เอาค่าต่างๆเข้า java class
                account.insertAccount(User_IDM, "MEM", usernameM, passwordM);
                user.insertUser(User_IDM, fnameM, lnameM, emailM);
                member.insertMember(User_IDM, idCardM);
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            
                
            } catch (SQLException ex) {
                Logger.getLogger(SignUpMem.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpMem.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpMem.class.getName()).log(Level.SEVERE, null, ex);
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
