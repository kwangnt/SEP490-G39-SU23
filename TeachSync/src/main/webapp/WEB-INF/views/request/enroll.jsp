<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Enroll</title>

  <link rel="stylesheet" href="../../../resources/css/bootstrap-5.3.0/bootstrap.css">

  <link rel="stylesheet" href="../../../resources/css/teachsync_style.css">

  <script src="../../../resources/js/jquery/jquery-3.6.3.js"></script>
  <script src="../../../resources/js/bootstrap-5.3.0/bootstrap.bundle.js"></script>

  <script src="../../../resources/js/common.js"></script>
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
          <a href="/index">
            <i class="bi-house-door"></i>&nbsp;Trang chủ
          </a>
        </li>
        <li class="breadcrumb-item" aria-current="page">
          <a href="/course">
            Khóa học
          </a>
        </li>
        <li class="breadcrumb-item" aria-current="page">
          <c:url var="courseDetail" value="course-detail">
            <c:param name="id" value="${course.id}"/>
          </c:url>
          <a href="${courseDetail}">
            <c:out value="${course.courseName}"/>
          </a>
        </li>
        <li class="breadcrumb-item active" aria-current="page">
          Đăng ký học
        </li>
      </ol>
    </nav>
  </div>
</div>

<c:set var="currentUri" value="${requestScope['jakarta.servlet.forward.request_uri']}"/>
<c:set var="queryString" value="${requestScope['jakarta.servlet.forward.query_string']}"/>
<c:set var="targetUrl" scope="session" value="${currentUri}${not empty queryString ? '?'.concat(queryString) : ''}"/>
<!-- ================================================== Breadcrumb ================================================= -->

