<%@page import="Model.Food"%>
<%@page import="Model.Order"%>
<%@page import="Model.OrderDetail"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!--[if IE 7 ]>    <html lang="en-gb" class="isie ie7 oldie no-js"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en-gb" class="isie ie8 oldie no-js"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en-gb" class="isie ie9 no-js"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<!--<![endif]-->
<!--<![endif]-->
<html lang="en">

<head>
  <title>Website Oder King's Fast Food</title>
  <meta charset="utf-8">
  <!-- Meta -->
  <meta name="keywords" content="" />
  <meta name="author" content="">
  <meta name="robots" content="" />
  <meta name="description" content="" />

  <!-- this styles only adds some repairs on idevices  -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Favicon -->
  <link rel="shortcut icon" href="./Homepage/images/logo.ico">

  <!-- Google fonts - witch you want to use - (rest you can just remove) -->
  <link
    href='https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic,700,700italic,800,800italic'
    rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto:100,200,300,400,500,600,700,800,900' rel='stylesheet'
    type='text/css'>
  <link href='https://www.google.com/fonts#UsePlace:use/Collection:Droid+Serif:400,400italic,700,700italic'
    rel='stylesheet' type='text/css'>
  <link
    href='https://www.google.com/fonts#UsePlace:use/Collection:Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic'
    rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Great+Vibes' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Old+Standard+TT:400,400italic,700' rel='stylesheet'
    type='text/css'>

  <!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

  <!-- Stylesheets -->
  <link rel="stylesheet" media="screen" href="./Homepage/js/bootstrap/bootstrap.min.css" type="text/css" />
  <link rel="stylesheet" href="./Homepage/js/mainmenu/menu.css" type="text/css" />
  <link rel="stylesheet" href="./Homepage/css/default.css" type="text/css"/>
  <link rel="stylesheet" href="./Homepage/css/layouts.css" type="text/css"/>
  <link rel="stylesheet" href="./Homepage/css/shortcodes.css" type="text/css" />
  <link rel="stylesheet" href="./Homepage/css/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" media="screen" href="./Homepage/css/responsive-leyouts.css" type="text/css" />
  <link rel="stylesheet" href="./Homepage/js/masterslider/style/masterslider.css"/>
  <link rel="stylesheet" type="text/css" href="./Homepage/css/Simple-Line-Icons-Webfont/simple-line-icons.css" media="screen" />
  <link rel="stylesheet" href="./Homepage/css/et-line-font/et-line-font.css">
  <link href="./Homepage/js/owl-carousel/owl.carousel.css" rel="stylesheet">
  <link rel="stylesheet" href="./Homepage/css/colors/yellow.css" />

</head>

