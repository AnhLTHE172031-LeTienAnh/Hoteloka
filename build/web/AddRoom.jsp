<%-- 
    Document   : AddRoom
    Created on : Jul 10, 2023, 5:00:50 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Room" %>
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
                                <form action="add" method="post">
                                    <h1>ADD ROOM</h1>
                                    <div class="delete_input">
                                        <label>HotelID: </label>
                                        <input type="text" name="HotelID"><br>
                                    </div>
                                    <div class="delete_input">
                                        <label>Room Type Name: <label>
                                                <select name="RoomTypeName">
                                                    <option value="all" selected="">All</option>
                                                    <option value="Double">Double</option>
                                                    <option value="Executive Suite">Executive Suite</option>
                                                    <option value="Junior Suite">Junior Suite</option>
                                                    <option value="King">King</option>
                                                    <option value="Premium Room">Premium Room</option>
                                                    <option value="Quad">Quad</option>
                                                    <option value="Queen">Queen</option>
                                                    <option value="Single">Single</option>
                                                    <option value="Studio">Studio</option>
                                                    <option value="Super Deluxe">Super Deluxe</option>
                                                    <option value="Triple">Triple</option>
                                                </select><br>
                                                </div>
                                                <div class="delete_input">
                                                    <label>UnitsInStock: </label><br>
                                                    <input type="radio" name="UnitsInStock" value="0"> Not available room
                                                    <input type="radio" name="UnitsInStock" value="1"> Available room <br>
                                                </div>
                                    <div class="delete_input" style="margin-left: 100px">
                                                    <input class="button-14" type="submit" name="add" value="ADD">
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
