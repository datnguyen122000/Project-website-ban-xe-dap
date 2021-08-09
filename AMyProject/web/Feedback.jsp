<%-- 
    Document   : Feedback
    Created on : Mar 21, 2021, 11:39:57 AM
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
        <h1>Mời bạn feedback</h1>
        <form action="feedback" method="get">
            <table>
                <tr>
                    <td>ID: </td>
                    <td><input readonly name="orderID" type="text" value="${orderID}"></td>
                </tr>
                <tr>
                    <td>Comment: </td>
                    <td><input name="comment" type="text" value=""></td>
                </tr>
                <tr>
                    <td>Đánh giá </td>
                    <td>
                        <select name="evalue">
                            <option>1*</option>
                            <option>2*</option>
                            <option>3*</option>
                            <option>4*</option>
                            <option>5*</option>
                        </select>
                    </td>
                </tr>
            </table>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
