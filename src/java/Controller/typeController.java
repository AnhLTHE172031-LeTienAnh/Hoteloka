/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Hotel;
import Model.RoomType;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "typeController", urlPatterns = {"/type"})
public class typeController extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomType rt = new RoomType();

        //Nhan ten khach san da chon tu client
        String roomname = request.getParameter("hotelid");
        //Nhan gia phong tu client
        //truyen vao selectedHotel de hien thi ten ksan vua chon
        request.setAttribute("selectedHotel", roomname);
        String[] pageValues = request.getParameterValues("page");
        String page = (pageValues != null && pageValues.length > 0) ? pageValues[0] : "1";
        int n = Integer.parseInt(page);
        ArrayList<RoomType> data2 = data2 = rt.getListRoomType(n);
        request.setAttribute("data2", data2);
        request.getRequestDispatcher("ListRoomType.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
