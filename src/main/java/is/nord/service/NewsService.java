package is.nord.service;

import java.util.Calendar;


public interface NewsService {
    public Calendar getCalendar(String sTime, String sDate);
    public boolean getPriority(String isChecked);
}
