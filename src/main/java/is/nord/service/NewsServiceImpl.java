package is.nord.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class NewsServiceImpl implements NewsService {

    @Override
    public Calendar getCalendar(String sTime, String sDate) {
        Calendar calendar = new GregorianCalendar();

        String time[] = sTime.split(":");
        int hour = Integer.parseInt(time[0].trim());
        int minute = Integer.parseInt(time[1].trim());

        String date[] = sDate.split("-");
        int day = Integer.parseInt(date[0].trim());
        int month = Integer.parseInt(date[1].trim());
        int year = Integer.parseInt(date[2].trim());

        calendar.set(year, month, day, hour, minute);

        return calendar;
    }

    @Override
    public boolean getPriority(String isChecked) {
        if (isChecked == null) {
            return false;
        }
        return isChecked.equals("checked");
    }
}
