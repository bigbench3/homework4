/*
    Copywrite Ben Hay and Haris Cesko 2015
 */
package edu.elon.business;

import edu.elon.user.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.GregorianCalendar;

import sql.LibraryDB;


/**
 * The servlet the drives and controls the web application
 */

@WebServlet(name = "LibraryServlet", urlPatterns = {"/library"})
public class LibraryServlet extends HttpServlet {
    
    /**
     *  The primary post method to take all the data and control
     *  the application
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String url = "/index.jsp";
        
        String action = request.getParameter("action");
        
//        Changes page from index to checkout
        
            if(action != null && action.equals("goToCheckout")){
                url = "/checkout.jsp";
                
            }
        
//        changes page from index to checkedoutBooks and reads the database, 
//        library, to generate an arraylist of all of the books checked out
            
            
            if(action != null && action.equals("goToBooks")){
                
                ArrayList<User> users = LibraryDB.selectUser();
                
                
                request.setAttribute("users", users);
                
                url = "/checkedoutBooks.jsp";
                
            }
            
//        changes page from checkout to confirmedCheckout and reads in data from 
//        the browser and writes it to a database and passes it on as an attribute
//        to the next page to display data
        
            if(action != null && action.equals("doCheckout")){
        
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                String bookTitle = request.getParameter("bookTitle");
            
                Calendar cal = GregorianCalendar.getInstance();
                cal.add(Calendar.DATE, 14); //adds 2 weeks to the date
                SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM-dd-yyy");
            
                String dueDate = outputDateFormat.format(cal.getTime());
            
                User user = new User();
        
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmailAddress(emailAddress);
                user.setBookTitle(bookTitle);
                user.setDueDate(dueDate);
            
                LibraryDB.insert(user);
            
                request.setAttribute("user", user);
            

                url = "/confirmedCheckout.jsp";
        }
            
//        changes page from confirmedCheckout to index
            
            if(action != null && action.equals("goToIndex")){
                url = "/index.jsp";
                
            }
            

        
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    }

    


