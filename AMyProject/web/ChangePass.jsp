<%-- 
    Document   : ChangePass
    Created on : Mar 20, 2021, 10:59:06 PM
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
        <form action="changePass" method="get">
            <!--Mới vào đổi mật khẩu chưa có gì-->
            <c:if test="${notice==null}">
                <h1>Đổi mật khẩu</h1>
                <table>
                    <tr>
                        <td>Nhập mât khẩu cũ: </td>
                        <td><input name="oldPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập mật khẩu mới: </td>
                        <td><input name="newPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu mới: </td>
                        <td><input name="reNewPass" type="pass"></td>
                    </tr>
                </table>
                <button type="sumit">Change Pass</button>
            </c:if>
               <!--trường hợp người dùng không nhập đầy đủ các ô-->
            <c:if test="${notice==1}">
                <h1>Bạn phải nhập đầy đủ hết các ô</h1>
                <table>
                    <tr>
                        <td>Nhập mât khẩu cũ: </td>
                        <td><input name="oldPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập mật khẩu mới: </td>
                        <td><input name="newPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu mới: </td>
                        <td><input name="reNewPass" type="pass"></td>
                    </tr>
                </table>
                <button type="sumit">Change Pass</button>
            </c:if>
                <!--trường hợp người dùng nhập sai mật khẩu cũ-->
            <c:if test="${notice==2}">
                <h1>Bạn đã nhập sai mật khẩu cũ</h1>
                <table>
                    <tr>
                        <td>Nhập mât khẩu cũ: </td>
                        <td><input name="oldPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập mật khẩu mới: </td>
                        <td><input name="newPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu mới: </td>
                        <td><input name="reNewPass" type="pass"></td>
                    </tr>
                </table>
                <button type="sumit">Change Pass</button>
            </c:if>
                <!--trường hợp người dùng nhập repass sai-->
            <c:if test="${notice==3}">
                <h1>Bạn nhập lại mật khẩu mới sai</h1>
                <table>
                    <tr>
                        <td>Nhập mât khẩu cũ: </td>
                        <td><input name="oldPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập mật khẩu mới: </td>
                        <td><input name="newPass" type="pass"></td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu mới: </td>
                        <td><input name="reNewPass" type="pass"></td>
                    </tr>
                </table>
                <button type="sumit">Change Pass</button>
            </c:if>

            
                
            
            
           
            <!--Đổi mật khẩu thành công-->   
            <c:if test="${notice==4}">
                <h1>Đổi mật khẩu thành công</h1>
                <button type="sumit"><a href="home">Trở về trang chủ</a></button>
            </c:if>
        </form>
    </body>
</html>
