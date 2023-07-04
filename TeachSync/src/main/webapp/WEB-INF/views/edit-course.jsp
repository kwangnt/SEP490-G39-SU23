<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Thêm mới khóa học</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap-5.3.0/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/teachsync_style.css">

    <script src="../../resources/js/jquery/jquery-3.6.3.js"></script>
    <script src="../../resources/js/bootstrap-5.3.0/bootstrap.bundle.js"></script>
    <script src="../../resources/js/common.js"></script>
</head>
<body class="container-fluid ts-bg-white-subtle">
<!-- ================================================== Header ===================================================== -->
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!-- ================================================== Header ===================================================== -->

<!-- ================================================== Main Body ================================================== -->
<div class="row ts-bg-white border ts-border-teal rounded-3 pt-3 mx-2 mb-3">
    <form action="edit-course" method="post">
        <input name="id" hidden value="${course.id}">
        <div class="form-group">
            <label>Tên khóa học</label>
            <input type="text" name="name"
                   required
                   value="${course.courseName}"
                   class="form-control" placeholder="Nhập tên lớp">
        </div>
        <div class="form-group">
            <label>Ảnh khóa học</label>
            <img src="${course.courseImg}" width="30%" height="30%">
            <input type="file" name="image"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Miêu tả về khóa học</label>
            <input type="text" name="desc"
                   value="${course.courseDesc}"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Điểm khóa học</label>
            <input type="number" name="score"
                   required
                   value="${course.minScore}"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Số thành viên</label>
            <input type="number" name="attendant"
                   required
                   value="${course.minAttendant}"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Giá khóa học</label>
            <input type="number" name="price"
                   required
                   value="${course.currentPrice.price}"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Giảm giá</label>
            <input type="number" name="promotionAmount"
                   value="${course.currentPrice.promotionAmount}"
                   class="form-control">
        </div>
        <div class="form-group">
            <label>Giảm giá theo</label>
        <select name="promotionType"
                class="btn btn-secondary dropdown-toggle">
                <option value="PERCENT"> Phầm trăm</option>
            <option value="AMOUNT"> Số tiền</option>
        </select>
        </div>
        <div class="form-group">
            <label>Mô tả về chương trình giảm giá</label>
            <input type="text" name="promotionDesc"
                   value="${course.currentPrice.promotionDesc}"
                   class="form-control">
        </div>

        <div class="form-group">
            <br>
            <button type="submit" class="btn btn-primary">Submit</button>
            <br><br>
        </div>
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