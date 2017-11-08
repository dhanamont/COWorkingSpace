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

//            สร้าง Object
            Space space = new Space();
            Date date = new Date();
            Time time = new Time();
            Type_Space type_space = new Type_Space();
            Room room = new Room();
            Table table = new Table();

//            รับรายละเอียดผู้ประกอบการ
            String space_Name = request.getParameter("Space_Name");
            String location = request.getParameter("Location");
            String pic_poster = request.getParameter("Picture_poster");
            String pic_cover = request.getParameter("Picture_cover");
            String start_date = request.getParameter("Start_Date");
            String end_date = request.getParameter("End_Date");
            String start_time = request.getParameter("Start_Time");
            String end_time = request.getParameter("End_Time");
            String description = request.getParameter("Description");

//            ArrayList ของ Date
            ArrayList<String> alldate = new ArrayList<>();
            alldate.add("Monday");
            alldate.add("Tuesday");
            alldate.add("Wednesday");
            alldate.add("Thursday");
            alldate.add("Friday");
            alldate.add("Saturday");
            alldate.add("Sunday");

//            ArrayList ของ Time
            ArrayList<String> alltime = new ArrayList<>();
            alltime.add("8.00");
            alltime.add("9.00");
            alltime.add("10.00");
            alltime.add("11.00");
            alltime.add("12.00");
            alltime.add("13.00");
            alltime.add("14.00");
            alltime.add("15.00");
            alltime.add("16.00");
            alltime.add("17.00");
            alltime.add("18.00");
            alltime.add("19.00");
            
//            Arraylist ไว้เก็บข้อมูลวันเปิด-ปิด & เวลาเปิด-ปิด
            ArrayList<String> open_close_Date = new ArrayList<>();
            ArrayList<String> open_close_Time = new ArrayList<>();

//            ตัวแปรเอาไว้เก็บ index ของวันเปิด-ปิด
            int saveStartDate;
            int saveEndDate;
            
//            Loop เช็คว่าวันเปิด-ปิดตรงกับลำดับที่เท่าไหร่ใน Arraylist
            for (int i = 0; i <= alldate.size(); i++) {                
                if (start_date.equals(alldate.get(i))) {                    
                    saveStartDate = i;
                    
                    for (int j =  0; j <= alldate.size(); j++) {
                        if (end_date.equals(alldate.get(j))) {
                            saveEndDate = j;
                            
                            for (int dateRange = saveStartDate; dateRange <= saveEndDate; dateRange++) {
                                open_close_Date.add(alldate.get(dateRange));
                            }
                        }
                    }
                }
            }
            
//            ตัวแปรเอาไว้เก็บ index ของเวลาเปิด-ปิด
            int saveStartTime;
            int saveEndTime;
            
//            Loop เช็คว่าเวลาเปิด-ปิดตรงกับลำดับที่เท่าไหร่ใน Arraylist
            for (int k = 0; k <= alltime.size(); k++) {
                if (start_time.equals(alltime.get(k))) {
                    saveStartTime = k;
                    
                    for (int l = 0; l <= alltime.size(); l++) {                        
                        if (end_time.equals(alltime.get(l))) {
                            saveEndTime = l;
                            
                            for(int timeRange = saveStartTime; timeRange <= saveEndTime; timeRange++) {
                                open_close_Time.add(alltime.get(timeRange));
                            }
                        }
                    }
                }
            }

//            รับข้อมูล Type Space
            String type_name = request.getParameter("Type_name");
            String num_Room = request.getParameter("NumberofRoom");
            String prototype = request.getParameter("Prototype");

//            รับข้อมูล Room
            String price = request.getParameter("Price");
            String room_Name = request.getParameter("Room_Name");
            String num_Table = request.getParameter("End_Time");
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
            space.insertSpace(space_ID, space_Name, location, pic_poster, pic_cover, start_date, end_date, start_time, end_time, description);
            date.insertDate(date_ID, open_close_Date);
            time.insertTime(time_ID, open_close_Time);
            type_space.insertType_Space(type_ID, type_name, num_Room, prototype);
            room.insertRoom(room_ID, price, room_Name, num_Table, pic_room);
            table.insertTable(table_ID, num_People);

//            2 อันนี้เหมือนกันปะ?? ส่งถูกมั้ยช่วยดูโหน่ย
            request.getRequestDispatcher("MyProperty.jsp").forward(request, response);
            
            response.sendRedirect("MyProperty.jsp");
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
