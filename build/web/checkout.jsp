<%-- 
    (c) 2015, Ben Hay and Haris Cesko
--%>

<%@include file="/Includes/header.html" %>

    <section>
        <form method="post" action="library">
        <h1>Checkout a book</h1>

        <label>First Name:</label>
        <input type="text" name="firstName" required><br><br>
        <label>Last </label>
        <input type="text" name="lastName" required><br><br> 
        <label>Email Address:</label>
        <input type="text" name="emailAddress" required><br><br>
        <label>Book Title:</label>
        <input type="text" name="bookTitle" required><br><br>
        <input type="submit" value="Checkout" id="checkout">
        <input type="hidden" name="action" value="doCheckout">
        </form>
    </section>
<%@include file="/Includes/footer.html" %>