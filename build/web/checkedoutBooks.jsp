<%-- 
    (c) 2015, Ben Hay and Haris Cesko
--%>

<%@include file="/Includes/header.html" %>
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
           
            <%-- <c:forEach items="$(years)" var="amount" varStatus="status">
                <tr>
                    <td></td>
                    <td></td>
                </tr>
            </c:forEach> --%>
        </table>
        
        <p><a href="index.jsp">Return to front page</a></p>
    </section>
<%@include file="/Includes/footer.html" %>
