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
    <title>DELETE</title>
</head>
<body>
<h1>DELETE</h1>


<form action="DeleteServlet" method="post">
    <select name="delete_choice">
        <option value="name">name</option>
        <option value="country">country</option>
        <option value="season">season</option>
        <option value="price">price</option>
    </select>
    <input type="text" id="delete-field" name="delete_field">

    <button>
        delete resort
    </button>

    <div name="result">${result}</div>
</body>
</html>
