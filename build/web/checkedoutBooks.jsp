<%-- 
    (c) 2015, Ben Hay and Haris Cesko
--%>

<%@include file="/Includes/header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <section>
        <table id="checkedOut">
            <tr id='table_header'>
                <th>Patron Name</th>
                <th></th>
                <th>Email Address</th>
                <th></th>
                <th>Book Title</th>
                <th></th>
                <th>Due Date</th>
                <th></th>
                <th>Overdue</th>
                <th></th>
            </tr>
                           
                <c:set var="index" value="0" scope="page"/>
            <c:forEach items="${test}" var="users">
                
                <tr>
                    <td>${test[index].firstName}</td>
                    <td></td>
                    <td>${test[index].emailAddress}</td>
                    <td></td>
                    <td>${test[index].bookTitle}</td>
                    <td></td>
                    <td>${test[index].dueDate}</td>
                    <td></td>
                    <td>${test[index].overDue}</td>
                    <td></td>
                    <td>
                        <form method="post" action="library">
                            <input var="${index}" type="submit" value="Check in" action="doCheckIn" id="checkin">                            
                        </form>
                    </td>    
                </tr>
                    <c:set var="index" value="${index + 1}" scope="page"/>    
            </c:forEach>
        
            
        </table>
        
        <p><a href="index.jsp">Return to front page</a></p>
    </section>
<%@include file="/Includes/footer.html" %>
