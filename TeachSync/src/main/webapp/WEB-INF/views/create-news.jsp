<%--
  Created by IntelliJ IDEA.
  User: Tha
  Date: 6/11/2023
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>News Detail</title>

    <link rel="stylesheet" href="../../resources/css/bootstrap-5.3.0/bootstrap.css">

    <link rel="stylesheet" href="../../resources/css/teachsync_style.css">

    <script src="../../resources/js/jquery/jquery-3.6.3.js"></script>
    <script src="../../resources/js/bootstrap-5.3.0/bootstrap.js"></script>

    <script src="../../resources/js/common.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<div>
    <form action="submitcreatenews" method="post">
        <table>
            <tr>
                <td><form:label>Tiêu đề</form:label></td>
                <td><input type="text" id="title" name="title"></td>
            </tr>
            <tr>
                <td><form:label>Tóm tắt</form:label></td>
                <td><input type="text" id="description" name="description"></td>
            </tr>
            <tr>
                <td><form:label>Nội dung</form:label></td>
                <td><input type="text" id="content" name="content"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>


</body>
</html>
