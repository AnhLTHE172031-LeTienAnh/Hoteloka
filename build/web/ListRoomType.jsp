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
                    <div id="container" style="height: 3445px">
                        <div id="header">
                            <div id="header_left">
                                <div id="menu" style="width: 550px">
                                    <ul style="width: 550px">
                                        <li><a href="home_log.jsp" class="current"><span></span>Home</a></li>
                                        <li><a class="sub-btn" href="city"> </i> Hotels</a></li>
                                        <li><a href="#">Blogs</a></li>
                                        <li><a href="#">${sessionScope.account}</a></li>
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
                                <form class="sort" action="sorter" method="get">
                                    <div class="page-div" style="margin-right: -180px">
                                        <label class="lab">Type</label>
                                        <select class="sel" name="type">
                                            <option value="" selected="">All</option>
                                            <c:forEach var="c" items="${data3}">
                                                <option value="${c.getRoomTypeName()}">${c.getRoomTypeName()}</option>
                                            </c:forEach>
                                        </select>
                                        <label class="lab">Price</label>
                                        <select class="sel" name="sort_price">
                                            <option value="asc">Ascending</option>
                                            <option value="desc">Descending</option>
                                        </select>
                                        <input class="submit" type="submit" value="Sort">
                                        <input style="width: 15px; text-align: center;" class="submit" type="text" name="hotelid" value="${selectedHotel}" hidden>
                                    </div>
                                </form>
                            </div>
                            <div class="list-hotel">

                                <c:forEach items="${data3}" var="item">
                                    <div class="hotel">
                                        <div class="hotel-image">
                                            <a href="room?hotelid=${selectedHotel}&roomname=${item.getRoomTypeName()}">
                                                <img src="img/${item.getImage()}" alt="" />
                                            </a>
                                        </div>
                                        <div class="hotel-detail" style="border-right: none; text-align: center">
                                            <h1 style="margin-right: -150px"><a href="room?hotelid=${selectedHotel}&roomname=${item.getRoomTypeName()}">${item.getRoomTypeName()}</a></h1><br>
                                            <div class="hotel-rate" style="display: flex; justify-content: center; align-items: center;margin-right: -150px">
                                                <h3 style="margin-left: -20px; padding-right: 5px">Capacity:</h3>
                                                <c:if test="${item.getCapacity() >= 5}">
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                </c:if>
                                                <c:if test="${item.getCapacity() == 4}">
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                </c:if>
                                                <c:if test="${item.getCapacity() == 3}">
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                </c:if>
                                                <c:if test="${item.getCapacity() == 2}">
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                </c:if>
                                                <c:if test="${item.getCapacity() == 1}">
                                                    <i style="font-size: x-large" class="uil uil-bed"></i>
                                                </c:if>
                                            </div>
                                            <div class="room_slot" style="display: flex; justify-content: center; align-items: center; margin-right: -150px; margin-top: -20px">
                                                <h4>Number of rooms: </h4>
                                                <h4>${item.getRoomAvailable()}</h4>
                                            </div>
                                            <div class="hotel-contact hotel-price" style="margin-right: -140px">
                                                <h2 style="margin: -5px 0">Price</h2>
                                                <h1>${item.getRoomPrice()}</h1>
                                                <p style="margin-top: -10px">VND/đêm</p>
                                            </div>
                                                <div class="hotel-contact hotel-hotline" style="margin-right: -150px">
                                                    <p>Vui lòng click vào Detail</p>
                                                    <P>để biết thêm chi tiết</P>
                                                    <button class="button-12"><a href="room?hotelid=${selectedHotel}&roomname=${item.getRoomTypeName()}">Detail</a></button>
                                                </div>
                                        </div>      
                                    </div>
                                </c:forEach>
                            </div>        
                            <div id="footer" style="margin: 0 0 0 10px;">
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
