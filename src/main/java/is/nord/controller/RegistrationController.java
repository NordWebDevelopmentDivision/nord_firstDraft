package is.nord.controller;


import is.nord.model.Registration;
import is.nord.repository.RegistrationRepository;
import is.nord.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

/* Authors:
 *      Kári Snær Kárason (ksk12@hi.is),
 */

/**
 * A controller that handles registrations to events
 */

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository; // Connect with the registration repository

    @Autowired
    private NewsServiceImpl newsService; // Connect with new service

    /**
     * Deletes the registration from the repository
     * @param event name of the event
     * @param username name of user
     * @return a website confirming delete
     */
    @RequestMapping("/delete")
    public String deleteRegistration (String event, String username) {
        System.out.println(username);
        System.out.println(event);
        registrationRepository.remove(username, event);
        return "registration/registrationDeleted";
    }
    /**
     * Adds a registration for the current user and selected event
     * @param model model of the view
     * @param event name of event
     * @return a website telling the user the registration was a success
     */
    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String register (@RequestParam(value="event", required=false) String event, ModelMap model) {

        //model.addAttribute("username", UserController.getUserName());
        //model.addAttribute("event", event);
        Registration registration = new Registration(UserController.userName, event, new Timestamp(newsService.getCurrentDate().getTimeInMillis()), true);
        registrationRepository.add(registration);
        return "/registration/registrationSuccessful";
    }
}
