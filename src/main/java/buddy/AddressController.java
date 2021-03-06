package buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository bookRepo;

    @Autowired
    private BuddyRepository buddyRepo;

    private AddressBook book;

    @PostMapping("/book/create")
    public AddressBook create (
            @RequestParam("name") String name
            ) {
        AddressBook book = new AddressBook(name);
        bookRepo.save(book);

        return book;
    }

    @GetMapping("/book/list")
    public List<AddressBook> list () {
        final ArrayList<AddressBook> books = new ArrayList<AddressBook>();
        bookRepo.findAll().forEach((b) -> { books.add(b); });
        return books;
    }



    @PostMapping("/add")
    public BuddyInfo add (
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam(value = "address", required = false) String address
    ) {
        AddressBook book = getBook();
        BuddyInfo info = new BuddyInfo(name, phone);

        if (address != null) {
            info.setAddress(address);
        }

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

    private AddressBook getBook () {
        bookRepo.findAll().forEach((b) -> { book = b; });

        if (book == null) {
            book = new AddressBook();
        }
        return book;
    }

}
