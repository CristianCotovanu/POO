package Task4;

import java.io.*;
import java.util.*;

class Book {
    private String title;
    private String author;
    private int year;

    public Book() {}

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String toString() {
        return ("[ Title is: " + this.title + "|"
                + "Author is: " + this.author + "|"
                + "Year is: " + this.year + " ]");

    }
}