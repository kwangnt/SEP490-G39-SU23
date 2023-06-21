<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Danh sách lớp học</title>

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
<div class="row ts-bg-white border ts-border-teal rounded-3 pt-3 mx-2 mb-3">
    <form action="add-classroom" method="post">
        <input type="hidden" name="classroomId" value="${classroom.id}">
        <div class="form-group">
            <label>Tên lớp</label>
            <c:if test="${option == 'detail'}">
                <input type="text" name="name"
                       value="${classroom.className}"
                       disabled
                       class="form-control" placeholder="Nhập tên lớp">
            </c:if>
            <c:if test="${option == 'edit' || option == 'add'}">
                <input type="text" name="name"
                       value="${classroom.className}"
                       class="form-control" placeholder="Nhập tên lớp">
            </c:if>

        </div>
        <div class="row">
            <div class="col-md-4 pt-4">
                <div class="d-flex align-items-center">
                    <p class="mr-2">Tên khóa học</p>
                    <div class="dropdown ms-3">
                        <c:if test="${option == 'detail'}">
                            <select name="courseId"
                                    disabled
                                    class="btn btn-secondary dropdown-toggle">
                                <c:forEach items="${listCourse}" var="course">
                                    <option value="${course.id}"> ${course.courseName}</option>
                                </c:forEach>
                            </select>
                        </c:if>
                        <c:if test="${option == 'edit' || option == 'add'}">
                            <select name="courseId"
                                    class="btn btn-secondary dropdown-toggle">
                                <c:forEach items="${listCourse}" var="course">
                                    <option value="${course.id}"> ${course.courseName}</option>
                                </c:forEach>
                            </select>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label>Miêu tả</label>
            <c:if test="${option == 'detail'}">
                <input type="text" disabled value="${classroom.classDesc}" name="desc" class="form-control" placeholder="Nhập miêu tả">
            </c:if>
            <c:if test="${option == 'edit' || option == 'add'}">
                <input type="text" value="${classroom.classDesc}" name="desc" class="form-control" placeholder="Nhập miêu tả">
            </c:if>
        </div>
        <br>
        <c:if test="${option == 'edit' || option == 'add'}">
            <button type="submit" class="btn btn-primary">Submit</button>
        </c:if>
        <br><br>
    </form>


</div>
<!-- ================================================== Main Body ================================================== -->

<!-- ================================================== Footer ===================================================== -->
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
<!-- ================================================== Footer ===================================================== -->
</body>
<script>
    var mess = '${mess}'
    if (mess != '') {
        alert(mess);
    }
</script>
</html>