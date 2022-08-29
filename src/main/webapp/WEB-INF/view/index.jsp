<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<c:import url="parts/commonCss.jsp" />
<c:import url="parts/commonJs.jsp" />

<script src="<%=request.getContextPath()%>/js/chart-3.8.0.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- テーブルソート -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.min.js"></script>

<!-- データテーブル -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.12.1/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.12.1/datatables.min.js"></script>

<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<title>NeonMap</title>

</head>
<body>
	<div style="text-align: center;">
		<h1 class="logo text-center my-3 fw-normal">NeonMap</h1>
		<iframe
			src="https://www.google.com/maps/d/embed?mid=1ond_Pc_ve1GbUDlGbPJaDX3KxpDrHUU&ehbc=2E312F"
			width="640" height="480"
			style="border-radius: 30px; border: 1px solid;"></iframe>
	</div>

	<div class="container mt-3">
		<table id="fav-table" class="table">
			<thead class="thead-dark">
				<tr class="bg-light text-center">
					<th>名称</th>
					<th>写真</th>
					<th>住所</th>
					<th>備考</th>
					<th>投稿日</th>
					<th>投稿者</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${neons}" var="neon" varStatus="vs">
					<tr class="align-middle text-center">
						<td class="text-nowrap"><c:out value="${neon.name}" /></td>
						<td><img
							src="<%=request.getContextPath()%>/img/neon<c:out value="${neon.id}" />.jpg"
							alt="" class="img-fluid rounded img-thumbnail"></td>
						<td><c:out value="${neon.address}" /></td>
						<td><c:out value="${neon.note}" /></td>
						<td><c:out value="${neon.registered}" /></td>
						<td class="text-nowrap"><c:out value="${neon.memberName}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


	<div class="text-center">
		<div class="my-3">
			<a class="btn btn-primary" href="login" role="button">ログインページへ</a>
		</div>
		<div class="my-3">
			<a class="btn btn-success" href="signup" role="button">メンバー登録ページへ</a>
		</div>
	</div>


	<script>
		//テーブルのソート
		$(document).ready(function() {
			$('#fav-table').tablesorter();
		});
	</script>

</body>
</html>