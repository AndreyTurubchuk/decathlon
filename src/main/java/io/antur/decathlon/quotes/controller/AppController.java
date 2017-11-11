package io.antur.decathlon.quotes.controller;

import io.antur.decathlon.quotes.dao.QuoteDao;
import io.antur.decathlon.quotes.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/upVote", method = RequestMethod.GET)
    public String upVote(@RequestParam(value = "id") Integer id, @RequestParam(value = "sign") Integer sign) {
        Quote quote = quoteDao.getById(id);
        quote.setUpvote(quote.getUpvote() + sign);
        quoteDao.saveOrUpdate(quote);
        return "redirect:/list";
    }



}
