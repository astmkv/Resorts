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
    <title>READ</title>
</head>
<body>
<h1>READ</h1>
<form action="ReadServlet" method="post">
    <h4>Request:
    </h4>
    <select name="req">
        <option value="all">show all</option>
        <option value="search">search</option>
    </select>
    <select name="search">
        <option value="name">name</option>
        <option value="country">country</option>
        <option value="season">season</option>
        <option value="price">price</option>
    </select>
    <input type="text" name="search_field">
    <button> show results </button>

<table>
    <c:forEach var="resort" items="${resorts}">
        <tr>
            <td>
                ${resort}
            </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
