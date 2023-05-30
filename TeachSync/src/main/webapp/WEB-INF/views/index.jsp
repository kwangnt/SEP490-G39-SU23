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
            <a href="index.jsp" class="text-center w-100">
                <img src="../../resources/img/p_logo.jpg" alt="logo" class="w-50 h-auto rounded-circle border border-primary mx-auto">
            </a>
        </div>

        <!-- Menu -->
        <div class="col-11 txt-normal">
            <div class="row row-cols-md-2 row-cols-sm-1 d-flex align-items-center h-100">
                <!-- Home, Course, Promotion -->
                <div class="col">
                    <div class="row row-cols-3">
                        <div class="col border-start border-primary border-end border-primary ">
                            <a href="index.jsp" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-house-door"></i>
                                &nbsp; Home
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="course.jsp" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-book"></i>
                                &nbsp; Course
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="promotion.jsp" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-graph-up"></i>
                                &nbsp; Promotion
                            </a>
                        </div>
                    </div>
                </div>

                <!-- Material, News, Login -->
                <div class="col">
                    <div class="row row-cols-3">
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="material.jsp" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-box-seam"></i>
                                &nbsp; Material
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="news.jsp" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-file-text"></i>
                                &nbsp; News
                            </a>
                        </div>
                        <div class="col border-start border-primary border-end border-primary">
                            <a href="login.jsp" class="text-decoration-none txt-black txt-hover-blue">
                                <i class="bi-person"></i>
                                &nbsp; Login
                            </a>
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
                <a href="index.jsp" class="text-decoration-none txt-black txt-hover-blue">
                    <i class="bi-house-door"></i>&nbsp; Home
                </a>
            </p>
        </div>
    </div>
    <!-- ================================================== Breadcrumb ================================================= -->



    <!-- ================================================== Main Body ================================================== -->
    <div class="row bg-white border border-primary rounded-3 mx-2 mb-3">
        <div class="col">
            <h1>Testing mvc</h1>
            <p><c:out value="${test}"/></p>
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
    <div class="row bg-white sticky-bottom border-top border-primary">
        <br>
        <br>
        <br>
    </div>
    <!-- ================================================== Footer ===================================================== -->
</body>
</html>