/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author pasmimmo
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Book> findBooks() {
        TypedQuery<Book> query = entityManager.createNamedQuery("FIND_ALL", Book.class);
        return query.getResultList();
    }

    @Override
    public Book createBook(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public void deleteBook(Book book) {
        entityManager.remove(entityManager.merge(book));
    }

    @Override
    public Book updateBook(Book book) {
        return entityManager.merge(book);
    }
}
