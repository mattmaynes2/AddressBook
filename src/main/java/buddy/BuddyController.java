package buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BuddyController {

    @Autowired
    private AddressRepository bookRepo;

    @Autowired
    private BuddyRepository buddyRepo;

    @PostMapping("/contact/create")
    public BuddyInfo create (
            @RequestParam("bookId") Integer bookId,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam(value = "address", required = false) String address
            ) {

        AddressBook book = bookRepo.findById(bookId);
        BuddyInfo info = new BuddyInfo(name, phone);

        if (address != null) {
            info.setAddress(address);
        }


        info.setAddress(address);
        book.addContact(info);
        bookRepo.save(book);

        return info;
    }

    @PostMapping("/contact/remove")
    public BuddyInfo remove (
            @RequestParam("contactId") Integer contactId
            ) {

        BuddyInfo info = buddyRepo.findById(contactId);
        buddyRepo.removeById(contactId);
        return info;
    }
}
