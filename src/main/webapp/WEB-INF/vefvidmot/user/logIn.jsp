<!DOCTYPE html>

<!--
 Authors:
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
    <h1>Innskráning</h1>

    <form method="POST" action="/user/logIn">
        <label for="username">Notandanafn</label>
        <input type="text" placeholder="Notandanafn" id="username" name="username" required>

        <label for="password">Notandanafn</label>
        <input type="password" placeholder="Lykilorð" id="password" name="password" required>

        <input type="submit" value="Skrá inn"></input>
    </form>


    <a href="/">Fara á forsíðu</a>

</body>

</html>