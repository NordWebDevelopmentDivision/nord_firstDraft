package is.nord.service;

import java.util.Calendar;

/* Authors:
 *      Ólafur Georg Gylfason (ogg4@hi.is),
 */

/**
 * Handles logic for news.
 */


public interface NewsService {
    String getAuthor();
    Calendar getCurrentDate();
}
