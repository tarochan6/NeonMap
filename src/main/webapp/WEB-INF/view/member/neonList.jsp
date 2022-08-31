<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<c:import url="../parts/commonCss.jsp" />
<c:import url="../parts/commonJs.jsp" />

<script src="<%=request.getContextPath()%>/js/chart-3.8.0.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- テーブルソート -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.min.js"></script>

<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>メンバーページ - NeonMap</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<c:import url="../parts/header.jsp" />

	<div class="container mt-3">
		<table id="fav-table" class="table">
			<thead class="thead-dark">
				<tr class="bg-light text-center">
					<th class="text-nowrap">No</th>
					<th class="text-nowrap">名称</th>
					<th class="text-nowrap">写真</th>
					<th class="text-nowrap">住所</th>
					<th class="text-nowrap">備考</th>
					<th class="text-nowrap">投稿日</th>
					<th class="text-nowrap">投稿者</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${neons}" var="neon" varStatus="vs">
					<tr class="align-middle text-center">
						<td><c:out value="${neon.id}" /></td>
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

</body>
</html>