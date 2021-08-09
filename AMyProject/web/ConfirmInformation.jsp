<%-- 
    Document   : ConfirmInformation
    Created on : Mar 20, 2021, 9:47:24 AM
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
        <form action="confirm" method="post">
        <h1>Mời bạn xác nhận thông tin đơn hàng</h1><br>
        Họ và tên của bạn<input type="text" name="cusName"><br>
        Địa chỉ giao hàng<input type="text" name="deliveryAddress"><br>
        Hình thức thanh toán
        <select name="payment">
            <option>Chuyển khoản</option>
            <option>Ship Code</option>
            <option>Momo</option>
            <option>Viettel Pay</option>
        </select><br>
        <input type="submit" value="Xác nhận">
        </form>
    </body>
</html>
