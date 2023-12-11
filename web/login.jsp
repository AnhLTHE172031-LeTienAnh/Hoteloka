<%-- 
    Document   : login
    Created on : Jun 27, 2023, 9:13:13 AM
    Author     : ASUS
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="css/sign-in.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <link rel="icon" type="image/png" href="img/Logo D.png" />
    </head>
    <body>
        <% String mess="";
        if (request.getAttribute("mess") != null){
                mess= request.getAttribute("mess").toString();
            }
        %>

<!--        <form action="login" method="post">
            Account: 
            <br>
            <input type="text" name="acc">
            <br>
            Password:
            <br>
            <input type="password" name="pass">
            <br>  
            <input type="submit" value="Login">
        </form> -->

        <div class="form-container sign-in-form">
            <div class="form-box sign-in-box">
                
                <div class="login-logo">
                    <h2>Login</h2>
                    <img src="img/Logo D.png" class="nav-logo" alt="">
                </div>
                
                <form action="login" method="post">
                    <div class="field">
                        <i class="uil uil-user"></i>
                        <input type="text" placeholder="Username" name="account" required>
                    </div>
                    <div class="field">
                        <i class="uil uil-lock-alt"></i>
                        <input class="password-input" type="password" name="password" placeholder="Password" required>
                    </div>
                    <p class="error-mess">${requestScope.mess}</p>
                    <input class="submit-btn" type="submit" value="Login">
                </form>
                <div class="login-options">
                    <p class="text">Or, login with...</p>
                    <div class="other-logins">
                        <a href="https://accounts.google.com/signin"><img src="images/google.png" alt=""></a>
                        <a href="https://appleid.apple.com/sign-in"><img src="images/apple.png" alt=""></a> 
                        <a href="https://www.facebook.com/login/"><img src="images/facebook.png" alt=""></a>
                    </div>
                </div>
            </div>
            <div class="imgBox sign-in-imgBox">
                <div class="sliding-link">
                    <p>Don't have an account?</p>
                    <a class="sign-up-btn" href="register.jsp">Sign up</a>
                </div>
                <img src="images/signin-img.png" alt="">
            </div>
        </div>
    </body>
</html>
