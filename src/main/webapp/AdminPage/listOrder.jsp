<%@page import="Model.Personnel"%>
<%@page import="Model.Food"%>
<%@page import="Model.OrderDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAO"%>
<!DOCTYPE html>
<html class="loading dark-layout" lang="en" data-layout="dark-layout" data-textdirection="ltr">
<!-- BEGIN: Head-->

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimal-ui">
    <meta name="description" content="Vuexy admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, Vuexy admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>Admin King's Fast Food Page</title>
    <link rel="apple-touch-icon" href="./AdminPage/app-assets/images/ico/apple-icon-120.png">
    <link rel="shortcut icon" type="image/x-icon" href="./AdminPage/app-assets/images/ico/favicon.ico">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;1,400;1,500;1,600" rel="stylesheet">

    <!-- BEGIN: Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/vendors/css/vendors.min.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/vendors/css/tables/datatable/responsive.bootstrap.min.css">
    <!-- END: Vendor CSS-->

    <!-- BEGIN: Theme CSS-->
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/bootstrap-extended.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/colors.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/components.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/themes/dark-layout.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/themes/bordered-layout.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/themes/semi-dark-layout.css">

    <!-- BEGIN: Page CSS-->
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="./AdminPage/app-assets/css/pages/app-invoice-list.css">
    <!-- END: Page CSS-->

    <!-- BEGIN: Custom CSS-->
    <link rel="stylesheet" type="text/css" href="./AdminPage/assets/css/style.css">
    <!-- END: Custom CSS-->

</head>
<!-- END: Head-->

<!-- BEGIN: Body-->

