package is.nord.controller;

import is.nord.model.Event;
import is.nord.model.News;
import is.nord.model.Registration;
import is.nord.repository.NewsRepository;
import is.nord.repository.RegistrationRepository;
import is.nord.service.EventService;
import is.nord.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Calendar;

/* Authors:
 *      Kári Snær Kárason (ksk12@hi.is),
 *      Ólafur Georg Gylfason (ogg4@hi.is),
 */

/**
 * A controller that handles the news feed
 */
@Controller
@RequestMapping("/")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository; // Connection with the news repository

    @Autowired
    private RegistrationRepository registrationRepository; // Connection with the registration repository

    @Autowired
    private EventService eventService; // Connection with the event service

    @Autowired
    private NewsService newsService; // Connection with the news service

    /**
     * Displays the list of all news, with the latest one at the top
     * @param model model of the view
     * @return a website displaying news
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showNews (Model model) {
        ArrayList<News> newsList;
        newsList = (ArrayList<News>) newsRepository.getAll();
        model.addAttribute("news", newsList);

        ArrayList<Registration> registrationList;
        registrationList = (ArrayList<Registration>) registrationRepository.getAll();
        model.addAttribute("registrations", registrationList);

        String userName = UserController.userName;
        model.addAttribute("userName", userName);
        return "index";
    }

    /**
     * Displays empty form for a news item
     * @return a website with empty form for a news item
     */
    @RequestMapping("/news/makeNews")
    public String makeNews () { return "news/makeNews";}

    /**
     * Receives a news item and adds it to the news repository
     * @param title the title of the news item
     * @param text  the text of the news item
     * @param tag   the tag of the news item
     * @param model a model with attributes
     * @return a website with an empty form for a news item to be filled
     */
    @RequestMapping(value="/news/addNews", method = RequestMethod.POST)
    public String addNews (@RequestParam(value="title", required = false) String title,
                           @RequestParam(value="text", required = false) String text,
                           @RequestParam(value="tag", required = false) String tag,
                           ModelMap model) {
        String author = newsService.getAuthor();
        Calendar calendar = newsService.getCurrentDate();
        News news = new News(title, text, tag, author, calendar);
        newsRepository.add(news);
        return "news/makeNews";
    }

    /**
     * Displays a form to make an event
     * @return a website with an event form
     */
    @RequestMapping("/news/makeEvent")
    public String makeEvent () {
        return "news/makeEvent";
    }

    /**
     * This method handles all the parameters for an event, which are pasted in
     * the makeEvent form
     * @param title title of event
     * @param text text descibing the event
     * @param tag tag of the event
     * @param company company which is hosting the event
     * @param location location of the event
     * @param sCapacity how many can attend the event
     * @param sTime when the event starts (HH:MM)
     * @param sDate what date the event is on (DD-MM-YYYY)
     * @param sRegStartsTime the time when the registration starts (HH:MM)
     * @param sRegStartsDate the date when the registration starts (DD-MM-YYYY)
     * @param sRegEndsTime the time when the registration ends (HH:MM)
     * @param sRegEndsDate the date when the registration ends (DD-MM-YYYY)
     * @param sIsPriorityEvent is the event a priority event or not
     * @param model the model
     * @return a website displaying a form for events
     */
    @RequestMapping(value="/news/addEvent", method = RequestMethod.POST)
    public String addEvent (@RequestParam(value="title", required = false) String title,
                            @RequestParam(value="text", required = false) String text,
                            @RequestParam(value="tag", required = false) String tag,
                            @RequestParam(value="company", required = false) String company,
                            @RequestParam(value="location", required = false) String location,
                            @RequestParam(value="capacity", required = false) String sCapacity,
                            @RequestParam(value="timeOfEvent", required = false) String sTime,
                            @RequestParam(value="dateOfEvent", required = false) String sDate,
                            @RequestParam(value="regStartsTime", required = false) String sRegStartsTime,
                            @RequestParam(value="regStartsDate", required = false) String sRegStartsDate,
                            @RequestParam(value="regEndsTime", required = false) String sRegEndsTime,
                            @RequestParam(value="regEndsDate", required = false) String sRegEndsDate,
                            @RequestParam(value="isPriorityEvent", required = false) String sIsPriorityEvent,
                            ModelMap model) {

        int capacity = Integer.parseInt(sCapacity);
        boolean isPriorityEvent = eventService.getPriority(sIsPriorityEvent);
        Calendar timeOfEvent = eventService.getCalendar(sTime, sDate);
        Calendar registrationStarts = eventService.getCalendar(sRegStartsTime, sRegStartsDate);
        Calendar registrationEnds = eventService.getCalendar(sRegEndsTime, sRegEndsDate);
        String author = newsService.getAuthor();
        Calendar calendar = newsService.getCurrentDate();
        Event event = new Event(title, text, tag, author, calendar, company, location, capacity,
                timeOfEvent, registrationStarts, registrationEnds, isPriorityEvent);
        newsRepository.add(event);
        return "news/makeEvent";
    }
}
