/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Space;
import model.Date;
import model.Type_Space;
import model.Room;
import model.Table;
import model.Service;

/**
 *
 * @author admin
 */
@WebServlet(name = "SubmitPropertiesServlet", urlPatterns = {"/SubmitPropertiesServlet"})
public class SubmitPropertiesServlet extends HttpServlet {

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

//            สร้าง String
            String Space_ID;
            String Type_ID;
            String Room_ID;
            String Table_ID;

//            สร้าง Object
            Space space = new Space();
            Date date = new Date();
            Type_Space type_space = new Type_Space();
            Room room = new Room();
            Table table = new Table();
            Service service = new Service();

//            รับรายละเอียดผู้ประกอบการ
            String Space_Name = request.getParameter("Space_Name");
            String Address = request.getParameter("Address");
            String Place = request.getParameter("Place");
            String User_ID = request.getParameter("User_ID");
            String Map = request.getParameter("Map");
            String Description = request.getParameter("Description");
            String Picture_poster = request.getParameter("Picture_poster");
            String Picture_cover = request.getParameter("Picture_cover");
            String Start_Date = request.getParameter("Start_Date");
            String End_Date = request.getParameter("End_Date");
            String Start_Time = request.getParameter("Start_Time");
            String End_Time = request.getParameter("End_Time");
            String OpenDate = request.getParameter("OpenDate");

//            รับข้อมูล Type Space
            String Type_Name = request.getParameter("Type_name");
            int NumofRoom = Integer.parseInt(request.getParameter("NumberofRoom"));
            String Prototype = request.getParameter("Prototype");

//            รับข้อมูล Room
            String Room_Name = request.getParameter("Room_Name");
            int NumofTable = Integer.parseInt(request.getParameter("NumberofTable"));
            String Picture_room = request.getParameter("Picture_room");
            String Price = request.getParameter("Price");
            
//            รับข้อมูล Table
            int NumofPeople = Integer.parseInt(request.getParameter("NumofPeople"));

//            สร้าง ID จาก Java Class
            Space_ID = space.createSpace_ID();
            Type_ID = type_space.createType_ID();
            Room_ID = room.createRoom_ID();
            Table_ID = table.createTable_ID();

//            ส่งค่าไป Java Class
            space.insertSpace(Space_ID, Space_Name, Address, Place, User_ID, Map, Description, Picture_cover, Picture_poster, Start_Date, End_Date, Start_Time, End_Time, OpenDate);
            type_space.insertType_Space(Type_ID, Type_Name, NumofRoom, Prototype, Space_ID);
            room.insertRoom(Room_ID, Room_Name, NumofTable, Picture_room, Price);
            table.insertTable(Table_ID, NumofPeople, Room_ID);

            String[] Open_in = request.getParameterValues("Open_Date");
            List<String> Open_inList = Arrays.asList(Open_in);
            for (int i = 0; i <= Open_inList.size(); i++) {
                String OpenDateList = Open_inList.get(i);
                String Date_ID = date.createDateID();
                date.insertDate(Date_ID, OpenDateList);
            }

            String[] service_Name = request.getParameterValues("Service_Name");
            List<String> serviceList = Arrays.asList(service_Name);
            for (int j = 0; j <= serviceList.size(); j++) {
                String Service_Name = serviceList.get(j);
                String Service_ID = service.createServiceID();
                service.insertService(Service_ID, Service_Name);
            }

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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SubmitPropertiesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SubmitPropertiesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
