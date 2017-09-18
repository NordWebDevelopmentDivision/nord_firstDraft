<!DOCTYPE html>

<!--
 Authors:
     Ólafur Georg Gylfason (ogg4@hi.is),
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
    <h1>Búa til frétt</h1>

    <form method="POST" action="/news/addNews">
        Titill <input name="title" type="text" placeholder="Titill"> </input>

        Meginmál <textarea class="text" cols="86" rows ="20" name="text"></textarea>
        Tag <input name="tag" type="text" placeholder="Tag"> </input>
        <input type="submit" value="Í lagi"></input>
    </form>

    <a href="/">Fara á forsíðu</a>

</body>

</html>