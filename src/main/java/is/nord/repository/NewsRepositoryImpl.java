package is.nord.repository;

import is.nord.model.News;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository{

    private final List<News> newsRepo;

    public NewsRepositoryImpl() {
        this.newsRepo = new ArrayList<News>();
    }

    /**
     *
     * @return all the news items
     */
    @Override
    public List<News> getAll() {
        return newsRepo;
    }

    /**
     * Adds news to the newsRepo
     * @param news the news item to be added to the storage
     */
    @Override
    public void add(News news) {
        newsRepo.add(0, news);
    }
}
