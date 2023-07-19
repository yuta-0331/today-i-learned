<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!doctype html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <%
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String name = request.getParameter("name");
        if (name == null) {
            name = "名無し";
        }
        String[] fortune = { "大吉", "中吉", "小吉", "吉", "凶" };
        int ram = (int) (Math.random() * 5);

        out.print(simpleDateFormat.format(calendar.getTime()) + "の" + name + "さんの運勢は" + fortune[ram]);

    %>
</body>
</html>
