package buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Controller
public class FormController {

    @Autowired
    private AddressRepository bookRepo;

    @Autowired
    private AddressController addrCtrl;

    @Autowired
    private BuddyController buddyCtrl;

    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "index";
    }

    @GetMapping("/form/book/view")
    public String viewBook (
            @RequestParam("bookId") Integer id,
            Model model
            ) {

        model.addAttribute("book", bookRepo.findById(id));
        return "book";
    }

    @PostMapping("/form/book/create")
    public String createBook (
            @RequestParam("name") String name
            ) {

        addrCtrl.create(name);
        return "redirect:/";
    }

    @PostMapping("/form/contact/create")
    public String createContact (
            @RequestParam("bookId") Integer bookId,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            Model model
            ) {

        buddyCtrl.create(bookId, name, phone, address);
        model.addAttribute("book", bookRepo.findById(bookId));
        return "book";
    }

    @PostMapping("/form/contact/remove")
    public String removeContact (
            @RequestParam("bookId") Integer bookId,
            @RequestParam("contactId") Integer contactId,
            Model model
            ) {

        buddyCtrl.remove(contactId);
        model.addAttribute("book", bookRepo.findById(bookId));
        return "book";
    }

}
