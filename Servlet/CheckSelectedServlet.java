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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Entrepreneur;
import model.Room;
import model.Space;
import model.Table;
import model.Type_Space;
//import model.Room;
//import model.Table;

/**
 *
 * @author admin
 */
@WebServlet(name = "CheckSelectedServlet", urlPatterns = {"/CheckSelectedServlet"})
public class CheckSelectedServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            String Space_ID = request.getParameter("id");
            System.out.println("id: "+Space_ID);
            request.setAttribute("Space_ID", Space_ID);
            
            String roomName = request.getParameter("roomName");
            System.out.println("roomName: "+roomName);

            Room room = new Room();
            Space space = new Space();
            Type_Space type = new Type_Space();
            Entrepreneur ent = new Entrepreneur();
            Table table = new Table();
            
            String Type_ID = type.getType_ID(Space_ID);
            request.setAttribute("Type_ID", Type_ID);
            
            ArrayList<String> Room_ID = new ArrayList<String>();
            ArrayList<Float> Price = new ArrayList<Float>();
            ArrayList<String> Room_Name = new ArrayList<String>();
            ArrayList<String> Service_Name = new ArrayList<String>();
            ArrayList<String> Picture_room = new ArrayList<String>();
            ArrayList<String> Table_ID = new ArrayList<String>();
            
            room.getRoomList(Room_ID,Room_Name,Price,Picture_room,Type_ID);
            space.getService_Name(Service_Name, Space_ID);
            String User_ID = space.getUser_ID(Space_ID);
            
            //รับ Table_ID
            String roomID = room.getRoomID(roomName);
            System.out.println("roomID: "+roomID);
            table.getTable_ID(Table_ID, roomID);
            
            //วันเวลา
            //ArrayList<String> openDate = space.getOpenDate(Space_ID);
            ArrayList<String> openTime = space.getOpenTime(Space_ID);

            //ส่งค่าไป jsp
            request.setAttribute("Space_Name", space.getSpace_Name(Space_ID));
            request.setAttribute("Address", space.getAddress(Space_ID));
            request.setAttribute("Place", space.getPlace(Space_ID));
            request.setAttribute("Picture_cover", space.getPicture_Cover(Space_ID));
            request.setAttribute("Start_Time", space.getStart_Time(Space_ID));
            request.setAttribute("End_Time", space.getEnd_Time(Space_ID));
            request.setAttribute("Map", space.getMap(Space_ID));
            request.setAttribute("Prototype", type.getPrototype(Type_ID));
            request.setAttribute("Description", space.getDescription(Space_ID));
            //request.setAttribute("Date", openDate);
            request.setAttribute("Time", openTime);
            request.setAttribute("Price", Price);
            request.setAttribute("Room_Name", Room_Name);
            request.setAttribute("Service_Name", Service_Name);
            request.setAttribute("Picture_room", Picture_room);
            
            //ส่ง list TableID ไป jsp
            request.setAttribute("Table_ID", Table_ID);
            
            //------------------ผปก.
            request.setAttribute("Contact_name", ent.getContact_name(User_ID));
            request.setAttribute("Email", ent.getEmail(User_ID));
            request.setAttribute("Company_name", ent.getCompany_name(User_ID));
            request.setAttribute("Phone", ent.getPhone(User_ID));

            request.getRequestDispatcher("PropertyPart2.jsp").forward(request, response);
        } catch (SQLException ex) {
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
        try {
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(Property_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Property_Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(Property_Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Property_Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
