package buddy;

import javax.persistence.*;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mattmaynes on 1/12/2017.
 */



public class AddressBookTest {

    private AddressBook book;
    private BuddyInfo buddy;

    @org.junit.Before
    public void setUp() throws Exception {
        book = new AddressBook();
    }

    @org.junit.Test
    public void addContact() throws Exception {
        book.addContact(new BuddyInfo("John"));
        book.addContact(new BuddyInfo("Tom"));

        assertEquals(book.getContacts().size(), 2);
    }

    @org.junit.Test
    public void removeContact() throws Exception {
        BuddyInfo b = new BuddyInfo("John");

        book.addContact(b);
        book.removeContact(b);

        assertEquals(book.getContacts().size(), 0);
    }

    @org.junit.Test
    public void testToString () {
        book.addContact(new BuddyInfo("Tom"));
        book.addContact(new BuddyInfo("Tim"));

        assertEquals(book.toString(), "Tom\nTim\n");
    }

    @org.junit.Test
    public void testPersist () {
        BuddyInfo buddy1 = new BuddyInfo("John", "(123) 555 - 1234");
        BuddyInfo buddy2 = new BuddyInfo("Tom", "(123) 555 - 9999");
        BuddyInfo buddy3 = new BuddyInfo("Matt", "(123) 555 - 5678");
        AddressBook book = new AddressBook();

        book.addContact(buddy1);
        book.addContact(buddy2);
        book.addContact(buddy3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("buddy.AddressBook");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);
        em.persist(buddy3);
        em.persist(book);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT book FROM AddressBook book");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();
        assertTrue(results.get(0).equals(book));

        // Closing connection
        em.close();

        emf.close();
    }

    @org.junit.Test
    public void testPersistCascade () {
        AddressBook book = new AddressBook();

        book.addContact(new BuddyInfo("John", "(123) 555 - 1234"));
        book.addContact(new BuddyInfo("Tom", "(123) 555 - 9999"));
        book.addContact(new BuddyInfo("Matt", "(123) 555 - 5678"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("buddy.AddressBook");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(book);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT book FROM AddressBook book");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();
        assertTrue(results.get(0).equals(book));

        // Closing connection
        em.close();

        emf.close();
    }
}