<body class="vertical-layout vertical-menu-modern  navbar-floating footer-static  " data-open="click" data-menu="vertical-menu-modern" data-col="">

    <!-- BEGIN: Header-->
    <nav class="header-navbar navbar navbar-expand-lg align-items-center floating-nav navbar-dark navbar-shadow container-xxl">
        <div class="navbar-container d-flex content">
            <div class="bookmark-wrapper d-flex align-items-center">
                <ul class="nav navbar-nav d-xl-none">
                    <li class="nav-item"><a class="nav-link menu-toggle" href="javascript:void(0);"><i class="ficon" data-feather="menu"></i></a></li>
                </ul>
            </div>
            <ul class="nav navbar-nav align-items-center ml-auto">
                <li class="nav-item d-none d-lg-block"><a class="nav-link nav-link-style"><i class="ficon" data-feather="sun"></i></a></li>
                <li class="nav-item dropdown dropdown-user"><a class="nav-link dropdown-toggle dropdown-user-link" id="dropdown-user" href="javascript:void(0);" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <div class="user-nav d-sm-flex d-none"><span class="user-name font-weight-bolder">${sessionScope.acc.personnelName}</span><span class="user-status">Admin</span></div><span class="avatar"><img class="round" src="${sessionScope.acc.personnelImageUrl}" alt="avatar" height="40" width="40"><span class="avatar-status-online"></span></span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown-user"><a class="dropdown-item" href="updatePasswordAdmin"><i class="mr-50" data-feather="user"></i> Settings</a><a class="dropdown-item" href="/Homepage/index.html"><i class="mr-50" data-feather="user"></i> Home</a>
                        <div class="dropdown-divider"></div><a class="dropdown-item" href="logout"><i class="mr-50" data-feather="power"></i> Logout</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <!-- END: Header-->


    <!-- BEGIN: Main Menu-->
    <div class="main-menu menu-fixed menu-dark menu-accordion menu-shadow" data-scroll-to-active="true">
        <div class="navbar-header">
            <ul class="nav navbar-nav flex-row">
                <li class="nav-item mr-auto"><a class="navbar-brand" href="HomeAdminServlet"><span class="brand-logo">
                            <svg viewbox="0 0 139 95" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" height="24">
                                <defs>
                                    <lineargradient id="linearGradient-1" x1="100%" y1="10.5120544%" x2="50%" y2="89.4879456%">
                                        <stop stop-color="#000000" offset="0%"></stop>
                                        <stop stop-color="#FFFFFF" offset="100%"></stop>
                                    </lineargradient>
                                    <lineargradient id="linearGradient-2" x1="64.0437835%" y1="46.3276743%" x2="37.373316%" y2="100%">
                                        <stop stop-color="#EEEEEE" stop-opacity="0" offset="0%"></stop>
                                        <stop stop-color="#FFFFFF" offset="100%"></stop>
                                    </lineargradient>
                                </defs>
                                <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                    <g id="Artboard" transform="translate(-400.000000, -178.000000)">
                                        <g id="Group" transform="translate(400.000000, 178.000000)">
                                            <path class="text-primary" id="Path" d="M-5.68434189e-14,2.84217094e-14 L39.1816085,2.84217094e-14 L69.3453773,32.2519224 L101.428699,2.84217094e-14 L138.784583,2.84217094e-14 L138.784199,29.8015838 C137.958931,37.3510206 135.784352,42.5567762 132.260463,45.4188507 C128.736573,48.2809251 112.33867,64.5239941 83.0667527,94.1480575 L56.2750821,94.1480575 L6.71554594,44.4188507 C2.46876683,39.9813776 0.345377275,35.1089553 0.345377275,29.8015838 C0.345377275,24.4942122 0.230251516,14.560351 -5.68434189e-14,2.84217094e-14 Z" style="fill:currentColor"></path>
                                            <path id="Path1" d="M69.3453773,32.2519224 L101.428699,1.42108547e-14 L138.784583,1.42108547e-14 L138.784199,29.8015838 C137.958931,37.3510206 135.784352,42.5567762 132.260463,45.4188507 C128.736573,48.2809251 112.33867,64.5239941 83.0667527,94.1480575 L56.2750821,94.1480575 L32.8435758,70.5039241 L69.3453773,32.2519224 Z" fill="url(#linearGradient-1)" opacity="0.2"></path>
                                            <polygon id="Path-2" fill="#000000" opacity="0.049999997" points="69.3922914 32.4202615 32.8435758 70.5039241 54.0490008 16.1851325"></polygon>
                                            <polygon id="Path-21" fill="#000000" opacity="0.099999994" points="69.3922914 32.4202615 32.8435758 70.5039241 58.3683556 20.7402338"></polygon>
                                            <polygon id="Path-3" fill="url(#linearGradient-2)" opacity="0.099999994" points="101.428699 0 83.0667527 94.1480575 130.378721 47.0740288"></polygon>
                                        </g>
                                    </g>
                                </g>
                            </svg></span>
                        <h2 class="brand-text">Admin Page</h2>
                    </a></li>
                <li class="nav-item nav-toggle"><a class="nav-link modern-nav-toggle pr-0" data-toggle="collapse"><i class="d-block d-xl-none text-primary toggle-icon font-medium-4" data-feather="x"></i><i class="d-none d-xl-block collapse-toggle-icon font-medium-4  text-primary" data-feather="disc" data-ticon="disc"></i></a></li>
            </ul>
        </div>
        <div class="shadow-bottom"></div>
       <div class="main-menu-content">
                <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
                    <li class=" nav-item"><a class="d-flex align-items-center" href="HomeAdminServlet"><i data-feather="home"></i><span class="menu-title text-truncate" data-i18n="Dashboards">Dashboards</span><span class="badge badge-light-warning badge-pill ml-auto mr-1"></span></a>
                    </li>
                    <li class="nav-item"><a class="d-flex align-items-center" href="listFood"><i data-feather="shopping-cart"></i><span class="menu-item text-truncate" data-i18n="List">List Food</span></a>
                    </li>
                    <li class=" nav-item"><a class="d-flex align-items-center" href="listStaff"><i data-feather="user"></i><span class="menu-title text-truncate" data-i18n="User">List Staff</span></a>
                    </li>
                    <li class=" nav-item"><a class="d-flex align-items-center" href="listMember"><i data-feather="user"></i><span class="menu-title text-truncate" data-i18n="User">List Member</span></a>
                    </li>
                    <li class="active nav-item"><a class="d-flex align-items-center" href="listOrderAdmin"><i data-feather="check-square"></i><span class="menu-title text-truncate" data-i18n="User">List Order</span></a>
                    </li>
                    <li class=" nav-item"><a class="d-flex align-items-center" href="updatePasswordAdmin"><i data-feather="settings"></i><span class="menu-item text-truncate" data-i18n="Account Settings">Account Settings</span></a>
                    </li>
                </ul>
            </div>
    </div>
    <!-- END: Main Menu-->

    <!-- BEGIN: Content-->
   <div class="app-content content ">
        <div class="content-overlay"></div>
        <div class="header-navbar-shadow"></div>
        <div class="content-wrapper container-xxl p-0">
            <div class="content-header row">
            </div>
            <div class="content-body">
                <!-- users list start -->
                <div class="row" id="basic-table">
                    <div class="col-12">
                        <div class="card">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Order ID</th>
                                            <th>List</th>
                                            <th>Total</th>
                                            <th>Time</th>
                                            <th>Status</th>
                                            <th>Name</th>
                                            <th>Payment</th>
                                            <th>Active</th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${aAllOrder}" var="o">
                                        <tr>
                                            <td>
                                                <span class="font-weight-bold">${o.getOrderID()}</span>
                                            </td>
                                            <td>
                                                <div class="d-flex flex-column">
                                                    <% 
                                                        DAO dao = new DAO();
                                                        List<OrderDetail> listDetail = dao.getAllOrderDetails();
                                                        request.setAttribute("ORDERDETAIL", listDetail);
                                                    %>
                                                    <c:forEach items="${ORDERDETAIL}" var = "d">
                                                        <c:if test="${d.getOrderID()==o.getOrderID()}">
                                                            <% 
                                                                List<Food> listFood = dao.getAllFoods();
                                                                request.setAttribute("FOODLIST", listFood);
                                                            %>
                                                            <c:forEach items="${FOODLIST}" var = "f">
                                                                <c:if test="${f.getFoodID() == d.getFoodID()}">
                                                                <span class="font-weight-bold">${f.getFoodName()} x ${d.getQuantity()}</span>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:if>
                                                        
                                                    </c:forEach>
                                                                                                           
                                                </div>
                                            </td>
                                            <td>
                                                <span class="font-weight-bold">${o.getTotal()}</span>
                                            </td>
                                            <td>
                                                <div class="d-flex flex-column">
                                                    <span class="font-weight-bold">${o.getOrderDate()}</span>
