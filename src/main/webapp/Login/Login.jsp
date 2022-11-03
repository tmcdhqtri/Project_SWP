<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>King's Fast Food</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="./Homepage/images/logo.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./Login/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./Login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./Login/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./Login/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="./Login/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./Login/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./Login/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="./Login/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="./Login/css/util.css">
        <link rel="stylesheet" type="text/css" href="./Login/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-size: cover; background-image: url(https://img.freepik.com/free-psd/arrangement-fast-food-wooden-background_23-2148321316.jpg?w=2000);">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form class="login100-form validate-form" action="login" method ="post">
                        <span class="login100-form-title p-b-49">
                            Login
                        </span>

                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reaquired">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="username" placeholder="Type your username">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="password" placeholder="Type your password">
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>

                        <!-- <div class="text-right p-t-8 p-b-31">
                                <a href="#">
                                        Forgot password?
                                </a>
                        </div> -->

                        <div class="container-login100-form-btn mt-3">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button type ="submit" class="login100-form-btn">
                                    Login
                                </button>
                            </div>
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <a style="color: white; cursor: pointer;" href="/Homepage/index.html" class="login100-form-btn">
                                    Home
                                </a>
                            </div>
                        </div>
                        <!-- 
                                                                <div class="txt1 text-center p-t-54 p-b-20">
                                                                        <span>
                                                                                Or Sign Up Using
                                                                        </span>
                                                                </div>
                        
                                                                <div class="flex-c-m">
                                                                        <a href="#" class="login100-social-item bg1">
                                                                                <i class="fa fa-facebook"></i>
                                                                        </a>
                        
                                                                        <a href="#" class="login100-social-item bg2">
                                                                                <i class="fa fa-twitter"></i>
                                                                        </a>
                        
                                                                        <a href="#" class="login100-social-item bg3">
                                                                                <i class="fa fa-google"></i>
                                                                        </a>
                                                                </div> -->

                        <div class="flex-col-c p-t-155">
                            <span class="txt1 p-b-17">
                                Or Sign Up Using
                            </span>

                            <a href="/Register/Register.html" class="txt2">
                                Sign Up
                            </a>
                        </div>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Project_SWP/Login&response_type=code
                           &client_id=409601733964-72kvqd5ajhjtck17f11p5dsj04a279uu.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="./Login/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="./Login/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="./Login/vendor/bootstrap/js/popper.js"></script>
        <script src="./Login/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="./Login/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="./Login/vendor/daterangepicker/moment.min.js"></script>
        <script src="./Login/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="./Login/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="./Login/js/main.js"></script>

    </body>
</html>