<!-- ================================================== Main Body ================================================== -->
<div class="row ts-bg-white border ts-border-teal rounded-3 pt-3 mx-2 mb-3">
  <!-- Course List paging -->
  <div class="col-12 mb-3">
    <div class="row-cols-1">

      <h4>Khóa học: <c:out value="${course.courseName}"/></h4>
      <h5>Học kỳ:</h5>
  
      <!-- Semester Tab -->
      <ul class="nav nav-tabs align-items-center" id="semesterTab" role="tablist">
        <c:forEach var="courseSemesterClazzList" items="${courseSemesterClazzListMap}" varStatus="counter">
          <c:set var="semesterId" value="${courseSemesterClazzList.key.semester.id.toString()}"/>
          <li class="nav-item" role="presentation">
            <button type="button" class="nav-link" id="${semesterId}-se-tab"
                    data-bs-toggle="tab" data-bs-target="#${semesterId}-se-tab-pane" role="tab"
                    aria-controls="${semesterId}-se-tab-pane" aria-selected="false">
        
              <c:out value="${courseSemesterClazzList.key.semester.semesterAlias}"/>
      
            </button>
          </li>
    
          <c:if test="${counter.first}">
            <script id="script1">
                $("#${semesterId}-se-tab").addClass("active").attr("aria-selected", "true");
                $("#script1").remove(); /* Xóa thẻ <script> sau khi xong */
            </script>
          </c:if>
        </c:forEach>
      </ul>

      <!-- Semester TabPane -->
      <div class="tab-content border rounded-bottom-3 p-3" id="semesterTabContent">
      
      </div>
      
      <!-- Semester Tab -->
      <ul class="nav nav-tabs align-items-center" id="semesterTab" role="tablist">
        <c:forEach var="courseSemesterClazzList" items="${courseSemesterClazzListMap}" varStatus="counter">
          <c:set var="semesterId" value="${courseSemesterClazzList.key.semester.id.toString()}"/>
          <li class="nav-item" role="presentation">
            <button type="button" class="nav-link" id="${semesterId}-se-tab"
                    data-bs-toggle="tab" data-bs-target="#${semesterId}-se-tab-pane" role="tab"
                    aria-controls="${semesterId}-se-tab-pane" aria-selected="false">
              
              <c:out value="${courseSemesterClazzList.key.semester.semesterAlias}"/>
              
            </button>
          </li>
  
          <c:if test="${counter.first}">
            <script id="script1">
                $("#${semesterId}-se-tab").addClass("active").attr("aria-selected", "true");
                $("#script1").remove(); /* Xóa thẻ <script> sau khi xong */
            </script>
          </c:if>
        </c:forEach>
      </ul>
      
      <!-- Semester TabPane -->
      <div class="tab-content border rounded-bottom-3 p-3" id="semesterTabContent">
        <c:forEach var="semesterIdSemesterDTO" items="${semesterIdSemesterDTOMap}" varStatus="counter">
          <c:set var="semesterId" value="${semesterIdSemesterDTO.key.toString()}"/>
      
          <div class="tab-pane fade" id="${semesterId}-se-tab-pane"
               role="tabpanel" aria-labelledby="${semesterId}-se-tab" tabindex="0">
        
            <div class="">
              <p>Mã: <c:out value="${semesterIdSemesterDTO.value.semesterAlias}"/>&nbsp;&nbsp;&nbsp;
                 Tên: <c:out value="${semesterIdSemesterDTO.value.semesterName}"/></p>
              <p>Bắt đầu: <c:out value="${semesterIdSemesterDTO.value.startDate}"/>&nbsp;&nbsp;&nbsp;
                 Kết thúc: <c:out value="${semesterIdSemesterDTO.value.endDate}"/></p>
              <h6 class="card-title mb-0">
                Kỳ: <c:out value="${courseSemesterClazzList.key.semester.semesterAlias}"/><br/>
                Cơ sở: <c:out value="${courseSemesterClazzList.key.center.centerName}"/><br/>
                Từ: <c:out value="${courseSemesterClazzList.key.semester.startDate}"/><br/>
                Đến: <c:out value="${courseSemesterClazzList.key.semester.endDate}"/><br/>
              </h6>
            </div>
        
            <!-- Center Tab -->
            <ul class="nav nav-tabs" id="semesterTab${semesterId}" role="tablist">
              <c:forEach var="centerIdCenterDTO" items="${centerIdCenterDTOMap}" varStatus="counter2">
                <c:set var="centerId" value="${centerIdCenterDTO.key.toString()}"/>
            
                <li class="nav-item" role="presentation">
                  <button type="button" class="nav-link" id="${semesterId}-se-${centerId}-ce-tab"
                          data-bs-toggle="tab" data-bs-target="#${semesterId}-se-${centerId}-ce-tab-pane" role="tab"
                          aria-controls="${semesterId}-se-${centerId}-ce-tab-pane" aria-selected="true">
                    <c:out value="${centerIdCenterDTO.value.centerName}"/>
                  </button>
                </li>
            
                <c:if test="${counter2.first}">
                  <script id="script2">
                      $("#${semesterId}-se-${centerId}-ce-tab").addClass("active").attr("aria-selected", "true");
                      $("#script2").remove(); /* Xóa thẻ <script> sau khi xong */
                  </script>
                </c:if>
          
              </c:forEach>
            </ul>
        
            <!-- Center TabPane -->
            <div class="tab-content border rounded-bottom-3 p-3" id="semesterTab${semesterId}Content">
              <c:forEach var="centerIdCenterDTO" items="${centerIdCenterDTOMap}" varStatus="counter3">
                <c:set var="centerId" value="${centerIdCenterDTO.key.toString()}"/>
            
                <%--                <div class="">--%>
                <%--                  <p>Tên: <c:out value="${centerIdCenterDTO.value.centerName}"/></p>--%>
                <%--                  <p>Địa chỉ: <c:out value="${centerIdCenterDTO.value.addressId}"/></p>--%>
                <%--                </div>--%>
            
                <div class="tab-pane fade" id="${semesterId}-se-${centerId}-ce-tab-pane" role="tabpanel"
                     aria-labelledby="${semesterId}-se-${centerId}-ce-tab" tabindex="0">
                  <div class="row px-2">
                    <c:forEach var="courseIdCourseDTO" items="${courseIdCourseDTOMap}" varStatus="counter4">
                      <c:set var="courseId" value="${courseIdCourseDTO.key.toString()}"/>
                      <div class="col-2 py-2">
                        <input type="checkbox" name="courseId"
                               id="${semesterId}-se-${centerId}-ce-${courseId}-co"
                               value="${courseIdCourseDTO.value.id}" disabled="disabled">
                    
                        <c:if test="${distributionMap.get(Long.parseLong(semesterId)) ne null}">
                          <c:if test="${distributionMap.get(Long.parseLong(semesterId))
                                                        .get(Long.parseLong(centerId)) ne null}">
                            <c:if test="${distributionMap.get(Long.parseLong(semesterId))
                                                          .get(Long.parseLong(centerId))
                                                          .contains(Long.parseLong(courseId))}">
                              <script id="script3">
                                  $("#${semesterId}-se-${centerId}-ce-${courseId}-co").prop("checked", true);
                                  $("#script3").remove(); /* Xóa thẻ <script> sau khi xong */
                              </script>
                            </c:if>
                          </c:if>
                        </c:if>
                    
                        <c:out value="${courseIdCourseDTO.value.courseAlias}"/>
                      </div>
                    </c:forEach>
                
                    <div class="col-12 my-2"></div>
                
                    <div id="${semesterId}-se-${centerId}-ce-tab-pane-btn-edit" class="btn btn-warning col-2"
                         onclick="openEditCourseSemester('${semesterId}-se-${centerId}-ce-tab-pane',
                             '${semesterId}-se-${centerId}-ce-tab-pane-btn-edit',
                             '${semesterId}-se-${centerId}-ce-tab-pane-btn-cancel',
                             '${semesterId}-se-${centerId}-ce-tab-pane-btn-save')">
                      Chỉnh sửa
                    </div>
                
                    <div id="${semesterId}-se-${centerId}-ce-tab-pane-btn-cancel" class="btn btn-danger col-2 visually-hidden"
                         onclick="cancelEditCourseSemester('${semesterId}-se-${centerId}-ce-tab-pane',
                             '${semesterId}-se-${centerId}-ce-tab-pane-btn-edit',
                             '${semesterId}-se-${centerId}-ce-tab-pane-btn-cancel',
                             '${semesterId}-se-${centerId}-ce-tab-pane-btn-save')">
                      Hủy
                    </div>
                
                    <div id="${semesterId}-se-${centerId}-ce-tab-pane-btn-save" class="btn btn-primary col-2 visually-hidden ms-2"
                         onclick="sendRequestEditCourseSemester('${semesterId}-se-${centerId}-ce-tab-pane')">
                      Lưu
                    </div>
                  </div>
                </div>
            
                <c:if test="${counter3.first}">
                  <script id="script4">
                      $("#${semesterId}-se-${centerId}-ce-tab-pane").addClass("show active");
                      $("#script4").remove(); /* Xóa thẻ <script> sau khi xong */
                  </script>
                </c:if>
          
              </c:forEach>
            </div>
      
          </div>
      
          <c:if test="${counter.first}">
            <script id="script5">
                $("#${semesterId}-se-tab-pane").addClass("show active");
                $("#script5").remove(); /* Xóa thẻ <script> sau khi xong */
            </script>
          </c:if>
    
        </c:forEach>
      </div>
  
      <div class="col card">
        <div class="card-header">
        
        </div>
    
        <div class="card-body row flex-row flex-nowrap overflow-scroll">
          <c:forEach var="clazz" items="${courseSemesterClazzList.value}">
            <div class="col-4">
              <div class="card">
                <c:url var="enrollLink" value="enroll">
                  <c:param name="clazzId" value="${clazz.id}"/>
                </c:url>
                <form action="${enrollLink}" method="post">
                  <div class="card-header">
                    <h6 class="card-subtitle">
                      Lớp: <c:out value="${clazz.clazzName}"/>
                    </h6>
                  </div>
              
                  <c:set var="memberCount" value="0"/>
                  <c:if test="${clazz.memberList ne null}">
                    <c:set var="memberCount" value="${clazz.memberList.size()}"/>
                  </c:if>
              
                  <div class="card-body">
                    <p class="card-text">
                      Lịch học: <c:out value="${clazz.clazzSchedule.scheduleType}"/><br/>
                      Slot: <c:out value="${clazz.clazzSchedule.slot}"/><br/>
                      Từ: <c:out value="${clazz.clazzSchedule.sessionStart}"/>&nbsp;
                      Đến: <c:out value="${clazz.clazzSchedule.sessionEnd}"/><br/>
                  
                      Thành viên: <c:out value="${memberCount}"/> &sol; <c:out value="${clazz.clazzSize}"/>
                    </p>
                  </div>
              
                  <div class="card-footer">
                    <c:choose>
                      <c:when test="${memberCount lt clazz.clazzSize}">
                        <button type="submit" class="btn btn-primary w-100" >Đăng ký</button>
                      </c:when>
                      <c:when test="${memberCount ge clazz.clazzSize}">
                        <button type="submit" class="btn btn-primary w-100" disabled="disabled">Đăng ký</button>
                        <span class="ts-txt-orange">Lớp học đã đầy</span>
                      </c:when>
                    </c:choose>
                  </div>
                </form>
              </div>
        
            </div>
          </c:forEach>
        </div>
  
      </div>
      
      
      


    </div>
  </div>
</div>
<!-- ================================================== Main Body ================================================== -->


<!-- ================================================== Footer ===================================================== -->
<%@ include file="/WEB-INF/fragments/footer.jspf" %>
<!-- ================================================== Footer ===================================================== -->


<!-- ================================================== Script ===================================================== -->
<script>

</script>
<!-- ================================================== Script ===================================================== -->
</body>
</html>