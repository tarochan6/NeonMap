<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>


<c:import url="parts/commonCss.jsp" />

<title>TITLE</title>




</head>
<body>


 
<div style="text-align:center;">
<h1 class="logo text-center my-3 fw-normal">NeonMap</h1>
<iframe src="https://www.google.com/maps/d/embed?mid=1ond_Pc_ve1GbUDlGbPJaDX3KxpDrHUU&ehbc=2E312F" width="640" height="480" style="border-radius: 30px; border: 1px solid;"></iframe>


<div class="my-3"><a class="btn btn-primary" href="login" role="button">ログインページへ</a></div>
<div class="my-3"><a class="btn btn-success" href="signup" role="button">メンバー登録ページへ</a></div>
</div>

</body>
</html>