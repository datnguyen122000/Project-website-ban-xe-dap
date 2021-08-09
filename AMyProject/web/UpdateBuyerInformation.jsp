<%-- 
    Document   : UpdateBuyerInformation
    Created on : Mar 20, 2021, 8:11:26 PM
    Author     : DELL
--%>

<%@page import="Entity.BuyerAccount"%>
<%@page import="dao.loadDAO"%>
<%@page import="Entity.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            HttpSession sessionx = request.getSession();
            Account a = (Account) sessionx.getAttribute("acc");
            loadDAO ld = new loadDAO();
            BuyerAccount buyerAccount = ld.getBuyerAccountByUser(a.getUser());
        %>
        <h1>Cập nhật thông tin cá nhân</h1>
        <form action="updateBuyerInformation?oldFullName=<%=buyerAccount.getFullName()%>" method="post">
            <table>
                <tr>
                    <td>Họ và tên: </td>
                    <td><input name="newFullName" type="text" value="<%=buyerAccount.getFullName()%>"></td>
                </tr>
                <tr>
                    <td>Địa chỉ: </td>
                    <td><input name="address" type="text" value="<%=buyerAccount.getAddress()%>"></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input name="email" type="text" value="<%=buyerAccount.getEmail()%>"></td>
                </tr>
                <tr>
                    <td>Điện thoại: </td>
                    <td><input name="phone" type="text" value="<%=buyerAccount.getPhone()%>"></td>
                </tr>
                <tr>
                    <td><button type="submit">Update</button></td>
                    <td><button><a href="home">Trở về trang chủ</a></button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
