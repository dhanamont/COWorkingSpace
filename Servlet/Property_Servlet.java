/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
@WebServlet(name = "Property_Servlet", urlPatterns = {"/Property_Servlet"})
public class Property_Servlet extends HttpServlet {

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

            String Space_ID = request.getParameter("Space_ID");
            request.setAttribute("Space_ID", Space_ID);
            
            String Type_ID = request.getParameter("Type_ID");
            request.setAttribute("Type_ID", Type_ID);

            Space space = new Space();
            space.SpaceDetail(Space_ID);
            
            ArrayList<String> openDate = space.getOpenDate(Type_ID);
            ArrayList<String> openTime = space.getOpenTime(Type_ID);

            request.setAttribute("Space_Name", space.getSpaceName());
            request.setAttribute("Location", space.getLocation());
            request.setAttribute("Picture_poster", space.getPicturePoster());
            request.setAttribute("Picture_cover", space.getPictureCover());
            request.setAttribute("Start_Date", space.getStartDate());
            request.setAttribute("End_Date", space.getEndDate());
            request.setAttribute("Start_Time", space.getStartTime());
            request.setAttribute("End_Time", space.getEndTime());
            request.setAttribute("Description", space.getDescription());
            request.setAttribute("Date", openDate);
            request.setAttribute("Time", openTime);

//            ส่งไปหน้านี้ถูกปะ หรือต้อง MyProperty.jsp
            request.getRequestDispatcher("Property.jsp").forward(request, response);
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
