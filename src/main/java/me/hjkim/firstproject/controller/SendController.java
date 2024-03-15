package me.hjkim.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendController {

    @GetMapping("/random-quote")
    public String randomQuote(Model model) {
        String[] quotes = {
                "안녕하세요. -김현진-",
                "반갑습니다. -김현숙-",
                "호의, 둘리. -차무식-"
        };

        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);
        return "quote";
    }
}
