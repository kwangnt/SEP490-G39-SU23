<%@ page import="com.teachsync.utils.enums.RequestType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Tạo đơn</title>

  <link rel="stylesheet" href="../../../resources/css/bootstrap-5.3.0/bootstrap.css">

  <link rel="stylesheet" href="../../../resources/css/teachsync_style.css">

  <script src="../../../resources/js/jquery/jquery-3.6.3.js"></script>
  <script src="../../../resources/js/bootstrap-5.3.0/bootstrap.bundle.js"></script>
  
  <!-- Import the SDKs you need -->
  <script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-app.js"></script>
  <script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-storage.js"></script>
  <script src="../../../resources/js/firebase.js"></script>
  
  <script src="../../../resources/js/common.js"></script>
</head>
<body class="container-fluid ts-bg-white-subtle">
<!-- ================================================== Header ===================================================== -->
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<!-- ================================================== Header ===================================================== -->


<!-- ================================================== Breadcrumb ================================================= -->
<div class="row ts-bg-white border ts-border-teal rounded-3 pt-3 px-5 mx-2 mb-3">
  <div class="col">
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb ts-txt-sm ts-txt-bold my-2">
        <li class="breadcrumb-item">
          <a href="/index">
            <i class="bi-house-door"></i>&nbsp;Trang chủ
          </a>
        </li>
        <li class="breadcrumb-item" aria-current="page">
          <a href="/request/list">
            Đơn xin
          </a>
        </li>
        <li class="breadcrumb-item active" aria-current="page">
          Tạo mới
        </li>
      </ol>
    </nav>
  </div>
</div>
<!-- ================================================== Breadcrumb ================================================= -->


<!-- ================================================== Main Body ================================================== -->
<div class="row ts-bg-white border ts-border-teal rounded-3 pt-3 mx-2 mb-3">
  <div class="col-12 mb-3">
    <label>Loại đơn:
      <select name="requestType" id="selRequestType" onchange="toggleRequestForm()">
        <option value="" selected disabled hidden>-- Xin chọn loại đơn --</option>
        <option value="${RequestType.ENROLL}">Đăng ký học</option>
        <option value="${RequestType.CHANGE_CLASS}">Xin chuyển lớp</option>
      </select>
    </label>
  
    <div class="row visually-hidden" id="enrollForm">
      <label class="col-12">Khóa học:
        <select name="requestType" id="selCourse" onchange="toggleRequestForm()">
          <option value="" selected disabled hidden>-- Xin chọn khóa học --</option>
          <option value="${RequestType.ENROLL}">Đăng ký nhập học</option>
          <option value="${RequestType.CHANGE_CLASS}">Xin chuyển lớp</option>
        </select>
      </label>
      
      <label class="col-12">
        <input type="text" name="" id="">
      </label>
      <label class="col-12">
        <input type="text" name="" id="">
      </label>
      <label class="col-12">
        <input type="text" name="" id="">
      </label>
      <label class="col-12">
        <input type="text" name="" id="">
      </label>
      <label class="col-12">
        <input type="text" name="" id="">
      </label>
    </div>
    
    <div class="row visually-hidden" id="changeClassForm">
  
    </div>
  
    <c:if test="${fromEnroll}">
      <script id="script1">
          $("#selRequestType").val("${RequestType.ENROLL}").disabled();
          
          $("#changeClassForm").remove();
          $("#script1").remove(); /* Xóa thẻ <script> sau khi xong */
      </script>
    </c:if>
    
  </div>
</div>
<!-- ================================================== Main Body ================================================== -->


<!-- ================================================== Footer ===================================================== -->
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
<!-- ================================================== Footer ===================================================== -->


<!-- ================================================== Script ===================================================== -->
<script>
  function toggleRequestForm() {
      let requestType = $("#selRequestType").val();
      let enrollForm = $("#enrollForm");
      let changeClassForm = $("#changeClassForm");
      
      switch (requestType) {
          case ${RequestType.ENROLL}:
              enrollForm.removeClass("visually-hidden");
              changeClassForm.addClass("visually-hidden");
              break;
              
          case ${RequestType.CHANGE_CLASS}:
              changeClassForm.removeClass("visually-hidden");
              enrollForm.addClass("visually-hidden");
              break;
              
          default:
              changeClassForm.addClass("visually-hidden");
              enrollForm.addClass("visually-hidden");
              break;
      }
  }
</script>
<!-- ================================================== Script ===================================================== -->
</body>
</html>