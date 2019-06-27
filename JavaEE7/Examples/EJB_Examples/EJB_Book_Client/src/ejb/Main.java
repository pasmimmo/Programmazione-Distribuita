/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.*;
import javax.naming.*;

public class Main {

    public static void main(String[] args) throws NamingException {
        Context ctx;
        ctx = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:global/EJB_Book/BookEJB!ejb.BookEJBRemote");
        List<Book> books = bookEJB.findBooks();
        for (Book aBook : books) {
            System.out.println("--- " + aBook);
        }
        Book book = new Book("The Hitchhiker’s Guide ..", 12.5F, "Science fiction by Douglas Adams.", "1-24561-799-0", 354, false);
        book = bookEJB.createBook(book);
        System.out.println("### Book created : " + book);
        book.setTitle("H2G2");
        book = bookEJB.updateBook(book);
        System.out.println("### Book updated : " + book);
        bookEJB.deleteBook(book);
        System.out.println("### Book deleted");
    }

}
