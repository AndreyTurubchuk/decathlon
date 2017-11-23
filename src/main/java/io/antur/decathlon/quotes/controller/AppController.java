package io.antur.decathlon.quotes.controller;

import io.antur.decathlon.quotes.dao.QuoteDao;
import io.antur.decathlon.quotes.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class AppController {
    private static final String LIST_VIEW = "quoteList";

    @Autowired
    QuoteDao quoteDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(final Model model) {
        int size = quoteDao.getAll().size();
        model.addAttribute("quoteList", quoteDao.getAll());
        model.addAttribute("headerTitle", "quotes");
        model.addAttribute("numberRandomQuote", randInt(0, size));
        return LIST_VIEW;
    }

    @RequestMapping(value = "/listTOP10", method = RequestMethod.GET)
    public String showTOP10(final Model model2) {
        model2.addAttribute("quoteList", quoteDao.getTOPorFLOP10(0, 10, "upvote", "DESC"));
        model2.addAttribute("headerTitle", "quotes");
        return LIST_VIEW;
    }

    @RequestMapping(value = "/listFLOP10", method = RequestMethod.GET)
    public String showFLOP10(final Model model3) {
        model3.addAttribute("quoteList", quoteDao.getTOPorFLOP10(0, 10, "downvote", "DESC"));
        model3.addAttribute("headerTitle", "quotes");
        return LIST_VIEW;
    }

    @RequestMapping(value = "/upVote", method = RequestMethod.GET)
    public String upVote(@RequestParam(value = "id") Integer id, @RequestParam(value = "sign") Integer sign) {
        Quote quote = quoteDao.getById(id);
        quote.setUpvote(quote.getUpvote() + sign);
        quoteDao.saveOrUpdate(quote);
        return "redirect:/list";
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


}
