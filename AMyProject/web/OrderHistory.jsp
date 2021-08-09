<%-- 
    Document   : OrderHistory
    Created on : Mar 20, 2021, 10:34:30 PM
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
        <h1>Lịch sử mua hàng</h1>
        <table border="1">
            <tr>
                <th>orderID</th>
                <th>customerName</th>
                <th>detail</th>
                <th>totalPay</th>
                <th>status</th>
                <th>deliveryAddress</th>
                <th>payment</th>
            </tr>

            <c:forEach items="${list}" var="o">
                <tr>
                    <td>${o.orderID}</td>
                    <td>${o.customerName}</td>
                    <td>${o.detail}</td>
                    <td>${o.totalPay}</td>
                    <td>${o.status}</td>
                    <td>${o.deliveryAddress}</td>
                    <td>${o.payment}</td>
                <form action="feedback?orderID=${o.orderID}" method="post">
                    <!--tức là đã nhận hàng nhưng chưa feedback thì có nút feedback-->
                    <c:if test="${o.statusNum==3&&o.feedbackStatus==0}"> 
                        <td><button type="sumbmit">Feedback</button><td>
                        </c:if>
                </form>

                <!--tức là đã nhận hàng và feedback rồi thì có chữ view feedback-->
                <form action="viewFeedback?orderID=${o.orderID}" method="post">
                    <c:if test="${o.statusNum==3&&o.feedbackStatus==1}"> 
                        <td><button type="sumbmit">View feedback</button><td>
                        </c:if>
                </form>

            </tr>
        </c:forEach>

        <tr>
            <td><button><a href="home">Trở về trang chủ</a></button></td>
        </tr>

    </table>
</body>
</html>
