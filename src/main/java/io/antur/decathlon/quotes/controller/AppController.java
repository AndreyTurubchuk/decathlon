package io.antur.decathlon.quotes.controller;



import io.antur.decathlon.quotes.dao.QuoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    private static final String LIST_VIEW = "quoteList";

    @Autowired
    QuoteDao quoteDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(final Model model) {
        model.addAttribute("quoteList", quoteDao.getAll());
        model.addAttribute("headerTitle", "quotes");
        return LIST_VIEW;
    }
}
