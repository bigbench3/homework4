/*
    Copywrite Ben Hay and Haris Cesko 2015
 */
package edu.elon.user;

import java.io.Serializable;

/**
 *
 * @author bhay
 */
public class User implements Serializable {

    
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String bookTitle;
    private String overdue;
    private String dueDate;

    
    public User(){
        firstName = "";
        lastName = "";
        emailAddress = "";
        bookTitle = "";
        overdue = "";
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    public String getDueDate(){
        return dueDate;
    }
    
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
    
    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }
    
}
