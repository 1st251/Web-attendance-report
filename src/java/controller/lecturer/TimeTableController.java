/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.lecturer;

import dal.LecturerDBContext;
import dal.TimeSlotDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import model.Session;
import model.TimeSlot;
import util.DateTimeHelper;

/**
 *
 * @author admin
 */
public class TimeTableController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int lid = Integer.parseInt(request.getParameter("lid"));
//        Date from = Date.valueOf(request.getParameter("from"));
//        Date to = Date.valueOf(request.getParameter("to"));
        String year_raw = request.getParameter("year");
        String week_raw=request.getParameter("week");
        Date from, to;
        String[] week_list= week_raw.split(" to ");
        from = Date.valueOf(year_raw+"-"+week_list[0]);
        to = Date.valueOf(year_raw+"-"+week_list[1]);
        ArrayList<String> weeks = DateTimeHelper.getWeekStartEndDates(Integer.parseInt(year_raw), " to ");
        ArrayList<Date> dates = DateTimeHelper.getListDates(from, to);
        TimeSlotDBContext dbSlot = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = dbSlot.all();
        LecturerDBContext lecDb = new LecturerDBContext();
        ArrayList<Session> sessions = lecDb.getSessions(lid);
        String fromto = from.toString().substring(4)+ " to "+to.toString().substring(4);
        
        request.setAttribute("fromto", fromto);
        
        request.setAttribute("weeks", weeks);
        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("sessions", sessions);
        request.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(request, response);
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       ArrayList<String> weeks = DateTimeHelper.getWeekStartEndDates(2023, " to ");
       request.setAttribute("weeks", weeks);
       request.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(request, response);
    
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int lid = Integer.parseInt(request.getParameter("lid"));
//        Date from = Date.valueOf(request.getParameter("from"));
//        Date to = Date.valueOf(request.getParameter("to"));
        String year_raw = request.getParameter("year");
        String week_raw=request.getParameter("week");
        Date from, to;
        if(week_raw == null){
            
        }
        String[] week_list= week_raw.split(" to ");
        from = Date.valueOf(year_raw+"-"+week_list[0]);
        to = Date.valueOf(year_raw+"-"+week_list[1]);
        ArrayList<String> weeks = DateTimeHelper.getWeekStartEndDates(Integer.parseInt(year_raw), " to ");
        ArrayList<Date> dates = DateTimeHelper.getListDates(from, to);
        TimeSlotDBContext dbSlot = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = dbSlot.all();
        LecturerDBContext lecDb = new LecturerDBContext();
        ArrayList<Session> sessions = lecDb.getSessions(lid);
        String fromto = week_list[0]+" to " +week_list[1];
        
        request.setAttribute("year", year_raw);
        request.setAttribute("fromto", fromto);
        request.setAttribute("lid", lid);
        request.setAttribute("weeks", weeks);
        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("sessions", sessions);
        request.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(request, response);
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
