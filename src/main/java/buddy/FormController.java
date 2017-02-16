package buddy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FormController {

    @GetMapping("/")
    public String index () {
        return "index";
    }

}
