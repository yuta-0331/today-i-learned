<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>配列をHTMLのリストで表示</title>
</head>
<body>
    <%
    String[] names = {"阿笠", "江戸川", "灰原", "毛利"};
    int[] scores = {65, 100, 95, 50};
    %>
    <dl>
      <%
      for (int i = 0; i < names.length; i++) {
        String msg = "<dt>" + names[i] + "</dt><dd>" + scores[i] + "</dd>";
        if (scores[i] < 80) {
            msg = "<div style=\"background-color: red\">" + msg + "</div>";
        }
          out.print(msg);
      }
      %>
    </dl>
</body>
</html>
