package is.nord.model;

import java.util.Calendar;

/* Authors:
 *      Ólafur Georg Gylfason (ogg4@hi.is),
 */

/**
 * Stores information about news.
 * Superclass of Event
 */
public class News {
    private String title; // title of the news item
    private String text; // text of the news item
    private String tag; // tag of the news item
    private String author; // author of the news item
    private Calendar datePosted; // posting date of the news item

    public News() {}

    public News(String title, String text, String tag, String author, Calendar datePosted) {
        this.title = title;
        this.text = text;
        this.tag = tag;
        this.author = author;
        this.datePosted = datePosted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Calendar getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Calendar datePosted) {
        this.datePosted = datePosted;
    }

    /**
     * A method to format how the news item is shown
     * @return a string with information about the news itemn
     */
    @Override
    public String toString() {
        return "<h1>" + title + "</h1>" +
                "<h4>" + tag + "</h4>" +
                "<p>" + text + "</p>" +
                "<h4>Birt: " + datePosted.getTime() + " - " + author + "</h4>";
    }
}
