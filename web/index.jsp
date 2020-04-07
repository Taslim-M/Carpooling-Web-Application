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
    </head>
    <body class="h-100">
        <div class ="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <div class ="col-10 col-md-8 col-lg-6">

                    <div class="px-2">
                        <form name = "loginform" action="LoginController" method="post" class="justify-content-center">
                            <h1>USCP</h1>
                            <c:if test="${!empty errmsg}" >
                                <div class="alert alert-danger">
                                    ${errmsg}
                                </div>
                            </c:if>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required/>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required/>
                            </div>

                            <button type="submit" onClick="return validate();" class="btn btn-success btn-lg">Submit</button>
                            <div class ="container">
                                <p class="copyright">&copy; University Student Carpooling Platform by Team-E.</p>
                                <a href="NewUserRegistration.jsp" class="btn btn-primary btn-block" role="button">Register Here</a>
                            </div>
                        </form>
                        <!-- Form end -->
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
