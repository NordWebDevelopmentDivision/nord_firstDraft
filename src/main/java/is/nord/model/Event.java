package is.nord.model;

import java.util.Calendar;

/**
 * class Event. Subclass of News
 */
public class Event extends News {
    private String company;
    private String location;
    private int capacity;
    private Calendar timeOfEvent;
    private Calendar registrationStarts;
    private Calendar registrationEnds;
    private boolean isPriorityEvent;

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
                "<h4>Birt: " + getDatePosted().getTime() + " - " + getAuthor() + "</h4>";
    }
}
