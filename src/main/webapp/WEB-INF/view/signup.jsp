<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<c:import url="parts/commonCss.jsp" />
<c:import url="parts/commonJs.jsp" />

<script src="<%=request.getContextPath()%>/js/chart-3.8.0.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- フォントオーサム -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
	
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>ユーザー登録 - CowBirthdaylist</title>
</head>
<body>

<div class="dark">
<h1 class="neon text-center mb-3 fw-normal">NeonMap</h1>
</div>
        <h2 class="text-center">メンバー登録</h2>
<div class="container mt-3">
  <div class="row">
    <div class="col-lg-4 offset-lg-4">

      <form action="" method="post">
  
      <c:if test="${!empty errors}">
      <div class="alert alert-danger" role="alert">
          <c:forEach items="${errors}" var="error" varStatus="vs">
            <c:out value="${error}" />
            <c:out value="${vs.last ? '' : '<br>'}" escapeXml="false" />
          </c:forEach>
      </div>
      </c:if>

      <div class="form-floating">
        <input type="text" value="<c:out value="${loginId}" />" name="loginId" class="form-control rounded-0 rounded-top" id="floatingInput" placeholder="ログインID">
        <label for="floatingInput">ユーザーID</label>
      </div>
      
      <div class="form-floating">
        <input type="password" name="loginPass" class="form-control border-top-0 rounded-0" id="floatingPassword" placeholder="パスワード">
        <label for="floatingPassword">パスワード</label>
      </div>

      <div class="form-floating mb-3">
        <input type="password" name="confPass" class="form-control border-top-0 rounded-0 rounded-bottom" id="floatingPassword2" placeholder="パスワード(確認用)">
        <label for="floatingPassword2">パスワード(確認用)</label>
      </div>

<div class="text-center">
      <input class="text-center btn btn-dark my-3" type="submit" value="登録"></div>
      <div class="text-center my-2"><a href="<%= request.getContextPath() %>/login" class="link-primary">ログインページへ戻る</a></div>
       <div class="text-center my-2"><a href="<%= request.getContextPath() %>/index" class="link-primary">トップページへ戻る</a></div>
     
      </form>
    </div>
  </div>
</div><!-- /.container -->
<c:import url="parts/commonJs.jsp" />
</body>
</html>