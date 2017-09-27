package is.nord.controller;

import is.nord.model.Event;
import is.nord.model.News;
import is.nord.model.User;
import is.nord.service.NewsService;
import is.nord.service.RegistrationService;
import is.nord.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/*
 * Author:
 *       Ólafur Georg Gylfason (ogg4@hi.is)
*/

/**
 * A controller that controls news-related things
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;    // Establish a connection to the newsService

    @Autowired
    private UserService userService;    // Establish a connection to the userService

    @Autowired
    private RegistrationService registrationService;    // Establish a connection to the registrationService


    /**
     * Index of all news items
     * @param model the model
     * @return a webpage displaying all news items
     */
    @RequestMapping("/")
    public String listNews(Model model, Principal principal) {
        // Get all news items
        Iterable<News> news = newsService.findAll();
        // Add them to the model
        model.addAttribute("news", news);

        // If a user is logged in then add his/her object to the model
        if (principal != null) {
            // Get the user
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", user);
        }

        // Allow method calls from the thymeleaf template to registrationService
        model.addAttribute("registrationService", registrationService);
        return "home/index";
    }

    /**
     * Form for adding a new news item
     * @param model the model
     * @return a webpage with a form for adding a new news item
     */
    @RequestMapping("/addNews")
    public String formNewNews(Model model) {
        // Add model attributes needed for new form
        model.addAttribute("news", new News());
        model.addAttribute("submit","Bæta við");

        return "news/form";
    }

    @RequestMapping("/addEvent")
    public String formNewEvent(Model model) {
        // Add model attributes needed for new form
        model.addAttribute("event", new Event());
        model.addAttribute("submit","Bæta við");

        return "event/form";
    }

    /**
     * Add a news item if valid data is received TODO: validate the received data
     * @param news the news object formed from the user input that is to be added
     * @return back to the main page
     */
    @RequestMapping(value = "/saveNews", method = RequestMethod.POST)
    public String saveNews(News news) {
        // Get the user
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Set author
        news.setAuthor(user.getUsername());

        // Save to database through newsService
        newsService.save(news);

        // Redirect browser to /
        return "redirect:/";
    }

    /**
     * Add a event if valid data is received TODO: validate the received data
     * @param event the event object formed from the user input that is to be added
     * @return Back to the main page
     */
    @RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
    public String saveEvent(Event event) {
        // Get the user
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // Set author
        event.setAuthor(user.getUsername());

        // Save to database through newsService
        newsService.save(event);

        // Redirect browser to /
        return "redirect:/";
    }

}
