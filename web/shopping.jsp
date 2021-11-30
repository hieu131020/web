<%-- 
    Document   : shopping
    Created on : Nov 1, 2021, 11:47:27 PM
    Author     : hieu1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Store</title>
    </head>
    <body>
        <h1>List Mobile</h1>

        <c:set var="listMobile" value="${requestScope.LIST}"/>
        <c:if test="${not empty listMobile}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Mobile ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Add to car</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${listMobile}" varStatus="counter">
                    <form action="processAddBookToCart">
                        <tr>
                            <td> 
                                ${counter.count}
                            </td>
                            <td>
                                ${item.mobileid}
                            </td>
                            <td>
                                ${item.mobilename}
                                <input type="hidden" name="txtNameMobile" value="${item.mobilename}" />
                            </td>
                            <td>
                                ${item.price}
                            </td>
                            <td>
                                ${item.description}
                            </td>
                            <td>
                                <input type="submit" value="Add to your cart" />
                            </td>
                        </tr>
                    </form>
                </c:forEach>

            </tbody>
        </table>

    </c:if>
    <c:if test="${empty listMobile}">
        <h2>
            No Mobile
        </h2>
    </c:if>
    <br>
    <a href="processViewCart">View your cart</a>
</body>
</html>
