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
        //     int size = quoteDao.getAll().size();
        model.addAttribute("quoteList", quoteDao.getAll());
        model.addAttribute("quoteRandom", quoteDao.getRandom());
        model.addAttribute("quotePosted", quoteDao.getRandom());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/list2", method = RequestMethod.GET)
    public String showAll2(final Model model2, @RequestParam("postedNumber") Integer postedNumber) {
        model2.addAttribute("quoteList", quoteDao.getAll());
        model2.addAttribute("quoteRandom", quoteDao.getRandom());
        model2.addAttribute("quotePosted", quoteDao.getById(postedNumber));
        return LIST_VIEW;
        //   return "redirect:/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String doGetQuoteAdd() {
        return "quoteAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public String doPostQuoteAdd(Quote quote) {
        quoteDao.saveOrUpdate(quote);
        return "redirect:/list";
    }


    @RequestMapping(value = "/listTOP10", method = RequestMethod.GET)
    public String showTOP10(final Model model2) {
        Integer sizeQuote = quoteDao.getAll().size();
        if (sizeQuote >= 10) {
            sizeQuote = 10;
        }
        model2.addAttribute("quoteList", quoteDao.getTOPorFLOP10(0, sizeQuote, "upvote", "DESC"));
        model2.addAttribute("quoteRandom", quoteDao.getRandom());
        model2.addAttribute("quotePosted", quoteDao.getRandom());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/listFLOP10", method = RequestMethod.GET)
    public String showFLOP10(final Model model3) {
        Integer sizeQuote = quoteDao.getAll().size();
        if (sizeQuote >= 10) {
            sizeQuote = 10;
        }
        model3.addAttribute("quoteList", quoteDao.getTOPorFLOP10(0, sizeQuote, "downvote", "DESC"));
        model3.addAttribute("quoteRandom", quoteDao.getRandom());
        model3.addAttribute("quotePosted", quoteDao.getRandom());
        return LIST_VIEW;
    }

    @RequestMapping(value = "/LAST", method = RequestMethod.GET)
    public String showLAST(final Model model4) {
        model4.addAttribute("quoteList", quoteDao.getLAST());
        model4.addAttribute("quoteRandom", quoteDao.getRandom());
        model4.addAttribute("quotePosted", quoteDao.getRandom());
        return LIST_VIEW;
    }


    @RequestMapping(value = "/upVote", method = RequestMethod.GET)
    public String upVote(Model model5, @RequestParam(value = "id") Integer id,
                         @RequestParam(value = "sign") Integer sign,
                         @RequestParam("numberQuotePosted") Integer numberQuotePosted) {
        Quote quote = quoteDao.getById(id);
        quote.setUpvote(quote.getUpvote() + sign);
        quoteDao.saveOrUpdate(quote);
        //return "redirect:/list";
        model5.addAttribute("quoteList", quoteDao.getAll());
        model5.addAttribute("quoteRandom", quoteDao.getRandom());
        model5.addAttribute("quotePosted", quoteDao.getById(numberQuotePosted));
        return LIST_VIEW;
    }

/*    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }*/


}
