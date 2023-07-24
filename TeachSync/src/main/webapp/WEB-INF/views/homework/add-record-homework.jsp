<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Danh sách lớp học</title>

    <link rel="stylesheet" href="../../../resources/css/bootstrap-5.3.0/bootstrap.css">
    <link rel="stylesheet" href="../../../resources/css/teachsync_style.css">

    <script src="../../../resources/js/jquery/jquery-3.6.3.js"></script>
    <script src="../../../resources/js/bootstrap-5.3.0/bootstrap.bundle.js"></script>
    <script src="../../../resources/js/common.js"></script>
    <script>
        $(document).ready(function () {
            $('#ckHoSo').click(function () {
                $('#divHoSo').toggle();
            });
        });
    </script>
    <script>
        var mess = '${mess}'
        if (mess != '') {
            alert(mess);
        }
    </script>
</head>
<body class="container-fluid ts-bg-white-subtle">
<!-- ================================================== Header ===================================================== -->
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!-- ================================================== Header ===================================================== -->

<!-- ================================================== Main Body ================================================== -->
<div class="row ts-bg-white border ts-border-teal rounded-3 pt-3 mx-2 mb-3">
    <form action="/homework/record-homework" method="post">
        <input type="hidden" name="homeworkId" value="${homework.id}">
        <div class="form-group">
            <label>Tên Bài tập</label>
            <input type="text" name="name"
                   value="${homework.homeworkName}"
                   disabled
                   class="form-control" placeholder="Nhập tên bài tập">
        </div>
        <div class="form-group">
            <label>File đính kèm</label>
            <input type="file" name="submission"
                   value=""
                   class="form-control" placeholder="File đính kèm">
        </div>
        <p>Bạn đã link của file bài tập <input type="checkbox" id="ckHoSo"></p>
        <div class="form-group" id="divHoSo" style="display: none;">
            <label>Link đính kèm</label>
            <input type="text" name="submissionLink"
                   value=""
                   class="form-control" placeholder="Link đính kèm">
        </div>


        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
        <br>
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