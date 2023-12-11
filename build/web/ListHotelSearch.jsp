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
                    <div id="container">
                        <div id="header">
                            <div id="header_left">
                                <div id="menu" style="width: 600px">
                                    <ul style="width: 600px">
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
                                    <form class="sort" action="hotel" method="post">
                                        <div class="page-div" style="margin-right: -180px">
                                            <input class="text" type="text" name="find" placeholder="Search hotel by name" value="${name}">
                                            <input class="submit" type="submit" value="Search">
                                            <input class="submit" type="submit" name="page" value="1">
                                            <input class="submit" type="submit" name="page" value="2">
                                            <input class="submit" type="submit" name="page" value="3">
                                            <input class="submit" type="submit" name="page" value="4">
                                            <input class="submit" type="submit" name="page" value="5">
                                        </div>
                                    </form>

                            </div>
                            <div class="list-hotel">
                                <c:forEach items="${data}" var="item">
                                    <div class="hotel"> 
                                        <div class="hotel-image">
                                            <a href="sorter?type=&sort_price=asc&hotelid=${item.getHotelID()}">
                                                <img src="img/${item.getImage()}" alt="" />
                                            </a>
                                        </div>
                                        <div class="hotel-detail">
                                            <h2><a href="sorter?type=&sort_price=asc&hotelid=${item.getHotelID()}">${item.getHotelName()}</a></h2><br>
                                            <div class="hotel-rate">
                                                <c:if test="${item.getRateNumber() >= 5}">
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                </c:if>
                                                <c:if test="${item.getRateNumber() == 4}">
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star"></i>
                                                </c:if>
                                                <c:if test="${item.getRateNumber() == 3}">
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star"></i>
                                                    <i class="uis uis-star"></i>
                                                </c:if>
                                                <c:if test="${item.getRateNumber() == 2}">
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star"></i>
                                                    <i class="uis uis-star"></i>
                                                    <i class="uis uis-star"></i>
                                                </c:if>
                                                <c:if test="${item.getRateNumber() == 1}">
                                                    <i class="uis uis-star" style="color: greenyellow;"></i>
                                                    <i class="uis uis-star"></i>
                                                    <i class="uis uis-star"></i>
                                                    <i class="uis uis-star"></i>
                                                    <i class="uis uis-star"></i>
                                                </c:if>
                                            </div>
                                            <div class="hotel-address">
                                                <p>${item.getAddress()}</p>
                                                <i class="uil uil-map-marker"></i>
                                                <a href="https://www.google.com/maps">Bản đồ</a>
                                            </div>
                                            <div class="hotel-services">
                                                <h4>Services:</h4>
                                                <ul>
                                                    <li>${item.getService()}</li>
                                                    <li>Relaxing vacation</li>
                                                    <li>Suitable for families</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="hotel-contact">
                                            <div class="hotel-contact hotel-price">
                                                <h3>Liên Hệ</h3>
                                                <h1>${item.getHotline()}</h1>
                                            </div>
                                            <form action="type" method="get">
                                                <div class="hotel-contact hotel-hotline">
                                                    <p>Vui lòng click vào Detail</p>
                                                    <P>để biết thêm chi tiết</P>
                                                    <button class="button-12" style="margin-top: 10px"><a href="sorter?type=&sort_price=asc&hotelid=${item.getHotelID()}">Detail</a></button>
                                                </div>
                                            </form>

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
