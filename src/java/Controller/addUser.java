/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name="addUser", urlPatterns={"/register"})
public class addUser extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addUser</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addUser at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        String account = request.getParameter("account");
        String pass = request.getParameter("password");
        String pass2 = request.getParameter("repassword");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        User u = new User(account);
        boolean check = u.checkUsername();

        boolean valid = true;
        
        //Trung ten dang nhap
        if (check) {
            //register fail
            valid = false;
            String mess = "Username have been used!";
            request.setAttribute("mess", mess);
            //send direct with parameter
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        
        //Mat khau nhap lai sai
        if (!pass2.equals(pass)) {
            //register fail
            valid = false;
            String mess = "Re-entered password is incorrect!";
            request.setAttribute("mess", mess);
            //send direct with parameter
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        
        //Ten dang nhap qua ngan;
        if (account.length()<5) {
            //register fail
            valid = false;
            String mess = "Username must be between 5-12 characters!";
            request.setAttribute("mess", mess);
            //send direct with parameter
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        
        User user = new User(account, pass, name, email);
            
            u.addUser(user);
            String mess = "Your account have been created";
            request.setAttribute("mess1", mess);
            //send direct with parameter
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
