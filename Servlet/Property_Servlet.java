/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
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
import model.Room;
import model.Table;

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
            
            ArrayList<String> Room_ID = new ArrayList<String>();
            ArrayList<Float> Price = new ArrayList<Float>();
            ArrayList<String> Room_Name = new ArrayList<String>();
            
            Room room = new Room();
            Space space = new Space();
            
            room.getRoomList(Room_ID,Room_Name,Price,Type_ID);
            room.getListProp(Type_ID);
            
            ArrayList<String> openDate = space.getOpenDate(Space_ID);
            ArrayList<String> openTime = space.getOpenTime(Space_ID);


            request.setAttribute("Space_Name", space.getSpace_Name(Space_ID));
            request.setAttribute("Address", space.getAddress(Space_ID));
            request.setAttribute("Place", space.getPlace(Space_ID));
            request.setAttribute("Picture_poster", space.getPicture_Poster(Space_ID));
            request.setAttribute("Picture_cover", space.getPicture_Cover(Space_ID));
            request.setAttribute("Start_Time", space.getStart_Time(Space_ID));
            request.setAttribute("End_Time", space.getEnd_Time(Space_ID));
            request.setAttribute("Description", space.getDescription(Space_ID));
            request.setAttribute("Date", openDate);
            request.setAttribute("Time", openTime);
            request.setAttribute("Price", Price);
            request.setAttribute("Room_Name", Room_Name);

            request.getRequestDispatcher("Property.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException | ParseException ex) {
            Logger.getLogger(Property_Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
