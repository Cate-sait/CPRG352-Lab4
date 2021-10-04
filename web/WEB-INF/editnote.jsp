<%-- 
    Document   : editnote
    Created on : 29-Sep-2021, 9:42:28 PM
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
        <h2>Edit Note</h2>
        <form action="note" method="POST">
            <b>Title: </b> <input type="text" name="in_title" value="${note.title}"<br>
            <br>
            <b>Contents: </b>
            <textarea name="in_contents" rows="5" cols="25">${note.contents}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
