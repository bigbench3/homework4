<%-- 
    (c) 2015, Ben Hay and Haris Cesko
--%>

<%@include file="/Includes/header.html" %>

    <section>
        <h2>Checkout a book</h2>
        
        <form method="post" action="library">
            <table>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><input type="text" name="firstName" required></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><input type="text" name="lastName" required></td>
                </tr>
                <tr>
                    <td><label>Email Address: </label></td>
                    <td><input type="text" name="emailAddress" required></td>
                </tr>
                <tr>
                    <td><label>Book Title:</label></td>
                    <td><input type="text" name="bookTitle" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Checkout" id="checkout"></td>
                </tr>
            </table>
            
            <input type="hidden" name="action" value="doCheckout">
        </form>
    </section>
<%@include file="/Includes/footer.html" %>