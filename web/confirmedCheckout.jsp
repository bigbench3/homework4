<%-- 
    (c) 2015, Ben Hay and Haris Cesko
--%>

<%@include file="/Includes/header.html" %>
    <section>
        <p>
           <span>Thank you for your patronage of the Belk Library. You've 
               successfully checked out the book, </span>
           <span>${user.bookTitle}.</span>
           <span> Please note that this book is due back on </span>
           <span>${user.dueDate}.</span>
           <span> A friendly email reminder will be sent to you if your book 
               becomes overdue.</span>
        </p>
        <p><a href="index.jsp">Return to front page</a></p>
    </section>
<%@include file="/Includes/footer.html" %>
