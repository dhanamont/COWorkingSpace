/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
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
            throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
//          ตำแหน่งที่รูปจะเซฟลง
            String savePath = "D:\\Co-workingSpace\\web\\assets\\img\\space";
//          สร้าง Object
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
            String User_ID = (String) session.getAttribute("User_ID");
            String Map = request.getParameter("Map");
            String Description = request.getParameter("Description");
            Part Picture_poster = request.getPart("Picture_poster");
            Part Picture_cover = request.getPart("Picture_cover");
            
            DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
            String startTime = (String) request.getParameter("Start_Time");
            Time StartTime = new Time(df2.parse(startTime).getTime());
            
            String endTime = (String) request.getParameter("End_Time");
            Time EndTime = new Time(df2.parse(endTime).getTime());
            
            
            //Add image to directory
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            String covername = extractFileName(Picture_cover);
            Picture_cover.write(savePath + File.separator + covername);
            covername = "assets/img/" + covername;

            String postername = extractFileName(Picture_poster);
            Picture_poster.write(savePath + File.separator + postername);
            postername = "assets/img/" + postername;
            out.println("spaceName: "+Space_Name+"\naddress: "+Address+"\nplace: "+Place+"\nUser_ID: "+User_ID+"\n"
                    + "Map: "+Map+"\nDescription: "+Description+"\ncovername: "+covername+"\npostername: "+postername+"\nStartTime: "+StartTime+"\nEndTime: "+EndTime);
            
//            รับข้อมูล Type Space
            String Type_Name[] = request.getParameterValues("Type_name[]");
            String numofRoom[] = request.getParameterValues("NumberofRoom[]");
            ArrayList<Integer> NumofRoom = new ArrayList<Integer>();
            for(int i = 0; i< numofRoom.length;i++){
                NumofRoom.add(Integer.parseInt(numofRoom[i]));
            }
            Part Prototype = request.getPart("Prototype");
            
            out.println("-----------------------------------------");
            out.println("TypeName[]: "+Arrays.toString(Type_Name)+"\numofRoom[]:"+NumofRoom);

//            รับข้อมูล Room
            String numofTable[] = request.getParameterValues("NumberofTable[]");
            ArrayList<Integer> NumofTable = new ArrayList<Integer>();
            for(int i = 0; i< numofTable.length;i++){
                NumofTable.add(Integer.parseInt(numofTable[i]));
            }
            Part Picture_room = request.getPart("Picture_room");
            String priceroom[] = request.getParameterValues("Price[]");
            ArrayList<Float> Price = new ArrayList<Float>();
            for(int i = 0; i< priceroom.length;i++){
                Price.add(Float.parseFloat(priceroom[i]));
            }
            String prototype = extractFileName(Prototype);
            Prototype.write(savePath + File.separator + prototype);
            prototype = "assets/img/" + prototype;

            String picroom = extractFileName(Picture_room);
            Picture_room.write(savePath + File.separator + picroom);
            picroom = "assets/img/" + picroom;
            
            out.println("-----------------------------------------");
            out.println("NumofTable[]: "+NumofTable+"\nPrice[]: "+Price);
            
//            รับข้อมูล Table
            String numofPeople[] = request.getParameterValues("NumofPeople[]");
            ArrayList<Integer> NumofPeople = new ArrayList<Integer>();
            for(int i = 0; i< numofPeople.length;i++){
                NumofPeople.add(Integer.parseInt(numofPeople[i]));
                
            }
            
            out.println("-----------------------------------------");
            out.println("NumofPeople[]: "+NumofPeople);

            //สร้าง ID จาก Java Class
            String Type_ID;
            String Room_ID;
            String Room_Name;
            String Table_ID;
            
            String Space_ID = space.createSpace_ID();
            System.out.println(Space_ID+"\n"+Space_Name+"\n"+Address+"\n"+Place+"\n"+User_ID+"\n"+Map);
            space.insertSpace(Space_ID, Space_Name, Address, Place, User_ID, Map, Description, covername, postername, StartTime, EndTime);
            System.out.println(Type_Name.length);
            for (int i=0;i<Type_Name.length;i++){
                Type_ID = type_space.createType_ID();
                System.out.println(NumofRoom.get(i));
                System.out.println(Type_Name[i]);
                System.out.println(prototype);
                type_space.insertType_Space(Type_ID, Type_Name[i], NumofRoom.get(i), prototype, Space_ID);
                for (int j=0;j < NumofRoom.get(i);j++){
                    Room_ID = room.createRoom_ID();
                    System.out.println(Room_ID);
                    Room_Name = "ROOM"+(j+1);
                    System.out.println(Room_Name);
                    room.insertRoom(Room_ID, Room_Name, NumofTable.get(j), picroom, Price.get(i), Type_ID);
                    for (int k=0;k < NumofTable.get(j);k++){
                        Table_ID = table.createTable_ID();
                        table.insertTable(Table_ID, NumofPeople.get(j), Room_ID);
                    }
                }
            }
            

            //ส่งค่าไป Java Class
            
            

            String[] Open_in = request.getParameterValues("Open_Date");
            List<String> Open_inList = Arrays.asList(Open_in);
            for (int i = 0; i < Open_inList.size()-1; i++) {
                String OpenDateList = Open_inList.get(i);
                String Date_ID = date.createDate_ID();
                date.insertDate(Date_ID, OpenDateList, Space_ID);
            }

            String[] service_Name = request.getParameterValues("Service_Name");
            List<String> serviceList = Arrays.asList(service_Name);
            for (int j = 0; j < serviceList.size()-1; j++) {
                String Service_Name = serviceList.get(j);
                String Service_ID = service.createService_ID();
                service.insertService(Service_ID, Service_Name, Space_ID);
            }

            response.sendRedirect("Property_Servlet?id="+Space_ID);
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
                Logger.getLogger(SubmitPropertiesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(SubmitPropertiesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
