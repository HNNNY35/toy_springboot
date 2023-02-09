<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />

<div class="container">
<%-- Form list --%>
<div class="row">
	<div class="col">
		<form action="/commonCodeOur/form" method="get">
			<button class="btn btn-info"
				>Form</button>
		</form>
	</div>
	<div class="col">
		<form action="/commonCodeOur/formMulti" method="get">
			<button class="btn btn-info"
				>FormMulti</button>
		</form>
	</div>
</div>
<%-- pagination --%>
<nav aria-label="Page navigation example">
  <span>총 갯수 : </span>
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>
<form action="/commonCodeOur/deleteMulti" method="post">
<button class="btn btn-info">delete Multi</button>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr class="text-center">
				<th><input type="checkbox" id="selectall" /></th>
				<th>코드 ID</th>
				<th>코드 ID with Files</th>
				<th>코드명</th>
				<th>부모 코드 ID</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${resultMap}" var="resultData" varStatus="loop">
				<tr>
					<td class="text-center">
						<input type="checkbox" class="checkbox"
						name="COMMON_CODE_ID" value="${resultData.COMMON_CODE_ID}" />
					</td>
					<td>
						<form action="/commonCodeOur/edit/${resultData.COMMON_CODE_ID}" method="get">
							<button class="btn btn-link viewPopup"
								>${resultData.COMMON_CODE_ID}</button>
						</form>
					</td>
					<td>
						<form action="/commonCodeOur/editMulti/${resultData.COMMON_CODE_ID}" method="get">
							<button class="btn btn-link viewPopup"
								>${resultData.COMMON_CODE_ID} Multi</button>
						</form>
					</td>
					<td>${resultData.NAME}</td>
					<td class="text-center">
						<div class="btn-group">
							<button class="btn btn-outline-info"
								name="PARENT_COMMON_CODE_ID" >
								${resultData.PARENT_COMMON_CODE_ID}
							</button>
						</div>
					</td>
					<td>
						<form action="/commonCodeOur/delete/${resultData.COMMON_CODE_ID}" method="post">
							<button class="btn btn-outline-info"
								>Delete</button>
						</form>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</div>
<!-- /.table-responsive -->