<%-- 
    Document   : register
    Created on : 9 Jul, 2022, 10:48:36 AM
    Author     : HP
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>
        <link rel="stylesheet" href="css/sign-in.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <link rel="icon" type="image/png" href="img/Logo D.png" />
    </head>
    <body>


        <div class="form-container sign-up-form">
            <div class="imgBox sign-up-imgBox">
                <div class="sliding-link">
                    <p>Already have an account?</p>
                    <a class="sign-up-btn" href="login.jsp">Sign in</a>
                </div>
                <img src="images/signup-img.png" alt="">
            </div>
            <div class="form-box sign-up-box">
                <div class="login-logo">
                    <h2>Register</h2>
                    <img src="img/Logo D.png" class="nav-logo" alt="">
                </div>

                <!-- facebook google apple -->
                <div class="login-options">
                    <div class="other-logins">
                        <a href="https://accounts.google.com/signin"><img src="images/google.png" alt=""></a>
                        <a href="https://appleid.apple.com/sign-in"><img src="images/apple.png" alt=""></a>
                        <a href="https://www.facebook.com/login/"><img src="images/facebook.png" alt=""></a>
                    </div>
                    <p class="text">Or, sign up with email...</p>
                </div>

                <form action="register" method="post">
                    <div class="field">
                        <i class="uil uil-user"></i>
                        <input type="text" placeholder="Useraccount" name="account" required>
                    </div>
                    <div class="field">
                        <i class="uil uil-lock-alt"></i>
                        <input class="password-input" type="password" placeholder="Password" name="password" required>
                    </div>
                    <div class="field">
                        <i class="uil uil-lock-access"></i>
                        <input class="password-input" type="password" placeholder="Confirm password" name="repassword" required>
                    </div>
                    <div class="field">
                        <i class="uil uil-user-circle"></i>
                        <input type="text" placeholder="Username" name="name" required>
                    </div>
                    <div class="field">
                        <i class="uil uil-at"></i>
                        <input type="email" placeholder="Email" name="email" required>
                    </div>
                    <p class="error-mess">${requestScope.mess}</p>


                    <input class="submit-btn" type="submit" value="Sign up">
                </form>

            </div>

        </div>
        <script>
            //input field focus effect
            const textInputs = document.querySelectorAll("input");

            textInputs.forEach(textInput => {
                textInput.addEventListener("focus", () => {
                    let parent = textInput.parentNode;
                    parent.classList.add("active");
                });

                textInput.addEventListener("blur", () => {
                    let parent = textInput.parentNode;
                    parent.classList.remove("active");
                })
            })

            //password show/hide button
            const passwordInput = document.querySelector(".password-input");
            const eyeBtn = document.querySelector(".eye-btn");
            eyeBtn.addEventListener("click", () => {
                if (passwordInput.type === "password") {
                    passwordInput.type = "text";
                    eyeBtn.innerHTML = "<i class='uil uil-eye'></i>"
                } else {
                    passwordInput.type = "password";
                    eyeBtn.innerHTML = "<i class='uil uil-eye-slash'></i>"
                }
            })
        </script>
    </body>
</html>
