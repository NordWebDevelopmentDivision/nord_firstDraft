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
    <title>Hver er notandinn</title>
</head>
<body>

<h1></h1>

<form method="POST" action="/demo/hver">
    Hvað heitir þú? <input name="nafn" type="text" placeholder="Nafn"> </input>
    <input type="submit" value="Í lagi"></input>
</form>

</body>

</html>