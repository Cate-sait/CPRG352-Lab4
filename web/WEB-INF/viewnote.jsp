<%-- 
    Document   : viewnote
    Created on : 29-Sep-2021, 9:42:11 PM
    Author     : Ya-Yun Huang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab4_SimpleNoteKeeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <b>Title: </b> ${note.title}<br>
        <br>
        <b>Contents: </b> <br>
        ${note.contents}<br>
        <br>
        <a href="edit">Edit</a>
    </body>
</html>
