package is.nord.service;

import java.util.Calendar;

/* Authors:
 *      Ólafur Georg Gylfason (ogg4@hi.is),
 */

/**
 * Handles logic for events.
 */

public interface EventService {
    Calendar getCalendar(String sTime, String sDate);
    boolean getPriority(String isChecked);
}
