package com.jbclibrary_wc.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class JBCLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=2)
    private String title;

    @NotNull
    @Size(min=2)
    private String author;

    @NotNull
    @Size(max=4)
    private String year;

    //@Size(min=10)
    private String isbn;

    //@Size(min=5)
    private String image;


    private boolean borrowed;






    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        //this.borrowed = borrowed;

        if (borrowed ==false)

            this.borrowed = false;
            //System.out.println(title + "by" + author + "is already checked out.");

        else

            this.borrowed = true;

//            borrowed=true;
//            System.out.println("You have checked out " + title + "by" + author +".");
        }

    }
//
//    public boolean isReturned() {
//        return returned;
//    }
//
//    public void setReturned(boolean returned) {
//        //this.returned = returned;
//
//        if (borrowed==false)
//            System.out.println(title + "by" + author + "is already checked out.");
//        else{
//            returned=true;
//            System.out.println("You have returned out " + title + "by" + author +".");
//        }
//
//    }


