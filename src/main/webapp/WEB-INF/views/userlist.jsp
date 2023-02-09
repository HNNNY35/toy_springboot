<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/all.css" />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <title>SUN - ADMIN</title>
  </head>
  <body>

    <%@ include file="header.jsp" %>

    <div class="container border border-dark rounded text-center w-100 mt-4">
      <main class="p-5">
        <div class="text-center pb-5">전체 회원을 조회합니다.</div>

        <table
          class="table table-primary table-bordered border-dark text-center"
        >
          <thead>
            <tr class="table-light border-dark">
              <th>UID</th>
              <th>아이디</th>
              <th>비밀번호</th>
              <th>이름</th>
              <th>연락처</th>
              <th>이메일</th>
              <th>설문 여부</th>
              <th>관리자 여부</th>
            </tr>
          </thead>
          <c:forEach items="${resultMap.resultList}" var="resultData" varStatus="loop">
            <tr>
            <td>${resultData.USER_ID}</td>
            <td>${resultData.EMAIL}</td>
            <td>${resultData.FRIST_NAME}</td>
            <td>${resultData.LAST_NAME}</td>
            <td>${resultData.TITLE_OF_HONOR}</td>
            <td><fmt:formatDate value="${resultData.BIRTHDAY}" pattern="yyyy-MM-dd"/></td>
            <td>${resultData.COUNTRY}</td>
            <td>${resultData.STATE}</td>
            <td>${resultData.CITY}</td>
            <td>${resultData.ADDRESS}</td>
            <td><form action="/edit/${resultData.USER_ID}"><button class="btn btn-primary" >Edit</button></form></td>
            <td><form action="/delete/${resultData.USER_ID}" method="post"><button class="btn btn-primary">Delete</button></form></td>
            </tr>
            </c:forEach>
         </tbody>
        </table>
        <br /><br /><br />
        
        <table>
          <a class="btn btn-lg btn-warning border-dark" href="/index"
            >메인</a
          >
        </table>
      </main>
    </div>
    <%@ include file="footer.jsp" %>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
