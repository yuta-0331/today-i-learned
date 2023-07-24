<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力フォーム</title>
<style>
    * {
        margin: 0;
        padding: 0;
    }
    form {
        width: 100vw;
        height: 100vh;
    }
    .form_container {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
</head>
<body>
    <% 
    Double gallon = (Double) request.getAttribute("gallon");
    Double yard = (Double) request.getAttribute("yard");
    Double pound = (Double) request.getAttribute("pound");
    Double liter = (Double) request.getAttribute("liter");
    Double meters = (Double) request.getAttribute("meters");
    Double kiloGram = (Double) request.getAttribute("kiloGram");
    
    Boolean gallonIsNull = (gallon != null);
    Boolean yardIsNull = (yard != null);
    Boolean poundIsNull = (pound != null);
    Boolean literIsNull = (liter != null);
    Boolean metersIsNull = (meters != null);
    Boolean kiloGramIsNull = (kiloGram != null);
    %>
    <form action="" method="post">
        <div class="form_container">
            <div class="form_inner">
                <input type="number" name="gallon">
                <input type="number" name="yard">
                <input type="number" name="pound">
            </div>
            <div class="form_inner">
                <input type="number" name="liter">
                <input type="number" name="meters">
                <input type="number" name="kiloGram">
            </div>
        </div>
        <%= gallon %>
        <div class="submit_container">
            <input type="submit" value="変換する">
        </div>
    </form>
</body>
</html>