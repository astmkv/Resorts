<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>СПИСОК КУРОРТОВ</h1>
<%--вывод списка с использованием JSTL--%>
<form action="DBResortServlet" method="post">

<%--    <button value="create">--%>
<%--        create--%>
<%--    </button>--%>
<%--    <button value="read">--%>
<%--        read--%>
<%--    </button>--%>
<%--    <button value="update">--%>
<%--        update--%>
<%--    </button>--%>
<%--    <button value="delete">--%>
<%--        delete--%>
<%--    </button>--%>

<select name="req">
        <option value="create"> create </option> >
        <option value="read"> read </option> >
        <option value="update"> update </option> >
        <option value="delete"> delete </option> >
</select>
    <button> GO! </button>
    </form>


</body>
</html>