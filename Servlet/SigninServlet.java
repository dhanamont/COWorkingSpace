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
import model.Account;
import model.Entrepreneur;

@WebServlet(name = "SigninServlet", urlPatterns = {"/SigninServlet"})
public class SigninServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
//            รับค่าจาก jsp          
            String usernameIn = request.getParameter("Username");              
            String passwordIn = request.getParameter("Password");
            
            try {
                HttpSession session = request.getSession();
                
//                สร้าง Object
                Account account = new Account();
                Entrepreneur ent = new Entrepreneur();
                String Username = account.getUsername(usernameIn);
                String Password = account.getPassword(usernameIn);
                String User_ID = account.getUser_ID(usernameIn);
                String Role_ID = account.getRole_ID(usernameIn);  
                String Status = ent.getStatus(User_ID);
                
                if(Username == null || Username.isEmpty()){
                    session.setAttribute("error","Invalid username");
                    response.sendRedirect("register.jsp");
                }
                else if (Username.equals(usernameIn) && Password.equals(passwordIn)) {
                    if(Role_ID.equals("ENT") && (Status.equals("WAITING")||Status.equals("CANCELED")) ){
                        session.setAttribute("error","Invalid Username and Password");
                        response.sendRedirect("register.jsp");
                    }
                    else {
                    session.setAttribute("Username", Username);
                    session.setAttribute("User_ID", User_ID);
                    session.setAttribute("Role_ID", Role_ID);
                    
                    response.sendRedirect("index.jsp");
                    }
                } else {
                    session.setAttribute("error","Invalid password");
                    response.sendRedirect("register.jsp");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SigninServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SigninServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SigninServlet.class.getName()).log(Level.SEVERE, null, ex);
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
