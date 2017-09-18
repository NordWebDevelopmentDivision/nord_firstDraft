<!DOCTYPE html>

<!--
 Authors:
     Kári Snær Kárason (ksk12@hi.is),
     Ólafur Georg Gylfason (ogg4@hi.is),
     Stella Rut Guðmundsdóttir (srg30@hi.is)
 -->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="is">

<head>
    <meta charset="UTF-8">
    <title>Nemendafélagið Nörd</title>
    <link rel="stylesheet" href="../../css/normalize.css">
</head>
<body>
    <h1>Nemendafélagið Nörd</h1>
    <p for="user">Innskráður notandi: ${userName}</p>

    <c:choose>
        <c:when test="${userName == null || userName == '' || userName == 'Innskráning tókst ekki'}">
            <a href="/user/showLogIn">Innskráning</a>
        </c:when>
        <c:otherwise>
            <a href="/user/logOut">Útskráning</a>
        </c:otherwise>
    </c:choose>

    <a href="/news/makeNews">Búa til frétt</a>
    <a href="/news/makeEvent">Búa til viðburð</a>
    ${news}
    ${registrations}

</body>

</html>