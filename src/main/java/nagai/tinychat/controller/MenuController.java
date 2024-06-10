package nagai.tinychat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MenuController {
    @GetMapping("/")
    public String Index() {
        return "menu";
    }

    @GetMapping("/menubar")
    public String MenuBar() {
        return "bar";
    }
}
