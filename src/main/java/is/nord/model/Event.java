package is.nord.model;

import java.util.Calendar;

/* Authors:
 *      Ólafur Georg Gylfason (ogg4@hi.is),
 */

/**
 * A class that is a subclass of News.
 * Stores information about events.
 */
public class Event extends News {
    private String company; // the company that hosts the event
    private String location; // the location of the event
    private int capacity; // the maximum allowed attendance of the event
    private Calendar timeOfEvent; // the time of the event
    private Calendar registrationStarts; // when the registration for the event starts
    private Calendar registrationEnds; // when the registration for the event ends
    private boolean isPriorityEvent; // is this a priority event (for older students) or not

    public Event(String title, String text, String tag, String author, Calendar datePosted, String company,
                 String location, int capacity, Calendar timeOfEvent,
                 Calendar registrationStarts, Calendar registrationEnds, boolean isPriorityEvent) {
        super(title, text, tag, author, datePosted);
        this.company = company;
        this.location = location;
        this.capacity = capacity;
        this.timeOfEvent = timeOfEvent;
        this.registrationStarts = registrationStarts;
        this.registrationEnds = registrationEnds;
        this.isPriorityEvent = isPriorityEvent;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Calendar getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(Calendar timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public Calendar getRegistrationStarts() {
        return registrationStarts;
    }

    public void setRegistrationStarts(Calendar registrationStarts) {
        this.registrationStarts = registrationStarts;
    }

    public Calendar getRegistrationEnds() {
        return registrationEnds;
    }

    public void setRegistrationEnds(Calendar registrationEnds) {
        this.registrationEnds = registrationEnds;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isPriorityEvent() {
        return isPriorityEvent;
    }

    public void setPriorityEvent(boolean priorityEvent) {
        isPriorityEvent = priorityEvent;
    }

    /**
     * A method to format how the event is shown
     * @return a string with information about the event
     */
    @Override
    public String toString() {
        return "<h1>Titill: " + getTitle() + "</h1>" +
                "<h4>Tag: " + getTag() + "</h4>" +
                "<h4>Fyrirtæki: " + company + "</h4>" +
                "<h4>Staðsetning: " + location + "</h4>" +
                "<h4>Fjöldi: " + capacity + "</h4>" +
                "<h4>Tími:" + timeOfEvent.getTime() + "</h4>" +
                "<h4>Skráning hefst:" + registrationStarts.getTime() + "</h4>" +
                "<h4>Skráningu lýkur:" + registrationEnds.getTime() + "</h4>" +
                "<p>Meginmál: " + getText() + "</p>" +
                "<h4>Forgangsviðburður: " + isPriorityEvent + "</h4>" +
                "<h4>Birt: " + getDatePosted().getTime() + " - " + getAuthor() + "</h4>" +
                "<form method=\"POST\" action=\"/registration/registration\">" +
                    "<input type=\"text\" id=\"event\" name=\"event\" value=\"" + this.getTitle() + "\" style=\"display:none;\"/>" +
                    "<input type=\"submit\" value=\"Skrá mig!\"></input>" +
                "</form>";
    }
}