<!--                                                    <span>13:05</span>-->
                                                </div>
                                            </td>
                                            <td>
                                                <c:if test="${o.getOrderStatus()==0}">
                                                    <span class="badge badge-pill badge-light-warning" text-capitalized="">Delivery</span>
                                                </c:if>
                                                    <c:if test="${o.getOrderStatus()==1}">
                                                    <span class="badge badge-pill badge-light-success" text-capitalized="">Success</span>
                                                </c:if>
                                                    <c:if test="${o.getOrderStatus()==2}">
                                                    <span class="badge badge-pill badge-light-danger" text-capitalized="">Canceled</span>
                                                </c:if>
                                                    
                                            </td>
                                            <% 
                                                List<Personnel> listPersonnel = dao.getAllPersonnel();
                                                request.setAttribute("PERSONNELLIST", listPersonnel);
                                            %>
                                            <c:forEach items="${PERSONNELLIST}" var="p">
                                                <c:if test="${o.getID() == p.getPersonnelID()}">
                                                    <td>${p.getPersonnelName()}</td>
                                                </c:if>
                                            </c:forEach>
                                                    
                                                    <td>
                                                        <c:if test="${o.isPayment()==true}">
                                                      <span class="font-weight-bold">VNPay</span>
                                                        </c:if>
                                                        <c:if test="${o.isPayment()==false}">
                                                      <span class="font-weight-bold">Cash</span>
                                                        </c:if>
                                                    </td>        
                                            <td>
                                                <c:if test="${o.isIsActive()==true}">
                                                <div class="badge badge-glow badge-success" style="padding: 4px 12px;">active</div>
                                                </c:if>
                                                <c:if test="${o.isIsActive()==false}">
                                                <div class="badge badge-glow badge-danger" style="padding: 4px 12px;">inactive</div>
                                                </c:if>
                                            </td>
                                            <td>
                                                <div class="dropdown">
                                                    <button type="button" class="btn btn-sm dropdown-toggle hide-arrow" data-toggle="dropdown">
                                                        <i data-feather="more-vertical"></i>
                                                    </button>
                                                    <div class="dropdown-menu">
                                                        <a class="dropdown-item" href="viewDetailAdmin?orderid=${o.getOrderID()}">
                                                            <i data-feather="edit-2" class="mr-50"></i>
                                                            <span>Edit</span>
                                                        </a>
                                                        <a class="dropdown-item" href="DeleteOrderServlet?ORDERID=${o.getOrderID()}&username=${sessionScope.acc.personnelUsername}">
                                                            <i data-feather="trash" class="mr-50"></i>
                                                            <span>Delete</span>
                                                        </a>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>  
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END: Content-->

    <div class="sidenav-overlay"></div>
    <div class="drag-target"></div>

    <!-- BEGIN: Footer-->
    <footer class="footer footer-static footer-light">
        <p class="clearfix mb-0"><span class="float-md-right d-none d-md-block">Hand-crafted & Made with<i data-feather="heart"></i></span></p>
    </footer>
    <button class="btn btn-primary btn-icon scroll-top" type="button"><i data-feather="arrow-up"></i></button>
    <!-- END: Footer-->


    <!-- BEGIN: Vendor JS-->
    <script src="./AdminPage/app-assets/vendors/js/vendors.min.js"></script>
    <!-- BEGIN Vendor JS-->

    <!-- BEGIN: Page Vendor JS-->
    <script src="./AdminPage/app-assets/vendors/js/extensions/moment.min.js"></script>
    <script src="./AdminPage/app-assets/vendors/js/tables/datatable/jquery.dataTables.min.js"></script>
    <script src="./AdminPage/app-assets/vendors/js/tables/datatable/datatables.buttons.min.js"></script>
    <script src="./AdminPage/app-assets/vendors/js/tables/datatable/datatables.bootstrap4.min.js"></script>
    <script src="./AdminPage/app-assets/vendors/js/tables/datatable/dataTables.responsive.min.js"></script>
    <script src="./AdminPage/app-assets/vendors/js/tables/datatable/responsive.bootstrap4.min.js"></script>
    <!-- END: Page Vendor JS-->

    <!-- BEGIN: Theme JS-->
    <script src="./AdminPage/app-assets/js/core/app-menu.js"></script>
    <script src="./AdminPage/app-assets/js/core/app.js"></script>
    <!-- END: Theme JS-->

    <!-- BEGIN: Page JS-->
    <script src="./AdminPage/app-assets/js/scripts/pages/app-invoice-list.js"></script>
    <!-- END: Page JS-->

    <script>
        $(window).on('load', function() {
            if (feather) {
                feather.replace({
                    width: 14,
                    height: 14
                });
            }
        })
    </script>
</body>
<!-- END: Body-->

</html>