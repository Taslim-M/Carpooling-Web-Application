<%-- 
    Document   : RegisterAsDriver
    Created on : Apr 3, 2020, 4:38:39 PM
    Author     : Tasli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register As Driver</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script type ="text/javascript">
            function validateReg() {
                var carModel = document.forms.registerDriverForm.carModel.value;
                var capacity = document.forms.registerDriverForm.capacity.value;

                var EID = document.getElementById('EID');
                var carReg = document.getElementById('carReg');
                var license = document.getElementById('license');

                if (carModel == null || carModel == "" || EID.files.length == 0 || carReg.files.length == 0 || license.files.length == 0) {
                    alert("Please input all fields");
                    return false;
                }
                if (!EID.files[0].name.match(/.(jpg|jpeg|png)$/i)) {
                    alert('Please upload EID as jpg, jpeg or png Image');
                    return false;
                }

                if (!carReg.files[0].name.match(/.(jpg|jpeg|png)$/i)) {
                    alert('Please upload Car Registration jpg, jpeg or png Image');
                    return false;
                }

                if (!license.files[0].name.match(/.(jpg|jpeg|png)$/i)) {
                    alert('Please upload License as jpg, jpeg or png Image');
                    return false;
                }

                return true;
            }
        </script>
    </head>
    <body class="h-100">
        <c:if test="${empty sessionScope.driver}" >
            <jsp:include page="navbarPassenger.html"/>
        </c:if> 
        <c:if test="${! empty sessionScope.driver}" >
            <jsp:include page="navbar.html"/>
        </c:if> 
        <div class ="container h-100">
            <form name = "registerDriverForm" action="RegisterDriverController" method="post" class="justify-content-center" enctype="multipart/form-data">
                <h1>Register As Driver</h1>
                <h2> ${errmsg} </h2>
                <div class="form-group">
                    <label for="carModel">Car Model:</label>
                    <input type="text" class="form-control" id="carModel" placeholder="Nissan Pathfinder.." name="carModel">
                </div>

                <div class="form-group">
                    <label for="capacity">Select Passenger Capacity</label>
                    <select class="form-control" id="capacity" name="capacity">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                    </select>
                </div>

                <div class="file-field">
                    <div class="btn btn-unique btn-sm float-left">
                        <span>Choose Emirates ID Image file</span>
                        <input type="file" id="EID" name="EID">
                    </div>
                </div>

                <div class="file-field">
                    <div class="btn btn-unique btn-sm float-left">
                        <span>Choose License Image file</span>
                        <input type="file" id="license" name="license">
                    </div>
                </div>
                <div class="file-field">
                    <div class="btn btn-unique btn-sm float-left">
                        <span>Choose License Image file</span>
                        <input type="file" id="carReg" name="carReg">
                    </div>
                </div>
                <h1>  </h1>
                <button type="submit" onClick="return validateReg();" class="btn btn-success btn-lg">Submit</button>
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

</body>
</html>
