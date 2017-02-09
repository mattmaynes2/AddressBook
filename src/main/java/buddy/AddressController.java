package buddy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mattmaynes on 2/2/2017.
 */
@RestController
public class AddressController {

    @Autowired
    private AddressRepository bookRepo;
    @Autowired
    private BuddyRepository buddyRepo;
    private AddressBook book;

    @PostMapping("/add")
    public BuddyInfo add (
            @RequestParam("name") String name,
            @RequestParam("phone") String phone
    ) {
        AddressBook book = getBook();
        BuddyInfo info = new BuddyInfo(name, phone);
        book.addContact(info);
        bookRepo.save(book);
        return info;
    }

    @PostMapping("/remove")
    public BuddyInfo add (
            @RequestParam("index") int index
    ) {
        AddressBook book = getBook();
        BuddyInfo info = book.getContacts().get(index);
        book.removeContact(index);
        buddyRepo.delete(info);
        bookRepo.save(book);
        return info;
    }

    @RequestMapping("/")
    public List<BuddyInfo> list () {
        return getBook().getContacts();
    }

    private AddressBook getBook () {
        bookRepo.findAll().forEach((b) -> { book = b; });

        if (book == null) {
            book = new AddressBook();
        }
        return book;
    }

}
