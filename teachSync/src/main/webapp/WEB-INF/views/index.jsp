<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap-5.3.0/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/style.css">

    <script src="../../resources/js/jquery/jquery-3.6.3.js"></script>
    <script src="../../resources/js/bootstrap-5.3.0/bootstrap.js"></script>
</head>
<body class="container-fluid bg-white-sub">
    <!-- ================================================== Header ===================================================== -->
    <div class="row bg-white sticky-top border-bottom border-primary mb-3">
        <!-- Logo -->
        <div class="col-1 d-flex align-items-center p-0"> 
            <a href="/" class="text-center w-100">
                <img src="../../resources/img/Logo.png" alt="logo" class="w-50 h-auto rounded-circle border border-primary mx-auto">
            </a>
        </div>

        <!-- Menu -->
        <div class="col-11 txt-normal">
            <div class="row row-cols-md-2 row-cols-sm-1 d-flex align-items-center h-100">
                <!-- Home, Course, Promotion/Class -->
                <div class="col">
                    <div class="row row-cols-3">
                        <div class="col border-start border-primary border-end border-primary ">
                            <a href="/" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-house-door"></i>
                                &nbsp; Home
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="course" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-book"></i>
                                &nbsp; Course
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <c:choose>
                                <c:when test="${user ne null}">
                                    <a href="class" class="text-decoration-none txt-black txt-hover-blue">
                                        <i class="bi-calendar-week"></i>
                                        &nbsp; Class
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="promotion" class="text-decoration-none txt-black txt-hover-blue">
                                        <i class="bi-tags"></i>
                                        &nbsp; Promotion
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>

                <!-- Material, News, Login/Account -->
                <div class="col">
                    <div class="row row-cols-3">
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="material" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-box-seam"></i>
                                &nbsp; Material
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="news" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-file-text"></i>
                                &nbsp; News
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <c:choose>
                                <c:when test="${user ne null}">
                                    <a href="account" class="text-decoration-none txt-black txt-hover-blue">
                                        <i class="bi-person"></i>
                                        <%--TODO: Replace with avatar, dropdown option--%>
                                        &nbsp; <c:out value="${user.username}"/>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="login" class="text-decoration-none txt-black txt-hover-blue">
                                        <i class="bi-person"></i>
                                        &nbsp; Login
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ================================================== Header ===================================================== -->



    <!-- ================================================== Breadcrumb ================================================= -->
    <div class="row bg-white border border-primary rounded-3 mx-2 mb-3">
        <div class="col">
            <p class="txt-black txt-bold txt-sm my-2">
                <a href="/" class="text-decoration-none txt-black txt-hover-blue">
                    <i class="bi-house-door"></i>&nbsp; Home
                </a>
            </p>
        </div>
    </div>
    <!-- ================================================== Breadcrumb ================================================= -->



    <!-- ================================================== Main Body ================================================== -->
    <div class="row bg-white border border-primary rounded-3 mx-2 mb-3">
        <div class="col">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
    </div>
    <!-- ================================================== Main Body ================================================== -->



    <!-- ================================================== Footer ===================================================== -->
    <div class="row bg-white border-top border-primary pt-3">
        <div class="col-4">
            <a href="/" class="d-inline-flex align-items-center text-decoration-none mb-2">
                <img src="../../resources/img/Logo.png" alt="logo" width="40" height="40"
                     class="h-auto rounded-circle border border-primary mx-auto">
                <span class="ms-1 txt-bold txt-italic txt-lgr txt-teal">&nbsp; Teach Sync</span>
            </a>
            <p class="txt-lg">Streamline, organize and excel in education</p>
        </div>

        <div class="col-8">
            <div class="row row-cols-3">
                <div class="col">
                    <h6 class="txt-bolder txt-grey">Useful Link</h6>
                    <p class="ps-1"><a href="/" class="text-decoration-none txt-black txt-hover-blue mb-3">Home</a></p>
                    <p class="ps-1"><a href="about" class="text-decoration-none txt-black txt-hover-blue mb-3">About Us</a></p>
                    <p class="ps-1"><a href="contact" class="text-decoration-none txt-black txt-hover-blue mb-3">Contact</a></p>
                </div>
                <div class="col">
                    <h6 class="txt-bolder txt-grey">Support</h6>
                    <p class="ps-1"><a href="faq" class="text-decoration-none txt-black txt-hover-blue mb-3">FAQ</a></p>
                    <p class="ps-1"><a href="policies" class="text-decoration-none txt-black txt-hover-blue mb-3">Policies</a></p>
                    <p class="ps-1"><a href="term-of-service" class="text-decoration-none txt-black txt-hover-blue mb-3">Term of service</a></p>
                </div>
                <div class="col">
                    <h6 class="txt-bolder txt-grey">Address</h6>
                    <p class="ps-1"><i class="bi-pin-map"></i>&nbsp; 123 xxx str, W.1, D.1, Hanoi</p>
                    <p class="ps-1"><i class="bi-telephone"></i>&nbsp; +84 987 456 321</p>
                    <p class="ps-1"><i class="bi-envelope"></i>&nbsp; teachsync@ts.com.vn</p>
                </div>
            </div>
        </div>
    </div>
    <!-- ================================================== Footer ===================================================== -->
</body>
</html>