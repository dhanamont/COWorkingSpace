/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Space;

/**
 *
 * @author admin
 */
@WebServlet(name = "PropertiesServlet", urlPatterns = {"/PropertiesServlet"})
public class PropertiesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            
            Space space = new Space();

            ArrayList<ArrayList<String>> SpaceSet = new ArrayList<ArrayList<String>>();
            String Place = request.getParameter("Place");
            String Type_Name = request.getParameter("TypeSpace");
            System.out.println("Place: "+Place+" //TypeName: "+Type_Name);
            if (Place != null && Type_Name != null) {
                System.out.println("เข้า");
                space.PropertiesBoxSearch(Place, Type_Name);
                SpaceSet = space.getSpaceSet();
            }else{
                space.PropertiesBox();
                SpaceSet = space.getSpaceSet();
            }
            request.setAttribute("SpaceSet", SpaceSet);
           

//                out.println(SpaceSet.size() + "<br>");
//            for (int j = 0; j < SpaceSet.size(); j++) {
//                out.println("Poster: " + SpaceSet.get(0).get(0) + "<br>");
//                out.println("SpaceID: " + SpaceSet.get(0).get(1) + "<br>");
//                out.println("SpaceName: " + SpaceSet.get(0).get(2) + "<br>");
//                out.println("Place: " + SpaceSet.get(0).get(3) + "<br>");
//                out.println("TypeID: " + SpaceSet.get(0).get(4) + "<br>");
//                out.println("TypeName: " + SpaceSet.get(0).get(5) + "<br>");
//                out.println("----------------------------<br>");
//            }
//           out.println(SpaceSet.get(1));

//            ส่งไปหน้า properties.jsp
            request.getRequestDispatcher("properties.jsp").forward(request, response);
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PropertiesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PropertiesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
