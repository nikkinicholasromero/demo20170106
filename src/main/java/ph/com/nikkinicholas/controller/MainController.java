package ph.com.nikkinicholas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nikkiromero on 16/01/2017.
 */
@RestController
public class MainController {
    @RequestMapping(value = { "", "/", "/home", "index" }, method = RequestMethod.GET)
    public String index() {
        return "Hello World";
    }
}
