<%--
  Created by IntelliJ IDEA.
  User: astmkv
  Date: 18.10.2022
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE</title>
</head>
<body>
<h1>UPDATE</h1>
<%--<h6>обновление данных по имени</h6>--%>
<form action="UpdateServlet" method="post">
    <select name="update_choice">
        <option value="name">name</option>
        <option value="country">country</option>
        <option value="season">season</option>
        <option value="price">price</option>
    </select>
    <input type="text" id="update-field" name="update_field">

<br>
    <h4>new data:</h4>
<br>
    <label>
        name
        <input type="text" id="name-field" name="name_field">
    </label>
    <label>
        country
        <input type="text" id="country-field" name="country_field">
    </label>
    <label>
        season
        <input type="text" id="season-field" name="season_field">
    </label>
    <label>
        price
        <input type="text" id="price-field" name="price_field">
    </label>
    <button>
        update resort
    </button>

    <div name="result">${result}</div>
</form>
</body>
</html>
