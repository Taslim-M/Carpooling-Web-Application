<%-- 
    Document   : index
    Created on : Apr 5, 2020, 1:57:47 PM
    Author     : Tasli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script type ="text/javascript">
            function validate() {
                var uname = document.forms.loginform.email.value;

                if (!(/@aus.edu\s*$/.test(uname))) {
                    alert("Please enter a valid AUS email ID");
                    return false;
                }
                return true;
            }
        </script>
        <style>
            body {
                background: url('https://free4kwallpapers.com/uploads/originals/2019/06/08/dubai-burj-khalifa-wallpaper.jpg') no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                background-size: cover;
                -o-background-size: cover;
            }
            .login-dark form {
                max-width:320px;
                width:90%;
                background-color:#1e2833;
                padding:40px;
                border-radius:4px;
                transform:translate(-50%, -50%);
                position:absolute;
                top:50%;
                left:50%;
                color:#fff;
                box-shadow:3px 3px 4px rgba(0,0,0,0.2);
            }
            .login-dark form .btn-primary {
                background:#214a80;
                border:none;
                border-radius:4px;
                padding:11px;
                box-shadow:none;
                margin-top:26px;
                text-shadow:none;
                outline:none;
            }
            .login-dark form .btn-primary:hover, .login-dark form .btn-primary:active {
                background:#214a80;
                outline:none;
            }
            .login-dark form .form-control {
                background:none;
                border:none;
                border-bottom:1px solid #434a52;
                border-radius:0;
                box-shadow:none;
                outline:none;
                color:inherit;
            }
            .login-dark form .btn-primary:active {
                transform:translateY(1px);
            }
        </style>

    </head>
    <body class="h-100">
        <div class ="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <div class ="col-10 col-md-8 col-lg-6">

                    <div class="px-2">
                        <div class="login-dark">
                            <form name = "loginform" action="LoginController" method="post" class="form justify-content-center">
                                <h1 class="card-title text-center">USCP</h1>
                                <c:if test="${!empty errmsg}" >
                                    <div class="alert alert-danger">
                                        ${errmsg}
                                    </div>
                                </c:if>
                                <div class="form-group">

                                    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required/>
                                </div>
                                <div class="form-group">

                                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required/>
                                </div>
                                <div class="form-group">
                                    <button type="submit" onClick="return validate();" class="btn btn-block btn-success">Login</button>
                                </div>
                                <div class ="container">
                                    <p class="copyright">&copy; USCP by Team-E.</p>
                                    <a href="NewUserRegistration.jsp" class="btn btn-primary btn-block" role="button">Register Here</a>
                                </div>
                            </form>
                            <!-- Form end -->
                        </div>
                    </div>
                </div>
            </div>

        </form>
    </div>
</div>
</div>
</div> 
</body>
</html>
