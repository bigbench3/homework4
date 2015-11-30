/*
    Copywrite Ben Hay and Haris Cesko 2015
 */
package edu.elon.business;

import edu.elon.user.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  (c) Ben Hay and Haris Cesko
 */

@WebServlet(name = "LibraryServlet", urlPatterns = {"/library"})
public class LibraryServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String url = "/checkout.jsp";
        
        String action = request.getParameter("action");
        
            if(action != null && action.equals("doCheckout")){
        
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");
            String bookTitle = request.getParameter("bookTitle");
            
            User user = new User();
        
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmailAddress(emailAddress);
            user.setBookTitle(bookTitle);
            
        request.setAttribute("user", user);
            
        

            url = "/confirmedCheckout.jsp";
        } else {
           url = "/index.jsp"; 
        }
        
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }
    
        @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    }

    


