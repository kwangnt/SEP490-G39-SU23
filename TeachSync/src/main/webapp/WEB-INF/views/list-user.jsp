<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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



<!-- ================================================== Main Body ================================================== -->
<div>
    <h1>ssahdfbjskdf</h1>
    <!-- Hot Course -->
    <c:if test="${lstUser ne null}">
        <div class="col-12 border-bottom ts-border-blue mb-3">
            <div class="row flex-row flex-nowrap overflow-auto gx-3 mb-3">
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Tên</th>
                        <th>User Name</th>
                        <th>Email</th>
                    </tr>
                    <c:forEach var="lstUser" items="${lstUser}">
                        <tr>
                            <td>lstUser.id</td>
                            <td>Maria Anders</td>
                            <td>Germany</td>
                            <td>Germany</td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td>Alfreds Futterkiste</td>
                        <td>Maria Anders</td>
                        <td>Germany</td>
                    </tr>
                    <tr>
                        <td>Centro comercial Moctezuma</td>
                        <td>Francisco Chang</td>
                        <td>Mexico</td>
                    </tr>
                </table>
<%--                <c:forEach var="lstUser" items="${lstUser}">--%>
<%--                    <div class="col-sm-4 col-md-2">--%>
<%--                        <div class="card ts-border-orange h-100">--%>
<%--                                &lt;%&ndash;<img src="${hotCourse.img}" class="rounded-1 border ts-border-yellow w-100 h-auto mb-2">&ndash;%&gt;--%>
<%--                            <img src="../../resources/img/logo-wide.png" class="card-img-top">--%>

<%--                            <div class="card-body">--%>
<%--                                <h6 class="card-title">--%>
<%--                                    <c:url var="courseLink" value="course-detail">--%>
<%--                                        <c:param name="id" value="${hotCourse.id}"/>--%>
<%--                                    </c:url>--%>
<%--                                    <a href="${courseLink}">--%>
<%--                                        <c:out value="${hotCourse.courseName}"/>--%>
<%--                                    </a>--%>
<%--                                </h6>--%>

<%--                                <p class="card-text ts-txt-sm">--%>
<%--                                    <c:out value="${hotCourse.courseDesc}"/>--%>
<%--                                </p>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
            </div>
        </div>
    </c:if>
</div>

    <!-- Course List paging -->

<!-- ================================================== Main Body ================================================== -->


<!-- ================================================== Footer ===================================================== -->
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
<!-- ================================================== Footer ===================================================== -->
</body>
</html>