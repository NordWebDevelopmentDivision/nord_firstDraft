<!DOCTYPE html>

<!--
 Höfundar:
     Kári Snær Kárason (ksk12@hi.is),
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
    <h1>Skráning í viðburð</h1>

    <form method="POST" action="/registration/registration">
        <p id="event" name="event"> ${event}</p>
        <input type="submit" value="Skrá mig inn!"></input>
    </form>

    <a href="/">Fara á forsíðu</a>

</body>

</html>