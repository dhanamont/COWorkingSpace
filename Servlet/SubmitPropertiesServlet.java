/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Space;
import model.Date;
import model.Time;
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

//            สร้าง String
            String space_ID;
            String date_ID;
            String time_ID;
            String type_ID;
            String room_ID;
            String table_ID;
            String service_ID;

//            สร้าง Object
            Space space = new Space();
            Date date = new Date();
            Time time = new Time();
            Type_Space type_space = new Type_Space();
            Room room = new Room();
            Table table = new Table();
            Service service = new Service();

//            รับรายละเอียดผู้ประกอบการ
            String space_Name = request.getParameter("Space_Name");
            String address = request.getParameter("Address");
            String place = request.getParameter("Place");
            String pic_poster = request.getParameter("Picture_poster");
            String pic_cover = request.getParameter("Picture_cover");
            String start_time = request.getParameter("Start_Time");
            String end_time = request.getParameter("End_Time");
            String map = request.getParameter("Map");
            String description = request.getParameter("Description");

//            รับข้อมูล Type Space
            String type_name = request.getParameter("Type_name");
            String num_Room = request.getParameter("NumberofRoom");
            String prototype = request.getParameter("Prototype");

//            รับข้อมูล Room
            String price = request.getParameter("Price");
            String room_Name = request.getParameter("Room_Name");
            String num_Table = request.getParameter("NumberofTable");
            String pic_room = request.getParameter("Picture_room");

//            รับข้อมูล Table
            String num_People = request.getParameter("NumofPeople");

//            สร้าง ID จาก Java Class
            space_ID = space.createSpace_ID();
            date_ID = date.createDate_ID();
            time_ID = time.createTime_ID();
            type_ID = type_space.createType_ID();
            room_ID = room.createRoom_ID();
            table_ID = table.createTable_ID();

//            ส่งค่าไป Java Class
            space.insertSpace(space_ID, space_Name, address, place, pic_poster, pic_cover, start_time, end_time, map, description);
            type_space.insertType_Space(type_ID, type_name, num_Room, prototype);
            room.insertRoom(room_ID, price, room_Name, num_Table, pic_room);
            table.insertTable(table_ID, num_People);
            
            String[] open = request.getParameterValues("Open_Date");
            List<String> openDateList = Arrays.asList(open);
            for (int i = 0; i <= openDateList.size(); i++) {
                String OpenDate = openDateList.get(i);
                String Date_ID = date.createDateID();
                date.insertDate(Date_ID, OpenDate);
            }
            
            String [] service_Name = request.getParameterValues("Service_Name");
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
