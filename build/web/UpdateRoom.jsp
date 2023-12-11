<%-- 
    Document   : UpdateRoom
    Created on : Jul 12, 2023, 4:21:18 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div id="container">
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
                            <div class="delete">
                                <form action="update" method="post">
                                    <h1>UPDATE ROOM</h1>
                                    <div class="delete_input">
                                        <label>RoomID: </label>
                                        <input type="text" name="RoomID" value="${r.getRoomID()}" readonly><br>
                                    </div>
                                    <div class="delete_input">
                                        <label>HotelID: </label>
                                        <input type="text" name="HotelID" value="${r.getHotelID()}"><br>
                                    </div>
                                    <div class="delete_input">
                                        <label>Room Type Name: <label>
                                        <select name="RoomTypeName">
                                            <option value="0">All</option>
                                            <c:forEach items="${data2}" var="c">
                                                <c:choose>
                                                    <c:when test="${c.getRoomID() eq r.getRoomID()}">
                                                        <option selected value="${c.getRoomTypeName()}">${c.getRoomTypeName()}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${c.getRoomTypeName()}">${c.getRoomTypeName()}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select><br>
                                    </div>
                                    <div class="delete_input">
                                        <label>UnitsInStock: </label><br>
                                        <c:if test="${r.getUnitsInStock() == 1}">
                                            <input type="radio" name="UnitsInStock" value="0"> Not available room
                                            <input type="radio" name="UnitsInStock" value="1" checked> Available room <br>
                                        </c:if>
                                        <c:if test="${r.getUnitsInStock() == 0}">
                                            <input type="radio" name="UnitsInStock" value="0" checked> Not available room
                                            <input type="radio" name="UnitsInStock" value="1"> Available room <br>
                                        </c:if>
                                    </div>
                                    <div class="delete_input" style="margin-left: 90px">
                                        <input class="button-14" type="submit" name="update" value="UPDATE">
                                    </div>
                                </form>
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

