package is.nord.model;

import is.nord.controller.UserController;

import java.sql.Timestamp;

/*
  Authors:
    Kári Snær Kárason (ksk12@hi.is),
*/

/**
 * A model for registrations to events
 */

public class Registration {

    private String username; // username of the person that's logged in
    private String event; // which event to register in
    private Timestamp timestamp; // time of the registration
    private boolean isPriorityRegistration; // is the event a priority event for old students or not

    public Registration(String username, String event, Timestamp timestamp, boolean isPriorityRegistration){
        this.username = username;
        this.event = event;
        this.timestamp = timestamp;
        this.isPriorityRegistration = isPriorityRegistration;
    }

    /**
     * Makes a string representation of the registration
     * @return a html string
     */
    @Override
    public String toString() {
        String returnString = "<h4>" + username + " " + event + " " + timestamp + " " + isPriorityRegistration +"</h4>" +
                "<form method=\"POST\" action=\"/registration/delete\">" +
                "<input type=\"text\" id=\"event\" name=\"event\" value=\"" + this.getEvent() + "\" style=\"display:none;\"/>" +
                "<input type=\"text\" id=\"username\" name=\"username\" value=\"" + this.getUsername() + "\" style=\"display:none;\"/>";
        // If the current user matches the registered user, a button for unregistering is shown
        if(username.equals(UserController.userName)){
            returnString += "<c:if test=\"${username == UserController.userName}\">" +
                    "<input type=\"submit\" value=\"Skrá mig út\"></input>" +
                    "</c:if>" +
                    "</form>";
        }
        return returnString;
    }
    public String getUsername() {
        return username;
    }

    public String getEvent() {
        return event;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public boolean getIsPriorityRegistration() {
        return isPriorityRegistration;
    }
}
