package masterSpringMvc.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import java.util.stream.Collectors;

@Controller
public class TweetController {
    @Autowired
    private Twitter twitter;
    private final Logger log = Logger.getLogger(this.getClass());
    @RequestMapping("/twitter")
    public String hello(@RequestParam(defaultValue = "#spring") String search, Model model)
    {
        SearchResults searchResults = twitter.searchOperations().search(search);
        //log.debug(searchResults);
        //SearchResults searchResults = twitter.searchOperations().search("a");
        //String text = searchResults.getTweets().get(0).getText();
        List<Tweet> tweets = searchResults.getTweets();//.stream().map(Tweet::getText).collect(Collectors.toList());
        model.addAttribute("tweets", tweets);
        model.addAttribute("search", search);
        return "resultPage";
    }

    @RequestMapping("/search")
    public String home()
    {
        return "searchPage";
    }

    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes)
    {
        String search = request.getParameter("search");
        if(search.toLowerCase().contains("dupa"))
        {
            redirectAttributes.addFlashAttribute("error", "Spróbuj wpisać spriing");
            return "redirect:search";
        }
        redirectAttributes.addAttribute("search", search);
        return "redirect:twitter";
    }
}
