<%-- 
    Document   : ViewFeedback
    Created on : Mar 21, 2021, 3:03:18 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>OrderID: </td>
                <td><input readonly name="" type="text" value="${feedback.orderID}"></td>
            </tr>
            <tr>
                <td>Comment: </td>
                <td><input readonly name="" type="text" value="${feedback.comment}"></td>
            </tr>
            <tr>
                <td>Time: </td>
                <td><input readonly name="" type="text" value="${feedback.time}"></td>
            </tr>
            <tr>
                <td>Evalue </td>
                <td><input readonly name="" type="text" value="${feedback.evalue}"></td>
            </tr>
            <c:if test="${isAdmin==1}">
                <tr>
                    <td><button><a href="managerOrder"> Manager Order</a></button></td>
                    <td><button><a href="home">home</a></button></td>
                </tr>
            </c:if>
            <c:if test="${isAdmin==0}">
                <tr>
                    <td><button><a href="orderHistory"> Trở về lịch sử giao dich</a></button></td>
                    <td><button><a href="home">Trở về trang chủ</a></button></td>
                </tr>
            </c:if>

        </table>
    </body>
</html>
