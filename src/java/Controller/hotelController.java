/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Hotel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author FiSH
 */
@WebServlet(name = "hotelController", urlPatterns = {"/hotel"})
public class hotelController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Hotel h = new Hotel();
        //Nhan thong tin thanh pho dua theo dia chi da chon tu client
        String cityName = request.getParameter("showlist");
        //set gia tri nhan duoc cua cityName cho selectedCity
        request.setAttribute("selectedCity", cityName);
        //Nhan gia tri cua page tu client
        String[] pageValues = request.getParameterValues("page");
        //su dung toan tu dieukien de kiem tra dieu kien cua pageValues va gan gia tri mac dinh = 1
        String page = (pageValues != null && pageValues.length > 0) ? pageValues[0] : "1";
        int n = Integer.parseInt(page);
        //Lay danh sach hotel tu db
        ArrayList<Hotel> data = h.getListHotelbyCity(n, cityName);
        //truyen danh sach hotel vao data
        request.setAttribute("data", data);
        //chuyen huong den ListHotelbyCity.jsp
        request.getRequestDispatcher("ListHotelbyCity.jsp").forward(request, response);
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
            ArrayList<Hotel> data = h.getListHotel(n);
            request.setAttribute("data", data);
            request.getRequestDispatcher("ListHotel.jsp").forward(request, response);
        } else /*lay list khach san dua theo chu cai vua nhap*/{
            String page = (pageValues != null && pageValues.length > 0) ? pageValues[0] : "1";
            int n = Integer.parseInt(page);
            ArrayList<Hotel> data = h.getListHotelbyName(n, name);
            request.setAttribute("data", data);
            request.getRequestDispatcher("ListHotelSearch.jsp").forward(request, response);
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
