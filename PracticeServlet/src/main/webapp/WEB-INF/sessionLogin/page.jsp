<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>メインページです</title>
</head>
<body>
  <% String userName = request.getParameter("userName"); %>
  <%= userName %>: ログインしました。

</body>
</html>
