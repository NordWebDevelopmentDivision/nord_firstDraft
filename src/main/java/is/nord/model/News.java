package is.nord.model;

/**
 * News class. Superclass of Event
 */
public class News {
    private String title;
    private String text;
    private String tag;

    public News() {}

    public News(String title, String text, String tag) {
        this.title = title;
        this.text = text;
        this.tag = tag;
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

    @Override
    public String toString() {
        return "<h1>" + title + "</h1><h4>" + tag + "</h4><p>" + text + "</p>";
    }
}