<body>
  <div id="header">
    <div class="container" style="display: flex;">
      <div class="navbar yellow navbar-default red2 yamm">
        <div class="navbar-header">
          <button type="button" data-toggle="collapse" data-target="#navbar-collapse-grid" class="navbar-toggle"><span
              class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
          <a href="index.html" class="navbar-brand"><img src="./Homepage/images/Logo2.png" alt="" /></a>
        </div>
        <div id="navbar-collapse-grid" class="navbar-collapse collapse pull-right">
          <ul class="nav red2 navbar-nav">
            <li> <a href="home" class="dropdown-toggle active">Home</a></li>
            <li> <a href="about" class="dropdown-toggle">About</a></li>
            <li> <a href="menu" class="dropdown-toggle">Menu</a></li>
            <c:if test="${sessionScope.acc==null}">
                 <li><a href="login" class="dropdown-toggle">My Order</a></li>
            </c:if>
            <c:if test="${sessionScope.acc!=null}">
                 <li><a href="listOrder" class="dropdown-toggle">My Order</a></li>
            </c:if>

            <li> <a href="contact" class="dropdown-toggle">Contact</a></li>
            <span class="hideres">
              <a class="navbar-brand "><img src="./Homepage/images/Deliver.png" alt="" /></a>
              <li class="rightsec" style="width:150px;margin:0">
                <div>Call and Oder in</div>
                <strong style="color: #ffc222;font-size: 19px;font-weight: 900;">+84 905-999-999</strong>
              </li>
            </span>

            <span class="rightsec1">
              <span class="hideres2">
                <li class="rightsec rightsecphone "> <a class="icon1" href="tel:0905999999"><i class="fa fa-phone"
                      style="color:#000; font-size: 18px;"></i></a></li>
                </li>
              </span>
              <li class="rightsec "> <a class="icon1" href="${sessionScope.acc==null ? "login":"info"}"><i class="fa fa-user"
                    style="color:#000; font-size: 18px;"></i></a></li>
              <li class="rightsec "> <a class="icon3" href="cart"><i class="fa fa-shopping-cart"
                    style="color:#000; font-size: 18px;"></i></a>
                <span class="icon4">0</span>
              </li>
            </span>
            <!-- <li> <a href="\" style="border: 1px solid #ccc;padding: 12px 14px;margin-top: 18px;border-radius: 26px;margin-left: 12px;"><i class="fa fa-search" style="color:#000; font-size: 18px;"></i></a></li> -->
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!--end menu-->
  <div class="clearfix"></div>

  <!-- masterslider -->
  <div class="master-slider ms-skin-default" id="masterslider">

    <!-- slide 1 -->
    <div class="ms-slide slide-1" data-delay="9">
      <div class="slide-pattern"></div>
      <img style="opacity: 0.7;" src="./Homepage/js/masterslider/blank.gif"
        data-src="https://theme.hstatic.net/200000232135/1000682292/14/slideshow_1.jpg?v=274" alt="" />

      <h3 class="ms-layer text18" style="top: 200px; left:400px" data-type="text" data-delay="500"
        data-ease="easeOutExpo" data-duration="1230" data-effect="left(250)"> Fresh taste at a</h3>

      <h3 class="ms-layer text19" style="top: 260px;" data-type="text" data-delay="1000" data-ease="easeOutExpo"
        data-duration="1230" data-effect="right(250)"> great price</h3>

      <h3 class="ms-layer text6 text-white" style="top: 380px;" data-type="text" data-effect="top(45)"
        data-duration="2000" data-delay="1500" data-ease="easeOutExpo"> Lorem ipsum dolor sit amet consectetuer
        adipiscing elit Suspendisse et justo <br />
        Praesent mattis commodo augue Aliquam ornare. </h3>

      <a class="ms-layer sbut7" style="left: 750px; top: 470px;" data-type="text" data-delay="2000"
        data-ease="easeOutExpo" data-duration="1200" data-effect="scale(1.5,1.6)"> Book now </a>
    </div>
    <!-- end slide 1 -->


    <!-- slide 2 -->
    <div class="ms-slide slide-2" data-delay="9">
      <div class="slide-pattern"></div>
      <img style="opacity: 0.7;" src="./Homepage/js/masterslider/blank.gif"
        data-src="https://media.gq.com/photos/5b4fb4c9b3161f214d1a079e/64:25/w_1920,h_750,c_limit/fried-chicken-summer-gq.jpg"
        alt="" />

      <h3 class="ms-layer text18" style="top: 200px; left:400px" data-type="text" data-delay="500"
        data-ease="easeOutExpo" data-duration="1230" data-effect="left(250)"> Fresh taste at a</h3>

      <h3 class="ms-layer text19" style="top: 260px;" data-type="text" data-delay="1000" data-ease="easeOutExpo"
        data-duration="1230" data-effect="right(250)"> great price</h3>

      <h3 class="ms-layer text6 text-white" style="top: 380px;" data-type="text" data-effect="top(45)"
        data-duration="2000" data-delay="1500" data-ease="easeOutExpo"> Lorem ipsum dolor sit amet consectetuer
        adipiscing elit Suspendisse et justo <br />
        Praesent mattis commodo augue Aliquam ornare. </h3>

      <a class="ms-layer sbut7" style="left: 750px; top: 470px;" data-type="text" data-delay="2000"
        data-ease="easeOutExpo" data-duration="1200" data-effect="scale(1.5,1.6)"> Book now </a>

    </div>
    <!-- end slide 2 -->

    <!-- slide 3 -->
    <div class="ms-slide slide-3" data-delay="9">
      <div class="slide-pattern"></div>
      <img style="opacity: 0.7;" src="js/masterslider/blank.gif"
        data-src="https://images3.alphacoders.com/922/922680.jpg" alt="" />

      <h3 class="ms-layer text18" style="top: 200px; left:400px" data-type="text" data-delay="500"
        data-ease="easeOutExpo" data-duration="1230" data-effect="left(250)"> Fresh taste at a</h3>

      <h3 class="ms-layer text19" style="top: 260px;" data-type="text" data-delay="1000" data-ease="easeOutExpo"
        data-duration="1230" data-effect="right(250)"> great price</h3>

      <h3 class="ms-layer text6 text-white" style="top: 380px;" data-type="text" data-effect="top(45)"
        data-duration="2000" data-delay="1500" data-ease="easeOutExpo"> Lorem ipsum dolor sit amet consectetuer
        adipiscing elit Suspendisse et justo <br />
        Praesent mattis commodo augue Aliquam ornare. </h3>

      <a class="ms-layer sbut7" style="left: 750px; top: 470px;" data-type="text" data-delay="2000"
        data-ease="easeOutExpo" data-duration="1200" data-effect="scale(1.5,1.6)"> Book now </a>

    </div>
    <!-- end slide 3 -->

  </div>
  <!-- end of masterslider -->
  <div class="clearfix"></div>

  <section class="sec-padding">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="title-line-8 red2"></div>
          <h1 class="section-title-4 great-vibes text-center">Special Offers</h1>
          <p class="sub-title text-center">Lorem ipsum dolor sit amet consectetuer adipiscing.</p>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">aliquam rhoncus</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food1.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">Nullam turpis</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food2.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">Etiam dictum</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food3.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">venenatis quis</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->
      </div>
    </div>
  </section>
  <div class="clearfix"></div>

  <section class="parallax-section21">
    <div class="section-overlay bg-opacity-5">
      <div class="container sec-tpadding-3 sec-bpadding-3">
        <div class="row">
          <div class="col-md-8 col-centered">
            <div class="title-line-8 white"></div>
            <h1 class="section-title-4 great-vibes text-center text-white">Reservation</h1>
            <p class="text-white">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse et justo.
              Praesent mattis commodo augue. Aliquam ornare hendrerit augue. Cras tellus. In pulvinar lectus a est.
              Curabitur eget orci. Cras laoreet <br />
              consectetuer ligula. Etiam sit amet dolor. </p>
            <br />
            <br />
            <a class="btn btn-white btn-xround" href="#">Reserve</a>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--end section-->
  <div class="clearfix"></div>

  <section class="sec-padding">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <div class="feature-box32 bmargin">
            <div class="iconbox-large left grayoutline2 round"><span class="icon-screen-desktop"></span></div>
            <div class="text-box-right more-padding-3">
              <h4 class="uppercase old-standardtt">Order online</h4>
              <p>Lorem ipsum dolor sit amet, consectetuer elit justo.</p>
              <h6>Hours: 8AM - 11PM</h6>
              <br />
              <a class="btn btn-border light btn-small red-2" href="#">Order now</a>
            </div>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-4">
          <div class="feature-box32 bmargin">
            <div class="iconbox-large left grayoutline2 round"><span class="icon-present"></span></div>
            <div class="text-box-right more-padding-3">
              <h4 class="uppercase old-standardtt">Gift Cards</h4>
              <p>Lorem ipsum dolor sit amet, consectetuer elit justo.</p>
              <h6>Hours: 8AM - 11PM</h6>
              <br />
              <a class="btn btn-border light btn-small red-2" href="#">Order now</a>
            </div>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-4">
          <div class="feature-box32 bmargin">
            <div class="iconbox-large left grayoutline2 round"><span class="icon-globe-alt"></span></div>
            <div class="text-box-right more-padding-3">
              <h4 class="uppercase old-standardtt">free delivery</h4>
              <p>Lorem ipsum dolor sit amet, consectetuer elit justo.</p>
              <h6>on orders above $100</h6>
              <br />
              <a class="btn btn-border light btn-small red-2" href="#">Order now</a>
            </div>
          </div>
        </div>
        <!--end item-->

      </div>
    </div>
  </section>
  <!--end section-->
  <div class="clearfix"></div>

  <section>
    <div class="container">
      <div class="divider-line dashed light"></div>
      <div class="row sec-tpadding-2 sec-bpadding-2">
        <div class="col-xs-12">
          <div class="title-line-8 red2"></div>
          <h1 class="section-title-4 great-vibes text-center">Special Menu</h1>
          <p class="sub-title text-center">Lorem ipsum dolor sit amet consectetuer adipiscing.</p>
        </div>
        <div class="clearfix"></div>
        <div class="col-md-6 bmargin">
          <div class="image-holder"><img src="./Homepage/images/food/Food4.png" alt="" class="img-responsive" /></div>
        </div>
        <!--end item-->

        <div class="col-md-3 text-center bmargin">
          <h5 class="old-standardtt uppercase less-mar1">Etiam dictum Nunc enim</h5>
          <h5 class="text-gray">$19.99</h5>
          <div class="divider-line dashed light"></div>
          <br />
          <h5 class="old-standardtt uppercase less-mar1">venenatis suscipit </h5>
          <h5 class="text-gray">$32.99</h5>
          <div class="divider-line dashed light"></div>
          <br />
          <h5 class="old-standardtt uppercase less-mar1">magna tempus urna</h5>
          <h5 class="text-gray">$45.99</h5>
        </div>
        <!--end item-->

        <div class="col-md-3 text-center bmargin">
          <h5 class="old-standardtt uppercase less-mar1">Aliquam ornare </h5>
          <h5 class="text-gray">$22.99</h5>
          <div class="divider-line dashed light"></div>
          <br />
          <h5 class="old-standardtt uppercase less-mar1">Pellentesque aliquet</h5>
          <h5 class="text-gray">$18.99</h5>
          <div class="divider-line dashed light"></div>
          <br />
          <h5 class="old-standardtt uppercase less-mar1">Donec pretium felis</h5>
          <h5 class="text-gray">$15.99</h5>
        </div>
        <!--end item-->

      </div>
    </div>
  </section>
  <!--end section-->
  <div class="clearfix"></div>

  <section class="parallax-section22">
    <div class="section-overlay bg-opacity-5">
      <div class="container sec-tpadding-3 sec-bpadding-3">
        <div class="row">
          <div class="col-md-8 col-centered">
            <div class="title-line-8 white"></div>
            <h1 class="section-title-4 great-vibes text-center text-white">Customer Review</h1>
            <div class="text-left"><img src="./Homepage/images/197.png" alt="" /></div>
            <br />
            <p class="text-white">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse et justo.
              Praesent mattis commodo augue. Aliquam ornare hendrerit augue. Cras tellus. In pulvinar lectus a est.
              Curabitur eget orci. Cras laoreet <br />
              consectetuer ligula. Etiam sit amet dolor. </p>
            <div class="text-right"><img src="./Homepage/images/198.png" alt="" /></div>
            <div class="iconbox-medium round overflow-hidden"><img src="./Homepage/images/chef.jpg" alt="" /></div>
            <h6 class="text-white less-mar1">John Doe, Chef cook</h6>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--end section-->
  <div class="clearfix"></div>

  <section class="sec-padding">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="title-line-8 red2"></div>
          <h1 class="section-title-4 great-vibes text-center">Featured</h1>
          <p class="sub-title text-center">Lorem ipsum dolor sit amet consectetuer adipiscing.</p>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food5.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">aliquam rhoncus</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food6.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">Nullam turpis</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food7.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">Etiam dictum</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-3 col-sm-6">
          <div class="feature-box31 text-center bmargin">
            <div class="image-holder">
              <div class="price">$29.9</div>
              <img src="./Homepage/images/food/Food8.png" alt="" class="img-responsive" />
            </div>
            <div class="divider-line solid margin light"></div>
            <div class="clearfix"></div>
            <br />
            <h4 class="old-standardtt uppercase">venenatis quis</h4>
            <p>Lorem ipsum dolor sit amet sit et justo consectetuer adipiscing elit sit justo. Suspendisse et justo.
            </p>
            <br />
            <a class="btn btn-border light red-2" href="#">Order now</a>
          </div>
        </div>
        <!--end item-->
      </div>
    </div>
  </section>
  <div class="clearfix"></div>

  <section class="parallax-section23">
    <div class="section-overlay bg-opacity-5">
      <div class="container sec-tpadding-3 sec-bpadding-3">
        <div class="row">
          <div class="col-xs-12">
            <div class="title-line-8 red2"></div>
            <h1 class="section-title-4 great-vibes text-center text-white">News & Events</h1>
            <p class="sub-title text-center text-white">Lorem ipsum dolor sit amet consectetuer adipiscing.</p>
          </div>
          <div class="clearfix"></div>
          <div id="owl-demo2" class="owl-carousel">
            <div class="item">
              <div class="col-md-6 bmargin">
                <div class="feature-box33 bmargin">
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="image-holder">
                      <div class="post-date-box"> 25 <span>May, 2020</span> </div>
                      <img src="./Homepage/images/food/Food9.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="text-box-inner text-left">
                      <h4 class="old-standardtt uppercase"><a href="#">Vestibulum</a></h4>
                      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse et </p>
                      <p>Lorem ipsum dolor sit amet, consectetuer</p>
                      <br />
                      <a class="read-more" href="#"><i class="fa fa-long-arrow-right"></i> Read more</a>
                    </div>
                  </div>
                </div>
                <div class="divider-line solid red2 top-padding"></div>
              </div>
              <!--end item-->

              <div class="col-md-6 bmargin">
                <div class="feature-box33 bmargin">
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="image-holder">
                      <div class="post-date-box"> 25 <span>May, 2020</span> </div>
                      <img src="./Homepage/images/food/Food10.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="text-box-inner text-left">
                      <h4 class="old-standardtt uppercase"><a href="#">Donec libero</a></h4>
                      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse et </p>
                      <p>Lorem ipsum dolor sit amet, consectetuer</p>
                      <br />
                      <a class="read-more" href="#"><i class="fa fa-long-arrow-right"></i> Read more</a>
                    </div>
                  </div>
                </div>
                <div class="divider-line solid red2 top-padding"></div>
              </div>
              <!--end item-->

            </div>
            <!--end slider item-->

            <div class="item">
              <div class="col-md-6 bmargin">
                <div class="feature-box33 bmargin">
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="image-holder">
                      <div class="post-date-box"> 25 <span>May, 2020</span> </div>
                      <img src="./Homepage/images/food/Food11.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="text-box-inner text-left">
                      <h4 class="old-standardtt uppercase"><a href="#">Vestibulum</a></h4>
                      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse et </p>
                      <p>Lorem ipsum dolor sit amet, consectetuer</p>
                      <br />
                      <a class="read-more" href="#"><i class="fa fa-long-arrow-right"></i> Read more</a>
                    </div>
                  </div>
                </div>
                <div class="divider-line solid red2 top-padding"></div>
              </div>
              <!--end item-->

              <div class="col-md-6 bmargin">
                <div class="feature-box33 bmargin">
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="image-holder">
                      <div class="post-date-box"> 25 <span>May, 2020</span> </div>
                      <img src="./Homepage/images/food/Food12.png" class="img-responsive" alt="" />
                    </div>
                  </div>
                  <div class="col-md-6 col-sm-6 nopadding">
                    <div class="text-box-inner text-left">
                      <h4 class="old-standardtt uppercase"><a href="#">Donec libero</a></h4>
                      <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse et </p>
                      <p>Lorem ipsum dolor sit amet, consectetuer</p>
                      <br />
                      <a class="read-more" href="#"><i class="fa fa-long-arrow-right"></i> Read more</a>
                    </div>
                  </div>
                </div>
                <div class="divider-line solid red2 top-padding"></div>
              </div>
              <!--end item-->
              <div class="clearfix"></div>
              <br />
              <br />
            </div>
            <!--end slider item-->

          </div>
        </div>
      </div>
    </div>
  </section>
  <!--end section-->
  <div class="clearfix"></div>

  <section class="section-light sec-padding">
    <div class="container ">
      <div class="row">
        <div class="col-md-3 clearfix">
          <div class="footer-logo"><img src="./Homepage/images/Logo3.png" alt="" /></div>
          <ul class="address-info-2">
            <li>Address: No.28 - 63739 street lorem ipsum City, Country</li>
            <li><i class="fa fa-phone"></i> Phone: + 1 (234) 567 8901</li>
            <li><i class="fa fa-fax"></i> Fax: + 1 (234) 567 8901</li>
            <li><i class="fa fa-envelope"></i> Email: support@yoursite.com </li>
            <li class="last"><i class="fa fa-envelope"></i> Email: support@yoursite.com </li>
          </ul>
        </div>
        <!--end item-->

        <div class="col-md-3 clearfix">
          <div class="item-holder">
            <h4 class="uppercase less-mar3 old-standardtt">Recent Posts</h4>
            <div class="footer-title-bottomstrip dark"></div>
            <div class="clearfix"></div>
            <div class="image-left"><img src="./Homepage/images/food/Food13.png" alt="" class="img-responsive" /></div>
            <div class="text-box-right">
              <h5 class="less-mar3 nopadding"><a href="#">Clean And Modern</a></h5>
              <p>Lorem ipsum dolor sit</p>
              <div class="footer-post-info"> <span>By John Doe</span><span> May 20</span> </div>
            </div>
            <div class="divider-line solid light margin"></div>
            <div class="image-left"><img src="./Homepage/images/food/Food14.png" alt="" /></div>
            <div class="text-box-right">
              <h5 class="less-mar3"><a href="#">Layered PSD Files</a></h5>
              <p>Lorem ipsum dolor sit</p>
              <div class="footer-post-info"> <span>By John Doe</span><span> May 20</span> </div>
            </div>
          </div>
        </div>
        <!--end item-->

        <div class="col-md-3 clearfix">
          <h4 class="uppercase less-mar3 old-standardtt">our specials</h4>
          <div class="clearfix"></div>
          <div class="footer-title-bottomstrip dark"></div>
          <ul class="usefull-links-2">
            <li><a href="#"><i class="fa fa-angle-right"></i> Placerat bibendum</a></li>
            <li><a href="#"><i class="fa fa-angle-right"></i> Ullamcorper odio nec turpis</a></li>
            <li><a href="#"><i class="fa fa-angle-right"></i> Aliquam porttitor vestibulum ipsum</a></li>
            <li><a href="#"><i class="fa fa-angle-right"></i> Lobortis enim nec nisi</a></li>
            <li class="last"><a href="#"><i class="fa fa-angle-right"></i> Placerat bibendum</a></li>
          </ul>
        </div>
        <!--end item-->

        <div class="col-md-3 clearfix">
          <h4 class="uppercase less-mar3 old-standardtt">weekly events</h4>
          <div class="clearfix"></div>
          <div class="footer-title-bottomstrip dark"></div>
          <ul class="usefull-links-2">
            <li><a href="#"><i class="fa fa-angle-right"></i> Placerat bibendum</a></li>
            <li><a href="#"><i class="fa fa-angle-right"></i> Ullamcorper odio nec turpis</a></li>
            <li><a href="#"><i class="fa fa-angle-right"></i> Aliquam porttitor vestibulum ipsum</a></li>
            <li><a href="#"><i class="fa fa-angle-right"></i> Lobortis enim nec nisi</a></li>
            <li class="last"><a href="#"><i class="fa fa-angle-right"></i> Placerat bibendum</a></li>
          </ul>
        </div>
        <!--end item-->

      </div>
    </div>
  </section>
  <!--end section-->
  <div class="clearfix"></div>

  <section class="section-copyrights sec-moreless-padding">
    <div class="container">
      <div class="row">
        <div class="col-md-12"> <span>Copyright 2022 by team King's Fast Food</a> | All rights reserved.</span></div>
      </div>
    </div>
  </section>
  <!--end section-->
  <div class="clearfix"></div>

  <a href="#" class="scrollup red2"></a><!-- end scroll to top of the page-->
  </div>
  <!-- end site wraper -->


  <!-- ============ JS FILES ============ -->
  <script type="text/javascript" src="./Homepage/js/universal/jquery.js"></script>
  <script src="./Homepage/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
  <script src="./Homepage/js/masterslider/jquery.easing.min.js"></script>
  <script src="./Homepage/js/masterslider/masterslider.min.js"></script>
  <script type="text/javascript">
    (function ($) {
      "use strict";
      var slider = new MasterSlider();
      // adds Arrows navigation control to the slider.
      slider.control('arrows');
      slider.control('bullets');

      slider.setup('masterslider', {
        width: 1600,    // slider standard width
        height: 750,   // slider standard height
        space: 0,
        speed: 45,
        layout: 'fullwidth',
        loop: true,
        preload: 0,
        autoplay: true,
        view: "parallaxMask"
      });

    })(jQuery);
  </script>
  <script src="./Homepage/js/mainmenu/customeUI.js"></script>
  <script src="./Homepage/js/mainmenu/jquery.sticky.js"></script>
  <script src="./Homepage/js/owl-carousel/owl.carousel.js"></script>
  <script src="./Homepage/js/owl-carousel/custom.js"></script>
  <script src="./Homepage/js/scrolltotop/totop.js"></script>
  <script src="./Homepage/js/scripts/functions.js" type="text/javascript"></script>
</body>
</html>