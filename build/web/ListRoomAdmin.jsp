<%-- 
    Document   : home
    Created on : Jun 26, 2023, 8:50:49 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Hotel" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/project-home.css">
        <link rel="stylesheet" href="css/hotel.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/solid.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" charset="utf-8"></script>
    </head>
    <body>
        <div id="wrapper_outter">
            <div id="wrapper_inner">
                <div id="wrapper">
                    <div id="container" style="height: 1500px">
                        <div id="header">
                            <div id="header_left">
                                <div id="menu">
                                    <ul>
                                        <li><a href="home_log.jsp" class="current"><span></span>Home</a></li>
                                        <li><a class="sub-btn" href="city"> </i> Hotels</a></li>
                                        <li><a href="#">Blogs</a></li>
                                        <li><a href="#">Gallery</a></li>
                                        <li><a href="#">Contact Us</a></li>
                                    </ul>
                                </div>
                                <!-- end of menu -->
                                <div id="site">
                                    <h1><a href="#">Travel & Hotel<h4>provide the best services for customers</h4> </a></h1>
                                </div>
                            </div>
                            <!-- end of header left -->
                            <div id="header_right">
                                <a href="#"><img style="height: 250px; width: 250px" src="images/Blue And Yellow Simple Travel Agency Logo.png" alt="" /></a>
                            </div>
                            <!-- end of header right -->
                            <div id="body">
                            </div>
                            <div class="list-hotel" style="text-align: center;">
                                <table class="room-table" border="1">
                                    <tr class="room-table_row">
                                        <td class="room-table_ele">Room ID</td>
                                        <td class="room-table_ele">Hotel ID</td>
                                        <td class="room-table_ele">Room Type Name</td>
                                        <td class="room-table_ele">Room Availability</td>
                                        <td colspan="2"><a style="font-weight: bolder; font-size: large; color: azure" href="add?mod1=1">Add</a></td>
                                    </tr>
                                    <c:forEach items="${data2}" var="item">
                                        <tr class="room-table_row_1">
                                            <td>${item.getRoomID()}</td>
                                            <td>${item.getHotelID()}</td>
                                            <td>${item.getRoomTypeName()}</td>
                                            <td>${item.getUnitsInStock()}</td>
                                            <td><a style="color: #71950f; font-weight: bold" href="update?id=${item.getRoomID()}&mod2=1">Update</a></td>
                                            <td><a style="color: crimson; font-weight: bold" href="delete?id=${item.getRoomID()}&mod3=1">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>        
                            <div id="footer" style="margin: 450px 0 0 10px;">
                                <ul class="footer_menu">
                                    <li><a href="#">Home</a></li>
                                    <li><a href="#">Hotels</a></li>
                                    <li><a href="#">Blogs</a></li>
                                    <li><a href="#">Gallery</a></li>
                                    <li class="last_menu"><a href="#">Contact</a></li>
                                </ul>
                                Company &copy; 2023 <a href="#">HOTELOKA</a> | Designed by LE TIEN ANH</div>
                            <!-- end of footer -->
                            <div class="cleaner"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
