package is.nord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
  Authors:
    Stella Rut Guðmundsdóttir (srg30@hi.is)
*/

/**
 * A controller to handle the log in
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * Displays a form for username and password
     * @return a website that displays a form for username and password
     */
    @RequestMapping("/showLogIn")
    public String showLogIn () {
        return "user/logIn";
    }

    /**
     * Checks if the user put in correct username and password
     * @param username the username input from user
     * @param password the password input from user
     * @param model the model
     * @return a website that displays who is logged in
     */
    @RequestMapping(value="/logIn", method= RequestMethod.POST)
    public String logIn (@RequestParam(value="username", required=false) String username, @RequestParam(value="password", required=false) String password, ModelMap model) {
        String fakeUsername = "nord";
        String fakePassword = "12345";

        if(fakeUsername.equals(username) && fakePassword.equals(password)) {
            model.addAttribute("username", username);
            return "index";
        } else {
            model.addAttribute("username", "Innskráning tókst ekki");
            return "index";
        }
    }

    /**
     * Logs the user out
     * @param model the model
     * @return a website where no one is logged in
     */
    @RequestMapping(value="/logOut", method= RequestMethod.GET)
    public String logOut (ModelMap model) {
        model.addAttribute("username", "Enginn");
        return "index";
    }
}
