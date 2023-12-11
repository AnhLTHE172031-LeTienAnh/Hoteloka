/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Model.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
@WebServlet(name="searchController", urlPatterns={"/search"})
public class searchController extends HttpServlet {
   
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
            out.println("<title>Servlet searchController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchController at " + request.getContextPath () + "</h1>");
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
        Hotel h = new Hotel();
        //Nhan gia tri ten khach san can tim kiem tu client
        String name = request.getParameter("find");
        request.setAttribute("name", name);
        //Nhan gia tri cua page tu client
        String[] pageValues = request.getParameterValues("page");
        //Neu do dai ten ksan can tim kiem = 0->lay list tat ca khach san
        if (name.length() == 0) {
            String page = (pageValues != null && pageValues.length > 0) ? pageValues[0] : "1";
            int n = Integer.parseInt(page);
            //Lay danh sach users tu db
            ArrayList<Hotel> data = h.getListHotel(n);
            request.setAttribute("data", data);
            request.getRequestDispatcher("ListHotel.jsp").forward(request, response);
        } else /*lay list khach san dua theo chu cai vua nhap*/{
            String page = (pageValues != null && pageValues.length > 0) ? pageValues[0] : "1";
            int n = Integer.parseInt(page);
            //Lay danh sach users tu db
            ArrayList<Hotel> data = h.getListHotelbyName(n, name);
            request.setAttribute("data", data);
            request.getRequestDispatcher("ListHotelSearch.jsp").forward(request, response);
        }
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
        processRequest(request, response);
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
