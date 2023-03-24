/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.lecturer;

import dal.AttendanceDBContext;
import dal.LecturerDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import model.Attendance;
import model.Lecturer_User;
import model.Session;
import model.Student;
import util.DateTimeHelper;

/**
 *
 * @author admin
 */
public class AttendanceController extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../view/lecturer/attendance.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Lecturer_User user=(Lecturer_User) request.getSession().getAttribute("acc");
        int sid = Integer.parseInt(request.getParameter("sid"));
        AttendanceDBContext attdb = new AttendanceDBContext();
        ArrayList<Attendance> att = attdb.getTimeTableStudent(sid);
        int lid = user.getLecturer().getLid();
        LecturerDBContext lecDb = new LecturerDBContext();
        ArrayList<Session> sessions = lecDb.getSessions(lid);
        request.setAttribute("lid", lid);
        request.setAttribute("sid", sid);
        request.setAttribute("att", att);
        request.setAttribute("sessions", sessions);
//        int lid = user.getLecturer().getLid();
//        LecturerDBContext lecDb = new LecturerDBContext();
//        ArrayList<Session> sessions = lecDb.getSessions(lid);
////        String date = request.getParameter("date");
//        int countSes=0,count=0;
//        for(Session s : sessions){
//            countSes++;
//            if(s.isStatus() !=true){
//                count++;
//            }
//        }
//        int absent = count/countSes*100;
//        request.setAttribute("countSes", countSes);
//        request.setAttribute("count", count);
////        request.setAttribute("date", date);
//        request.setAttribute("lid", lid);
//        request.setAttribute("sessions", sessions);
//        request.setAttribute("absent", absent);
        request.getRequestDispatcher("../view/lecturer/attendance.jsp").forward(request, response);

    }
    
    
}
