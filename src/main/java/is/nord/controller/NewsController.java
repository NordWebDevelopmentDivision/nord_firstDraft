package is.nord.controller;

import is.nord.model.Event;
import is.nord.model.News;
import is.nord.repository.NewsRepository;
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

/** Authors:
 *      Kári Snær Kárason (ksk12@hi.is),
 *      Ólafur Georg Gylfason (ogg4@hi.is),
 *      Stella Rut Guðmundsdóttir (srg30@hi.is)
 */

/**
 * A controller that handles the news feed
 */

@Controller
@RequestMapping("/")
public class NewsController {

    // Connection with the news repository
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private NewsService newsService;

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
        return "news/index";
    }

    /**
     * Displays empty form for a news item
     * @return a website with empty form for a news item
     */
    @RequestMapping("/makeNews")
    public String makeNews () { return "news/makeNews";}

    /**
     * Receives a news item and adds it to the news repository
     * @param title the title of the news item
     * @param text  the text of the news item
     * @param tag   the tag of the news item
     * @param model a model with attributes
     * @return a website with an empty form for a news item to be filled
     */
    @RequestMapping(value="/addNews", method = RequestMethod.POST)
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

    @RequestMapping("/makeEvent")
    public String makeEvent () {
        return "news/makeEvent";
    }

    @RequestMapping(value="/addEvent", method = RequestMethod.POST)
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

        System.out.println("gildið á checkboxinu er: " + sIsPriorityEvent);
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
