<%-- 
    Document   : bill
    Created on : Mar 20, 2021, 10:17:32 AM
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
        <h1>HÓA ĐƠN CỦA BẠN</h1>
        <table border="1">
            <tr>
                <th>Tên sản phẩm</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
            </tr>
            <c:forEach items="${listBuy}" var="o">
            <tr>
                <td>${o.name}</td>
                <td>${o.amount}</td>
                <td>${o.price}</td>
            </tr>
            </c:forEach>
        </table><br>
        <span>Tổng thanh toán: ${totalPay}</span><br>
        <span>Địa chỉ giao hàng: ${deliveryAddress}<</span>br>
        <span>Hình thức thanh toán: ${payment}</span></p>
        <span>Bạn vui lòng chờ nhân viên chúng tôi sẽ gọi lại để xác nhận đơn hàng</span><br>
        <a href="home"><button>Quay về trang chủ</button></a>
    </body>
</html>
