<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Tuyển dụng</title>

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
  <div class="container">
    <h1 style="text-align:center">Tuyển dụng làm giáo viên</h1>
    <div class="col">
      <!-- Content here -->

      <div class="container">
        <div class="row">
          <div class="col mb-3">
            <form action="/teacher-request/add" method="post">
              <div class="form-group">
                <p>Giới thiệu về bản thân</p>
                <input type="text" required class="form-control" placeholder="nhập giới thiệu"
                     name="requestDesc">
              </div>
              <div class="form-group">
                <p>Nhập link hồ sơ (CV)</p>
                <input type="text" class="form-control" placeholder="nhập hồ sơ" name="contentLink">
              </div>
              <br><br>
              <button type="submit" class="btn btn-success">Ứng Tuyển</button>
              <button id="uploadFile" type="button" class="btn btn-success">Upload File CV</button>
              <br><br>
            </form>

          </div>
          <div class="col">
            <img src="https://data-gcdn.basecdn.net/202007/sys1954/hiring/18/20/WLGKALH4NL/89182dbf4577a34120fda4453ed2a168/QNC57FLLCRELF/ae/28/b9/19/b1/23dbef7b613e2731de7a653ac6cf4477/ispeaking_gvta_size2_3.jpg"
               width="100%" height="100%">
          </div>
        </div>
      </div>

    </div>

  </div>
</div>
<!-- ================================================== Main Body ================================================== -->

<!-- ================================================== Footer ===================================================== -->
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
<!-- ================================================== Footer ===================================================== -->
</body>
<script>
  $(document).ready(function () {
    $("#uploadFile").click(function () {
      alert("Chức năng đang phát triển")
    });
  });
</script>
<script>
  var mess = '${mess}'
  if (mess != '') {
    alert(mess);
  }
</script>
</html>