<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>King's Fast Food</title>
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="./Homepage/images/logo.ico" />
    <!-- Icons font CSS-->
    <link href="./Register/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="./Register/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link
        href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="./Register/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="./Register/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="./Register/css/main.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Update Information Form</h2>
                    <form method="POST" action="">
                        <input type="hidden" name="id" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelID):(sessionScope.acc.customerID)}">
                        <input type="hidden" name="username" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelUsername):(sessionScope.acc.customerUsername)}">
                        <input type="hidden" name="password" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelPassword):(sessionScope.acc.customerPassword)}">
                        <div class="row row-space">
                            <div class="col">
                                <div class="input-group">
                                    <label class="label">Full Name</label>
                                    <input class="input--style-4" type="text" name="name" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelName):(sessionScope.acc.customerName)}">
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Birthday</label>
                                    <div class="input-group-icon">
                                        <input class="input--style-4 js-datepicker" type="text" name="dob" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelDateOfBirth):(sessionScope.acc.customerBirthday)}">
                                        <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Phone Number</label>
                                    <input class="input--style-4" type="text" name="phone" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelPhone):(sessionScope.acc.customerPhone)}">
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col">
                                <div class="input-group">
                                    <label class="label">Email</label>
                                    <input class="input--style-4" type="email" name="email" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelEmail):(sessionScope.acc.customerEmail)}">
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col">
                                <div class="input-group">
                                    <label class="label">Address</label>
                                    <input class="input--style-4" type="text" name="address" value="${sessionScope.acc.isStaff() ? (sessionScope.acc.personnelAddress):(sessionScope.acc.customerAddress)}">
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="p-t-15">
                                <button class="btn btn--radius-2 btn--blue" type="submit">Submit</button>
                            </div>
                            <div class="p-t-15">
                                <a class="btn btn--radius-2 btn--green" style="text-decoration: none;" href="info">Cancel</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="./Register/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="./Register/vendor/select2/select2.min.js"></script>
    <script src="./Register/vendor/datepicker/moment.min.js"></script>
    <script src="./Register/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="./Register/js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->