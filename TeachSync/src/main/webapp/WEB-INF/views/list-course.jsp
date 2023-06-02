<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Course List</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap-5.3.0/bootstrap.css">

    <link rel="stylesheet" href="../../resources/css/teachsync_style.css">

    <script src="../../resources/js/jquery/jquery-3.6.3.js"></script>
    <script src="../../resources/js/bootstrap-5.3.0/bootstrap.js"></script>

    <script src="../../resources/js/common.js"></script>
</head>
<body class="container-fluid ts-bg-white-subtle">
    <!-- ================================================== Header ===================================================== -->
    <%@ include file="/WEB-INF/fragments/header.jspf" %>
    <!-- ================================================== Header ===================================================== -->



    <!-- ================================================== Breadcrumb ================================================= -->
    <div class="row ts-bg-white border ts-border-teal rounded-3 mx-2 mb-3">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb ts-txt-sm ts-txt-bold my-2">
                    <li class="breadcrumb-item">
                        <a href="/">
                            <i class="bi-house-door"></i>&nbsp;Trang chủ
                        </a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                        Khóa học
                    </li>
                </ol>
            </nav>
        </div>
    </div>
    <!-- ================================================== Breadcrumb ================================================= -->



    <!-- ================================================== Main Body ================================================== -->
    <div class="row ts-bg-white border ts-border-teal rounded-3 pt-3 mx-2 mb-3">
        <%@ include file="/WEB-INF/fragments/hot-course.jspf"%>
<%--        <div class="col-12">--%>
<%--            <div class="row flex-row flex-nowrap overflow-scroll gx-3">--%>
<%--                <div class="col-3">--%>
<%--                    <p class="border ts-border-orange">a</p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="col-12">

        </div>
    </div>
    <!-- ================================================== Main Body ================================================== -->



    <!-- ================================================== Footer ===================================================== -->
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
    <!-- ================================================== Footer ===================================================== -->
</body>
</html>