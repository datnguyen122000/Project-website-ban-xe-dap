<%-- 
    Document   : ManagerOrder
    Created on : Mar 21, 2021, 9:35:10 PM
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
        <h1>Manager Order</h1>
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

            <c:forEach items="${listOrder}" var="o">
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
                    <c:if test="${o.feedbackStatus==0}"> 
                        <td><button><a href="updateStatusOrder?orderID=${o.orderID}">Update status</a></button></td>
                    </c:if>
                </form>

                <!--với đơn hàng có feedback rồi thì cú nút xem feedback-->
                <form action="viewFeedback?orderID=${o.orderID}" method="post">
                    <!--trường hợp đã giao đã feedback rồi--> 
                    <c:if test="${o.feedbackStatus==1&&o.statusNum==3}"> 
                        <td><button type="sumbmit">View feedback</button></td>
                        <!--đã feedback rồi thì không thể thay đổi trạng thái đơn hàng được nữa-->
                        <!--<td><button><a href="updateStatusOrder?orderID=${o.orderID}">Update status</a></button></td>-->
                    </c:if>
                        <!--đã giao nhưng chưa feedback-->
                    <c:if test="${o.feedbackStatus==0&&o.statusNum==3}"> 
                        <td>Chưa feedback</td>
                        
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
