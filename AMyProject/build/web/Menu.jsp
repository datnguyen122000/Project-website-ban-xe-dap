
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="home">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">

                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.acc.user}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="managerOrder">Manager Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="loadToManagerProduct">Manager Product</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="loadToManagerCategory">Manager Category</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc.isAdmin == null&& sessionScope.acc.isAdmin==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.acc.isAdmin == 0}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.acc.user}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FollowOrder.jsp">Theo dõi đơn hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="orderHistory">Lịch sử đơn hàng</a>
                    </li>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="UpdateBuyerInformation.jsp">Cập nhật thông tin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ChangePass.jsp">Đổi mật khẩu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </c:if>

            </ul>

            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input name="txtSearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <a class="btn btn-success btn-sm ml-3" href="cartPage">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light"></span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Cửa xe đạp chất lượng cao</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm xe đạp nhập từ Trung Quốc</p>
    </div>
</section>
