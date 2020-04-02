<%-- 
    Document   : newUserRegistration
    Created on : Apr 1, 2020, 9:11:50 PM
    Author     : Tasli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script type ="text/javascript">
            function validate() {
                var fname = document.forms.registerform.fname.value;
                var lname = document.forms.registerform.lname.value;
                var email = document.forms.registerform.email.value;
                var pwd = document.forms.registerform.pwd.value;
                var mobilenumber = document.forms.registerform.mobilenumber.value;

                if (email == null || email == "" || pwd == null || pwd == "" || fname == null || fname == "" || lname == null || lname == "") {
                    alert("Please input Username, Password, First and Last name");
                    return false;
                }
                if (mobilenumber.length != 10) {
                    alert("Please enter Mobile number correctly");
                    return false;
                }
                if (!(/@aus.edu\s*$/.test(email))) {
                    alert("You can only register with your AUS account");
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
                        <form name = "registerform" action="RegisterController" method="post" class="justify-content-center">
                            <h1>New User Registration</h1>
                            <div class="form-group">
                                <label for="fname">First Name:</label>
                                <input type="text" class="form-control" id="fname" placeholder="Enter First Name" name="fname">
                            </div>
                            <div class="form-group">
                                <label for="lname">Last Name:</label>
                                <input type="text" class="form-control" id="lname" placeholder="Enter Last Name" name="lname">
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
                            </div>
                            <div class="form-group">
                                <label for="mobilenumber">Mobile Number:</label>
                                <input type="text" class="form-control" id="mobilenumber" placeholder="05XXXXXXXX" name="mobilenumber">
                            </div>
                            <div>
                                <label for="sel1">Select Gender:</label>
                                <select class="form-control" id="gender" name="gender">
                                    <option>M</option>
                                    <option>F</option>
                                </select>
                            </div>
                             <h1>  </h1>
                            <button type="submit" onClick="return validate();" class="btn btn-success btn-lg">Submit</button>
                            <div class ="container">
                                <p class="copyright">&copy; University Student Carpooling Platform by Team-E.</p>  
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
