/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.login;
import dal.StudentDBContext;
import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import model.Lecturer_User;
import model.Student_User;

/**
 *
 * @author admin
 */
public class LoginController extends HttpServlet {
   
    

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
        request.getRequestDispatcher("../view/authentication/login.jsp").forward(request, response);
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
        StudentDBContext sdb = new StudentDBContext();
        UserDBContext db = new UserDBContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Lecturer_User luser = db.getlu(username,password);
        Student_User suser =  sdb.getsu(username, password);
        HttpSession session = request.getSession();
        String mess="Access Fail";
        if(luser != null)
        {
            session.setAttribute("acc", luser);
            request.getRequestDispatcher("../view/menu.jsp").forward(request, response);        }
        else if (suser !=null){
           session.setAttribute("acc", suser);
           request.getRequestDispatcher("../view/studentmenu.jsp").forward(request, response);
        }
        
        else
        {
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("../view/authentication/login.jsp").forward(request, response);

        }
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
