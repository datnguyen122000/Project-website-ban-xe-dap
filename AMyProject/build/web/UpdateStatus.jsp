<%-- 
    Document   : UpdateStatus
    Created on : Mar 21, 2021, 10:11:23 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Status</h1>
        <form action="updateStatusOrder?orderID=${orderID}" method="post">
            <select name="status" method="post">
                <option value="Chờ xác nhận">Chờ xác nhận</option>
                <option value="Xác nhận">Xác nhận</option>
                <option value="Đang giao">Đang giao</option>
                <option value="Đã giao">Đã giao</option>
            </select>
            <button type="submit">Submit</button>
        </form>

    </body>
</html>
