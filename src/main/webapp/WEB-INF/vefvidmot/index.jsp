<!DOCTYPE html>

<!--
 Höfundar:
     Kári Snær Kárason (ksk12@hi.is),
     Ólafur Georg Gylfason (ogg4@hi.is),
     Stella Rut Guðmundsdóttir (srg30@hi.is)
 Ath. skrifað eftir fyrirlestri hjá Ebbu Þóru 31. ágúst 2017.
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
    <p for="user">Innskráður notandi: ${username != null ? username : "Enginn"}</p>
    <p>${userName}</p>
    <c:choose>
        <c:when test="${username == Enginn || username == 'Innskráning tókst ekki'}">
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