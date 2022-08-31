<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<c:import url="parts/commonCss.jsp" />

<link rel="icon" href="<%=request.getContextPath()%>/img/favicon.ico" />


<title>メンバーログイン - NeonMap</title>

</head>
<body>			  
<div class="dark">
<h1 class="neon text-center mb-3 fw-normal">NeonMap</h1>
</div>
       <h2 class="text-center">メンバーログイン</h2>
	<div class="container mt-3">
		<div class="row">
			<div class="col-lg-4 offset-lg-4">
				<form action="" method="post">

					<c:if test="${error}">
						<div class="alert alert-danger" role="alert">
							ログインIDまたはパスワードが間違っています。</div>
					</c:if>

					<div class="form-floating">
						<input type="text" name="loginId"
							class="form-control rounded-0 rounded-top" id="floatingInput"
							placeholder="ログインID"> <label for="floatingInput">ログインID</label>
					</div>

					<div class="form-floating mb-3">
						<input type="password" name="loginPass"
							class="form-control border-top-0 rounded-0 rounded-bottom"
							id="floatingPassword" placeholder="パスワード"> <label
							for="floatingPassword">パスワード</label>
					</div>
				
					<div class="text-center"><input class="btn btn-dark my-3 " type="submit"
						value="ログイン"></div>
					<div class="text-center my-2"><a class="link-primary" href="<%= request.getContextPath() %>/signup">ユーザー登録を行う</a></div>
					<div class="text-center my-2"><a class="link-primary" href="<%= request.getContextPath() %>/index">トップページへ戻る</a></div>
					
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
</body>
</html>
