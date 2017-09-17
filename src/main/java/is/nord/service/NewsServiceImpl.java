package is.nord.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class NewsServiceImpl implements NewsService {
    @Override
    public String getAuthor() {
        return "Melkorka";
    }

    @Override
    public Calendar getCurrentDate() {
        Calendar calendar = new GregorianCalendar();
        Date currentDate = calendar.getTime();
        calendar.setTime(currentDate);
        return calendar;
    }
}
