<%-- 
    Document   : home
    Created on : Jun 26, 2023, 8:50:49 PM
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
                               <form class="sort" action="hotel" method="post">
                                        <div class="page-div" style="margin-right: -130px; display: flex">
                                            <input style="margin-top: -10px; margin-right: 3px" class="text" type="text" name="find" placeholder="Search hotel by name" value="${name}">
                                            <input style="margin-top: -10px; padding: 2px; background-color: sandybrown; border: none; border-radius: 3px; cursor: pointer" class="submit" type="submit" value="Search">
                                        </div>
                                </form>
                            </div>
                            
                            <!-- end of header right -->
                            <div class="cleaner"></div>
                        </div>
                        <!-- end of header -->
                        <div id="content_wrapper">
                            <div id="content_outer">
                                <div id="content">
                                    <div class="content_section">
                                        <h2>Welcome to Travel &amp; Tour</h2>
                                        <p>Welcome to our Travel & Hotel website, where we aim to provide you with exceptional services and unforgettable experiences. Whether you're planning a leisurely vacation, a business trip, or a quick weekend getaway, we have a wide range of options to suit your needs. Explore our collection of luxurious hotels, charming bed and breakfasts, and stunning resorts, all carefully selected to ensure your comfort and satisfaction. Our team of dedicated professionals is ready to assist you in creating a memorable journey, offering expert advice, convenient booking services, and personalized recommendations. Start your adventure with us and let us exceed your expectations at every step of the way.</p>
                                    </div>
                                    <div class="content_section">
                                        <h2>About Hoteloka Company</h2>
                                        <p class="em_text">Hoteloka is a renowned travel company that offers exceptional services for all your travel needs. With a wide range of destinations and accommodations, we strive to provide unforgettable experiences. Our dedicated team ensures seamless bookings, competitive prices, and personalized assistance. Whether it's a luxurious getaway or a budget-friendly trip, Hoteloka has you covered. Trust us to make your travel dreams come true.</p>
                                        <ul class="featured_tour float_l">
                                            <li> <a href="hotel?showlist=DaNang">Da Nang <span>A captivating destination with stunning beaches and vibrant culture.</span></a> </li>
                                            <li> <a href="hotel?showlist=HaNoi">Ha Noi <span>A captivating destination with stunning beaches and vibrant culture. </span></a> </li>
                                            <li> <a href="hotel?showlist=VungTau">Vung Tau <span>A coastal gem with stunning beaches and vibrant culture.</span></a> </li>
                                            <li> <a href="hotel?showlist=DaLat">Da Lat <span>A picturesque city nestled in the Central Highlands of Vietnam.</span></a> </li>
                                        </ul>
                                        <ul class="featured_tour float_r">
                                            <li> <a href="hotel?showlist=NhaTrang">Nha Trang <span>A captivating coastal city with pristine beaches and vibrant culture.</span></a> </li>
                                            <li> <a href="hotel?showlist=PhuQuoc">Phu Quoc <span>A tropical paradise with pristine beaches and breathtaking scenery.</span></a> </li>
                                            <li> <a href="hotel?showlist=ConDao">Con Dao <span>A tropical paradise with pristine beaches and breathtaking scenery.</span></a> </li>
                                            <li> <a href="hotel?showlist=PhanThiet">Phan Thiet <span>A captivating travel destination with stunning natural beauty.</span></a> </li>
                                        </ul>
                                        <div class="cleaner"></div>
                                        <div class="button_01"><a href="city">View All</a></div>
                                        <div class="cleaner"></div>
                                    </div>
                                </div>
                                <!-- end of content -->
                                <div id="content_bottom"></div>
                                <div class="cleaner"></div>
                            </div>
                            <!-- end of content_outer -->
                            <div id="sidebar">
                                <div class="sidebar_section">
                                    <h2>The Trendy Place <i style="color: orange" class="uil uil-fire"></i><i style="color: orange" class="uil uil-fire"></i></h2>
                                    <div class="image_wrapper"> <a href="hotel?showlist=DaNang"><img src="img/danang_1.jpg" alt="" width="260" height="120" /></a> </div>
                                    <h1>Da Nang</h1>
                                    <p>Da Nang, the hottest tourist destination this summer, offers pristine beaches, vibrant nightlife, and rich cultural experiences.</p>
                                    <div class="button_01"><a href="hotel?showlist=DaNang">List Hotel</a></div>
                                    <div class="cleaner_h30"></div>
                                    <div class="image_wrapper"> <a href="hotel?showlist=VungTau"><img src="img/vungtau_1.jpg" alt="" width="260" height="120" /></a> </div>
                                    <h1>Vung Tau</h1>
                                    <p>Vung Tau, the hottest travel destination this summer, offers breathtaking beaches and captivating coastal landscapes.</p>
                                    <div class="button_01"><a href="hotel?showlist=VungTau"> List Hotel</a></div>
                                </div>
                            </div>
                            <!-- end of template_sidebar -->
                            <div class="cleaner"></div>
                        </div>
                        <!-- end of content_wrapper -->
                        <div id="footer" style="margin-top: 15px">
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
    </body>
</html>
