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
    <h1>Búa til Viðburð</h1>

    <form method="POST" action="/news/addEvent">
        Titill <input name="title" type="text" placeholder="Titill"> </input>

        Meginmál <textarea class="text" cols="86" rows ="20" name="text"></textarea>
        Tag <input name="tag" type="text" placeholder="Tag"> </input>
        Fyrirtæki <input name="company" type="text" placeholder="Fyrirtæki"> </input>
        Staðsetning <input name="location" type="text" placeholder="Staðsetning"> </input>
        Fjöldi <input name="capacity" type="text" placeholder="Fjöldi"> </input>

        Tímasetning viðburðar<input name="timeOfEvent" type="text" placeholder="HH:MM"> </input>
        <input name="dateOfEvent" type="text" placeholder="DD-MM-YYYY"> </input>

        Skráning hefst<input name="regStartsTime" type="text" placeholder="HH:MM"> </input>
        <input name="regStartsDate" type="text" placeholder="DD-MM-YYYY"> </input>

        Skráning endar<input name="regEndsTime" type="text" placeholder="HH:MM"> </input>
        <input name="regEndsDate" type="text" placeholder="DD-MM-YYYY"> </input>

        Forgangsviðburður <input name="isPriorityEvent" type="checkbox" value="checked"></input>

        <input type="submit" value="Í lagi"></input>
    </form>

    <a href="/">Fara á forsíðu</a>

</body>

</html>