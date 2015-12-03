/*
    Copywrite Ben Hay and Haris Cesko 2015
 */
package edu.elon.user;

import java.io.Serializable;

/**
 * A Bean to be used by the web application
 */
public class User implements Serializable {

    
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String bookTitle;
    private String overDue;
    private String dueDate;
    private String id;

    /**
     * a non-argument constructor for the User class
     */
    public User(){
        firstName = "";
        lastName = "";
        emailAddress = "";
        bookTitle = "";
        overDue = "";
        dueDate = "";
        id = "";
    }
    
    /**
     * gets the first name
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets the last name
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets the email address
     * 
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * sets the email address
     * 
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * gets the book title
     * 
     * @return book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * sets the book title
     *
     * @param bookTitle
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    /**
     * gets the due date
     * 
     * @return due date
     */
    public String getDueDate(){
        return dueDate;
    }
    
    /**
     * set the due date 
     * 
     * @param dueDate
     */
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
    
    /**
     * gets the id
     * 
     * @return id 
     */
    
    public String getId(){
        return id;
    }
    
    /**
     * sets the id
     * 
     * @param id 
     */
    
    public void setId(String id){
        this.id = id;
    }
    
    /**
     * gets the status of the book (overdue or null)
     * 
     * @return overdue
     */
    public String getOverDue() {
        return overDue;
    }

    /**
     * sets overdue status
     * 
     * @param overdue
     */
    public void setOverDue(String overdue) {
        this.overDue = overdue;
    }
    
}
