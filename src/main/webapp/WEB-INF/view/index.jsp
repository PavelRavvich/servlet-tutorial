<%--
  Author: Pavel Ravvich.
  Date: 14.10.17.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подробный разбор возможностей библиотеки</title>
    <%--Справка : http://ru.bmstu.wiki/JSTL_(JavaServer_Pages_Standard_Tag_Library)--%>
</head>
<body>


<a target="_blank"
   href="http://ru.bmstu.wiki/JSTL_(JavaServer_Pages_Standard_Tag_Library)">
    Подробный разбор возможностей библиотеки jstl тут.
</a>
<hr />


<h2>Пример использования вывода на данных</h2>
<div>При использовании "out" контекст указывается в формате requestScope.youreObj"</div>
<c:out value="${requestScope.simpleOutput.text}"/>
<hr />


<div>При использовании "set" контекст указывается в формате scope="request"</div>
<c:set var="operations" scope="request" value="${operations}" />
<hr />

<h2>Пример использования цикла:</h2>
<c:forEach items="${operations}" var="operation">
    <c:out value="${operation}"/><br />
</c:forEach>
<hr />


<h2>Пример использования условного оператора:</h2>
<c:if test="${requestScope.condition eq true}">
    <div>Сработал условный оператор</div>
</c:if>

</body>
</html>
